import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
public class UpdateServlet extends HttpServlet
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
		try
		{
			if(pwd1.equals(pwd2))
			{
			PreparedStatement ps=cn.prepareStatement("update User_reg set pwd=? where uname=?");
			ps.setString(1,pwd1);
			ps.setString(2,u);
		    c=ps.executeUpdate();
			}
			else
			{
			out.println("<html><body bgcolor='#78BCBC'><font face='monotypecorsiva' size=10>");
			out.println("Passwords are not Matched");
			}			
			if(c>0)
			{
				out.println("<html><body bgcolor='#78BCBC'><font face='monotypecorsiva' size=10>");
				out.println("Passwords are Matched and Updated");
			}
			else 	
				{
				out.println("<html><body bgcolor='#78BCBC'><font face='monotypecorsiva' size=10>");
				out.println("Invalid Username");
			 }
		}
		catch (Exception k)
		{
			k.printStackTrace();
		}
	}
}