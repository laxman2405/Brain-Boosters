import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
public class SignInServlet extends HttpServlet
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
		String u=req.getParameter("u1");
		String p=req.getParameter("p1");
		String q=req.getParameter("q1");
		String s=req.getParameter("s1");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try
		{
			PreparedStatement ps=cn.prepareStatement("insert into user_reg values(?,?,?,?)");
			ps.setString(1,u);
			ps.setString(2,p);
			ps.setString(3,q);
			ps.setString(4,s);
			int x=ps.executeUpdate();
			if(x>0)
			{
				out.println("<h1> Hi '+u+'..... Thank you for Registering ....</h1>");
				out.println("<h1> You have Successfully Created an Account in our Web-Site</h1>");
			}
		}
		catch (Exception k)
		{
			k.printStackTrace();
		}
	}
}