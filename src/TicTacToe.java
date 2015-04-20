/* COSC 3324
 * Lab2
 * John Pavelchak
 */ 

// This program allows two users to play tic tac toe\
// Some functions for this program were taken from 
// https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaGame_TicTacToe.html

//package tictactoe;
import java.util.*;
import java.util.Scanner;

// The main class for the game

public class TicTacToe{
    private Board gameBoard;
    private GameState currentState;
    private CellContents currentPlayer;
    private static Scanner in = new Scanner(System.in);
    
    //Constructor for TicTacToe
    public TicTacToe(){
    gameBoard = new Board();
    initializeGame();
    // do while loop that places player moves and continues while currentState == Playing
     do {
         playerMove(currentPlayer); // update the content, currentRow and currentCol
         gameBoard.paint();             // ask the board to paint itself
         updateGame(currentPlayer); // update currentState
         // Program goes here if game is over and prints message
        
         if (currentState == GameState.X_WON) {
            System.out.println("'X' won");
         } else if (currentState == GameState.X_WON) {
            System.out.println("'O' won");
         } else if (currentState == GameState.DRAW) {
            System.out.println("It's a Draw");
         }
         // Switch player
         currentPlayer = (currentPlayer == CellContents.X) ? CellContents.O : CellContents.X;
      } while (currentState == GameState.PLAYING);  // repeat until game-over
   }
    


    // initializes the game up but adding rows/cols, game starts with x player first
    public void initializeGame(){
    gameBoard.initilize();
    currentPlayer = CellContents.X;
    currentState = GameState.PLAYING;
    }
    // function for alternating player turns
    public void playerMove(CellContents theCell) {
      boolean validInput = false;  // for validating input
      // do while loop for alternating player turns
      do {
         try{ 
         if (theCell == CellContents.X) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
         }
         int row = in.nextInt() - 1;
         int col = in.nextInt() - 1;
         // input validation
         if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
               && gameBoard.cell[row][col].value == CellContents.EMPTY) {
           gameBoard.cell[row][col].value = theCell;
            gameBoard.currentRow = row;
            gameBoard.currentCol = col;
            
            validInput = true;
         }// input okay, exit loop
         } catch(InputMismatchException e) {
             
            System.out.println("This move is not valid. Try again...");
            in.nextLine();
            
            //int row = in.nextInt() - 1;
            //int col = in.nextInt() - 1;
            
         }
      } while (!validInput);   // repeat until input is valid
   }
    
    // This function checks to see if the game state needs to be change from "playing"
   public void updateGame(CellContents theCell) {
      if (gameBoard.hasWon(theCell)) {  // check for win
         currentState = (theCell == CellContents.X) ? GameState.X_WON : GameState.O_WON;
      } else if (gameBoard.isDraw()) {  // check for draw
         currentState = GameState.DRAW;
      }
      // Otherwise, no change to current state (still GameState.PLAYING).
   }
 // main
    public static void main(String[] args) {
        System.out.println("Hi");
        new TicTacToe();
       
    }
    
}