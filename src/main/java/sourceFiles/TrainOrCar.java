package sourceFiles;

public class TrainOrCar
{
	public static void main(String[] args)
	{		
		double mpg, drivingCost, trainCost, gasCost, carMaintCost;
		int distance;
	
		mpg = 19.3;
		distance = 50;
		trainCost = 35.70;
		gasCost = 4.00;
		carMaintCost = .05;
	
		System.out.println(distance/mpg);
		drivingCost = ((distance/mpg) * (gasCost)) + (distance * carMaintCost);
		System.out.println("Driving Cost: " + drivingCost);
		System.out.println("Train Ticket Cost: " + trainCost);
	}
}
