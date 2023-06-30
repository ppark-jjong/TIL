package homework3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BookDao {
	private JdbcTemplate jdbcTemplate;

	//생성자로 DataSource를 받는데 해당 DataSource에는 DB 연결 path와 지정문이 들어있는 메서드를 리턴 받아야 한다
	public BookDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public BookDao() {
	}

	public int search(String name) {
		Integer count = jdbcTemplate.queryForObject("select count(*) from Book where name = ?", Integer.class, name);
		return count;
	}

	public List<Book> selectAll() {
		List<Book> results = jdbcTemplate.query("select * from BOOK", new RowMapper<Book>() {
			@Override
			public Book mapRow(ResultSet arg0, int arg1) throws SQLException {
				Book book = new Book(arg0.getString("NAME"));
				return book;
			}
		});
		return results;
	}

	public void insert(Book book) {
		jdbcTemplate.update("insert into Book (NAME) values (?)", book.getName());
	}

	public void update(String newName, String oldName) {
		jdbcTemplate.update("update Book set NAME = ? where NAME = ?", newName, oldName);
	}

	public void delete(String name) {
		jdbcTemplate.update("delete from Book where NAME = ?", name);
	}

}