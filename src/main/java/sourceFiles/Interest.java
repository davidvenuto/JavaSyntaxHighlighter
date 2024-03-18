package sourceFiles;

public class Interest
{
	public static void main (String[] args)
	{
		double balance;
		double initialBalance = 1000;
		double interestRate = 5.0 / 100;
		
		// Initial Balance
		System.out.println("Initial Balance: " + initialBalance);
		
		// 1 Year Interest
		balance = initialBalance + (initialBalance * interestRate);
		System.out.println("Balance after One Year Interest: " + balance);
		
		// 2 Years Interest
		balance = balance + (balance * interestRate);
		System.out.println("Balance after Two Years Interest: " + balance);
		
		// 3 Years Interest
				balance = balance + (balance * interestRate);
				System.out.println("Balance after Three Years Interest: " + balance);
	}
}
