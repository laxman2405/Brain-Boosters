import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
public class DeleteQuestionsServlet extends HttpServlet
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
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		String S=req.getParameter("s1");
		String D=req.getParameter("d1");
		try
		{
		PreparedStatement ps=cn.prepareStatement("delete from "+S+" where sno=?");
			ps.setString(1,D);
			int c=ps.executeUpdate();
			if (c>=0)
			{
					out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='delqn_css.css'>");
        			out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
					out.println("<body><div class='container'><div class='banner' align='center' style='font-size:70px'><img src='./images/BB.png'/></div><hr>");
        			out.println("<div class='main'>");
					out.println("<form action='DeleteQuestions.html'>");   
					out.println("<center><h2><p><b> "+S+" Question is Deleted</h2></center>");
			         out.println("<input type='submit' class='a' value='Delete Another Question' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:250px;font-size:20px' ></form><hr></div>");
					 out.println("<div align='right'><form action='LoginPage.html' ><input type='submit' class='a' value='Log Out' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:150px;font-size:20px' ></form></div>");           
    	    		out.println("</div></body></html> ");
			}
		}
		catch (Exception k)
		{
			out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='delqn_css.css'>");
        	out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
			out.println("<body><div class='container'><div class='banner' align='center' style='font-size:50px'>Brain Boosters</div><hr>");
			out.println("<h1>Please Enter Valid Details</h1>");
			out.println("</div></body></html> ");
		}
	}
}