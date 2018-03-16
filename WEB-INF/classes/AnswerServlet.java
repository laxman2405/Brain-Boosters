import javax.servlet.*;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class AnswerServlet extends HttpServlet
{
	String u3;
	Connection cn;
	public void init()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		}
		catch (Exception k)
		{
			k.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		String option[]=new String[10];
		int sno[]=new int[5];
		int i=0,score=0;
		int size=0;
		PrintWriter out=response.getWriter();
				out.println("<form action='./score'>");
				HttpSession session1=request.getSession();
				session1.setAttribute("subject",sub);
				out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='login.css'>");
				out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
				out.println("<body><div class='container'><div class='banner' align='center' style='font-size:70px'><img src='./images/BB.png'/></div><hr>");
				out.println("<div class='main'>");
		try
		{
			for (int p=1;p<=10;p++ )
			{
				option[p-1]=request.getParameter("option"+p);
				System.out.println(option[p-1]);
			}
			PreparedStatement ps=cn.prepareStatement("select Answer from Questions");
			ResultSet rs1=ps.executeQuery();
			while(rs1.next())
			{
				size++;
			}
			String Ans[]=new String[size];
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Ans[i]=rs.getString(1);
				i++;
			}
			for(int j=0;j<10;j++)
			{
				for(int k=0;k<size;k++)
				{
					if(option[j].equalsIgnoreCase(Ans[k]))
					{
						score++;
					}
				}
			}
			out.println("<h2>Your Score is :" +score);
				out.println("<form action='./score'>");
				HttpSession session2=request.getSession();
				session2.setAttribute("scored",score);		}
		catch (Exception k)
		{
			out.println("<h1>Attempt all the Questions</h1>");
		}
		out.println("<br><br>");
		out.println("<table><tr><th>");
		out.println("<form action='./score'>");
		out.println("<div align='center'><input type='submit' class='a' value='Save Score' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'></div>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp");
		out.println("</form></th>");	
		out.println("<th><form action='./year'>");
		out.println("<center><input type='submit' class='a' value='Try Again...' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp");
		out.println("</form></th></tr></table>");		
		out.println("<hr>");
		out.println("<div align='right'><form action='./LoginPage.html'><input type='submit' class='a' value='LogOut' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'></form></div>");
	}
}