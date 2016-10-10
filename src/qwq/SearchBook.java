package qwq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

public class SearchBook extends ActionSupport {

	private String authorsname;
	private String authorid;
	private String name;
	private String title;
	private String isbn;
	private ArrayList resultstr = new ArrayList();
	
	public String getAuthorsname() {
		return authorsname;
	}
	
	public void setAuthorsname(String authorsname) {
		this.authorsname = authorsname;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList getResultstr() {
		return resultstr;
	}
	
	public void setResultstr(ArrayList resultstr) {
		this.resultstr = resultstr;
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
//		String ret = SUCCESS;
//		String URL = "jdbc:mysql://localhost/BookDB";
		String URL = "jdbc:mysql://eshgjxkzwyfg.rds.sae.sina.com.cn:10436/bookdb";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, "root", "12345678");
		String sql = "SELECT authorid FROM Author WHERE";
		sql += " Name = '";
		sql += authorsname;
		sql += "'";
		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, authorsname);
		ResultSet rs = ps.executeQuery();
		
		ActionContext ctx = ActionContext.getContext();
		String tipstr;
		tipstr = authorsname;
		ctx.put("tip", tipstr+" 的查询结果:");
		
		while(rs.next()) {
			authorid = rs.getString(1);
			String sql2 = "SELECT title FROM Book WHERE";
			sql2 += " authorid = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, authorid);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()) {
				title = rs2.getString(1);
				resultstr.add(title);
				ctx.put("tip", "您查询的图书信息如下");
				ret = SUCCESS;
			}
		}
	
//		if (ret.equals(SUCCESS)) {
//			//ctx.put("authorsname", "xxxxxxx");
////			ctx.put("title", title);
//		}
		
		if(conn != null) {	
			conn.close();
		}
		return ret;
	}
}
