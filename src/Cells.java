
//package tictactoe;

// Class for placing the values in the cells

public class Cells {
    CellContents value;
    
    int row, col;
    
    public Cells(int row, int col){
        this.row=row;
        this.col = col;
        clear();
    }
    
    public void clear() {
        
        value = CellContents.EMPTY;
    }
    
    public void paint(){
        switch (value){
            case X: System.out.print(" X "); break;
            case O: System.out.print(" O "); break;
            case EMPTY: System.out.print("   "); break;
        }
    }
}
