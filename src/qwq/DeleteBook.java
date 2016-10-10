package qwq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteBook extends ActionSupport {

	private String id;
	private String title;

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title ;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String ret = ERROR;
//		String ret = SUCCESS;
//		String URL = "jdbc:mysql://localhost/BookDB";
		String URL = "jdbc:mysql://eshgjxkzwyfg.rds.sae.sina.com.cn:10436/bookdb";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, "root", "12345678");

		String sql = "SELECT AuthorID FROM Book WHERE Title=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();	
		
		String sqldel = "DELETE FROM Book WHERE Title=?";
		PreparedStatement psdel = conn.prepareStatement(sqldel);
		psdel.setString(1, id);		
		title = id;
		psdel.executeUpdate();

		if(rs.next()) {
			String authorid = rs.getString(1);
			id = authorid;
			String au = "SELECT Title FROM Book WHERE AuthorID=?";
			PreparedStatement psau = conn.prepareStatement(au);
			psau.setString(1, authorid);
			ResultSet rsau = psau.executeQuery();
			if(!rsau.next()) {
				String delau = "DELETE FROM Author WHERE AuthorID=?";
				PreparedStatement delaups = conn.prepareStatement(delau);
				delaups.setString(1, authorid);		
				delaups.executeUpdate();
			}
		}
		
//		String sql = "DELETE FROM Book WHERE ISBN=?";
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, id);
//		System.out.println("成功删除"+ps.executeUpdate()+"条数据");
//		ResultSet rs = ps.executeQuery();

		return SUCCESS;
	}
}
