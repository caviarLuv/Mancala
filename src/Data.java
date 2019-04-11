


public class Data {
	
	//who's turn is it
	private boolean isPlayerA;
	
	//the pits(0-5) and the mancala(6) 
	private int[] playerA;
	private int[] playerB;
	
	/**
	 * Constructs a new Data object, filling each pit with the specified amount of stones
	 * @param stones the number of stones per pit
	 */
	public Data(int stones)
	{
		playerA = new int[7];
		playerB = new int[7];
		isPlayerA = true;
		for(int i = 0; i < 6; i++)
		{
			playerA[i] = stones;
			playerB[i] = stones;
		}
	}
	
	
	public void select(int pit)
	{
		int[] side = playerB;
		if(isPlayerA)
		{
			side = playerA;
		}
		
		int numOfStones = side[pit];
		int counter = 7;
		side[pit] = 0;
		pit++;
		
		while(numOfStones > 0)
		{
			while(pit < counter && numOfStones > 0)
			{
				side[pit]++;
				numOfStones--;
				pit++;
			}
			if(pit == counter && numOfStones > 0)
			{
				if(counter == 7)
				{
					counter = 6;
				}
				else
				{
					counter = 7;
				}
				
				if(side == playerA)
				{
					side = playerB;
				}
				else
				{
					side = playerA;
				}
				pit = 0;
			}
		}
		//if we're on the current player's side
		if(counter == 7)
		{
			if(pit < counter && side[pit-1] == 1)
			{
				if(side == playerA)
				{
					int addStone = playerB[6-pit];
					playerB[6-pit] = 0;
					side[6] += addStone;
				}
				else if(side == playerB)
				{
					int addStone = playerA[6-pit];
					playerA[6-pit] = 0;
					side[6] += addStone;
				}
			}
			//if the last stone goes into current player's mancala
			else if(pit >= 7 && side[pit-1] == 1)
			{
				//take an extra turn
			}
		}
		//update view
		//insert code here//
	}
	
	/**
	 * Gets value of isPlayerA
	 * @return boolean isPlayerA 
	 */
	public boolean getIsPLayerA()
	{
		return isPlayerA;
	}
	
}
