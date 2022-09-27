package edu.iastate.cs228.hw1;

/**
 *  
 * @author Patrick Westerlund
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.Random; 

/**
 * 
 * The plain is represented as a square grid of size width x width. 
 *
 */
public class Plain
{
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	/**
	 *  Default constructor reads from a file 
	 */
	public Plain(String inputFileName) throws FileNotFoundException
	{		
		File f = new File(inputFileName);
		Scanner s = new Scanner(f);
		Scanner sc= new Scanner(f);
		double count = 0.0;
		while(s.hasNext())
		{
			count++;
			s.next();
		}
		double realCount = Math.sqrt(count);
		grid = new Living[(int)realCount][(int)realCount];
		width = (int)realCount;
		while(sc.hasNext())
		{
			for(int i = 0;i<realCount;i++)
			{
				for(int j = 0;j<realCount;j++)
				{
					String s1 = sc.next();
					if(s1.charAt(0)=='B')
					{
						String a = Character.toString(s1.charAt(1));
						int age = Integer.parseInt(a);
						grid[i][j]= new Badger(this,i,j,age);
					}
					else if(s1.charAt(0)=='E')
					{
						grid[i][j]= new Empty(this,i,j);
					}
					else if(s1.charAt(0)=='F')
					{
						String a = Character.toString(s1.charAt(1));
						int age = Integer.parseInt(a);
						grid[i][j]= new Fox(this,i,j,age);
					}
					else if(s1.charAt(0)=='G')
					{
						grid[i][j]= new Grass(this,i,j);
					}
					else if(s1.charAt(0)=='R')
					{
						String a = Character.toString(s1.charAt(1));
						int age = Integer.parseInt(a);
						grid[i][j]= new Rabbit(this,i,j,age);
					} 
				}
			}
		}
		s.close();
		sc.close();
		// Assumption: The input file is in correct format. 
		// 
		// You may create the grid plain in the following steps: 
		// 
		// 1) Reads the first line to determine the width of the grid.
		// 
		// 2) Creates a grid object. 
		// 
		// 3) Fills in the grid according to the input file. 
		// 
		// Be sure to close the input file when you are done. 
	}
	
	/**
	 * Constructor that builds a w x w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Plain(int w)
	{
		grid = new Living[w][w];
		width = w;
	}
	
	
	public int getWidth()
	{
		return width; 
	}
	
	/**
	 * Initialize the plain by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random(); 
		 
		for(int i = 0;i<width;i++)
		{
			for(int j = 0;j<width;j++)
			{
				int rand = generator.nextInt(5);
				if(rand == 0)
				{
					grid[i][j]=new Badger(this,i,j,0);
				}
				else if(rand == 1)
				{
					grid[i][j]=new Empty(this,i,j);
				}
				else if(rand == 2)
				{
					grid[i][j]=new Fox(this,i,j,0);
				}
				else if(rand == 3)
				{
					grid[i][j]=new Grass(this,i,j);
				}
				else
				{
					grid[i][j]=new Rabbit(this,i,j,0);
				}
			}
		}
	}
	
	
	/**
	 * Output the plain grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		String ret = "";
		for(int i = 0;i<this.width;i++)
		{
			String s1 = "";
			for(int j = 0;j<this.width;j++)
			{
				if(grid[i][j].who().equals(State.BADGER))
				{
					s1+="B"+((Badger)grid[i][j]).myAge()+" ";
				}
				else if(grid[i][j].who().equals(State.EMPTY))
				{
					s1+="E  ";
				}
				else if(grid[i][j].who().equals(State.FOX))
				{
					s1+="F"+((Fox)grid[i][j]).myAge()+" ";
				}
				else if(grid[i][j].who().equals(State.GRASS))
				{
					s1+="G  ";
				}
				else
				{
					s1+="R"+((Rabbit)grid[i][j]).myAge()+" ";
				}
			}
			ret+=s1+"\n";
		}
		return ret;
	}
	

	/**
	 * Write the plain grid to an output file.  Also useful for saving a randomly 
	 * generated plain for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		File f = new File(outputFileName);
		PrintWriter p = new PrintWriter(f);
		p.println(this.toString());
		
		p.close();
		// 1. Open the file. 
		// 
		// 2. Write to the file. The five life forms are represented by characters 
		//    B, E, F, G, R. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		// 3. Close the file. 
	}		

}
