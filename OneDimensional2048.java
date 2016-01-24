//Elizabeth Davis HW 3

public class OneDimensional2048 {


   public static void main(String[] argv) {
   assert(!validateValue(8, 4));
   assert(validateValue(8, 8));
   assert(validateValue(0, 16));
   assert(validateValue(2, 2048));
   assert(!validateValue(7, 2048));
   assert(!validateValue(1023, 2048));
   assert(!validateValue(1025, 2048));
   
   assert(validateRow(new int[] {2, 2, 2, 2}));
   assert(validateRow(new int[] {0, 2, 4, 0, 32}));
   assert(!validateRow(new int[] {2, 2, 0, 3, 4, 0}));
   assert(validateRow(new int[] {}));
   assert(!validateRow(new int[] {8, 2, 64, 32, 30}));
   //System.out.println(validateRow(new int[] {8, 2, 64, 32, 30}));
   
   //moveLeft
   int[] row = new int[] {0,0,4,0,0};
    assert(moveLeft(row) && identicalRows(new int[] {4, 0, 0, 0, 0}, row));
   row = new int[] {0, 0, 4, 0, 0};
      assert(moveLeft(row) && !identicalRows(new int[] {4, 0, 0, 0, 0, 0}, row));
   row = new int[] {2, 0, 4, 0, 0, 16};
      moveLeft(row);
      assert(moveLeft(row) && identicalRows(new int[] {2, 4, 16, 0, 0, 0}, row));
   row = new int[] {0, 0, 0};
      assert(moveLeft(row) && identicalRows(new int[] {0, 0, 0}, row));
      assert(!moveLeft(new int[] {2, 0, 31})); 
   row = new int[] {4, 16, 2048};
      assert(moveLeft(row) && identicalRows(new int[] {4, 16, 2048}, row));
  
  //combineLeft    
   row = new int[] {8, 8, 16, 16, 32, 32};
      assert(combineLeft(row) && identicalRows(new int[] {16, 32, 64, 0, 0, 0}, row));
   row = new int[] {2, 0, 2, 8, 0, 8, 64, 0, 64, 0};
         assert(combineLeft(row) && identicalRows(new int[] {4, 16, 128, 0, 0, 0, 0, 0, 0, 0}, row));
   row = new int[] {2, 0, 8, 2, 0, 64, 4, 0, 64, 0};
      //printRow(row);
      //combineLeft(row);
      //printRow(row);
      assert(combineLeft(row) && identicalRows(new int[] {2, 8, 2, 64, 4, 64, 0, 0, 0, 0}, row));
   row = new int[] {2, 0, 8, 2, 0, 64, 4, 0, 64, 0};
      assert(combineLeft(row) && identicalRows(new int[] {2, 8, 2, 64, 4, 64, 0, 0, 0, 0}, row));
   row = new int[] {0, 0, 2, 2, 128, 64, 0, 64};
      assert(combineLeft(row) && identicalRows(new int[] {4, 128, 128, 0, 0, 0, 0, 0}, row));
   row = new int[] {0, 0, 2, 2, 128, 1234, 64, 0, 64};
      assert(!combineLeft(row));
   row = new int[] {};
      assert(moveLeft(row) && identicalRows(new int[] {}, row));
   row = new int[] {2, 0, 2, 0};
      assert(combineLeft(row) && identicalRows(new int[] {4, 0, 0, 0}, row)); 
      
   row = new int[] {2, 0, 0, 2};
      combineLeft(row);    
      //System.out.println(row[0] + " " +row[1] + " " +row[2] + " " + row[3]);
   
   row = new int[] {0, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 0, 2, 0};
      assert(combineLeft(row) && combineLeft(row) && combineLeft(row) && combineLeft(row) && combineLeft(row) && combineLeft(row) && combineLeft(row) && combineLeft(row) && combineLeft(row) && combineLeft(row) &&  
      identicalRows(new int[] {2048, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, row)); 
    
   }
   public static boolean validateValue(int value, int maxPowerOfTwo){  
      if (maxPowerOfTwo >= value) {
         int x = 1;
         if (value == 0){
            return true;
         }
         //need this to run until the end of the array not until
         //
         maxPowerOfTwo = 2048;
         for(int i = 0; i != value; i++) {
            x = x * 2;
            //System.out.println("value of x is: " + x);
            if (x == value){
            //System.out.println("value of value is: " + value);
               return true;
            }
            //we need to make this so if that is not true, we get false
         }
         return false;

      }
         
      return false;
   }
   
   public static boolean validateRow(int[] row){
      int y = 0;
      int x = row.length;
      while (y < x) {
         int a = row[y];
         int maxValue = 2048;
            if (validateValue(a, maxValue) == false) {
               //System.out.println("the problem is validateRow");
               return false;
            }
            else {
               y++;
            }
       }
       //System.out.println("it is validateValue");             
      return true;
   } 
   
   public static boolean moveLeft(int[] row){
      int length = row.length;
      if (validateRow(row) == false) {
         //System.out.println("moveLeft doesn't work");
         return false;
      }
      else{ 
      for (int i = 0; i < length - 1; i++){
         int number = row[i];
         if (number == 0){
               for(int j = i; j < length - 1; j++){
                  row[j] = row[j+1];
               }  
               row[length - 1] = 0; 
         }
         if (number != 0) {
            row[i] = number;
         }
      }   
               return true;
      }
   }
   

   public static boolean identicalRows(int[] testRow, int[] row) {
      //return true if identical
      int lengthOfTestRow = testRow.length;
      int lengthOfRow = row.length;
      int sumOfTest = 0;
      int sumOfRow = 0;
      if (lengthOfRow == lengthOfTestRow) {
         int i = 0;
         while (i < lengthOfRow) {
              int valueOfTestRow = testRow[i];
              int valueOfRow = row[i];
              
              for(i = 0; i < lengthOfRow; i++){
                  sumOfTest += testRow[i];
                  sumOfRow += row[i];
              }
              i++;
         }
            if (sumOfTest == sumOfRow){
              return true; 
            }    
      }
         return false;
   }
   
   static void printRow(int[] row)
   {
    for (int i = 0; i < row.length; i++) {
        //System.out.print(row[i] + " ");
    }
    //System.out.println("");
    }
   
   public static boolean combineLeft(int[] row){
      if (validateRow(row) != true) {
         //System.out.print("false");
         return false;
      }
      else {
         //System.out.println("true");
         moveLeft(row);
         //System.out.println(row[0] + " " + row[1] + " " + row[2] + " " + row[3]); 
         int length = row.length;
         for(int i = 0; i < length - 1; i++) {
            moveLeft(row);
            int value = row[i];
            //System.out.println(value);
            int nextValue = row[i + 1];
            //System.out.println(nextValue);
            if(value == nextValue && (value != 0)){
               row[i] = 2 * value;
               row[i + 1] = 0;
               //System.out.println(row[0] + " " + row[1] + " " + row[2] + " " + row[3]); 
               moveLeft(row);
               //System.out.println(row[0] + " " + row[1] + " " + row[2] + " " + row[3]); 
            }
         }
         moveLeft(row);
      }
      return true;   
   }
      
}   