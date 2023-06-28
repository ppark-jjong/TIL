package db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class AppCtx {
	
	public DataSource dataSource() {
		SimpleDriverDataSource ds = new SimpleDriverDataSource();
		ds.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		ds.setUrl("http://localhost:8080/Final/shopping?maker=adidas");
		ds.setUsername("root");
		ds.setPassword("1234");
		return ds;
	}

}
