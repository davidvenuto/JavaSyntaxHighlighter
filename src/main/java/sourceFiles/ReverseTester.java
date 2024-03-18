package sourceFiles;

public class ReverseTester
{
	public static void main (String[] args)
	{
		StringBuilder string = new StringBuilder("desserts");
		
		string.reverse();
		
		System.out.println("Expected: stressed");
		System.out.println(string);
	}
}
