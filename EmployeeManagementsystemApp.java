// Importing an inbuilt Pacakage
import java.util.Scanner;

//Creating a class name Employee
class Employee
{
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) 
    {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName()
   {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public double getSalary()
    {
        return salary;
    }

    @Override
    public String toString()
     {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}

//Creating a class name EmployeeManagementSystem
class EmployeeManagementSystem
 {
    private static final int MAX_EMPLOYEES = 100;
    private Employee[] employees = new Employee[MAX_EMPLOYEES];
    private int employeeCount = 0;

    public void addEmployee(String name, int id, double salary)
     {
        if (employeeCount < MAX_EMPLOYEES) 
        {
            employees[employeeCount] = new Employee(name, id, salary);
            employeeCount++;
            System.out.println("Employee added successfully.");
        } 
        else 
        {
            System.out.println("Cannot add more employees. Maximum limit reached.");
        }
    }

    public void displayEmployees() 
    {
        System.out.println("Employee details:");
        for (int i = 0; i < employeeCount; i++)
     {
            System.out.println(employees[i]);
        }
    }

    public Employee findEmployeeById(int id)
     {
        for (int i = 0; i < employeeCount; i++)
         {
            if (employees[i].getId() == id)
             {
                return employees[i];
            }
        }
        return null;
    }
}


//Creating a class name EmployeeManagementSystemApp
public class EmployeeManagementSystemApp
 {
    public static void main(String[] args) 
    {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true)
         {
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Find Employee by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice)
             {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter employee salary: $");
                    double salary = scanner.nextDouble();
                    ems.addEmployee(name, id, salary);
                    break;
                case 2:
                    ems.displayEmployees();
                    break;
                case 3:
                    System.out.print("Enter employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee foundEmployee = ems.findEmployeeById(searchId);
                    if (foundEmployee != null)
                    {
                        System.out.println("Employee found: " + foundEmployee);
                    } else
                    {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
