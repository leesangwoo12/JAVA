package kr.co.softsoldesk.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@MapperScan("kr.co.softsoldesk.mapper")
public class MyBatisConfig {
	
	 private final DataSource dataSource;

	    public MyBatisConfig(DataSource dataSource) {
	        this.dataSource = dataSource;
	    }

	    @Bean
	    public SqlSessionFactory sqlSessionFactory() throws Exception {
	        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

	        factoryBean.setDataSource(dataSource);

	        // 방법 1: MyBatis 설정 파일 사용하기 (sql-map-config.xml이 resources에 있을 때)
	        factoryBean.setConfigLocation(new ClassPathResource("sql-map-config.xml"));

	        // 방법 2: 매퍼 XML 위치 직접 지정하기
	        //PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	        //factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));

	        // 타입 별칭 패키지 설정 (BoardInfoBean 같은 DTO들이 있는 패키지)
	        //factoryBean.setTypeAliasesPackage("kr.co.softsoldesk.beans");

	        return factoryBean.getObject();
	    }

}
