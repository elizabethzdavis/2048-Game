//Elizabeth Davis HW 6

public class Ai2048 {
	static void playLeft(TwoThousandFourtyEight board) {
		while (board.left()) {
			// loop until the board is full!
		}
	}

	static void playRandom(TwoThousandFourtyEight board) {
      //Check to see if there is room to move
      while(TwoDimensional2048.numUnoccupied(board.getBoard()) != 0) {
         //Min + (int)(Math.random() * ((Max - Min) + 1))
        int rando = 1 + (int)(Math.random() * ((1000 - 1) + 1)); // Returns numbers 1-100
        if(rando >= 1 && rando <= 400) {
            board.down();
            board.left();
        }
        if(rando > 400 && rando <= 700) {
            board.left();
            board.up();
        }
        if(rando > 700 && rando <= 920) {
            board.down();
        }
        if(rando > 920 && rando <= 1000) {
            board.right();
        }
      }
    
	}

	static void playAI(TwoThousandFourtyEight board) {
      int[][] playing = board.getBoard();
      while(TwoDimensional2048.numUnoccupied(board.getBoard()) != 0) {
          for(int i = 0; i < playing.length - 1; i++) {
               board.down();
               board.left();            
            for(int j = 0; j < playing[i].length - 1; j++) {
               TwoDimensional2048.combineLeft(playing);
               board.down();
               board.left();
               if(playing[i][j] == playing[i+1][j]) {
                  board.down();
               } 
               if(playing[i][j] == playing[i][j+1]) {
                  board.right();
               }
               
            }
          
          } 
      }
      
   }   
}
