package week11;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//DB에 Access 하는 클래스 = DAO
public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// Ex 2
	public List<Member> selectAll() {
		// List<T> ex = (sql, RomMapper<T> rowMapper)로 DB 객체를 List 형식으로 받는다
		List<Member> results = jdbcTemplate.query("select * from MEMBER", new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet arg0, int arg1) throws SQLException {
				Member member = new Member(arg0.getString("EMAIL"), arg0.getString("PASSWORD"), arg0.getString("NAME"),
						arg0.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(arg0.getLong("ID"));
				return member;
			}
		});
		return results;
	}

	// Ex 3 -> Ex 2와 다르게 2번째 인자로 객체를 직접 생성하는게 아닌 인터페이스 한 메서드를 선언하여 객체 자동 생성을 목적으로
	// 한다.
	public List<Member> selectAllUsingParameter(String name) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where name = ?", new MemberRowMapper(), name);
		return results;
	}

	// Ex 4
	public Member selectInfoID(int ID, String name) {
		// Ex 3 메서드와 다르게 인자로 데이터 값을 받는 것이 아닌,
		// 파라미터 값을 저장하기 위한 Object 타입의 배열을 이용할 수 있다. (인자 순서도 다름)
		Object[] args = { ID, name };
		Member member = jdbcTemplate.queryForObject("select * from MEMBER where ID = ? and NAME =?", args,
				new MemberRowMapper());
		return member;
	}

	// Ex 5 Update 메서드
	public void updateInfo(String name, String passwd, String email) {
		jdbcTemplate.update("update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?", name, passwd, email);
	}
}
