package sourceFiles;

public class HollePrinter
{
	public static void main (String[] argss)
	{
		String greeting = "Hello, World!";
		
		greeting = greeting.replace('e', 'O');
		greeting = greeting.replace('o', 'e');
		greeting = greeting.replace('O', 'o');
		
		System.out.println(greeting);
	}
}
