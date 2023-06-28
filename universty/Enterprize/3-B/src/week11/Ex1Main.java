package week11;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//JDBC API를 이용하여 DB에 접근하는 클래스 => 결론은 API 복잡하다.
public class Ex1Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		Statement stmt = null;
		Connection conn = null;
		String sql;

		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();

//			sql = "create table MEMBER(ID int auto_increment primary key, "
//					+ "EMAIL varchar(255), PASSWORD varchar(100), " + "NAME varchar(100), REGDATE datetime)";
//			stmt.executeUpdate(sql);

			for (int i = 1; i <= 5; i++) {
				sql = "insert into MEMBER(EMAIL, PASSWORD, NAME, REGDATE)" + "values('virus" + i
						+ "@virus.net' , '1234','std" + i + "' , now())";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}
}
