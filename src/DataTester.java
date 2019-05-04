import java.util.Scanner;

public class DataTester {
	public static void main(String[] args)
	{
		Data myData = new Data(3);
		Scanner sc = new Scanner(System.in);
		boolean playerA = true;
	
		print(myData);

		while(true) {
			System.out.println("Enter pit num");
			//myData.select(sc.nextInt());
			print(myData);
			
			System.out.println("Enter pit num");
			//myData.select(sc.nextInt());
			print(myData);
			
			myData.undo();
			print(myData);
			
			myData.undo();
			print(myData);
		}
	}
	
	public static void print(Data myData)
	{
		int[] barr = myData.getBData();
		
		for(int i = barr.length-1; i >= 0; i-- )
		{
			System.out.print(barr[i] + " ");
		}
		System.out.println();
		System.out.print("  ");
		
		for(int i : myData.getAData())
		{
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
	}
}


