# WildlifeSimulator

Patrick Westerlund patwest1234@gmail.com

This project simulates interactions among different forms of life in a plain. The plain is 
represented by an NxN grid that changes over a number of cycles. Within a cycle, each square 
is occupied by one of the following five life forms:    
 
    Badger (B), Fox (F), Rabbit (R), Grass (G), and Empty (E) 
 
An Empty square means that it is not occupied by any life form.  
 
Below is a plain example as a 6  6 grid.    
 
F5 E  E  F0 E  E   
B3 F1 B0 R0 G  R0  
R0 E  R2 B0 B2 G   
B0 E  E  R1 F0 E   
B1 E  E  G  E  R0  
G  G  E  B0 R2 E   
 
Both row and column indices start from 0. In the example, the (1, 1)th square is occupied by a 
1-year-old Fox.  It has a 3×3 neighborhood centered at the square:    
 
F5 E  E   
B3 F1 B0  
R0 E  R2  
 
The (0, 0)th square F5 (a 5-year-old Fox) has only a 2×2 neighborhood:  
 
F5 E     
B3 F1 
 
Meanwhile, the (2, 0)th square R0 (a newborn Rabbit) has a 3×2 neighborhood:  
 
B3 F1   
R0 E    
B0 E     
 
Generally, the neighborhood of a square is a "3×3" grid which includes only those squares 
lying within the intersection of the plain with a 3×3 window centered at the square.  When a 
square is on the border, the dimension of its neighborhood reduces to 2×3, 3×2, or 2×2.
