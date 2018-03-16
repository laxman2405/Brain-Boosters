import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
public class ViewTopicsServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String a=req.getParameter("a");
		String u3=req.getParameter("u3");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		if (a.equals("First Year"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("FirstYear.html");
			rd.forward(req,res);
		}
		else if (a.equals("Second Year"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("SecondYear.html");
			rd.forward(req,res);
		}
		else if (a.equals("Third Year"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("ThirdYear.html");
			rd.forward(req,res);
		}	
		out.println("<form action='./LoginPage.html'>");
		out.println("<input type='submit' value='LogOut'>");
		out.println("</form>");
	}
}