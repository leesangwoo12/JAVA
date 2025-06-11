package kr.co.softsoldesk.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.softsoldesk.beans.UserBean;
import kr.co.softsoldesk.interceptor.CheckLoginInterceptor;
import kr.co.softsoldesk.interceptor.CheckWriterInterceptor;
import kr.co.softsoldesk.interceptor.TopMenuInterceptor;
import kr.co.softsoldesk.mapper.BoardMapper;
import kr.co.softsoldesk.mapper.TopMenuMapper;
import kr.co.softsoldesk.mapper.UserMapper;
import kr.co.softsoldesk.service.BoardService;
import kr.co.softsoldesk.service.TopMenuService;
	// MVC -> Model View Controller
	//MVC프로젝트에 관련된 설정 클래스
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kr.co.softsoldesk.controller")
@ComponentScan(basePackages = "kr.co.softsoldesk.dao")
@ComponentScan(basePackages = "kr.co.softsoldesk.service")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {
	
	@Value("${db.classname}")
	private String db_classname;
	
	@Value("${db.url}")
	private String db_url;
	
	@Value("${db.username}")
	private String db_username;
	
	@Value("${db.password}")
	private String db_password;
	
	@Autowired
	private TopMenuService topMenuService;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	@Autowired
	private BoardService boardService;
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		WebMvcConfigurer.super.configureViewResolvers(registry);
		//받아들이는 값을 .jsp로 반환 (index 를 받으면 index.jsp 를 보여주는 설정)
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	// 정적 파일의 경로를 매핑한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		WebMvcConfigurer.super.addResourceHandlers(registry);
		//모든 하위 경로에 파일들 resources타고 오게 설정
		registry.addResourceHandler("/resources/upload/**").addResourceLocations("file:///D:/resources/uploadFiles/");
	}
	
	  

	// 데이터베이스 접속 정보를 관리하는 Bean
	   @Bean
	   public BasicDataSource dataSource() { 
	      BasicDataSource source = new BasicDataSource();
	      source.setDriverClassName(db_classname);
	      source.setUrl(db_url);
	      source.setUsername(db_username);
	      source.setPassword(db_password);
	      
	      return source;
	   }
	   
	   // 쿼리문과 접속 정보를 관리하는 객체
	   @Bean
	   public SqlSessionFactory factory(BasicDataSource source) throws Exception{
	      SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	      factoryBean.setDataSource(source);
	      SqlSessionFactory factory = factoryBean.getObject();
	      return factory;
	   }
	   
	   // 쿼리문 실행을 위한 객체(Mapper 관리)
	   @Bean
	   public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factory) throws Exception{
	      MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
	      factoryBean.setSqlSessionFactory(factory);
	      return factoryBean;
	   }
	   
	   @Bean
	   public MapperFactoryBean<TopMenuMapper> getTopMenuMapper(SqlSessionFactory factory) throws Exception{
	      MapperFactoryBean<TopMenuMapper> factoryBean = new MapperFactoryBean<TopMenuMapper>(TopMenuMapper.class);
	      factoryBean.setSqlSessionFactory(factory);
	      return factoryBean;
	   }
	   
	   @Bean
	   public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory) throws Exception{
	      MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<UserMapper>(UserMapper.class);
	      factoryBean.setSqlSessionFactory(factory);
	      return factoryBean;
	   }
	   
	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
		   WebMvcConfigurer.super.addInterceptors(registry);
		   
		   TopMenuInterceptor topMenuInterceptor  = new TopMenuInterceptor(topMenuService,loginUserBean);
		   InterceptorRegistration reg1 = registry.addInterceptor(topMenuInterceptor);
		   
		   //모든 요청주소에 동작
		   reg1.addPathPatterns("/**");
		   
		   CheckLoginInterceptor checkLoginInterceptor = new CheckLoginInterceptor(loginUserBean);
		   InterceptorRegistration reg2 = registry.addInterceptor(checkLoginInterceptor);
		   //로그인 필수
		   reg2.addPathPatterns("/user/modify", "/user/logout", "/board/*");
		   //로그인 필수에서 제외
		   reg2.excludePathPatterns("/board/main");
		   
		   
		   CheckWriterInterceptor checkWriterInterceptor = new CheckWriterInterceptor(loginUserBean,boardService);
		   InterceptorRegistration reg3 = registry.addInterceptor(checkWriterInterceptor);
		   reg3.addPathPatterns("/board/modify","/board/delete");
		   
		}
	   
	   
	   @Bean
	   public ReloadableResourceBundleMessageSource messageSource() {
	      ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
	      
	      res.setDefaultEncoding("utf-8");
	      res.setBasenames("/WEB-INF/properties/error_message");


	      return res;
	   }
	   
	   @Bean
	   public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
	      return new PropertySourcesPlaceholderConfigurer();
	   }
	   
	   //파일 업로드 기능
	   @Bean
	   public StandardServletMultipartResolver multipartResolver() {
		   return new StandardServletMultipartResolver();
	   }
	   
	
}
