package edu.iastate.cs228.hw1;

/**
 *  
 * @author Patrick Westerlund
 *
 */

/**
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal
{

	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Badger (Plain p, int r, int c, int a) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
		super.age = a;
	}
	
	/**
	 * A badger occupies the square. 	 
	 */
	public State who()
	{
		return State.BADGER; 
	}
	
	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group of foxes. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		int[] population = new int[5];
		this.census(population);
		if(this.myAge()==4)
		{
			Living L = new Empty(pNew,this.row,this.column);
			return L;
		} 
		else if(population[0]==1&&population[2]>1)
		{
			Living L = new Fox(pNew,this.row,this.column,0);
			return L;
		}
		else if(population[0]+population[2]>population[4])
		{
			Living L = new Empty(pNew,this.row,this.column);
			return L;
		}
		else
		{
			int age = this.myAge();
			Living L = new Badger(pNew,this.row,this.column,age+1);
			return L;
		}
	}
}
