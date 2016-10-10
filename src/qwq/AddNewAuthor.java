package qwq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

public class AddNewAuthor extends ActionSupport {

	private String name;
	private String authorid;
	private String age;
	private String title;
	private String country;
	private String price;
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthorid() {
		return authorid;
	}
	
	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}
	
	public String execute() throws Exception {
		String ret = ERROR;
//		String URL = "jdbc:mysql://localhost/BookDB";
		String URL = "jdbc:mysql://eshgjxkzwyfg.rds.sae.sina.com.cn:10436/bookdb";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, "root", "12345678");
		
		String askCount = "select count(*) from Author";
		PreparedStatement cntps = conn.prepareStatement(askCount);
		ResultSet rscnt = cntps.executeQuery();
		if(rscnt.next()) {
			authorid = String.valueOf(Integer.parseInt(rscnt.getString(1))+1);
		}
		
		String askdup = "select name from Author where authorid=?";
		PreparedStatement askdupps = conn.prepareStatement(askdup);
		ResultSet duprs;
		
		do {
			authorid = String.valueOf(Integer.parseInt(authorid)+1);
			askdupps.setString(1, authorid);
			duprs = askdupps.executeQuery();
		} while(duprs.next());

		System.out.println("authorid = " + authorid);
		String sql = "insert into Author values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, authorid);
		ps.setString(2, name);
		ps.setString(3, age);
		ps.setString(4, country);
		
		if(ps.executeUpdate() != 0) {
			ret = SUCCESS;
		}
		
		if (conn != null) {	
			conn.close();
		}
		return ret;
	}
}
