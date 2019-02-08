public class QueenBoard {
//Instance Variables:
private int[][]board;
private boolean threatened;

//Constructor:
//sets all the spaces in the board to 0.
public QueenBoard(int size){
  board = new board[size][size];
  for (int i = 0; i < size; i++) {
    for (int x = 0; x <board[i].length; x++) {
      board[size][size] = 0;
    }
  }
}

/*
Nested loops are not necessary.
You can move through the array using one loop,
(r, c) -> (r - i, c + i)
(r, c) -> (r, c + i)
(r, c) -> (r + i, c + i)
*/
//Private methods (suggested):
//private to see if you can add in a queen.
private boolean addQueen(int r, int c){
  if ((board[r][c] == board[r+1][c]) && board[r][c] == board[r][c+1]){
  board[r][c] += 1;
  return true;
}
else {
  return false;
}

//A private method to see if you can remove a queen.
private boolean removeQueen(int r, int c){
  if ((board[r][c] == board[r+1][c] && board[r][c] == board[r][c+1])){
    board[r][c] -= 1;
  return true;
}
else{
  return false;
}


//Public Methods:
/**
*@return The output string formatted as follows:
*All numbers that represent queens are replaced with 'Q'
*all others are displayed as underscores '_'
*There are spaces between each symbol:
*"""_ _ Q _
*Q _ _ _
*_ _ _ Q
*_ Q _ _"""
*(pythonic string notation for clarity,
*excludes the character up to the *)
*/
public String toString(){
  for (int i = 0; i < board.length; i++) {
    for (int x = 0; x < board[x].length; x++){
      if (board[i][x] == 0) {
        board [i][x] = '_';
      }
      else {
        board [i][x] = 'Q';
      }
    }
  }
}


/**
*@return false when the board is not solveable and leaves the board filled with zeros;
*        true when the board is solveable, and leaves the board in a solved state
*@throws IllegalStateException when the board starts with any non-zero value
*/
public boolean solve(){
  if (board[0][0] !== 0){
    throw IllegalStateException();
  }
  for (int i = 0; i < board.length; i++) {
    for(int x= 0; x < board[i].length; x++) {
      if (addQueen(i, x)){
        return solve();
      }
    }
  }
}

/**
*@return the number of solutions found, and leaves the board filled with only 0's
*@throws IllegalStateException when the board starts with any non-zero value
*/
public int countSolutions(){
  if (board[0][0] == 0) {
    throw IllegalStateException();
  }

}








}
