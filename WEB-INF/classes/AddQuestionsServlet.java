import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
public class AddQuestionsServlet extends HttpServlet
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
		String S=req.getParameter("s1");
		HttpSession session=req.getSession();
		session.setAttribute("sub",S);
		System.out.println(S);
	out.println("<!doctype html><html lang='en-US'><head><title>Brain Boosters</title><link rel='stylesheet' type='text/css' href='Admin.css'>");
        out.println("<meta charset='utf-8'><link rel='icon' type='image/ico' href=''></head>");
	out.println("<body style='background-color:lightblue'><div class='container'><div class='banner' align='center' style='font-size:70px'><img src='./images/BB.png'/></div><hr>");
        out.println("<div class='main'> <form action='./add'>");   
         
      
       	 out.println("<br><br><h4><p><b> Enter Serial Number:     <input type='text'name='S1' style='border:1px solid black ;border-radius:10px;height:25px;width:200px;' required></br></h4>");
	out.println("<h4><p><b> Enter Question:          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' name='q1' style='border:1px solid black ;border-radius:10px;height:25px;width:200px;' required></br></h4>");
    	 out.println("<h4><p><b>Enter Option1:           &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' name='o1' style='border:1px solid black ;border-radius:10px;height:25px;width:200px;' required></br></h4>");
    	 out.println("<h4><p><b>Enter Option2:           &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' name='o2' style='border:1px solid black ;border-radius:10px;height:25px;width:200px;' required></br></h4>");
    	 out.println("<h4><p><b>Enter Option3:           &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' name='o3' style='border:1px solid black ;border-radius:10px;height:25px;width:200px;' required></br></h4>");
    	 out.println("<h4><p><b>Enter Option4:           &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' name='o4' style='border:1px solid black ;border-radius:10px;height:25px;width:200px;' required></br></h4>");
    	 out.println("<h4><p><b>Enter Answer:            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' name='a1' style='border:1px solid black ;border-radius:10px;height:25px;width:200px;' required></br></br></h4>");
    	 out.println("<center><input type='submit' class='a' value='Add Question' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:200px;;font-size:20px' ></center> </br></br><hr></form></div>");
 out.println("<div align='right'><form action='LoginPage.html' ><input type='submit' class='a' value='Log Out' height='40px' style='border:1px solid black;border-radius:50px;height:40px;width:150px;font-size:20px' ></form></div>");           
    	    
out.println("</div></body></html> ");
  	}
}