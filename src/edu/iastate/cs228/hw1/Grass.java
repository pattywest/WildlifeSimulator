package edu.iastate.cs228.hw1;

/**
 *  
 * @author Patrick Westerlund
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (Plain p, int r, int c) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
	}
	
	public State who()
	{
		return State.GRASS;
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		int[] population = new int[5];
		this.census(population);
		if(population[4]>=population[3]*3)
		{
			Living L = new Empty(pNew,this.row,this.column);
			return L;
		}
		else if(population[4]>2)
		{
			Living L = new Rabbit(pNew,this.row,this.column,0);
			return L;
		}
		else
		{
			Living L = new Grass(pNew,this.row,this.column);
			return L;
		}
	}
}
