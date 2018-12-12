package CaseStudy2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeServicesFileMain {

	public static void main(String[] args) {
		
		String choice = null;

		while (choice!="10") {
		System.out.println("Please choose from the below options");
		System.out.println("1.Add Employee");
		System.out.println("2.View all Employess");
		System.out.println("3.Seach by Employee Id");
		System.out.println("4.Delete by Employee Id");
		System.out.println("5.Search by Employee Name");
		System.out.println("6.Delete by Employee Name");
		System.out.println("7.List Employess between a salary range");
		System.out.println("8.View Employee List in Alphabetical order(Name)");
		System.out.println("9.View Employee List in Descending order(Salary)");
		System.out.println("10.Exit");
	    
		
		Scanner scan = new Scanner(System.in);
		choice  = scan.nextLine();
	
		switch (choice){
		case "1":
			System.out.println("Enter Employee Id");
	        int id1 = scan.nextInt();
			System.out.println("Enter Employee Name");
	        String name1 = scan.next();
            System.out.println("Enter Employee Salary");
			double salary1 = scan.nextDouble();
			Employee employee = new Employee(id1,name1,salary1);
			System.out.println("Adding Employee " + employee);
			boolean add = EmployeeServicesFile.addEmployee(employee);
			if (add == true)
			{
				System.out.println("Employee addedd successfully");
			
			}
			else
			{
				System.out.println("Employee could not be added");
			
			}	
            break;
           
		case "2":
			System.out.println(EmployeeServicesFile.getAllEmployees());
			break;
			     
		case "3":
			System.out.println("Enter Employee Id");
	        int id2 = scan.nextInt();
	        Employee E1 = EmployeeServicesFile.searchById(id2);
	        if(E1 == null)
	        	System.out.println("Employee not found");
	        else
	            System.out.println(E1);
			break;
		
		case "4":
			System.out.println("Enter Employee Id");
	        int id3 = scan.nextInt();
	        if(EmployeeServicesFile.deleteById(id3))
	        	System.out.println("Record deleted successfully" +id3);
	        else 
	        	System.out.println("Record not found");
			break;
		
		case "5":
			System.out.println("Enter Employee Name");
	        String name2 = scan.next();
	        System.out.println(EmployeeServicesFile.searchByName(name2));
			break;
		
		case "6":
			System.out.println("Enter Employee Name");
	        String name3 = scan.next();
	        List<Employee> tempEmp1 = EmployeeServicesFile.searchByName(name3);
	        if(tempEmp1.size() == 0)
	        	System.out.println("No record found");
	        else if (tempEmp1.size() == 1)
	        {
	        	int id4 = tempEmp1.get(0).hashCode();
		        if(EmployeeServicesFile.deleteById(id4))
		        System.out.print("Record deleted successfully");
	        	
	        }
	        else
	        {
	        	Iterator empIterator = tempEmp1.iterator();
	  	      
	       		while (empIterator.hasNext()) 
	       		{
	       			System.out.println(empIterator.next());
	       		}
	    		
	       		System.out.println("Enter Employee Id from the above list to be deleted");
	    		int id4 = scan.nextInt();
		        if(EmployeeServicesFile.deleteById(id4))
				  System.out.print("Record deleted successfully");		

	        }
	        
			break;
		
		case "7":
			System.out.println("Enter Minimum Salary");
			double minSalary = scan.nextDouble();

			System.out.println("Enter Maximum Salary");
			double maxSalary = scan.nextDouble();
		
			System.out.println(EmployeeServicesFile.getEmployeesSalaryRange(minSalary,maxSalary));
			
			break;
		
		case "8": System.out.println("Displaying all Employees in Alphabetical order if their name");
		          System.out.println(EmployeeServicesFile.getAllEmployeesOrderByName());
			      break;
			
		case "9": System.out.println("Displaying all Employees in Descending order if their salary");
                  System.out.println(EmployeeServicesFile.getAllEmployeesOrderBySalary());
			      break;
		
		case "10":
			System.out.println("Quitting...");
			EmployeeServicesFile.onExit();
            System.exit(0);
			break;
			
	       }

	}

	}
}


