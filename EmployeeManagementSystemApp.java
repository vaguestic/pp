// Importing an inbuilt Pacakage
import java.util.Scanner;
//Creating a class name Employee
class Employee
{
    private String name;
    private String desg;
    private int id;
    private String gender;
    private long phoneNum;
    private String emailId;
    private double salary;
    private String dob;
    private int age;

    public Employee(String name,String desg, int id ,String gender,long phoneNum,String emailId,double salary, String dob, int age) 
    {
        this.name = name;
        this.id = id;
        this.desg= desg;
        this.gender= gender;
        this.phoneNum= phoneNum;
        this.emailId= emailId;
        this.salary = salary;
        this.dob= dob;
        this.age= age;
    }

    public String getName()
   {
        return name;
    }
    
    public String getdesg()
    {
        return desg;
    }

    public int getId()
    {
        return id;
    }
    

    public String getgender()
    {
        return gender;
    }
    
    public long getphoneNum()
    {
        return phoneNum;
    }
    
    public String getemailId()
    {
        return emailId;
    }
    
    public double getSalary()
    {
        return salary;
    }
    
    public String getdob()
    {
        return dob;
    }
    
    public int getage()
    {
        return age;
    }
    

    @Override
    public String toString()
     {
        return "Employee{" +
                "name='" + name + '\'' +
                " desg=" + desg + 
                ", id=" + id +
                ", gender=" + gender +
                " phoneNum=" + phoneNum +
                ", emailId =" + emailId +
                ", salary=" + salary +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}

//Creating a class name EmployeeManagementSystem
class EmployeeManagementSystem
 {
    private static final int MAX_EMPLOYEES = 100;
    private Employee[] employees = new Employee[MAX_EMPLOYEES];
    private int employeeCount = 0;

    public void addEmployee(String name, String desg, int id, String gender, long phoneNum, String emailId, double salary, String dob, int age)
     {
        if (employeeCount < MAX_EMPLOYEES) 
        {
            employees[employeeCount] = new Employee(name, desg, id, gender, phoneNum, emailId, salary, dob, age);
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
        for (int i = 0; i <employeeCount; i++)
     {
            System.out.println(employees[i]);
        }
    }

    public Employee findEmployeeById(int id)
     {
        for (int i = 0; i <employeeCount; i++)
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
        Scanner sc = new Scanner(System.in);

        while (true)
         {
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Find Employee by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice)
             {
                case 1:
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee Designation: ");
                    String desg= sc.nextLine();
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Employee gender(F/M): ");
                    String gender = sc.next();
                    System.out.print("Enter Employee phoneNumber: ");
                    int phoneNum= sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Employee EmailId: ");
                    String emailId= sc.next();
                    sc.nextLine();
                    System.out.print("Enter Employee Salary: Rs");
                    double salary = sc.nextDouble();
                    System.out.print("Enter Employee dob(DD/MM/YYYY):");
                    String dob= sc.next();
                    System.out.print("Enter Employee Age:");
                    int age= sc.nextInt();
                    
                    ems.addEmployee(name, desg, id, gender, phoneNum, emailId , salary, dob, age);
                    break;
                case 2:
                    ems.displayEmployees();
                    break;
                case 3:
                    System.out.print("Enter employee ID to search: ");
                    int searchId = sc.nextInt();
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
