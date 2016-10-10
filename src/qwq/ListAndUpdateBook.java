package qwq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

public class ListAndUpdateBook extends ActionSupport {

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
		String sql = "SELECT Title FROM Book";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ActionContext ctx = ActionContext.getContext();
		ctx.put("tip", "对不起，您查询的作者不存在");
		
		while(rs.next()) {
			title = rs.getString(1);
			resultstr.add(title);
			ctx.put("tip", "您查询的图书信息如下");
			ret = SUCCESS;
		}
		
		if(conn != null) {	
			conn.close();
		}
		return ret;
	}
}
