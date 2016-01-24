public class Main2048 {
	public static void main(String[] args) {
		TwoThousandFourtyEight t1 = new TwoThousandFourtyEight(4, 4);
		TwoThousandFourtyEight t2;

		t1.up();
		// 0	0	2	0	
		// 0	0	0	0	
		// 0	0	2	0	
		// 0	0	0	0	
		// Score: 4
      
      //t1.printBoard();
      //System.out.println("");
      
		t1.right();
		// 0	0	0	2	
		// 0	2	0	0	
		// 0	0	0	2	
		// 0	0	0	0	
		// Score: 6
      //t1.printBoard();
      //System.out.println("");
      
		t1.down();
		// 2	0	0	0	
		// 0	0	0	0	
		// 0	0	0	0	
		// 0	2	0	4	
		// Score: 10
      
      //t1.printBoard();
      //System.out.println("");

		t1.left();
		// 2	0	0	0	
		// 0	0	0	0	
		// 0	0	2	0	
		// 2	4	0	0	
		// Score: 12	
      
      //t1.printBoard();
      //System.out.println("");      	
		
		for (int i = 0 ; i < 16 ; i++) {
			if (!t1.up() || !t1.left()) {
				break;
			}
		}
      //t1.printBoard();
      //System.out.println(t1.getScore()+ ": if it is 128, it is correct");
		//System.out.println("");
      assert(t1.getScore() == 128);

      //t1.printBoard();
      //System.out.println("");
		t2 = t1.copy();
		for (int i = 0 ; i < 16 ; i++) {
			if (!t1.up() || !t1.left()) {
				break;
			}
		}
      //t1.printBoard();
      //System.out.println("");
      //t2.printBoard();
      //System.out.println(t1.getScore() + ": if it is 256, it is correct");
      assert(t1.getScore() == 256);
      //System.out.println(t2.getScore() + ": if it is 128, it is correct");
		assert(t2.getScore() == 128);
      
		if (!t2.down() || !t2.right() || !t2.up() || !t2.left()) {
			assert(false);
		}
      //System.out.println(t2.getScore() + ": if it is 146, it is correct");
		assert(t2.getScore() == 146);
      //System.out.println(t2.getHighestTile() + ": if it is 32, it is correct");
		assert(t2.getHighestTile() == 32);
		// t2's state:
		// 2	8	16	32	
		// 8	2	0	0	
		// 8	0	0	0	
		// 4	0	0	2	
      //print t2 right here 
      /*
      System.out.println("");
      int[][] tcopied = t1.getBoard();
      for(int i = 0; i < tcopied.length; i++) {
         for(int j = 0; j < tcopied[i].length; j++) {
            System.out.print(tcopied[i][j] + " ");
         }
         System.out.println("");
      }
      */
	}
}