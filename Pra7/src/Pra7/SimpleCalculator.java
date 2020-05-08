package Pra7;

import java.util.Scanner;


public class SimpleCalculator {
	public static void main(String[] args) {
		
			Scanner input = new Scanner(System.in);	
			String in = input.nextLine();			
			int idx=0,  cnt=0;
			int res=0;
		
			if(in.contains("+"))
			{
				idx = in.indexOf("+");
				cnt=1;
			}
			else if(in.contains("-"))
			{
				idx = in.indexOf("-");
				cnt=2;
			}
			String n1 = in.substring(0, idx);
			String n2 = in.substring(idx+1);
		try{
			int num1 = Integer.parseInt(n1);
			int num2 = Integer.parseInt(n2);
			
			if(cnt==1) 
			{
				add(num1); add(num2);
				res = num1+num2;
			}
			else if(cnt == 2)
			{
				sub(num1);	sub(num2);
				res = num1-num2;
			}
			
			out(num1);	out(num2);
			out(res);

			System.out.println(res);
			//System.exit(0);

		}
		
		catch(AddZeroException e)
		{
			System.out.println("AddZeroException");
		}
		catch(SubtractZeroException e) 
		{
			System.out.println("SubtractZeroException");
		}
		catch(OutOfRangeException e)
		{
			System.out.println("OutOfRangeException");
		}
		System.exit(0);
	}
	
	
	public static int out(int number) throws OutOfRangeException
	{
		if(number<0 || number > 1000)
		{
			OutOfRangeException oor = new OutOfRangeException();
			throw oor;
		}
		return number;
	}
	
	public static int add(int number) throws AddZeroException
	{
		if(number==0)
		{
			AddZeroException az = new AddZeroException();
			throw az;
		}
		return number;
	}
	
	public static int sub(int number) throws SubtractZeroException
	{
		if(number==0)
		{
			SubtractZeroException sz = new SubtractZeroException();
			throw sz;
		}
		return number;
	}
}

class OutOfRangeException extends Exception
{
	public OutOfRangeException(){}
}
class AddZeroException extends Exception
{
	public AddZeroException(){}
}
class SubtractZeroException extends Exception
{
	public SubtractZeroException(){}
}
