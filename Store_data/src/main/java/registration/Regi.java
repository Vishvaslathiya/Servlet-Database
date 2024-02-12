package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/Regi")
public class Regi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				 
		String dburl = "jdbc:mysql://localhost:3306/test";
		String dbuser = "root";
		String dbpass = "root"; 
		
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String mail = request.getParameter("mail");
		String age = request.getParameter("age");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection c = DriverManager.getConnection(dburl,dbuser,dbpass);
			
			PreparedStatement p = c.prepareStatement("insert into tbl_user values(?,?,?)");
			
			p.setString(1, fname);
			p.setString(2, mail);
			p.setString(3, age);
			
			int i = p.executeUpdate();
			
			if (i > 0) {
				out.print("Registered Succesfully");
			}
		
			
			
			
		} catch (Exception e) {
			out.print("Registered Not"+e);
		}
		
		 
	}

}
