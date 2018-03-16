import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
public class ViewQuestionsServlet extends HttpServlet
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
		String S=req.getParameter("s1");
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		try
		{
			PreparedStatement ps=cn.prepareStatement("select * from "+S+" order by sno");
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{
				out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='add_css.css'>");
				out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
				out.println("<body style='background-color:lightblue'><div class='container'>");
				out.println("<div class='main'>");
				out.println("<p><b>Sno : "+rs.getInt(1)+"<br>");
				out.println("<p><b>Question : "+rs.getString(2)+"<br>");
				out.println("<p><b>Option 1 : "+rs.getString(3)+"<br>");
				out.println("<p><b>Option2 : "+rs.getString(4)+"<br>");
				out.println("<p><b>Option 3 : "+rs.getString(5)+"<br>");
				out.println("<p><b>Option 4 : "+rs.getString(6)+"<br>");
				out.println("<p><b>Answer : "+rs.getString(7)+"<br><br><br><br><br><br>");
				out.println("<hr>");
				out.println("</div></body></html> ");
			}
								out.println("<div align='right'><form action='LoginPage.html' ><input type='submit' class='a' value='Log Out' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:150px;font-size:20px' ></form></div>");           

		}
		catch (Exception k)
		{
			out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='add_css.css'>");
				out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
				out.println("<body style='background-color:lightblue'><div class='container'>");
				out.println("<div class='main'>");
			out.println("<h1> Choose Valid Subject Name</h1>");
			out.println("</div></body></html> ");
		}
	}
}
		