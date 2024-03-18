package sourceFiles;

public class DoubleSizePicture
{
	public static void main (String[] args)
	{
		Picture pic = new Picture();
		pic.load("C:\\Users\\Mayuresh\\Pictures\\deepika.jpg");
		pic.scale(pic.getWidth() * 2, pic.getHeight() * 2);
		
		pic.move(pic.getWidth() / 4, pic.getHeight() / 4);
	}
}
