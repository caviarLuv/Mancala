import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.*;

public class Data {
	
	//who's turn is it
	private boolean isPlayerA;
	
	//has game ended
	private boolean gameEnd;
	
	//undo stuff
	private boolean playerAUndo;
	private boolean playerBUndo;
	private boolean prevPlayerWasA;
	private boolean canUndo;
	
	private int undoAmount;
	
	
	//the pits(0-5) and the mancala(6) 
	private int[] playerA;
	private int[] playerB;
	
	private int[] undoA;
	private int[] undoB;

	
	private ArrayList<ChangeListener> listeners;
	
	/**
	 * Constructs a new Data object, filling each pit with the specified amount of stones
	 * @param stones the number of stones per pit
	 */
	public Data(int stones)
	{
		//reg game init
		playerA = new int[7];
		playerB = new int[7];
		listeners = new ArrayList<>();
		isPlayerA = true;
		gameEnd = false;
		
		//undo variable init
		playerAUndo = false;
		playerBUndo = false;
		undoAmount = 3;
		prevPlayerWasA = false;
		canUndo = false;
		
		//pit init
		for(int i = 0; i < 6; i++)
		{
			playerA[i] = stones;
			playerB[i] = stones;
		}
		//more redo init
		undoA = Arrays.copyOf(playerA, playerA.length);
		undoB = Arrays.copyOf(playerA, playerB.length);
	}
	
	/**
	 * Function undos the board state to the previous board
	 * if canUndo is false or if undoAmount is >=0, nothing happens
	 */
	public void undo()
	{
		if(undoAmount > 0 && canUndo)
		{
			canUndo =false;
			playerA = Arrays.copyOf(undoA,undoA.length);
			playerB = Arrays.copyOf(undoB,undoB.length);
			if(prevPlayerWasA)
			{
				isPlayerA = true;
			}
			else
			{
				isPlayerA = false;
			}
			undoAmount--;
			
			if(!(playerAUndo||playerBUndo))
			{
				if(isPlayerA)
				{
					playerBUndo = true;
				}
				else
				{
					playerAUndo = true;
				}
			}
		}
	}
	
	/**
	 * Method carries out game rules for if a pit has been selected 
	 * @param pit the pit that has been selected
	 */
	public void select(int pit)
	{System.out.println("select in progess");
		int[] side = playerB;
		prevPlayerWasA = false;
		if(isPlayerA)
		{
			side = playerA;
			prevPlayerWasA = true;
		}
		
		if(canUndo)
		{
			undoAmount = 3;
		}
		canUndo = true;
		
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
				for(int i : getAData())
				{
					System.out.print(i + " ");
				}
				System.out.println();
				for(int i : getBData())
				{
					System.out.print(i + " ");
				}
				System.out.println();
				System.out.println();
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
					capture(side, playerB, pit);
				}
				else if(side == playerB)
				{
					capture(side, playerA, pit);
				}
			}
			//if the last stone goes into current player's mancala
			else if(pit >= 7 && side[pit-1] == 1)
			{
				isPlayerA = !isPlayerA;
			}
			isPlayerA = !isPlayerA;
		}
		
		if(isEmpty(playerA))
		{
			gameEndProtocal(playerB);
		}
		else if(isEmpty(playerB))
		{
			gameEndProtocal(playerA);
		}
		
		
		ChangeEvent event = new ChangeEvent(this);
		for(ChangeListener l: listeners)
		{
			l.stateChanged(event);
		}
	}
	
	
	/**
	 * Adds a changelistener to the listeners of the data class
	 * @param listener the listener to add
	 */
	public void addChangeListener(ChangeListener listener)
	{
		listeners.add(listener);
	}
	
	
	/**
	 * Gets value of isPlayerA
	 * @return boolean isPlayerA 
	 */
	public boolean getIsPLayerA()
	{
		return isPlayerA;
	}
	
	/**
	 * Method gets if the game ended
	 * @return boolean t/f if game has ended
	 */
	public boolean getGameEnd()
	{
		return gameEnd;
	}
	
	/**
	 * Method carries out if a capture is being made
	 * @param cSide the current side to add to
	 * @param oppSide the opposite side to capture pieces
	 * @param pit which pit is capturing
	 */
	public void capture(int[] cSide, int[] oppSide, int pit)
	{
		cSide[pit-1] = 0;
		int addStone = oppSide[6-pit] + 1;
		oppSide[6-pit] = 0;
		cSide[6] += addStone;
	}
	
	
	/**
	 * Method carries out final steps if one side is empty
	 * @param nonEmpty the other array that is not empty
	 */
	public void gameEndProtocal(int[] nonEmpty)
	{
		for(int i = 0; i < nonEmpty.length-1; i++)
		{
			nonEmpty[nonEmpty.length-1] += nonEmpty[i];
			nonEmpty[i] = 0;
		}
		gameEnd = true;
	}
	
	
	/**
	 * Method checks if given array is empty
	 * @param test the array to test
	 * @return true if the array is empty
	 */
	public boolean isEmpty(int[] test)
	{
		boolean empty = true;
		int counter = 0;
		while(empty && counter < test.length-1)
		{
			if(test[counter] != 0 )
			{
				empty = false;
			}
		}
		return empty;
	}
	
	/**
	 * Accessor for playerA's array
	 * @return playerA an int[]
	 */
	public int[] getAData()
	{
		return playerA;
	}
	/**
	 * Accessor for playerB's array
	 * @return playerB an int[]
	 */
	public int[] getBData()
	{
		return playerB;
	}
	
	/**
	 * Accessor for canUndp
	 * @return boolean t/f if canUndo is t/f
	 */
	public boolean canUseUndo()
	{
		return canUndo;
	}
	
}
