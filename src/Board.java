
//package tictactoe;

// The class for the elements of the game board.

public class Board {
    
    
    public static final int ROWS = 3;
    public static final int COLS = 3;

    Cells[][] cell;
    int currentRow, currentCol;
    
    // constructor for the board class
    public Board() 
    {
        cell = new Cells[ROWS][COLS];
        for (int row = 0; row < ROWS; ++row)
        {
            for (int col = 0; col < COLS; ++col)
            {
                cell[row][col] = new Cells(row, col);
            }    
        }    
        
    }
    
    // clears the board
    public void initilize()
    {
        for(int row = 0; row <ROWS; ++row)
        {
            for (int col = 0; col < COLS; ++col)
            {
                cell[row][col].clear();
            }
            
        }
    }            
    // function to check to see if the game is a draw
      public boolean isDraw() {
      for (int row = 0; row < ROWS; ++row) 
      {
         for (int col = 0; col < COLS; ++col) 
         {
            if (cell[row][col].value == CellContents.EMPTY) 
            {
               return false; // an empty seed found, not a draw, exit
            }
         }
      }
      return true;
      }
      // Function to check if the game has been won by either player after each turn
      public boolean hasWon(CellContents theCell) {
      return (cell[currentRow][0].value == theCell         // 3-in-the-row
                   && cell[currentRow][1].value == theCell
                   && cell[currentRow][2].value == theCell
              || cell[0][currentCol].value == theCell      // 3-in-the-column
                   && cell[1][currentCol].value == theCell
                   && cell[2][currentCol].value == theCell
              || currentRow == currentCol            // 3-in-the-diagonal
                   && cell[0][0].value == theCell
                   && cell[1][1].value == theCell
                   && cell[2][2].value == theCell
              || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                   && cell[0][2].value == theCell
                   && cell[1][1].value == theCell
                   && cell[2][0].value == theCell);
   }
    // function to draw the board
    public void paint() 
    {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            cell[row][col].paint();   // each cell paints itself
            if (col < COLS - 1) System.out.print("|");
         }
         System.out.println();
         if (row < ROWS - 1) 
         {
            System.out.println("-----------");
         }
       } 
      
    }
    
}
