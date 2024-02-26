

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import  java.sql.ResultSet;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
	
		String dburl = "jdbc:mysql://localhost:3306/Temp_Database";
		String dbusr = "root";
		String dbpass = "root";
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		PrintWriter out  = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl, dbusr, dbpass);
			
			String qry = "select * from tmp_regi where uname = ? and pass = ?";
			
			PreparedStatement ps = con.prepareStatement(qry);
		
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			 if(rs.next()) {
			
				 out.println("Login Successfully");
			 }else {
				 out.println("no Successfully");
			}
			
		} catch (Exception e) {
			out.println("Login Failed........  "+e);
			
		}
	}

}
