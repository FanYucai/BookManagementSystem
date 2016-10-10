package qwq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

public class AddNewWhat extends ActionSupport {

	private String name;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String execute() throws Exception {
		String ret = ERROR;
//		String URL = "jdbc:mysql://localhost/BookDB";
		String URL = "jdbc:mysql://eshgjxkzwyfg.rds.sae.sina.com.cn:10436/bookdb";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, "root", "12345678");
		
		String sql = "SELECT * FROM Author WHERE Name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			ret = SUCCESS;
		}
		
		if (conn != null) {	
			conn.close();
		}
		return ret;
	}
}
