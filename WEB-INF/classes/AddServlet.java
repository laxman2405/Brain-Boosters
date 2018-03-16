import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
public class AddServlet extends HttpServlet
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
		HttpSession session=req.getSession(false);
		String subject=(String)session.getAttribute("sub");
		int s=Integer.parseInt(req.getParameter("S1"));
		String q=req.getParameter("q1");
		String op1=req.getParameter("o1");
		String op2=req.getParameter("o2");
		String op3=req.getParameter("o3");
		String op4=req.getParameter("o4");
		String ans=req.getParameter("a1");
		res.setContentType("text/html");
		try
		{
			PreparedStatement ps=cn.prepareStatement("insert into "+subject+" values (?,?,?,?,?,?,?)");
			ps.setInt(1,s);
			ps.setString(2,q);
			ps.setString(3,op1);
			ps.setString(4,op2);
			ps.setString(5,op3);
			ps.setString(6,op4);
			ps.setString(7,ans);
			int c=ps.executeUpdate();
			if (c>0)
			{
				out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='add_css.css'>");
				out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
				out.println("<body><div class='container'><div class='banner' align='center' style='font-size:70px'><img src='./images/BB.png'/></div><hr>");
				out.println("<div class='main'>");
				out.println("<center><h2><p><b>"+subject+" Question is Inserted</h2></center>");
				out.println("<form action='AddQuestions.html'>");
				out.println("<input type='submit' class='a' value='Add New Question' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:200px;font-size:20px'>");
				out.println("</form><hr>");
				out.println("<div align='right'><form action='LoginPage.html' ><input type='submit' class='a' value='Log Out' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:150px;font-size:20px' ></form></div>");           
    			 	out.println("</div></body></html> ");
			}
		}
		catch (Exception k)
		{
				out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='add_css.css'>");
				out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
				out.println("<body style='background-color:lightblue'><div class='container'><div class='banner' align='center' style='font-size:50px'>Brain Boosters</div><hr>");
				out.println("<div class='main'>");
				out.println("<h1>Please Enter Valid Details</h1>");
				out.println("</div></body></html> ");
		}
	}
}