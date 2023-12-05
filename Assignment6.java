
public class Assignment6 {
    public static void main(String[] args) {
        int n = 4;
        String [][] board = new String[n][n];
        findPositions(board, 0);
    }

    static void findPositions(String[][] board,int row){
        if(row == board.length){
            displayBoard(board);
            System.out.println();
            return; 
        }
        for(int column=0;column<board[0].length;column++){
            if(isSafe(board,row,column)){
                board[row][column] = "Q";
                findPositions(board, row+1);
                board[row][column] = null;
            }
        }
    }

    static boolean isSafe(String[][] board,int row,int column){
        // vertically
        for(int i=row-1;i>=0;i--){
            if(board[i][column] == "Q") return false;
        }

        // diagonally
        int steps = Math.min(row,column);
        for(int i=1;i<=steps;i++){
            if(board[row-i][column-i] == "Q") return false;
        }

        steps = Math.min(row,board[0].length-column-1);
        for(int i=1;i<=steps;i++){
            if(board[row-i][column+i] == "Q") return false;
        }

        return true;
    }

    static void displayBoard(String[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j] == null) System.out.print(". ");
                else System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
