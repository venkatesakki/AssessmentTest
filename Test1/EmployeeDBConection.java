package Assessment1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;

import org.postgresql.util.PSQLException;





public class EmployeeDBConection {
	private static String DB_DRIVER_CLASS="org.postgresql.Driver";
	private static String DB_URL="jdbc:postgresql://localhost:5432/vastpro1";
	private static String DB_USER="postgres";
	private static String DB_PASSWORD="postgres";
	private static String INSERT="insert into employee values(?,?,?,?,?,?,?);";
	private static String UPDATE ="update employee set designation=?,salary=? where emp_id=?;";
	private static String DELETE="delete from employee where emp_id=?;";
	private static String SELECTALL="select * from employee;";
	private static String SALCOND="select name from employee where sal>=300000;";
	public static Connection getConnection() throws SQLException
	{
		Connection con=null;
		try
		{
			Class.forName(DB_DRIVER_CLASS);
			System.out.println("suucessfully connected ");
			
		}
		catch (Exception e) {
			System.out.println("error in the connection :");
		}
		
		con =DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		
		
		return con;
	}
	public static int insert(Employee e) throws SQLException
	{
		int res=0;
		try
		{
		Connection con =EmployeeDBConection.getConnection();
		
		PreparedStatement ps=con.prepareStatement(INSERT);
		ps.setInt(1, e.getId());
		ps.setInt(2, e.getEmpId());
		ps.setString(3,e.getName());
		ps.setInt(4, e.getAge());
		ps.setString(5, e.getDesignation());
		ps.setString(6, e.getPhoneNo());
		ps.setString(7, e.getSalary());
	
		res=ps.executeUpdate();
		//ps.close();
		con.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
			
		}
		return res;
	}
	public static int update(Employee e) 
	{
	    int res=0;
	try
	{
	    Connection con =EmployeeDBConection.getConnection();
	    PreparedStatement ps=con.prepareStatement(UPDATE);
	    
	    ps.setInt(3, e.getEmpId());
	    ps.setString(1, e.getDesignation());
	    ps.setString(2, e.getSalary());
	
	    res=ps.executeUpdate();
       
        con.close();
        ps.close();
	}
	catch (Exception e1) 
	{
		e1.printStackTrace();
	}
	    return res;
	}
	
	public static int delete(int empId) throws SQLException
	{
	    int res=0;
	try
	{
	    Connection con =EmployeeDBConection.getConnection();
	    PreparedStatement ps=con.prepareStatement(DELETE);
	 
	    ps.setInt(1,empId);
	    res=ps.executeUpdate();
	   // ps.close();
	    con.close();
	    ps.close();
	}
	catch (Exception e1) {
		e1.printStackTrace();
	}
	
	    return res;
	}
	public static List<Employee> getEmployeeAll()
	{
		List<Employee> list = new ArrayList<Employee>();
		try
		{
			Connection con = EmployeeDBConection.getConnection();
			PreparedStatement ps=con.prepareStatement(SELECTALL);
			ResultSet re = ps.executeQuery();
			while(re.next())
			{
				Employee e=new Employee();
				e.setId(re.getInt(1));
				e.setEmpId(re.getInt(2));
				e.setName(re.getString(3));
				e.setAge(re.getInt(4));
				e.setDesignation(re.getString(5));
				e.setPhoneNo(re.getString(6));
				e.setSalary(re.getString(7));
				list.add(e);
			}
			con.close();
			 ps.close();
		}
		catch (Exception e) {
			e.printStackTrace();	
		}
		
		return list;
	}
	public static List<Employee> getSal()
	{
		List<Employee> list = new ArrayList<Employee>();
		try
		{
			Connection con = EmployeeDBConection.getConnection();
			PreparedStatement ps=con.prepareStatement(SALCOND);
			ResultSet re = ps.executeQuery();
			while(re.next())
			{
				Employee e=new Employee();
				
				e.setSalary(re.getString(1));
				
				list.add(e);
			}
			con.close();
			 ps.close();
		}
		catch (Exception e) {
			e.printStackTrace();	
		}
		
		return list;
	}
}
