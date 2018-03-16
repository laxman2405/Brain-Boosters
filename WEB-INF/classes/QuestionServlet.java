import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class QuestionServlet extends HttpServlet
{
	Connection cn;
	public void init()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		}
		catch (Exception a)
		{
			a.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		int count=0;
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		RequestDispatcher rd=req.getRequestDispatcher("./Timer.html");
		rd.include(req,res);
		out.println("<!doctype html><html lang='en-US'><head><title>WebCraft</title><link rel='stylesheet' type='text/css' href='login.css'>");
		out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
		out.println("<body><div class='container'><hr>");
		out.println("<div class='main'>");
		out.println("<h1> <center><u>---Let's Start the Quiz---</center></u></h1><br/>");
		out.println("<form action='./answer'>");
		try
		{
			PreparedStatement ps1=cn.prepareStatement("select * from Questions");
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				count++;
			}
			Random r=new Random();
			int a[]=new int[10];
			int k;
			boolean loop;
			for (int i=0; i<10; i++)
			{
				loop=true;
				a[i]=r.nextInt(count+1);
				while(a[i]==0)
				{
					a[i]=r.nextInt(count+1);
				}
				while(loop==true)
				{
					k=0;
					while(a[i]!=a[k])
						k++;
					if(k<i)
					{
						while(a[k]==a[i])
						{
							a[i]=r.nextInt(count+1);
						}
					}
					else
						loop=false;
				}
			System.out.print(a[i]+"\t");
			PreparedStatement ps=cn.prepareStatement("select * from Questions where sno=?");
			ps.setInt(1,a[i]);
			ResultSet rs=ps.executeQuery();
			rs.next();
				out.println("<h1>");
				out.println("<font face='Albertus' size='5'>");
				out.println((i+1)+":"+rs.getString(2));
				out.println("</font>");
				out.println("</h1>");
				out.println("<h3>");
				out.println("<font face='Albertus' size='5'>");
				out.println("<input type='radio' name='option"+(i+1)+"' value='"+rs.getString(3)+"' required='required'/>"+rs.getString(3));
				out.println("<br>");
				out.println("<input type='radio' name='option"+(i+1)+"' value='"+rs.getString(4)+"' required='required'/>"+rs.getString(4));
				out.println("<br>");
				out.println("<input type='radio' name='option"+(i+1)+"' value='"+rs.getString(5)+"' required='required'/>"+rs.getString(5));
				out.println("<br>");
				out.println("<input type='radio' name='option"+(i+1)+"' value='"+rs.getString(6)+"' required='required'/>"+rs.getString(6));
				out.println("<br>");
				out.println("</font>");
				out.println("</h3><hr>");
			}				
					out.println("<input type= hidden name=sub value='"+s2+"'>"); 
					out.println("<center><input type='submit' class='a' value='Submit'  height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:150px;font-size:20px'>");
					out.println("</form></font></body></html>");	 
		}
		catch (Exception p)
		{
			out.println("Error getting Questions!!");
		}
	}
}