

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
 
@WebServlet("/regi")
public class regi extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		String dburl = "jdbc:mysql://localhost:3306/Temp_Database";
		String dbusr = "root";
		String dbpass = "root";
		
		PrintWriter out  = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl, dbusr, dbpass);
			
			PreparedStatement qry = con.prepareStatement("insert into tmp_regi values(?,?,?)");
			
			qry.setString(1, uname);
			qry.setString(2, email);
			qry.setString(3, pass);
			
			qry.executeUpdate();

			
			out.println("Registered Successfully");
			
			
		} catch (Exception e) {
			out.println("Restart........  ");
			
		}
	}

}
