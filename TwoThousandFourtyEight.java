//Elizabeth Davis HW 6

public class TwoThousandFourtyEight {
//This class allows us to make 2048 objects with a board 
   private int[][] board;
   private int row;
   private int col;
   public int score;
   

   public TwoThousandFourtyEight(int x, int y) { //x and y are the dimensions NOT the number indexes there are
   //use addNewValue to add a two to the board
      board = TwoDimensional2048.blankBoard(x, y);
      row = x - 1;
      col = y - 1;
      TwoDimensional2048.addNewValue(board);
      //TwoDimensional2048.addNewValue(board);
      //TwoDimensional2048.printBoard(board);
   
   }
   
   public TwoThousandFourtyEight(TwoThousandFourtyEight orig) {
      this.row = orig.row;
      this.col = orig.col;
      this.score = orig.score;
      this.board = orig.getBoard();
      
   }
      public int[][] getBoard() {
         int[][] copies = new int[row + 1][col + 1];
         for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
               copies[i][j] = board[i][j];
            }
         }            
      return copies;
   }

   public int singleScore(int a, int b) {
      if((a > row) || (b > col)) {
         return -1;
      }  
       int space = board[a][b];
         for (int x = 0; x <= space; x++) {
               int singleValue = space;
               space = space / 2;
               if(space > 1) {
                  singleValue += space;
               }
               //System.out.println(singleValue);
               return singleValue;  
          }
         return -1;
   } 
   
   
   public int getScore() {
      /*if(TwoDimensional2048.validateBoard(board) == false) {
         return -1;
      }*/
      int score = 0;
      int totalValue = 0;
      for(int i = 0; i <= row; i++) {
         for(int j = 0; j <= col; j++) {
            //System.out.println("i = " + i);
            //System.out.println("j = " + j);
            int valueOfSpace = board[i][j];
            int value = 0;
            if(valueOfSpace != 0) {
               value = ((2 * valueOfSpace) - 2); 
            }
            totalValue += value;
         }
      }
      return totalValue;      
   }
   
   public int getHighestTile() {
      int highestValue = 0;
      for(int x = 0; x <= row; x++) {
         for(int y = 0; y <= col; y++) {
            int Value = board[x][y];
            if(Value > highestValue){
               highestValue = Value;
            }
         }
      }
      return highestValue;
   }
   
   public TwoThousandFourtyEight copy() {
      TwoThousandFourtyEight copies = new TwoThousandFourtyEight(this);
      return copies;
   } 
   
   //make sure numOccupied is not zero
   
   public boolean up() {
  
      board = TwoDimensional2048.up(board);
            
            //System.out.println("Up");

      if(TwoDimensional2048.addNewValue(board) == false) {
         return false;
      }
         //TwoDimensional2048.printBoard(board);
         //System.out.println(getScore());
      return true;
   }
   
   public boolean down() {

      board = TwoDimensional2048.down(board);
            
           //System.out.println("Down");

      if(TwoDimensional2048.addNewValue(board) == false) {
         return false;
      }
        //TwoDimensional2048.printBoard(board);
        //System.out.println(getScore());
      return true;
   }   
      
   public boolean left() {
         
      board = TwoDimensional2048.left(board);
   
           //System.out.println("Left");

      if(TwoDimensional2048.addNewValue(board) == false) {
         return false;
      }
         //TwoDimensional2048.printBoard(board);
         //System.out.println(getScore());
      return true; 
   }
   
   public boolean right() {
         
      board = TwoDimensional2048.right(board);
      
             //System.out.println("Right");

      if(TwoDimensional2048.addNewValue(board) == false) {
         return false;
      }
         //TwoDimensional2048.printBoard(board);
         //System.out.println(getScore());
      return true; 
   }
   
   public void printBoard() {
      for(int i = 0; i <= row; i++) {
         for(int j = 0; j <= col; j++) {
            System.out.print(board[i][j] + " ");
         }
         System.out.println("");
      }
   }  
   
   public boolean room() {
      if (TwoDimensional2048.numUnoccupied(board) != 0 ) {
         return true;
      }
      
      return false;
   } 

}
