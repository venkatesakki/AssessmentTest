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
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
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
		
		int id=Integer.parseInt(request.getParameter("txtId"));
		int empId=Integer.parseInt(request.getParameter("txtEmpId"));
		String name=request.getParameter("txtName");
		int age=Integer.parseInt(request.getParameter("txtAge"));
		String des=request.getParameter("txtDesignation");
		String phoneNo=request.getParameter("txtPhoneNo");
		String salary =request.getParameter("txtSalary");
		
		Employee e=new Employee();
	
		e.setId(id);
		e.setEmpId(empId);
		e.setName(name);
		e.setAge(age);
		e.setDesignation(des);
		e.setPhoneNo(phoneNo);
		e.setSalary(salary);
		
		int res = 0;
		
			try {
				res = EmployeeDBConection.insert(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			pw.print("data inserted succesfully");
		
		if(res>0)
		{
			pw.print("data saves successfully ");
			response.sendRedirect("intex.html");
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
