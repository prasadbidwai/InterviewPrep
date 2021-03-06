//******************* Example of custom exception *******************

class MyException extends Exception 
{
	private int detail;
	
	MyException(int a) 
	{
		detail = a;
	}

	public String toString() 
	{
		return "This is custom generatd MyException[" + detail + "]";		//this method is necessary to create a custom message to be generated by exception.
	}

}

class ExceptionDemo 
{
	static void compute(int a) throws MyException 
	{
		System.out.println("Called compute(" + a + ")");
		if(a > 10)
		throw new MyException(a);
		System.out.println("Normal exit");
	}
	
	public static void main(String args[]) 
	{
		try 
		{
			compute(1);
			compute(20);
		} catch (MyException e) 
			{
				System.out.println("Caught " + e);
			}
	}
}
/*
Output: 

Called compute(1)
Normal exit
Called compute(20)
Caught This is custom generatd MyException[20]

 ******************* End of program that creates a custom exception type  ******************* /



//******************* Example of a Checked Exception *******************/

class ExceptionClass 
{
	/*illegalAccessException is checked exception type of exception and hence  
	is to be mentioned as throws by method that throws it(elese compiler will complain)*/

	static void throwOne() throws IllegalAccessException 				
	{
		System.out.println("Inside throwOne.");
		throw new IllegalAccessException("demo");
	}
	
	public static void main(String args[]) {

		try{
			throwOne();
		}catch(IllegalAccessException e)
			{
				System.out.println("error thrown is: " + e);
			}
		}
}

/*output: 

Inside throwOne.
error thrown is: java.lang.IllegalAccessException: demo

********************End of Example of a Checked Exception *******************/
