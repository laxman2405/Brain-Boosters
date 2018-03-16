import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
public class SViewProfileServlet extends HttpServlet
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
		try
		{
			HttpSession session=req.getSession(false);
			String u=(String)session.getAttribute("uname");
			System.out.println("User Name:"+u);
			PreparedStatement ps=cn.prepareStatement("select * from User_reg where uname='"+u+"'");
			ResultSet rs=ps.executeQuery();
			rs.next();
			out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='login.css'>");
       			out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
			out.println("<body style='background-color:lightblue'><div class='container'><div class='banner' align='center' style='font-size:70px'><img src='./images/BB.png'/></div><hr>");
        			out.println("<div class='main'>");
			out.println("<center><h2>Your Current Profile<hr width='30%'></h2></center><br>");
			out.println("<p><b>UserName: &nbsp&nbsp&nbsp&nbsp"+rs.getString(1)+"<br>");
			out.println("<p><b>Password:&nbsp&nbsp&nbsp&nbsp"+rs.getString(2)+"<br>");
			out.println("<p><b>FatherName:&nbsp&nbsp&nbsp&nbsp"+rs.getString(3)+"<br>");
			out.println("Date of Birth:&nbsp&nbsp&nbsp&nbsp"+rs.getString(4)+"<br>");
			out.println("<p><b>Gender:&nbsp&nbsp&nbsp&nbsp"+rs.getString(5)+"<br>");
			out.println("<p><b>College Name:&nbsp&nbsp&nbsp&nbsp"+rs.getString(6)+"<br>");
			out.println("<p><b>College Code:&nbsp&nbsp&nbsp&nbsp"+rs.getString(7)+"<br>");
			out.println("<p><b>10th GPA:&nbsp&nbsp&nbsp&nbsp"+rs.getString(8)+"<br>");
			out.println("<p><b>PolyCet Rank:&nbsp&nbsp&nbsp&nbsp"+rs.getString(9)+"<br>");
			out.println("<p><b>Mobile Number:&nbsp&nbsp&nbsp&nbsp"+rs.getString(10)+"<br>");
			out.println("<p><b>E-Mail ID:&nbsp&nbsp&nbsp&nbsp"+rs.getString(11)+"<br>");
			out.println("<p><b>Address:&nbsp&nbsp&nbsp&nbsp"+rs.getString(12)+"<br>");
			out.println("<p><b>Pincode:&nbsp&nbsp&nbsp&nbsp"+rs.getString(13)+"<br>");
			out.println("</div></body><br>");
			out.println("<table align=center cellpadding=0><tr>");
			out.println("<form action='SUpdateProfile.html'>");
			out.println("<center><input type='submit' class='a' value='Update Profile' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'>");
			out.println("</form><hr>");
			out.println("<div align='right'><form action='LoginPage.html' ><input type='submit' class='a'  value='Log Out' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:150px;font-size:20px' ></form></div>");           
			out.println("</tr></table>");
			System.out.println("User :"+u);
			out.println("<form action='./updateprofile'>");
			session.setAttribute("user",u);
			out.println("</form></html> ");
		}
		catch (Exception k)
		{
			k.printStackTrace();
		}
	}
}