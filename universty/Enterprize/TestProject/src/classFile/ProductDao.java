package classFile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProductDao {

	private JdbcTemplate jdbcTemplate;

	public ProductDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public ProductDao() {
	}

	List<Item> selectAll(String maker) {
		List<Item> results = jdbcTemplate.query("select * from Item", new RowMapper<Item>() {
			@Override
			public Item mapRow(ResultSet arg0, int arg1) throws SQLException {
				Item item = new Item(arg0.getString("ITEMNAME"), arg0.getString("MAKER"), arg0.getInt("PRICE"));
				return item;
			}
		});
		return results;
	}

	void insert(Order order) {
		jdbcTemplate.update("insert into Item (ITEMNAME, MAKER, NUM) values (?, ?, ?)", order.getItemName());
	}

}
