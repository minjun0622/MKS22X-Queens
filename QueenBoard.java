public class QueenBoard {
//Instance Variables:
private int[][] board;

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
  if (board[r][c] != 0){
    return false;
  }

    for (int i = 1; i < board.length - c; i++) {
      board[r][c + i]++;

      if (r - i >= 0)
        board[r - i][c + i]++;


      if (r + i < board.length)
        board[r + i][c + i]++;

    }

      board[r][c] = -1;
      return true;
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
  if (board[r][c] != -1){
    return false;
  }

    for (int i = 1; i < board.length - c; i++) {
      board[r][c + i]--;

      if (r - i >= 0)
        board[r - i][c + i]--;


      if (r + i < board.length)
        board[r + i][c + i]--;

    }

      board[r][c] = 0;
      return true;
    }

  //Public Methods:
  public String toString() {
    String result = "";
    for (int i = 0; i < board.length; i++) {
      result += "\n";
      for (int x = 0; x < board[i].length; x++) {
        if (board[i][x] != -1) {
          result += "_ ";
        }
        else {
          result += "Q ";
        }
      }
    }
    return result;
  }

  private int countQ() {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int x = 0; x < board.length; x++) {
        if (board[i][x] == -1) {
          count++;
        }
      }
    }
    return count;
  }

  public boolean helperbool(int c) {
    if (c >= board.length) {
      return countQ() == board.length;
    }
    else {
      for (int i = 0; i < board.length; i++) {
        if (addQueen(i, c)) {
          if (helperbool(c + 1)) {
            return true;
          }
          else {
            removeQueen(i, c);
          }
        }
      }
    }
    return false;
  }

  public boolean solve() {
    for (int i = 0; i < board.length; i++) {
      for (int x = 0; x < board.length; x++) {
        if (board[i][x] != 0) {
          throw new IllegalStateException("Not a clear board");
        }
      }
    }
    return helperbool(0);
  }

  public int countSolutions() {
    for (int i = 0; i < board.length; i++) {
      for (int x = 0; x < board.length; x++) {
        if (board[i][x] != 0) {
          throw new IllegalStateException("Not a clear board");
        }
      }
    }
    return helperint(0);
  }

  public int helperint(int c) {
    if (c == board.length) {
      return 1;
    }

    int count = 0;
    for (int i = 0; i < board.length; i++) {
      if (addQueen(i, c)) {
        count += helperint(c + 1);
        removeQueen(i, c);
      }
    }
    return count;
  }
}
