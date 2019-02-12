public class QueenBoard {
//Instance Variables:
private int[][]board;
public int numQueens;

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
  //first checks for if the dimensions surpass the board.
  if (r >= board.length || c >= board[0].length){
    return false;
  }

  //if it's already added, what's the point of adding again??
  if (board[r][c] != 0) {
    return false;
  }

  if (board[r][c] == 0) {
    board[r][c] = -1;
    int d = 0;

    //- 1 to make sure that you don't go out of bounds.
    while (r < board.length - 1) {
      //this part increments south by one and checks and addding.
      r++;
      d++;
      board[r][c]++;

      // this part increments east by one and checks and adding.
      if (c + d <= board.length - 1){
        board[r][c + d]++;
      }

      //checks the possibility of going west and adds.
      if (c - d >= 0) {
        board[r][c-d]++;
      }
    }
    //return statments.
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
  //first checks for if the dimensions surpass the board.
  if (r >= board.length || c >= board[0].length){
    return false;
  }

  //checks if it can be removed. no conflict.
  if (board[r][c] == -1) {
    board[r][c] = 0;
    int d = 0;

    //- 1 to make sure that you don't go out of bounds.
    while (r < board.length - 1) {
      //this part increments south by one and checks and subtracting.
      r++;
      d++;
      board[r][c]--;

      // this part increments east by one and checks and substracting.
      if (c + d <= board.length - 1){
        board[r][c + d]--;
      }

      //checks the possibility of going west and subtracts.
      if (c - d >= 0) {
        board[r][c - d]--;
      }
    }

    //return statments.
    return true;
  }
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
  Strng result = "";
  for (int i = 0; i < board.length; i++) {
    String output = "";
    for (int x = 0; x < board[i].length; x++){
      if (board[i][x] < 0) {
        output += "Q ";
        //Q represents Queen.
      }
      else {
        result = "_ ";
        //_ represents a space.
      }
    }
    result += output + "\n";
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
        throw IllegalStateException();
      }
    }
  }
  return helperbool(0);
}

private int counter() {
  for (int i = 0; i < board.length; i++) {
    for (int x = 0; x < board.length; x++) {
      if (board[i][x] == -1){
        numQueens++;
      }
    }
  }
  return numQueens;
}

private boolean helperbool(int c) {
  if (c >= board.length) {
    return counter() == board.length;
  }

    for (int i = 0; i < board.length; i++) {
      if (addQueen(i, c)) {

        //a recursive call is used here because
        if (helperbool(c + 1)){
          return true;
        }

        else {
          removeQueen(i, c)
        }
      }
    }
  //return boolean
  return false;
}

/**
*@return the number of solutions found, and leaves the board filled with only 0's
*@throws IllegalStateException when the board starts with any non-zero value
*/
public int countSolutions(){
  for (int i = 0; i < board.length; i++) {
    for (int x = 0; x < board.length; x++) {
      if (board[i][x] != 0) {
        throw IllegalStateException();
      }
    }
  }
  return helperint(0);
}
