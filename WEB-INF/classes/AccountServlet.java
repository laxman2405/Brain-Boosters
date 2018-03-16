import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
public class AccountServlet extends HttpServlet
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
		String pwd=req.getParameter("p1");
		String fname=req.getParameter("f1");
		String dob=req.getParameter("dob1");
		String gender=req.getParameter("g");
		String college=req.getParameter("c");
		int code=Integer.parseInt(req.getParameter("c1"));
		String  gpa=req.getParameter("g1");
		int Prank=Integer.parseInt(req.getParameter("pr1"));
		String mobile=req.getParameter("m1");
		String email=req.getParameter("e1");
		String address=req.getParameter("a1");
		int pincode=Integer.parseInt(req.getParameter("pc1"));
		PrintWriter out=res.getWriter();
		out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='login.css'>");
        	out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
		out.println("<body style='background-color:lightblue'><div class='container'><div class='banner' align='center' style='font-size:70px'><img src='./images/BB.png'/></div><hr>");
        	out.println("<div class='main'>");
		res.setContentType("text/html");
		try
		{
			PreparedStatement ps=cn.prepareStatement("insert into User_reg values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,u);
			ps.setString(2,pwd);
			ps.setString(3,fname);
			ps.setString(4,dob);
			ps.setString(5,gender);
			ps.setString(6,college);
			ps.setInt(7,code);
			ps.setString(8,gpa);
			ps.setInt(9,Prank);
			ps.setString(10,mobile);
			ps.setString(11,email);
			ps.setString(12,address);
			ps.setInt(13,pincode);
			int count = ps.executeUpdate();
			if (count>0)
			{
			out.println( count+"Rows Inserted");
			out.println("<h1>You have Successfully Created an Account</h1>");
			}
		}
		catch (Exception k)
		{
			k.printStackTrace();
		}
	}
}