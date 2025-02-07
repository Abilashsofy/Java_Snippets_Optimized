package listTechniques;

import java.util.ArrayList;
import java.util.List;

/*
 * There is a arraylist contains paris of data. Name mapped with department
 * now we have to compare and display the pairs of name has same department
 * Similar to candy problem in leetcode, we need to traverse fully to know the pairs
 * Need a Arraylist to have pairs and use For loops or maps for efficiency, scalability and readability
 */

import java.util.HashMap;
import java.util.Map;

public class CompareValuesOfPairsAndArrange {
    public static void main(String[] args) {
        // Define the Employee class
        class Employee {
        	
        	/*
        	 * Declare variable inside a class called Employee
        	 */
            String name;
            String department;

            //Creating constructor
            Employee(String name, String department) {
                this.name = name;
                this.department = department;
            }
            //Override a method toString from parent class called String.
            @Override
            public String toString() {
               // return name + " (" + department + ")";
                return name;
            }
        }

        // Initialize the list of employees. Passing Constructor as Argument
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "Engineering"));
        employees.add(new Employee("Charlie", "HR"));
        employees.add(new Employee("Diana", "Engineering"));
        employees.add(new Employee("Eve", "Marketing"));
        employees.add(new Employee("Frank", "HR"));

        // A map to track employees by department
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        // Group employees by department
        for (Employee emp : employees) {
            departmentMap.putIfAbsent(emp.department, new ArrayList<>());//Initialize a list with Department one time and value is empty
            departmentMap.get(emp.department).add(emp);//Add employees to department list
            /*
             * Initially get(Object K) retrieves list with Department name with value as empty as created in prev step
             * then using add method, it will add the value "name" to the list [Alice, Charlier] for HR
             */
        }

        // Print pairs for each department
        for (Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()) {
            String department = entry.getKey();
            List<Employee> empList = entry.getValue();

            System.out.println("Department: " + department);
            boolean foundPair = false;
            
            /*
             * Concept is, consider this list, Abi, Sofy, Ajay, Aadvik are value belongs to Marutham the key
             * Possible pair can be Abi, sofy. Abi, Ajay, Abi, Aadvik. Sofy, Ajay. Sofy, Aadvik, Ajay, Aadvik
             */

            // Check for pairs in the same department
            for (int i = 0; i < empList.size(); i++) {
                for (int j = i + 1; j < empList.size(); j++) {
                    Employee emp1 = empList.get(i);
                    Employee emp2 = empList.get(j);
                    System.out.println(emp1 + " and " + emp2 + " are in the same department.");
                    foundPair = true; // Mark that we found at least one pair
                }
            }

            // If no pairs are found, print "No pairs found."
            if (!foundPair) {
                System.out.println("No pairs found.");
            }
        }
    }
}
