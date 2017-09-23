package com.javatpoint.controllers;  
  
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  
import com.javatpoint.beans.Emp;  
import org.springframework.web.bind.annotation.PathVariable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
@Controller  
public class EmpController {  
  
    @RequestMapping("/empform")  
    public ModelAndView showform(){  
         
        return new ModelAndView("empform","command",new Emp());  
    }  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("emp") Emp emp) throws Exception{  
        
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
    	String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "";
        String name = emp.getName();
        float salary = emp.getSalary();
        String desigmation = emp.getDesignation();
        
        Connection con = DriverManager.getConnection(url, user, password);
		Statement stt = con.createStatement();
		stt.execute("USE testdb");
		stt.execute("INSERT INTO employees (name, salary, designation) VALUES ('"+name+"',"+salary+",'"+desigmation+"')");
        //System.out.println(emp.getName()+" "+emp.getSalary()+" "+emp.getDesignation());  
        return new ModelAndView("redirect:/viewemp"); 
    }  
      
    @RequestMapping("/viewemp")  
    public ModelAndView viewemp() throws Exception 
    {  
        //write the code to get all employees from DAO  
        //here, we are writing manual code of list for easy understanding  
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "";

		Connection con = DriverManager.getConnection(url, user, password);
		Statement stt = con.createStatement();
		stt.execute("USE testdb");
		ResultSet result = stt.executeQuery("select * from employees");
		List<Emp> list=new ArrayList<Emp>(); 
		while(result.next())
		{
			list.add(new Emp(result.getInt(1), result.getString(2),result.getFloat(3),result.getString(4)));
		}
        return new ModelAndView("viewemp","list",list);        
    }
    
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id)  throws Exception 
    {  
        //int i = id;
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "";
        int i2 = id;
        Connection con = DriverManager.getConnection(url, user, password);
		Statement stt = con.createStatement();
		stt.execute("USE testdb");
		ResultSet result = stt.executeQuery("SELECT * FROM employees WHERE id = "+i2+"");
		List<Emp> list=new ArrayList<Emp>(); 
		while(result.next())
		{
			list.add(new Emp(result.getInt(1), result.getString(2),result.getFloat(3),result.getString(4)));
		}
		
        return new ModelAndView("edit","list",list);  
    }
    
    @RequestMapping(value="/edit/update",method = RequestMethod.POST)  
    public ModelAndView update(@ModelAttribute("emp") Emp emp) throws Exception {  
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "";
        
        int id = emp.getId();
        String name = emp.getName();
        float salary = emp.getSalary();
        //String desigmation = emp.getDesignation();
        
//        int id = request.getParameter("id");
//        String first_name=request.getParameter("first_name");
//        String last_name=request.getParameter("last_name");
//        String city_name=request.getParameter("city_name");
//        String email=request.getParameter("email");
        
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stt = con.createStatement();
		stt.execute("USE testdb");
		stt.execute("update employees set name = '"+name+"', salary = "+salary+" where id = "+id+"");
    	return new ModelAndView("redirect:/viewemp");  
    }
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id) throws Exception {  
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "";
        int i2 = id;
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stt = con.createStatement();
		stt.execute("USE testdb");
		stt.execute("DELETE FROM employees WHERE id = "+i2+"");
    	return new ModelAndView("redirect:/viewemp");  
    }
}