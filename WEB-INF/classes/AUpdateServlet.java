import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
public class AUpdateServlet extends HttpServlet
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
		int c=0;
		String u=req.getParameter("u1");
		String pwd1=req.getParameter("p1");
		String pwd2=req.getParameter("p2");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='Admin.css'>");
        	out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
		out.println("<body style='background-color:lightblue'><div class='container'><div class='banner' align='center' style='font-size:70px'><img src='./images/BB.png'/></div><hr><br><br>");
        	out.println("<div class='main'>");
		try
		{
			if(pwd1.equals(pwd2))
			{
			PreparedStatement ps=cn.prepareStatement("update Admin_reg set pwd=? where uname=?");
			ps.setString(1,pwd1);
			ps.setString(2,u);
		    	c=ps.executeUpdate();
			}
			else
			{
			out.println("Passwords are not Matched");
			}			
			if(c>0)
			{
				out.println("Passwords are Matched and Updated");
			}
			else 	
				{
				out.println("Invalid Username");
			 }
		}
		catch (Exception k)
		{
			k.printStackTrace();
		}
	}
}