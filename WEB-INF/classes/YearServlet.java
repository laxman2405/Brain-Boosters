import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
public class YearServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String u2=req.getParameter("u2");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try
		{
			out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='login.css'>");
			out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
			out.println("<body><div class='container'><div class='banner' align='center' style='font-size:70px'><img src='./images/BB.png'/></div><hr>");
			out.println("<div class='main'>");
			out.println("<table><tr>");
			out.println("<form action='./viewtopics'>");
			out.println("<input type= hidden name=u3 value='"+u2+"'>");
			out.println("<h1> Select Your Year :</h1><br>");
			out.println("&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='submit' class='a'  value='First Year' name='a'  height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'>&nbsp&nbsp&nbsp&nbsp&nbsp");
			out.println("<input type='submit' class='a' value='Second Year' name='a' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'>&nbsp&nbsp&nbsp&nbsp&nbsp");
			out.println("<input type='submit' class='a'  value='Third Year' name='a' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:180px;font-size:20px'>&nbsp&nbsp&nbsp&nbsp&nbsp");
			out.println("</form><br><br><hr>");
			out.println("<div align='right'><form action='LoginPage.html' ><input type='submit' class='a'  value='Log Out' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:150px;font-size:20px' ></form></div>");
			out.println("</tr></table><br><br>");
			out.println("</div></body></html> ");
		}
		catch (Exception k)
		{
			out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='login.css'>");
        	out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
			out.println("<body style='background-color:lightgrey'><div class='container'><div class='banner' align='center' style='font-size:50px'>Brain Boosters</div><hr><br><br>");
        	out.println("<div class='main'>");
			out.println("<h1>Please Select Your Year and Try Again...</h1>");
			out.println("</div></body></html> ");
		}
		
	}
}