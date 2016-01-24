//Elizabeth Davis HW 4

import java.util.Scanner;

public class TwoDimensional2048 {
	public static void main(String[] args) {
		int[][] b, br, brc;
		int[][] b2;
		int tmp;

		int[][] initb = {
			{0,2,0,0,2},
			{0,2,0,0,0},
			{0,2,0,2,0},
			{0,2,0,2,2},
			{2,0,2,0,0}};
		int[][] lb = {
			{4,0,0,0,0},
			{2,0,0,0,0},
			{4,0,0,0,0},
			{4,2,0,0,0},
			{4,0,0,0,0}};
		int[][] ub = {
			{2,4,2,4,4},
			{0,4,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}};
		int[][] rb = {
			{0,0,0,0,4},
			{0,0,0,0,2},
			{0,0,0,0,4},
			{0,0,0,2,4},
			{0,0,0,0,4}};
		int[][] db = {
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,4,0,0,0},
			{2,4,2,4,4}};
		int[][] multb = {
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,4},
			{0,0,0,0,16}};
		int[][] bprerot = {
			{0,0,2,2},
			{0,2,2,0},
			{0,2,0,2},
			{2,0,0,0},
			{0,2,0,2},
			{0,0,0,2},
			{0,0,0,0}};
		int[][] brot1 = {
			{2,0,2,0,2,2,0},
			{2,2,0,0,0,0,0},
			{0,2,2,0,2,0,0},
			{0,0,0,2,0,0,0}};
		int[][] brot3 = {
			{0,0,0,2,0,0,0},
			{0,0,2,0,2,2,0},
			{0,0,0,0,0,2,2},
			{0,2,2,0,2,0,2}};
           
      int[][] tester = {
         {0, 0, 0, 0},
         {0, 0, 0, 0},
         {0, 0, 0, 0},
         {2, 0, 0, 2}};
         //printBoard(combineLeft(tester));
         
         //System.out.println(rotateLeft(tester));
 
         
         //System.out.println(randCoord(brot3, 17));
         
         //printBoard(brot3); should return what is above
         //System.out.println(copyBoard(brot3)); should give same array
         
      //System.out.println(addValue(brot3, 4, 5, 3)); should be false
      //System.out.println(addValue(brot3, 3, 3, 4)); //should be true
      //System.out.println(addValue(brot3, 0, 3, 3)); should be false
      
      //System.out.println(numMax(brot3));
      //shoudl print 28
      
      //System.out.println(numOccupied(brot3));
      //should be 10
      
		// Check the creation of boards, and adding new values
		// to the board.
		
      b = blankBoard(5, 5);
		assert(validateBoard(b));

		for (int i = 0 ; i < 10 ; i++) {
			addNewValue(b);
		}
		assert(validateBoard(b));
		tmp = b[1][4];
		b[1][4] = 33;
	   assert(!validateBoard(b));
      //System.out.println(validateBoard(b));
		b[1][4] = tmp;
		assert(identicalBoard(initb, b));

		//Check if the randCoord method works
      //System.out.println(randCoord(brot3, 4)); //should be at 0, 4
      
		brc = blankBoard(5, 6);
		// add in some random values
		brc[0][0] = 2;
		brc[1][1] = 2;
		brc[2][2] = 2;
		brc[3][3] = 2;
		brc[4][4] = 2;
		brc[4][5] = 2;
      //printBoard(brc);      
		int[][] coordAnswers = {
			{0, 1},
			{3, 2},
			{2, 0},
			{0, 4}};
		for (int i = 0 ; i < 4 ; i++) {
			int[] coord = randCoord(brc, (i * 41)%numUnoccupied(brc));
         //System.out.println(randCoord(brc, (i * 41)%numUnoccupied(brc)));
		   assert(coord[0] == coordAnswers[i][0] && 
			       coord[1] == coordAnswers[i][1]); 
		}
      //System.out.println(numUnoccupied(brc));
      
      //System.out.print(addNewValue(brot3));
      
      //System.out.print(combineLeft(brot3));
      
      //System.out.println(rotateLeft(brot3));

		// Check rotation.
		br = blankBoard(7, 4);
		for (int i = 0 ; i < 10 ; i++) {
			addNewValue(br);
		}
		assert(validateBoard(br));
		assert(identicalBoard(br, bprerot));
		br = rotateLeft(br);
		assert(identicalBoard(br, brot1));
		br = rotateLeft(rotateLeft(br));
		assert(identicalBoard(br, brot3));

		// Check the movement operations.
		b2 = b;
		b = left(b2);
		assert(identicalBoard(lb, b));
		b = up(b2);
		assert(identicalBoard(ub, b));
		b = right(b2);
		assert(identicalBoard(rb, b));
		b = down(b2);
		assert(identicalBoard(db, b));

		b = b2;
		b = left(b);
		b = up(b);
		b = right(b);
		b = down(b);
		b = right(b);
		b = down(b);
		assert(identicalBoard(multb, b));

		// Now lets test playing!
		String[] moves = {"l",
				  "lr",
				  "ldru",
				  "ldruldru",
				  "lrudrldudlr",
				  "uldruldruldruldruldr"};
		int[][][] answers = {
			{{0,0,0,0},
			 {0,0,0,0},
			 {2,0,0,0},
			 {0,0,0,0}},
			{{0,0,0,2},
			 {0,0,0,0},
			 {0,0,0,2},
			 {0,0,0,0}},
			{{2,0,0,2},
			 {0,0,0,4},
			 {0,0,0,0},
			 {0,0,0,0}},
			{{2,0,8,2},
			 {0,0,0,4},
			 {0,0,0,0},
			 {0,0,0,0}},
			{{0,0,0,2},
			 {0,0,0,0},
			 {0,0,0,2},
			 {0,8,8,2}},
			{{0,0,0,0},
			 {0,0,0,2},
			 {0,4,16,2},
			 {0,4,4,8}}
		};
		for (int i = 0 ; i < moves.length ; i++) {
			int[][] bm = blankBoard(4,4);
			for (int j = 0 ; j < moves[i].length() ; j++) {
				bm = makeMove(bm, moves[i].charAt(j));
			}
			assert(identicalBoard(answers[i], bm));
		}
      
   //System.out.println(right(brot3));
   //System.out.println(up(brot3));
   //System.out.println(down(brot3));
   
   
}   	
   	
   public static int numMax(int[][] b){
      int rows = b.length;
      int columns = b[0].length;
      int number = rows * columns;
      
      return number;
   }
   
   public static int numOccupied(int[][]b) {
      int entries = numMax(b);
      int zeros = numUnoccupied(b);
      int occupied = entries - zeros;
      
      return occupied;
   }
   
   public static boolean addValue(int[][]b, int x,int y, int val) {
      
   
      int length = b.length;
      if (x >= length || y >= b[x].length) {
         return false;
      }
      if (b[x][y] != 0) {
         return false;
      }
      b[x][y] = val;
      return true;      
   }
   
   public static int[][] copyBoard(int[][]b) {
      int length = b.length;
      int num = b[0].length;
      int[][] board = new int[length][num] ;
      board = b;
      //printBoard(board);
      return board;
   }
   
   public static void printBoard(int[][] b) {
      int length = b.length;
      for(int i = 0; i < length; i++) {
         for(int j = 0; j < b[i].length; j++) {
            System.out.print(b[i][j] + " ");
         }
         System.out.println("");
      }
   }
   
   public static boolean validateBoard(int[][] b){
      int length = b.length;
      int i = 0;
      int j = 0;
      for (int z = 0; z < length-1; z++) {
         if (b[z].length != b[z+1].length) {
            return false;
         }
      }
      while (i < length) {
         if(OneDimensional2048.validateRow(b[i])) {
         i++;
         }
         
         if(!OneDimensional2048.validateRow(b[i])){
            return false;
         }
         return true;
      }
      return false;
   }
  
   public static int[][]blankBoard(int x, int y){
      int[][] board = new int[x][y];
      int lengthOfRows = board.length;
      for(int i = 0; i < lengthOfRows; i++){
         int lengthOfColumns = board[i].length;
         for(int j = 0; j < lengthOfColumns; j++) {
            board[i][j] = 0;
         }
      }
      return board;
   }
 
   public static boolean identicalBoard(int[][] a, int[][] b){  
      if (!validateBoard(a) || !validateBoard(b)) {
         return false;
      }      
      for(int i = 0; i < a.length; i++) {
         for(int j = 0; j < a[i].length; j++) {
            int valuea = a[i][j];
            for(int x = 0; x < b.length; x++) {
               for(int y = 0; y < b[x].length; y++) {
                  int valueb = b[i][j];
                  if (valuea == valueb) {
                  }
               }
            }
         } 
         return true; 
      } 
      return false;
   }     
         
   public static int numUnoccupied(int[][] b) {
      if(validateBoard(b) == false) {
           return -1;
      }   
      int zeros = 0;
      int length = b.length;
      for(int i= 0; i < length; i++) {
         for(int j = 0; j < b[i].length; j++){
            if(b[i][j] == 0) {
               zeros = zeros + 1;
            }
         }
      }
         return zeros;
   }
  
   public static int[] randCoord(int[][] b, int offset) {
      int zeros = numUnoccupied(b);
      if(zeros < offset) {
         int place[] = {-1,-1};
         //System.out.println("this should work");
         return place;
      }
      if(validateBoard(b) == false) {
         int place[] = {-1,-1};      
         return place;
      }        
      int zero = 0;
      for(int i = 0; i < b.length; i++) {
         for(int j = 0; j < b[i].length; j++){
            if(b[i][j] == 0) {
               if(zero == offset) {
                  int place[] = {i, j};
                  //System.out.print(i + " ");
                  //System.out.print(j);
                  return place;  
               }               
               zero = zero + 1;
            }
         }
      }
     int place[] = {-1, -1};
     //System.out.println(":(");
     return place;      
   } 
   
   public static boolean addNewValue(int[][] b) {
      if(validateBoard(b) == false) {
         return false;
      }
      
      if(numUnoccupied(b) == 0) {
         return false;
      }
   
      //printBoard(b);
      int value = Rnd2048.randValue(); //is just 2 for now
      int offset = Rnd2048.randNum(numUnoccupied(b)); //picking a random zero
      //System.out.println(value);
      //System.out.println(offset);
      //System.out.println(randCoord(b, offset));
      int[] coordinates = randCoord(b, offset);
      int x = coordinates[0];
      int y= coordinates[1];
      //System.out.println(x + "," + y);
      addValue(b, x, y, value);
      //printBoard(b);
      
      return true;
   }
   
   public static int[][] combineLeft(int[][] b) {
      if(validateBoard(b) == false) {
         int place[][] = {{-1,-1},
                        {-1,-1}};      
         return place;
      } 
      
      //printBoard(b);
      //System.out.println("");       
      int length = b.length;      
      for(int i = 0; i < length; i++) {
         OneDimensional2048.combineLeft(b[i]);
        
      }
      //printBoard(b);
      //System.out.println("");        
      //addNewValue(b);
      //printBoard(b);
      return b;
   }
   
   public static int[][] rotateLeft(int[][] b) {
      if(validateBoard(b) == false) {
         int place[][] = {{-1,-1},
                        {-1,-1}};      
         return place;
      } 
      //printBoard(b);
      //System.out.println("");
      int[][] copy = copyBoard(b);
      int length = b.length;
      int[][] rotation = new int[b[0].length][length];      
      for(int i = 0; i < length; i++) {
         for(int j = 0; j < b[i].length; j++) {
             int value = b[i].length-j-1;
             rotation[value][i] = b[i][j];
         }
      }
      //printBoard(rotation);
      return rotation;
   } 
   
   public static int[][] left(int[][] b) {
      //printBoard(combineLeft(b));
      return combineLeft(b);
   }

   public static int[][] right(int[][] b) {
      b= rotateLeft(b);
      //printBoard(b);
      //System.out.println("");
      b=rotateLeft(b);
      //printBoard(b);
      //System.out.println("");
      b=combineLeft(b);
      //printBoard(b);
      //System.out.println("");
      b=rotateLeft(b);
      //printBoard(b);
      //System.out.println("");
      b=rotateLeft(b);
      //printBoard(b);
      return b;
   }
   
   public static int[][] up(int[][] b) {
      b=rotateLeft(b);
      b=combineLeft(b);
      b=rotateLeft(b);
      b=rotateLeft(b);
      b=rotateLeft(b);
      //printBoard(b);
      //System.out.println(""); 
      return b;
   }
   
   public static int[][] down(int[][] b) {
      b=rotateLeft(b);
      b=rotateLeft(b);
      b=rotateLeft(b);  
      b=combineLeft(b);
      b=rotateLeft(b);
      //printBoard(b);
      //System.out.println("");          
      return b;
   }   
  
	public static void play2048() {
		String s = "";
		Scanner terminalInput = new Scanner(System.in);
		int[][] b = blankBoard(5,5);
		boolean ret;
		
		ret = addNewValue(b);
		assert(ret);
		while (!s.equals("q")) {
			b = makeMove(b, s.charAt(0));
			//printBoard(b);
			s = terminalInput.nextLine();
		}		
	}

	public static int[][] makeMove(int[][] b, char m) {
		if (!addNewValue(b)) {
			return b;
		}
		switch(m) {
		case 'l':
			return left(b);
		case 'r':
			return right(b);
		case 'u':
			return up(b);
		case 'd':
			return down(b);
		}
		return b;
	}
}