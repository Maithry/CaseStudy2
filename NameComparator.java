package CaseStudy2;

import java.util.Comparator;

class NameComparator implements Comparator<Employee>
{
public int compare(Employee o1,Employee o2)
{
return o1.name.compareTo(o2.name);
}
}