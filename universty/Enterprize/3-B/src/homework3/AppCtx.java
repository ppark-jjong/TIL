package homework3;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class AppCtx {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		// DB 연결 클래스
		SimpleDriverDataSource ds = new SimpleDriverDataSource();
		// DB 드라이버 종류 선언
		ds.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		// DB 주소 선언
		ds.setUrl("jdbc:mysql://localhost/springdb?characterEncoding=utf8");
		ds.setUsername("root");
		ds.setPassword("1234");
		return ds;
	}
	@Bean
	public BookDao bookDao() {
		return new BookDao(dataSource());
	}
}