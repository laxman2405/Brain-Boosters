import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
public class InstructionsServlet extends HttpServlet
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
		String s1=req.getParameter("s");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try
		{
			out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='login.css'>");
        			out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
			out.println("<body><div class='container'><div class='banner' align='center' style='font-size:70px'><img src='./images/BB.png'/></div><hr><br><br>");
        			out.println("<div class='main'>");
            			out.println("<form action='./Question'>");
			out.println("<h1><center><u><B>INSTRUCTIONS TO CANDIDATES</b></u></cener></h1><br>");
			out.println("<h3>");
			out.println("1. Candidates are Given 10 Questions based on "+s1+" Subject.<br>");
           			out.println("2. Candidates must Select One of the Option from the given four Options.<br>");
            			out.println("3. Each Question Carries 1 Mark.<b>There are no Negative Marks</b><br>");
           			out.println("4. To Answer these 10 Questions, Candidates are given 3 minutes of Time Only.<br>");
			out.println("5. After Attempting all the Questions, Candidate must Click on 'SUBMIT' Button to see his/her Result.<br></h3><br>");
			out.println("<h2><center>Good Luck for Your Quiz...</center></h2><br><hr>");
			out.println("<center><input type='submit' class='a' value='Click the Button to Start the Quiz' height='40px' style='border:1px solid black;border-radius:50px;height:45px;width:350px;font-size:20px'>&nbsp&nbsp&nbsp&nbsp&nbsp");
			out.println("<input type= hidden name=s2 value='"+s1+"'>");
			out.println("</form></div></body></html> ");
		}
		catch (Exception k)
		{
			k.printStackTrace();
		}
	}
}