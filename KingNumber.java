import java.util.ArrayList;
import java.util.Scanner;

class KingNumber
{
	public static ArrayList<Integer> primeNumber(ArrayList<Integer> num)
	{
		int count=0; 	//declare local variable count with intial value 0

		//create a new object of ArrayList class and store the adress in prime adress of ArrayList type
		ArrayList<Integer> prime = new ArrayList<Integer>();
		
		for(int i=0; i<num.size(); i++) //num is the argument variable of type ArrayList 
		{										//so num.size() is method which returns the size of the ArrayList num

			for (int j=2; j<num.get(i); j++)  //num.get() returns the value stored in ArrayList
			{
				//prime num is always greater than 1 and should be divisible by 1 and itself 
				//means prime number has only two factors that are 1 and itself
				//but to reduse the execution time we can check the number divisibility between ">1 && <num"
				if(num.get(i)>1 && num.get(i)%j==0) 
				{									//so here we check prime number should have No factors so the count remain zero
				 count++;						
				}								
			}
			if(count==0)			//count=0 means number has no factors between 1 and that num so it is prime number
			{
				prime.add(num.get(i)); //store the prime number in refrence variable of type ArrayList class using add() method				
			}
			count = 0;    //reinisialise the value of count with 0
		}
		return prime;		//return the prime numbers of Arraylist type and pass the control to the main() method

	}

	public static void kingNumber(ArrayList<Integer> prime, ArrayList<Integer> num)
	{
		int count = 0, maxVal= 0;

		//create object of ArrayList class and store the adress of object in referance varianle max
		ArrayList<Integer> max = new ArrayList<Integer>();
		//prime is variable of type ArrayList, value passed from main() mrthod which are prime numbers present in the list
		for(int i=0; i<prime.size(); i++)
		{
			//num is variable of type ArrayList, value passed from main() mrthod which are numbers of the list
			for (int j=0; j<num.size(); j++)
			 {
				if(num.get(j)%prime.get(i)==0) //check the which numbers of num are divisible by the prime number present in prime var
				{
					count++;				//if prime number divides the numbers of num so count value will increase
				}	
			}
			if(count>maxVal)			//check if count is more then maxVal=0
			{
				max.add(prime.get(i));	//add the prime number in ArrayList max
				maxVal = count;		//re-inintialise the value of maxVal with count so the next number should store which has more count
			}
			count= 0;				//reinitialise count with 0
		}


		//so the prime number that is the factor of the most numbers in a given list is stored in the last inedex(max.size()-1) of ArrayList max
		System.out.println("The king number is "+max.get(max.size()-1));

	}
	public static void main(String args[])
	{

		//take input of the list of numbers from the user
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Size of the list(>0)");
		
		//store the size of list in variable n using nextInt() method of Scanner class
		int n = sc.nextInt();

		System.out.println("Enter the numbers of list");

		//to store the inputs use ArrayList class because it is resizable
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(sc.hasNext())
		{
			//add the input number to ArrayList using add() method
			list.add(sc.nextInt());

			if(list.size()==n)	//check the size of list entered by user
			{
			break;	//break the loop
			}
		}

	/* 
		//if you dont want to take input from user..

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(9);
		list.add(13);
	*/
		System.out.print("The List of the numbers you have entered = {");

		//display the inputs enterd by user 
		for(int i=0; i<list.size(); i++)
		 	{
				System.out.print(""+list.get(i)+",");
			}
		System.out.println("}");

		//pass the stored input in primeNumber() method as argurment
		//the prime numbers present in the list returned from method primeNumber() and stored in refrence variable of type ArrayList
		ArrayList<Integer> prime = primeNumber(list);
		
		//pass the prime and the list from kingNumber() method as argument
		kingNumber(prime,list);
	}
}