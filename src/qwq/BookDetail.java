package qwq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookDetail extends ActionSupport {

	private String id;
	private String isbn;
	private String title;
	private String authorid;
	private String publishdate;
	private String price;
	private String publisher;
	private String authorname;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthorname() {
		return authorname;
	}
	
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
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
		String tle = getId();
//		String URL = "jdbc:mysql://localhost/BookDB";
		String URL = "jdbc:mysql://eshgjxkzwyfg.rds.sae.sina.com.cn:10436/bookdb";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, "root", "12345678");
		
		String sql1 = "SELECT ISBN FROM Book WHERE";
		sql1 += " Title = ?";
		String sql2 = "SELECT AuthorID FROM Book WHERE";
		sql2 += " Title = ?";
		String sql3 = "SELECT Publisher FROM Book WHERE";
		sql3 += " Title = ?";
		String sql4 = "SELECT PublishDate FROM Book WHERE";
		sql4 += " Title = ?";
		String sql5 = "SELECT Price FROM Book WHERE";
		sql5 += " Title = ?";
		String sql6 = "SELECT Name FROM Author WHERE";
		sql6 += " AuthorID = ?";
//		
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		PreparedStatement ps3 = conn.prepareStatement(sql3);
		PreparedStatement ps4 = conn.prepareStatement(sql4);
		PreparedStatement ps5 = conn.prepareStatement(sql5);
		PreparedStatement ps6 = conn.prepareStatement(sql6);
		
		ps1.setString(1, tle);
		ps2.setString(1, tle);
		ps3.setString(1, tle);
		ps4.setString(1, tle);
		ps5.setString(1, tle);

		ResultSet rs1 = ps1.executeQuery();
		ResultSet rs2 = ps2.executeQuery();
		ResultSet rs3 = ps3.executeQuery();
		ResultSet rs4 = ps4.executeQuery();
		ResultSet rs5 = ps5.executeQuery();
		
//		
		ActionContext ctx = ActionContext.getContext();
		ctx.put("tip", tle);
		
		title = tle;
		if(rs1.next()) {
			isbn = rs1.getString(1);
//			ctx.put("tip", isbn);
		}
		if(rs2.next()) {
			authorid = rs2.getString(1);
			ps6.setString(1, authorid);
			ResultSet rs6 = ps6.executeQuery();
			if(rs6.next()) {
				authorname = rs6.getString(1);
			}
//			ctx.put("tip", authorid);
		}
		if(rs3.next()) {
			publisher = rs3.getString(1);
//			ctx.put("tip", publisher);
		}
		if(rs4.next()) {
			publishdate = rs4.getString(1);
//			ctx.put("tip", publishdate);
		}
		if(rs5.next()) {
			price = rs5.getString(1);
//			ctx.put("tip", price);
		}
//		
		if(conn != null) {	
			conn.close();
		}
		return ret;
	}
}
