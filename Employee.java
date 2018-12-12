package CaseStudy2;

import java.io.Serializable;



public class Employee implements Serializable, Comparable<Employee> {
	 int id =0;
	 String name = null;
	 double salary = 0;
	
	Employee(int id,String name,double salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;

     }
	
	@Override
	public String toString() {
		//return "id=" + id + ", name=" + name + ", salary=" + salary;
		return + id + "," + name + "," + salary;

	}
	

	@Override
	public int hashCode()
	{

		return id;
	}

	@Override
	public boolean equals(Object obj) {
	
		
		if(this.hashCode() == obj.hashCode())
			return true;
		else 
			return false;
	}

	@Override
	public int compareTo(Employee o) {
		if(this.id>o.id)
			return 1;
		else if (this.id<o.id)
			return -1;
		else return 0;
	}
	
	/*
	public static Employee parseEmp(String t) {
        String temp[] = t.split(",");
        int id = Integer.parseInt(temp[0]);
        String name = temp[1];
        double salary = Double.parseDouble(temp[2]);
        return new Employee(id, name, salary);
    }
	*/
}

