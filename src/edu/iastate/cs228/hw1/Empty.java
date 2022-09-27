package edu.iastate.cs228.hw1;

/**
 *  
 * @author Patrick Westerlund
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Plain p, int r, int c) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
	}
	
	public State who()
	{
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{
		int[] population = new int[5];
		this.census(population);
		if(population[4]>1)
		{
			Living L = new Rabbit(pNew,this.row,this.column,0);
			return L;
		}
		else if(population[2]>1)
		{
			Living L = new Fox(pNew,this.row,this.column,0);
			return L;
		}
		else if(population[0]>1)
		{
			Living L = new Badger(pNew,this.row,this.column,0);
			return L;
		}
		else if(population[3]>=1)
		{
			Living L = new Grass(pNew,this.row,this.column);
			return L;
		}
		else
		{
			Living L = new Empty(pNew,this.row,this.column);
			return L;
		}
 
	}
}
