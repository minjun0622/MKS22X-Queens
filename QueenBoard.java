public class QueenBoard {
//Instance Variables:
private int[][]board;
private int numQueens;

//Constructor:
//sets all the spaces in the board to 0.
public QueenBoard(int size){
  board = new int [size][size];
    for (int i = 0; i < board.length; i++) {
      for (int x = 0; x < board[i].length; x++) {
      board [i][x] = 0;
    }
  }
}

/*
Nested loops are not necessary.
You can move through the array using one loop,
(r, c) -> (r - i, c + i)
(r, c) -> (r, c + i)
(r, c) -> (r + i, c + i)
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0    r = row
0 0 0 0 0    c = column
0 0 0 0 0

*/

//Private methods (suggested):
//private to see if you can add in a queen.
//make sure you print out the queen as a mean of testing.

private boolean addQueen(int r, int c){
  if (r >= board.length || c >= board[0].length){
    return false;
  }
  if (board[r][c] != 0) {
    return false;
    //if it's already added, what's the point of adding again??
  }
  else {
    board[r][c] = -1;
    int d = 0;

    while (r < board.length - 1) {
      r++;
      d++;
      board[r][c]++;
      if (c + d <= board.length - 1){
        board[r][c + d]++;
      }
      if (c - d >= 0) {
        board[r][c-d]++;
      }
    }
    return true;
  }
  return false;
}
  /*
  0 0 0 0
  0 0 0 0
  0 0 0 0
  0 0 0 0
  ok, to traverse as a queen, board[0][0]
  north = board[r - 1][c]
  east = board[r][c + 1]
  south east = board[r + 1][c + 1]
  south = board[r + 1][c]
  west = board[r][c - 1]
  north east = board[r - 1][c + 1]
  south west = board[r + 1][c - 1]
  north west = board[r - 1][c - 1]
  */


//A private method to see if you can remove a queen.
private boolean removeQueen(int r, int c){
  if (board[r][c] != 1) {
    return false;
    //if there is no queen then how can you remove it?
  }
  for (int i = 1; i < board.length - c; i++){
    board[r][c + i]--;
    if (r - i >= 0) {
      board[r - i][c + i]--;
    }
    if (r + i < board.length) {
      board[r + i][c + i]--;
    }
  }
  board[r][c] = 0;
  return true;
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
  Strng result = "";
  for (int i = 0; i < board.length; i++) {
    result += "\n";
    for (int x = 0; x < board.length; x++){
      if (board[i][x] == 0) {
        result = 'Q';
      }
      else {
        result = "_ ";
      }
    }
  }
  return result;
}


/**
*@return false when the board is not solveable and leaves the board filled with zeros;
*        true when the board is solveable, and leaves the board in a solved state
*@throws IllegalStateException when the board starts with any non-zero value
*/
public boolean solve(){
  for (int i = 0; i < board.length; i++) {
    for (int x = 0; x < board.length; x++) {
      if (board[i][x] != 0) {
        throw IllegalStateException("no good.");
      }
    }
  }
  return helperbool(0);
}

/**
*@return the number of solutions found, and leaves the board filled with only 0's
*@throws IllegalStateException when the board starts with any non-zero value
*/
public int countSolutions(){
  for (int i = 0; i < board.length; i++) {
    for (int x = 0; x < board.length; x++) {
      if (board[i][x] != 0) {
        throw IllegalStateException("no good.");
      }
    }
  }
  return helperint(0);
}
