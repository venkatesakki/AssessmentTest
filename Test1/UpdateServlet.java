package Assessment1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		//pw.print("save servlet");
		pw.print("<h1>view Employee Details</h1>");
		pw.print("<form method='post'><table>");
		pw.print("<tr><td>Empid:</td><td><input type='text' name='txtEmpId' placeholder='enter employee id'></td></tr>");
		pw.print("<tr><td>Designation:</td><td><input type='text' name='txtDesignation' placeholder='enter employee designation'></td></tr>");
		pw.print("<tr><td>Salary:</td><td><input type='text' name=\"txtSalary\" placeholder='enter employee salary'></td></tr>");
		pw.print("<tr><td><input type='submit' value ='submit' formaction='UpdateServlet1'></td></tr>");
		pw.print("</table></form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
