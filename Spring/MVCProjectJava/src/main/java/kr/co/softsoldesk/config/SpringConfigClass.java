package kr.co.softsoldesk.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/*
public class SpringConfigClass implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
		servletAppContext.register(ServletAppContext.class);

		// 요청 발생 시 요청을 처리하는 서블릿을 DispatcherServlet으로 설정
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);

		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);

		// 부가 설정
		servlet.setLoadOnStartup(1);// 가장먼저 받아들이겠다는 뜻
		servlet.addMapping("/");

		//RootAppContext 를 Bean 정의하는 클래스로 지정
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		rootAppContext.register(RootAppContext.class);

		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
		servletContext.addListener(listener);

		// 파라미터 인코딩 설정
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		// dispatcher에 의해서 추가된 Servlet에 UTF-8로 encoding하겠다는 구현부
		filter.addMappingForServletNames(null, false, "dispatcher");

	}

}
*/

public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{

	   // DispatcherServlet에 매핑할 요청 주소를 셋팅한다.
	   @Override
	   protected String[] getServletMappings() {
	      return new String[] {"/"};
	   }
	   
	   // Spring MVC 프로젝트 설정을 위한 클래스를 지정한다.
	   @Override
	   protected Class<?>[] getServletConfigClasses() {
	      return new Class[] {ServletAppContext.class};
	   }
	   
	   // 프로젝트에서 사용할 Bean들을 정의기 위한 클래스를 지정한다.
	   @Override
	   protected Class<?>[] getRootConfigClasses() {
	      return new Class[] {RootAppContext.class};
	   }
	   
	   // 파라미터 인코딩 필터 설정
	   @Override
	   protected Filter[] getServletFilters() {
	      CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
	      encodingFilter.setEncoding("UTF-8");
	      return new Filter[] {encodingFilter};
	   }

	   //Multipart 정보구현
	   //null: 사용자가 입력한 내용을 임시기억할 아파치톰켓에서 제공하는 서버의 임시기억장소
	   //52428800 :  업로드 데이터의 용량 (1024*50) 50M로 설정
	   //524288000 : 파일데이터를 포함한 전체용량 500M 설정
	   //0 : 파일의 임계값
	   @Override
	   protected void customizeRegistration(Dynamic registration) {
	      super.customizeRegistration(registration);
	      
	      MultipartConfigElement config1 = new MultipartConfigElement(null, 52428800, 524288000, 0);
	      registration.setMultipartConfig(config1);
	   }
	}