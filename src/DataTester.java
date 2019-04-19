
public class DataTester {
	public static void main(String[] args)
	{
		Data myData = new Data(3);
		
		print(myData);
		
		System.out.println(myData.getAData()[0]);
		
		myData.select(0);
		
		print(myData);
		
	}
	
	public static void print(Data myData)
	{
		for(int i : myData.getAData())
		{
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i : myData.getBData())
		{
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
	}
}


