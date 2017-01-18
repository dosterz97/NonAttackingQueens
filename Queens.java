import java.io.*;
import java.util.*;
/**
 * Finds all the solutions of Non attacking queens on a 8x8 board
 * 
 * @Zach Doster
 * @1/18/17
 */
public class NonAttackingQueens
{
    // instance variables - replace the example below with your own
    static private int SIZE =8;
    private int board[][] = new int[SIZE][SIZE];
    private ArrayList<Integer> moves = new ArrayList<Integer>();
    /**
     * initialize the board
     */
    public NonAttackingQueens()
    {
        for(int i = 0; i < SIZE; i++)
            for(int k =0; k<SIZE; k++)
                board[k][i]=0;
    }

    /**
     * Main method
     */
    static public void main(String[] args)
    {
        // put your code here
        NonAttackingQueens b = new NonAttackingQueens();
        b.solve();
    }
    
    public void print()
    {
        for(int i = 0; i < SIZE; i++)
        {
            for(int k = 0; k< SIZE; k++)
            {
                System.out.print(board[k][i]);
            }
            System.out.println();
        }
        System.out.println("********");
    }
    
    //check to see if it is ok to place a queen
    public boolean checkQueen(int row, int col)
    {
        //check vertical
        for(int i = 0; i <SIZE; i++)
        {
            if(board[row][i]==1)
                return false;
        }
        
        //check upper left diagnol
        for(int i = 0; i <= row && i <= col; i++)
        {
            if(board[row-i][col-i]==1)
                return false;
        }

        //check upper right diagnol
        for(int i = 0; i <= 7 - row && i <= 7- col; i++)
        {
            if(board[row + i][col + i]==1)
                return false;
        }
        return true;
    }
    
    //solve the nonAttackingQueens
    public void solve()
    {
        int total=0,x=0,y=0,count=0, runs = 0;
        //while the board doesnt have enought pieces
        while(total != 8)
        {
            runs++;
            total=0;
            //count the number of queens
            for(int i = 0; i < SIZE; i++)
            {
                for(int k = 0; k< SIZE; k++)
                {
                    if(board[i][k]==1)
                    {
                        total++;
                    }
                }
            }
            
            //Solution is found
            if(total ==8)
            {
                total=0;
                count++;
                System.out.println(count + ".");
                System.out.println(runs);
                print();//print soludtion
                //end if all solutions found
                if(count>91)
                {

                    return;
                }
                //move on to next solution
                else
                {
                    
                    for(int b = 0; b < SIZE; b++)
                    {
                        moves.add(moves.get(moves.size()-8));//add solution to list
                    }
                    
                    y--;//move back a row
                    x = moves.get(moves.size()-1).intValue();//move to last spot
                    board[x][y]=0;//set spot to empty
                    moves.remove(moves.size()-1);//remove last spot
                    
                    if(x!=7)//move to next spot
                        x++;
                        
                    if(x==7)//move back another row
                    {
                        y--;
                        x = moves.get(moves.size()-1).intValue();
                        board[x][y]=0;
                        x++;
                        moves.remove(moves.size()-1);
                    }
                }
            }
            
            //check to see if you can place the queen
            if(y < 8 && x < 8 && checkQueen(x,y))
            {
                Integer t = new Integer(x);
                moves.add(t);
                board[x][y]=1;
                y++;
                x=0;
                
            }
            //move to the next row if x is at the edge
            else if(x>7)
            {
                y--;
                x = moves.get(moves.size()-1).intValue();
                board[x][y]=0;
                x++;
                moves.remove(moves.size()-1);
            }
            //move to the right
            else
                x++;
        }
   }
}
