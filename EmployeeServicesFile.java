package CaseStudy2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class EmployeeServicesFile {
	
	private static ArrayList<Employee> empList ;
	
	static
	{	
		File file = new File("/Users/maithry/Documents/Employee.dat");

		   if(file.exists())

		   {
			   try
			   {
				   FileInputStream fi =	 new FileInputStream(file);
			 
			        ObjectInputStream ois = new ObjectInputStream(fi);
					//System.out.println("File Stream");

			        empList = (ArrayList<Employee>) ois.readObject();
			        ois.close();
	                fi.close();
			   } catch (IOException | ClassNotFoundException ioe)
			   {
				   System.out.println("Error");
			   }
		    }  

		   else
		     empList = new ArrayList<Employee>();
		   System.out.println(empList);
	
	}
	
	public static boolean addEmployee(Employee emp){
		if((empList.contains(emp)== true))
	   return false;
	   else
	   {
		   empList.add(emp);
		   return true;
	   }
	}

	public static List getAllEmployees(){
		return Collections.unmodifiableList(empList);
		}

	public static Employee searchById(int id)
	{
		for ( Employee currEmp : empList)  
        {  
            if(currEmp.id==id)
            	{
                  return currEmp;
            	}
           
        }
		
        return null;

	}
	
	public static boolean deleteById(int id)
	{
		for ( Employee currEmp : empList)  
        {  
            if(currEmp.id==id)
            	{
            	
                empList.remove(currEmp);
                return true;
            	}
          
	     }
        return false;
	}
	
	public static List<Employee> searchByName(String name)
	{
		ArrayList<Employee> tempEmpList = new ArrayList();
        for ( Employee currEmp : empList)  
        {  
            if(currEmp.name.equalsIgnoreCase(name) )
            	{
            	tempEmpList.add(currEmp);
            	}
          
        }
        return Collections.unmodifiableList(tempEmpList);
	}
	

	 
	
	
	public static  List<Employee> getEmployeesSalaryRange(double minSalary,double maxSalary)
	{      
		ArrayList<Employee> tempEmpList = new ArrayList();
		for ( Employee currEmp : empList) 
		{
			if(currEmp.salary>=minSalary & currEmp.salary<=maxSalary)
			{
				tempEmpList.add(currEmp);
			
			}
		}
        return Collections.unmodifiableList(tempEmpList);

		
	}
	
	
	public static Set<Employee> getAllEmployeesOrderByName()
	{
       TreeSet<Employee> empNameTree = new TreeSet<Employee>(new NameComparator());
	   empNameTree.addAll(empList);
       return Collections.unmodifiableSet(empNameTree);
		
	}
	
	public static Set<Employee> getAllEmployeesOrderBySalary()
	{
       TreeSet<Employee> empSalaryTree = new TreeSet<Employee>(new SalaryComparator());
	   empSalaryTree.addAll(empList);
       return Collections.unmodifiableSet(empSalaryTree);

	}
	
	public static void  onExit()
	{
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("/Users/maithry/Documents/Employee.dat");
	        ObjectOutputStream oos= new ObjectOutputStream(fos);	
	        oos.writeObject(empList);
	        oos.close();
	        fos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
}
