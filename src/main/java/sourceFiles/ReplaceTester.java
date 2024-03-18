package sourceFiles;

public class ReplaceTester
{
	public static void main (String[] args)
	{
		String river = "Mississippi";
		
		river = river.replace('i', '!');
		river = river.replace('s', '$');
		
		System.out.println("Expected: M!$$!$$!pp!");
		System.out.println(river);
	}
}
