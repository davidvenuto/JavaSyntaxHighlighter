package sourceFiles;

public class WorkOrPersonal
{
	public static void main(String[] args)
	{
		int workDays, distanceToWork;
		double driveRatio, workDrive, personalDrive, startMileage, endMileage;
		
		workDays = 7;
		distanceToWork = 15;
		startMileage = 12493;
		endMileage = 13090;
		
		workDrive = workDays * distanceToWork;
		personalDrive = endMileage - workDrive - startMileage;
		
		driveRatio = workDrive / personalDrive;
		
		System.out.println("You Drive " + workDrive + " miles to work each week");
		System.out.println(personalDrive + " is how many miles you drive personally");
		System.out.println("Your work:personal drive ratio is: " + driveRatio);
	}
}
