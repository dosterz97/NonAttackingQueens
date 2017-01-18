import java.io.*;
import java.util.*;
/**
 * Write a description of class NonAttackingQueens here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        b.print();
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
        System.out.println();
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
        
        //check horizontal
        for(int i = 0 ;i <SIZE;i++)
        {
            if(board[i][col]==1)
                return false;
        }
        
        //check upper left diagnol
        for(int i = 0; i <= row && i <= col; i++)
        {
            if(board[row-i][col-i]==1)
                return false;
        }
        //check bottom right diagnol
        for(int i = 0; i <= row && i <= 7- col; i++)
        {
            if(board[row-i][col + i]==1)
                return false;
        }
         //check upper right diagnol
        for(int i = 0; i <= 7 - row && i <= 7- col; i++)
        {
            if(board[row + i][col + i]==1)
                return false;
        }
         //check bottom left diagnol
        for(int i = 0; i <=7- row && i <= col; i++)
        {
            if(board[row+i][col - i]==1)
                return false;
        }
        return true;
        
    }
    
    //solve the nonAttackingQueens
    public void solve()
    {
        int total=0,x=0,y=0,count=0;
        //while the board doesnt have enought pieces
        while(total != 8)
        {
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
            
            if(total ==8)
            {
                total=0;
                count++;
                print();
                if(count>91)
                {
                    return;
                }
                else
                {
                    for(int b = 0; b < SIZE; b++)
                    {
                        moves.add(moves.get(moves.size()-8));
                    }
                    
                    y--;
                    x = moves.get(moves.size()-1).intValue();
                    board[x][y]=0;
                    moves.remove(moves.size()-1);
                    
                    if(x!=7)
                        x++;
                        
                    if(x==7)
                    {
                        y--;
                        x = moves.get(moves.size()-1).intValue();
                        board[x][y]=0;
                        x++;
                        moves.remove(moves.size()-1);
                    }
                }
            }
            
            if( y < 8 && x < 8 && checkQueen(x,y))
            {
                Integer t = new Integer(x);
                moves.add(t);
                board[x][y]=1;
                y++;
                x=0;
                
            }
            else if(x>7)
            {
                y--;
                x = moves.get(moves.size()-1).intValue();
                board[x][y]=0;
                x++;
                moves.remove(moves.size()-1);
            }
            else
                x++;
        }
   }
}
