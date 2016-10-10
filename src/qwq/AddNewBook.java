package qwq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

public class AddNewBook extends ActionSupport {

	private String isbn;
	private String authorid;
	private String publisher;
	private String title;
	private String publishdate;
	private String price;
	private String name;
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPublishdate() {
		return publishdate;
	}
	
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}

	public String getAuthorid() {
		return authorid;
	}
	
	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String execute() throws Exception {
		String ret = ERROR;
//		String URL = "jdbc:mysql://localhost/BookDB";
		String URL = "jdbc:mysql://eshgjxkzwyfg.rds.sae.sina.com.cn:10436/bookdb";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, "root", "12345678");
		
//		String askCount = "select count(*) from author";
//		PreparedStatement cntps = conn.prepareStatement(askCount);
//		ResultSet rscnt = cntps.executeQuery();
//		if(rscnt.next()) {
//			authorid = String.valueOf(Integer.parseInt(rscnt.getString(1)));
//		}
//		authorid = "00000099"; get authorid;
		
		String sql2 = "select authorid from Author where name=?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.setString(1, name);
		ResultSet rs2 = ps2.executeQuery();
		if(rs2.next()) {
			authorid = rs2.getString(1);
		}
		
		String sql = "insert into Book values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, isbn);
		ps.setString(2, title);
		ps.setString(3, authorid);
		ps.setString(4, publisher);
		ps.setString(5, publishdate);
		ps.setString(6, price);
		if(ps.executeUpdate() != 0) {
			ret = SUCCESS;
		}
		
		if (conn != null) {	
			conn.close();
		}
		return ret;
	}
}
