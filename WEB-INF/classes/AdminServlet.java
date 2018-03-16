import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
public class AdminServlet extends HttpServlet
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
		HttpSession session=req.getSession();
		session.setAttribute("uname",u);
		System.out.println(u);
		try
		{
			PreparedStatement ps=cn.prepareStatement("select uname,pwd from Admin_reg where uname=? and pwd=?");
			ps.setString(1,u);
			ps.setString(2,p);
			ResultSet rs=ps.executeQuery();
			rs.next();
				if((u.equals(rs.getString(1)))&&(p.equals(rs.getString(2))))
				{
				out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='Admin.css'>");
        				out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
				out.println("<body><div class='container'><div class='banner' align='center' style='font-size:70px'><img src='./images/BB.png'/></div><hr><br><br>");
        				out.println("<div class='main'>");
				out.println("<table><tr>");
				out.println("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='submit' class='a' value='Home' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:130px;font-size:20px'>&nbsp&nbsp&nbsp");
				out.println("<form action='AddQuestions.html'>");
     				out.println("<input type='submit' class='a' value='Add Questions' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'>&nbsp&nbsp&nbsp");
				out.println("</form>");
				out.println("<form action='DeleteQuestions.html'>");
		     		out.println("<input type='submit' class='a' value='Delete Questions' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'>&nbsp&nbsp&nbsp");	                     		
				out.println("</form>");
				out.println("<form action='ViewQuestions.html'>");
				out.println("<input type='submit' class='a'value='View Questions' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'>&nbsp&nbsp&nbsp");
	            			out.println("</form>");
				out.println("<form action='./Aviewprofile'>");
				out.println("<input type='submit' class='a' value='View Profile' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'>&nbsp&nbsp&nbsp");
				out.println("</form>");
				out.println("<form action='LoginPage.html'>");
			    	out.println("<input type='submit' class='a' value='LogOut' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:130px;font-size:20px'>&nbsp&nbsp&nbsp");
				out.println("</form>");
				out.println("</tr></table><br><br>");
				out.println("<center><h1><p><b>Welcome Administrator");
				out.println("</div></body></html> ");
				}
				else
					out.println("Enter Valid Administrator Details");
	}
		catch (Exception k)
		{
			out.println("<html><body bgcolor='Grey'>");
			out.println("<h1>Please Enter Valid UserName and Password</h1>");
		}
	}
}