package exceptionhandling;

public class Exceptionhandle {
	
	public static void main(String[] args)throws InvalidLogicException{
		
		try {
			int i=Integer.parseInt(args[0]);
			int j=Integer.parseInt(args[1]);
			System.out.println("value of divided number: "+(i/j));
		}
		catch(IndexOutOfBoundsException i) {
			System.out.println("Please Enter the value");
		}catch(ArithmeticException a) {
			System.out.println("Please not enter the 0 in the divisor");
		}catch(NumberFormatException n) {
			System.out.println("Please enter the number not the character");
		}
		finally {
			System.out.println("End of try/catch");
		}
		throw new InvalidLogicException("asda");	
	}

}
