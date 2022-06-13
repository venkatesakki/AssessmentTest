package Assessment1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SalNameServlet
 */
@WebServlet("/SalNameServlet")
public class SalNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalNameServlet() {
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
		//String salary =request.getParameter("txtSalary");
		
		List<Employee> list=EmployeeDBConection.getSal();
		
		for(Employee e:list) {
			pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getEmpId()+"</td><td>"+e.getName()+"</td><td>"+e.getAge()+"</td><td>"+e.getDesignation()+"</td><td>"+e.getPhoneNo()+"</td><td>"+e.getSalary()+"</td></tr>");
			}
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
