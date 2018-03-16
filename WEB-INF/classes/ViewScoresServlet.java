import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
public class ViewScoresServlet extends HttpServlet
{
	Connection cn;
	public void init()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		}
		catch(Exception k)
		{
			k.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try
		{
			String u1=req.getParameter("uname");
			PreparedStatement ps=cn.prepareStatement("select * from ViewScores where uname=?");
			ps.setString(1,u1);
			out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='login.css'>");
			out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
			out.println("<body><div class='container'><div class='banner' align='center' style='font-size:70px'><img src='./images/BB.png'/></div><hr>");
			out.println("<div class='main'>");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				out.println("Candidate Name:"+rs.getString(1));
				out.println("<br>");
				out.println("Date of Quiz Conducted :"+rs.getDate(3));
				out.println("<br>");				
				out.println("Score :"+rs.getString(4)+"<hr>");
				rs.next();
			}
			
				
		}
		catch (Exception k)
		{
			out.println("Error!!!!!!");
		}
	}
}