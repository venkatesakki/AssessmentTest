package Assessment1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet1
 */
@WebServlet("/UpdateServlet1")
public class UpdateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet1() {
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
		
		int empid=Integer.parseInt(request.getParameter("txtEmpId"));
		String des=request.getParameter("txtDesignation");
		String salary=request.getParameter("txtSalary");
		
		
		Employee e=new Employee();
	    e.setEmpId(empid);
		e.setDesignation(des);
		e.setSalary(salary);
		
		int res = 0;
		try {
			res = EmployeeDBConection.update(e);
			pw.print("connection success");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(res>0)
		{
			pw.print("data saves successfully ");
			response.sendRedirect("intex.html");
		}
		else 
		{
			pw.print("\nerror to upadte the data");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
