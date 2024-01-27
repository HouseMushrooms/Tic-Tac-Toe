import java.util.Scanner;

public class main {
    static boolean winner = false;
    static String[][] board = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
    static Scanner sc = new Scanner(System.in);
    static int numMoves = 0;
    public static void main(String[] args) {
         printBoard();
        while(winner == false){
           performTurn("X");
            if(isTiedGame(numMoves)){
                printBoard();
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                System.out.println("It's a tie!");
                break;
            }
            if(winner == true){
                break;
            }
            clearScreen();
            printBoard();
            performTurn("O");
            if(winner == true){
                break;
            }
            clearScreen();
            printBoard();
        }
    }

    public static void performTurn(String player){
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.println("It is " + player + "'s turn");
            System.out.println("Please enter the number for the space you'd like");
            int choice = sc.nextInt();
            board = chooseSpace(choice, player); 
            numMoves++;
            winner = checkWin();
            if(winner){
                printBoard();
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                System.out.println(player + " is the winner!");
            } 
            
    }

    public static boolean isTiedGame(int numMoves){
        if(numMoves == 9 && !checkWin()){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean checkWin(){
        if(isDiaginalWin() || isHorizontalWin() || isVerticalWin()){
            return true;
        } else{
            return false;
        }
    }

    public static boolean isDiaginalWin(){
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            return true;
        } else if(board[0][2] == board[1][1] && board[0][2] == board[2][0]){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isVerticalWin(){
        if(board[0][0] == board[1][0] && board[0][0] == board[2][0]){
            return true;
        } else if(board[0][1] == board[1][1] && board[0][1] == board[2][1]){
            return true;
        } else if(board[0][2] == board[1][2] && board[0][2] == board[2][2]){
            return true;
        }else {
            return false;
        }
    }

     public static boolean isHorizontalWin(){
        if(board[0][0] == board[0][1] && board[0][0] == board[0][2]){
            return true;
        } else if(board[1][0] == board[1][1] && board[1][0] == board[1][2]){
            return true;
        } else if(board[2][0] == board[2][1] && board[2][0] == board[2][2]){
            return true;
        }else {
            return false;
        }
    }


    public static boolean checkSpace(String value){
        if (value.equals("X") || value.equals("O")){
            return false;
        }
        return true;
    }

    public static void redo(String turn){
        if(turn.equals('X')){
           System.out.println("Space is already filled!");
            performTurn("X");
        } else {
            System.out.println("Space is already filled!");
            performTurn("O");
        }
        printBoard();
    }

    public static String[][] chooseSpace(int space, String turn){
        switch (space) {
            case 1:
            if (checkSpace(board[0][0])){
                board[0][0] = turn;
            } else {
                redo(turn);
            }
                break;
            case 2:
                if (checkSpace(board[0][1])){
                board[0][1] = turn;
            } else {
                redo(turn);
            }
                break;
            case 3:
                if (checkSpace(board[0][2])){
                board[0][2] = turn;
            } else {
                redo(turn);
            }
                break;
            case 4:
                if (checkSpace(board[1][0])){
                board[1][0] = turn;
            } else {
                redo(turn);
            }
                break;
            case 5:
                if (checkSpace(board[1][1])){
                board[1][1] = turn;
            } else {
                redo(turn);
            }
                break;
            case 6:
                if (checkSpace(board[1][2])){
                board[1][2] = turn;
            } else {
                redo(turn);
            }
                break;
            case 7:
                if (checkSpace(board[2][0])){
                board[2][0] = turn;
            } else {
                redo(turn);
            }
                break;
            case 8:
                if (checkSpace(board[2][1])){
                board[2][1] = turn;
            } else {
                redo(turn);
            }
             break;
            case 9:
               if (checkSpace(board[2][2])){
                board[2][2] = turn;
            } else {
                redo(turn);
            }
                break;
            default:
                return board; 
        }
        return board;
    }
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printBoard (){
        for(int i = 0; i < board.length; i++){
            System.out.print(board[i][0] + " | ");
            System.out.print(board[i][1] + " | ");
            System.out.println(board[i][2]);
            System.out.println("__________");
        }
    }
}