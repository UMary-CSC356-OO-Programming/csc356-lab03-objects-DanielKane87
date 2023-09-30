import java.util.Scanner;

class Employee
{
	/* Task 3B: Add instance variables */
	private String firstName;
	private String lastName;
	private int employeeId;
	private double salary;
	
	/* Task 3C: Add three constructors */
	public Employee()
	{
	}		
	public Employee( String last, String first )
	{
		lastName = last;
		firstName = first;
	}
	public Employee( String last, String first, int id, double wage )
	{
		lastName = last;
		firstName = first;
		employeeId = id;
		salary = wage;
	}
   
	/* Task 3D: Add set (mutator) and get (accessor) methods */
	public void setLast( String newLast ){ this.lastName = newLast; }
	public void setFirst( String newFirst ){ this.firstName = newFirst; }
	public void setEmployeeId( int newId ){ this.employeeId = newId; }
	public void setSalary( double newSalary )
	{
		if ( newSalary < 0 )
			this.salary = 0.0;
		else
			this.salary = newSalary; 
	}
	
	public String getLast() { return lastName; }
	public String getFirst() { return firstName; }
	public int getEmployeeId() { return employeeId; }
	public double getSalary() { return salary; }
   
	/* Task 3F: Add toString method */
	public String toString()
	{
		String message;
		
		message = String.format( "Last Name: %s; First Name: %s; Employee Id: %d; Salary: %.2f\n", this.lastName, this.firstName, this.employeeId, this.salary );
		return message;
	}
   
	/* Task 3G: Add equals method */
	public boolean equals( String name )
	{
		if ( this.lastName.equals(name) )
			return true;
		else
			return false;
	}   
}


public class EmployeeApp 
{
	public static final int MAX_EMPLOYEES = 5;
   
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner( System.in );
		Employee[] employees = new Employee[MAX_EMPLOYEES];
		Employee currentEmployee;
		String inputString;
		int inputInt;
		double inputDouble;
		char choice;
		int empCount=0;
      
		employees[empCount++] = new Employee( "Mitchum", "Robert", 120402, 34000.0 );
		employees[empCount++] = new Employee( "Ryan", "Cornelius" );
		employees[empCount++] = new Employee( "Asimov", "Isaac" );

		do 
		{
			System.out.println( "\n   Enter Selection\n   ===============" );
			System.out.println( "A> Add new Employee" );
			System.out.println( "E> Edit Employee" );
			System.out.println( "L> List Employees" );
			System.out.println( "Q> Quit" );
			System.out.print(  "   Select: " );
			inputString = keyboard.nextLine();
			choice = inputString.toUpperCase().charAt( 0 );
			System.out.println();

			switch( choice )
			{
				case 'A':
					if ( empCount < MAX_EMPLOYEES-1 )
					{
						// Create object for new Employee
						employees[empCount] = new Employee();
                
						// Task 3E: Prompt for user information and set the object 
						// parameters via the mutator methods
						System.out.print( "Enter Last Name: " );
						employees[empCount].setLast( keyboard.nextLine() );
						
						System.out.print( "Enter First Name: " );
						employees[empCount].setFirst( keyboard.nextLine() );
						
						System.out.print( "Enter Employee ID: " );
						employees[empCount].setEmployeeId( keyboard.nextInt() );
						
						System.out.print( "Enter Salary: " );
						employees[empCount].setSalary( keyboard.nextDouble() );
   
						empCount++;
					}
					keyboard.nextLine();
				break;
               
				case 'E':
					System.out.printf( "Enter Last Name of Employee to Edit: " );
					inputString = keyboard.nextLine();
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						// Verify that the employee entry has been allocated before Editing
						if ( employees[lp] != null )
						{
							if ( employees[lp].equals( inputString ) == true )
							{
								System.out.print( "Enter Employee ID: " );
								inputInt = keyboard.nextInt();
								employees[lp].setEmployeeId( inputInt );
                  
								System.out.print( "Enter Employee Salary: " );
								inputDouble = keyboard.nextDouble();
								employees[lp].setSalary( inputDouble );
   
								keyboard.nextLine();
							}
						}
					}
				break;
              
				case 'L':
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						System.out.println( employees[lp] );
					}
				break;
			}
			keyboard.reset();
		} while( choice != 'Q' );
	}  
}
