import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet
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
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try
		{
			PreparedStatement ps=cn.prepareStatement("select uname,pwd from User_reg where uname=? and pwd=?");
			ps.setString(1,u);
			ps.setString(2,p);
			HttpSession session=req.getSession();
			session.setAttribute("uname",u);
			ResultSet rs=ps.executeQuery();
			rs.next();
			out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='login.css'>");
        			out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
			out.println("<body><div class='container'><div class='banner' align='center' style='font-size:70px'><img src='./images/BB.png'/></div><hr><br><br>");
        			out.println("<div class='main'>");
			out.println("<table><tr>");
			if((u.equals(rs.getString(1)))&&(p.equals(rs.getString(2))))
				{
				out.println("&nbsp&nbsp&nbsp&nbsp&nbsp<input type='submit' class='a'  value='Home' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:130px;font-size:20px'>&nbsp&nbsp&nbsp");
				out.println("<form action='./score'>");
				HttpSession session1=req.getSession();
				session1.setAttribute("u2",u);
				out.println("</form>");
				out.println("<form action='./year'>");
				out.println("<input type='submit' class='a' value='View Topics' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'>&nbsp&nbsp&nbsp");
				out.println("</form>");
				out.println("<form action='./Sviewprofile'>");
				out.println("<input type='submit' class='a'  value='View Profile' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'>&nbsp&nbsp&nbsp");
				out.println("</form>");
				out.println("<form action='./viewscores'>");
				out.println("<input type= hidden name=uname value='"+u+"'>");
				out.println("<input type='submit' class='a'  value='View Previous Scores' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:250px;font-size:20px'>&nbsp&nbsp&nbsp");
				out.println("</form>");
				out.println("<form action='LoginPage.html'>");
				out.println("<input type='submit' class='a'  value='LogOut' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:130px;font-size:20px'>&nbsp&nbsp&nbsp");
				out.println("</tr></table><br><br>");
				out.println("<center><h1>Welcome Student, "+u);
				out.println("</div></div></body></html> ");
				}
				else
					out.println("Please Create a New Account and Try Again...");
		}
		catch (Exception k)
		{
			out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='login.css'>");
        			out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
			out.println("<body><div class='container'><div class='banner' align='center' style='font-size:50px'>Brain Boosters</div><hr><br><br>");
        			out.println("<div class='main'>");
			out.println("<h1>Please Enter Valid UserName and Password</h1>");
			out.println("</div></body></html> ");
		}
	}
}