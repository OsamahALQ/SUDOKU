
/** Assignment 1 - Winter 2021
  * <p>
  * Problem 3
  * <p> 
  * In this problem, you will complete three methods to check if a SUDOKU game is valid or not.
  */
import java.util.Arrays;
public class SudokuChecker{
   

  	/** checks if row 'row' is OK in the grid */	
    public static boolean checkRow(int row, byte[][] grid){
      Byte[] ordered2 = new Byte[9];
      for(int i=0; i<ordered2.length; i++){
        ordered2[i] = grid[row][i];
      }
      Arrays.sort(ordered2);
      for (int i = 0; i < 9; i++){
        if (ordered2[i] != i+1){
          return false;
        }
        }
        return true;
      
    }

  	/** checks if column 'col' is OK in the grid */
    public static boolean checkColumn(int col, byte[][] grid){
      Byte[] ordered2 = new Byte[9];
      for(int i=0; i < ordered2.length; i++){
        ordered2[i] = grid[i][col];
      }
      Arrays.sort(ordered2);
      for (int i = 0; i < 9; i++){
        if (ordered2[i] != i+1){
          return false;
        }
      }
        return true;
    }

  	/** checks if the subregion 'region' is OK in the grid */
    public static boolean checkSubregion(int region, byte[][] grid){
      //  Find the Subregion
      byte [][] sub = new byte [3][3];
      int rows = 0;
      int cols = 0;
      switch(region) {
      case 0:
        rows =0;
        cols =0;
        break;
      case 1:
        rows =3;
        cols =0;
        break;
      case 2:
      rows =6;
      cols =0;
        break;
      case 3:
      rows =0;
      cols =3;
        break;
      case 4:
      rows =3;
      cols =3;
        break;
      case 5:
      rows =6;
      cols =3;
        break;
      case 6:
      rows =0;
      cols =6;
        break;
      case 7:
      rows =3;
      cols =6;
        break;
      case 8:
      rows =6;
      cols =6;
        break;
      }
      int m = 0;
      int n = 0;
    for (int i = cols ; i < cols +3 ;i++){
      for (int j = rows ; j < rows + 3 ; j++){
        
        sub[m][n] = grid[i][j];
        n++;
      }
      m++;
      n=0;
    }

    Byte[] ordered2 = new Byte[9];
    int z = 0;
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          ordered2[z++] = sub[i][j];
      }}
      Arrays.sort(ordered2);
      for (int i = 0; i < 9; i++){
        if (ordered2[i] != i+1){
          return false;
        }
      }
     
      return true;
    }




    public static boolean check(byte[][] grid){
      // check the subregions
      for(int subregion=0; subregion<9; subregion+=1){  
        if( !checkSubregion(subregion, grid) ){
          return false;
        }
      }

      // check the rows

      for(int row=0; row<9; row+=1){                    
        if( !checkRow(row, grid) ){
          return false;
        }
            }
     // check the rows
     for(int col=0; col<9; col+=1){                    
        if( !checkColumn(col, grid) ){
          return false;
        }
      }
  		
  		// if we get this far then we conclude that the grid
  		// must be valid (because if it was not, we would have
  		// returned false somewhere above)
      return true;
    }
      


    public static void main(String[] args){

      System.out.print("exmample1 | expected output is true  | actual output is ");
      System.out.println(check(example1));

      System.out.print("exmample2 | expected output is false | actual output is ");
      System.out.println(check(example2));

    }


      /** sample valid game */
    public static byte[][] example1 = new byte[][]{
      {5,3,4,6,7,8,9,1,2},
      {6,7,2,1,9,5,3,4,8},
      {1,9,8,3,4,2,5,6,7},
      {8,5,9,7,6,1,4,2,3},
      {4,2,6,8,5,3,7,9,1},
      {7,1,3,9,2,4,8,5,6},
      {9,6,1,5,3,7,2,8,4},
      {2,8,7,4,1,9,6,3,5},
      {3,4,5,2,8,6,1,7,9}};

    /** sample invalid game */
    public static byte[][] example2 = new byte[][]{
      {5,3,4,6,7,8,9,1,2},
      {6,7,2,1,9,5,3,4,8},
      {1,9,8,3,4,2,5,6,7},
      {8,5,9,7,6,1,4,2,3},
      {4,2,6,8,5,3,7,9,1},
      {7,1,3,9,2,4,8,5,6},
      {9,6,1,5,3,7,2,8,3},
      {2,8,7,4,1,9,6,2,6},
      {3,4,5,2,8,6,1,8,8}};

  }

