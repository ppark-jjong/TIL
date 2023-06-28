package week05;

public class PropertyEx {
	private String jdbcDriver;
	private String jdbcUrl;
	private String username;
	private String password;

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	@Override
	public String toString() {
		return "PropertyEx [jdbcDriver=" + jdbcDriver + ", jdbcUrl=" + jdbcUrl + ", username=" + username
				+ ", password=" + password + "]";
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
