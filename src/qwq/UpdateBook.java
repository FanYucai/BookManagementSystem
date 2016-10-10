package qwq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateBook extends ActionSupport {

	private String id;
	private String isbn;
	private String title;
	private String authorid;
	private String publishdate;
	private String price;
	private String publisher;
	private String authorname;
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getAuthorname() {
		return authorname;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAuthorid() {
		return authorid;
	}
	
	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getPublishdate() {
		return publishdate;
	}
	
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String execute() throws Exception {
		String ret = SUCCESS;
//		String URL = "jdbc:mysql://localhost/BookDB";
		String URL = "jdbc:mysql://eshgjxkzwyfg.rds.sae.sina.com.cn:10436/bookdb";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, "root", "12345678");
		
		String sql1 = "SELECT Authorid FROM Author WHERE Name=?";
		String sql2 = "UPDATE Book SET Title=?, Authorid=?, Publisher=?, Publishdate=?, Price=? WHERE ISBN=?";

		PreparedStatement ps1 = conn.prepareStatement(sql1);
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		
		ps1.setString(1, name);
		ResultSet rs1 = ps1.executeQuery();
		if(rs1.next()) {
			authorid=rs1.getString(1);
			
			ps2.setString(6, isbn);
			ps2.setString(1, title);
			ps2.setString(2, authorid);
			ps2.setString(3, publisher);
			ps2.setString(4, publishdate);
			ps2.setString(5, price);
			
			ps2.executeUpdate();
//			ret = SUCCESS;
			if(name.equals(authorname)) {
				ret = SUCCESS;//如果name＝authorname则不更新author
			} else {
				String sql3 = "UPDATE Author SET Name=? WHERE AuthorID=?";
				PreparedStatement ps3 = conn.prepareStatement(sql3);
				ps3.setString(1, authorname);
				ps3.setString(2, authorid);
				ps3.executeUpdate();
				ret = SUCCESS;
			}
		} 
//		if(rs1.next()) {
//			authorid=rs1.getString(1);
//			ps2.setString(6, isbn);
//			ps2.setString(1, title);
//			ps2.setString(2, authorid);
//			ps2.setString(3, publisher);
//			ps2.setString(4, publishdate);
//			ps2.setString(5, price);
//			ps2.executeUpdate();
////			ret = SUCCESS;
//			}
//		

		if(conn != null) {	
			conn.close();
		}
		return ret;
	}
}
