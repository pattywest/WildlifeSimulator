package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author Patrick Westerlund
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with
 * squares inhabited by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class Wildlife
{
	/**
	 * Update the new plain from the old plain in one cycle. 
	 * @param pOld  old plain
	 * @param pNew  new plain 
	 */
	public static void updatePlain(Plain pOld, Plain pNew)
	{
		for(int i = 0;i<pOld.getWidth();i++)
		{
			for(int j = 0;j<pOld.getWidth();j++)
			{
				Living temp =pOld.grid[i][j].next(pNew);
				pNew.grid[i][j]=temp;
			}
		}
		 
	}
	
	/**
	 * Repeatedly generates plains either randomly or from reading files. 
	 * Over each plain, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		System.out.println("Simulation of Wildlife of the Plain");
		System.out.println("keys: 1 (random plain)  2 (file input)  3 (exit)");
		int cont = 0;
		int trial = 0;
		while(cont<3)
		{
			Scanner s = new Scanner(System.in);
			cont = s.nextInt();
			if(cont<0)
			{
				cont = 0;
				break;
			}
			if(cont>2)
			{
				break;
			}
			trial++;
			System.out.println("Trial " +trial+": " + cont);
			if(cont==1)
			{
				int width = 0;
				int cycles = 0;
				System.out.println("Random Plain");
				System.out.print("Enter Grid Width: ");
				width = s.nextInt();
				System.out.println(width);
				Plain even = new Plain(width);
				Plain odd = new Plain(width);
				System.out.print("Enter the Number of Cycles: ");
				cycles = s.nextInt();
				System.out.println(cycles);
				even.randomInit();
				System.out.println("Initial Plan: ");
				System.out.println(even.toString());
				if(cycles%2==0)
				{
					for(int i = cycles;i>0;i=i-2)
					{
						Wildlife.updatePlain(even, odd);
						even = new Plain(width);
						Wildlife.updatePlain(odd, even);
						odd = new Plain(width);
					}
					System.out.println("Final Plan: ");
					System.out.println(even.toString());
				}
				else
				{
					for(int i = cycles;i>0;i--)
					{
						Wildlife.updatePlain(even, odd);
						Plain temp = odd;
						even = temp;
					}
					System.out.println("Final Plan: ");
					System.out.println(odd.toString());
				}
			}
			else if(cont==2)
			{
				int width = 0;
				int cycles = 0;
				System.out.println("Plain imput from file");
				System.out.print("File name: ");
				String fil = s.next();
				Plain even = new Plain(fil);
				Plain odd = new Plain(fil);
				width = even.getWidth();
				System.out.print("Enter the Number of Cycles: ");
				cycles = s.nextInt();
				System.out.println(cycles);
				System.out.println("Initial Plan: ");
				System.out.println(even.toString());
				if(cycles%2==0)
				{
					for(int i = cycles;i>0;i=i-2)
					{
						Wildlife.updatePlain(even, odd);
						even = new Plain(width);
						Wildlife.updatePlain(odd, even);
						odd = new Plain(width);
					}
					System.out.println("Final Plan: ");
					System.out.println(even.toString());
				}
				else
				{
					for(int i = cycles;i>0;i--)
					{
						Wildlife.updatePlain(even, odd);
						Plain temp = odd;
						even = temp;
					}
					System.out.println("Final Plan: ");
					System.out.println(odd.toString());
				}
			}
			
		}
		// 
		// Generate wildlife simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random plain, 2 to read a plain from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.)
		// 
		// 2. Print out standard messages as given in the project description. 
		// 
		// 3. For convenience, you may define two plains even and odd as below. 
		//    In an even numbered cycle (starting at zero), generate the plain 
		//    odd from the plain even; in an odd numbered cycle, generate even 
		//    from odd. 		
		// 4. Print out initial and final plains only.  No intermediate plains should
		//    appear in the standard output.  (When debugging your program, you can 
		//    print intermediate plains.)
		// 
		// 5. You may save some randomly generated plains as your own test cases. 
		// 
		// 6. It is not necessary to handle file input & output exceptions for this 
		//    project. Assume data in an input file to be correctly formated. 
	}
}

