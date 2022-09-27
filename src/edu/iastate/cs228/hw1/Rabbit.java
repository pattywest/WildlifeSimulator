package edu.iastate.cs228.hw1;

/**
 *  
 * @author Patrick Westerlund
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param p: plain  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (Plain p, int r, int c, int a) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
		super.age = a; 
	}
		
	// Rabbit occupies the square.
	public State who()
	{
		return State.RABBIT;
	}
	
	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a fox.  
	 * @param pNew     plain of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{
		int[] population = new int[5];
		this.census(population);
		if(this.myAge()==3)
		{
			Living L = new Empty(pNew,this.row,this.column);
			return L;
		} 
		else if(population[3]==0)
		{
			Living L = new Empty(pNew,this.row,this.column);
			return L;
		}
		else if(population[0]+population[2]>=population[4]&&population[2]>population[0])
		{
			Living L = new Fox(pNew,this.row,this.column,0);
			return L;
		}
		else if(population[0]>population[4])
		{
			Living L = new Badger(pNew,this.row,this.column,0);
			return L;
		}
		else
		{
			int age = this.myAge();
			Living L = new Rabbit(pNew,this.row,this.column,age+1);
			return L;
		}
 
	}
}
