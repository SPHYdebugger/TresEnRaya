import java.util.*;

public class Main {
    public static void main(String[] args) {

        //variables
        Scanner key = new Scanner(System.in);
        char[][] board = new char[5][5];
        int move = 9;
        int row;
        int column;
        boolean humanWin= false;
        boolean iaWin= false;
        boolean playAgain= true;
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        //TODO Make a random order to play

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Hi human");
            System.out.println("you are the X");

            humanWin=false;
            iaWin=false;
            move=9;
            //build the board
            for (int i=0; i<5; i++){
                for (int j=0; j<5; j++){
                    board[i][j]= 'H';
                    if (i==1 || i==3){
                        board[i][j] = '-';
                    }
                    if (j==1 || j==3){
                        board[i][j]= '|';
                    }

                }
            }
            //show the board
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(" " +board[i][j] + " ");
                }
                System.out.println();
            }

            do {
                //human moves
                do {
                    System.out.println("choose row");
                    row = key.nextInt();
                    System.out.println("choose column");
                    column = key.nextInt();
                    //TODO select position with numbers
                } while (row == 1 || row == 3 || column == 1 || column == 3);
                if (board[row][column] == 'H') {
                    board[row][column] = 'X';
                    move--;
                } else {
                    System.out.println("You can't move to this position, you lost the throw");
                }

                //search winner
                for (int i = 0; i < 5; i++) {
                    if (board[i][0] == 'X' && board[i][2] == 'X' && board[i][4] == 'X') {
                        System.out.println("human WIN");
                        r1 = r2 = r3=i;
                        c1 = 0;
                        c2 = 2;
                        c3 = 4;
                        humanWin = true;
                        break;
                    }
                    if (board[0][i] == 'X' && board[2][i] == 'X' && board[4][i] == 'X') {
                        System.out.println("human WIN");
                        c1 = c2 = c3=i;
                        r1 = 0;
                        r2 = 2;
                        r3 = 4;
                        humanWin = true;
                        break;
                    }
                    if (board[0][0] == 'X' && board[2][2] == 'X' && board[4][4] == 'X') {
                        System.out.println("human WIN");
                        r1 = 0;
                        r2 = 2;
                        r3 = 4;
                        c1 = 0;
                        c2 = 2;
                        c3 = 4;
                        humanWin = true;
                        break;
                    }
                    if (board[0][4] == 'X' && board[2][2] == 'X' && board[4][0] == 'X') {
                        System.out.println("human WIN");
                        r1 = 0;
                        r2 = 2;
                        r3 = 4;
                        c1 = 4;
                        c2 = 2;
                        c3 = 0;
                        humanWin = true;
                        break;
                    }
                }

                //IA moves
                if (move != 0 && !humanWin) {
                    do {
                        row = (int) (Math.random() * (5));
                        column = (int) (Math.random() * (5));

                    } while (board[row][column] != 'H');

                    board[row][column] = 'O';
                    move--;
                }
                //search winner
                for (int i = 0; i < 5; i++) {
                    if (board[i][0] == 'O' && board[i][2] == 'O' && board[i][4] == 'O') {
                        System.out.println("IA WIN");
                        r1 = r2 = r3=i;
                        c1 = 0;
                        c2 = 2;
                        c3 = 4;
                        iaWin = true;
                        break;
                    }
                    if (board[0][i] == 'O' && board[2][i] == 'O' && board[4][i] == 'O') {
                        System.out.println("IA WIN");
                        c1 = c2 = c3=i;
                        r1 = 0;
                        r2 = 2;
                        r3 = 4;
                        iaWin = true;
                        break;
                    }
                    if (board[0][0] == 'O' && board[2][2] == 'O' && board[4][4] == 'O') {
                        System.out.println("IA WIN");
                        r1 = 0;
                        r2 = 2;
                        r3 = 4;
                        c1 = 0;
                        c2 = 2;
                        c3 = 4;
                        iaWin = true;
                        break;
                    }
                    if (board[0][4] == 'O' && board[2][2] == 'O' && board[4][0] == 'O') {
                        System.out.println("IA WIN");
                        r1 = 0;
                        r2 = 2;
                        r3 = 4;
                        c1 = 4;
                        c2 = 2;
                        c3 = 0;
                        iaWin = true;
                        break;
                    }
                }

                //show the board
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (humanWin){
                            if (i==r1 && j== c1 || i==r2 && j== c2 || i==r3 && j== c3){
                                System.out.print(" " +ANSI_GREEN + board[i][j] + " " + ANSI_RESET);
                            }else {
                                System.out.print(" "+board[i][j] + " ");
                            }
                        } else if (iaWin) {
                            if (i==r1 && j== c1 || i==r2 && j== c2 || i==r3 && j== c3){
                                System.out.print(" "+ANSI_GREEN + board[i][j] + " " + ANSI_RESET);
                            }else {
                                System.out.print(" " +board[i][j] + " ");
                            }
                        }else {
                            System.out.print(" "+board[i][j] + " ");
                        }

                    }
                    System.out.println();
                }

            } while (move != 0 && !humanWin && !iaWin);
            if (humanWin) {
                System.out.println("YOU ARE THE WINNER");
            } else if (iaWin) {
                System.out.println("THE IA IS THE WINNER");
            } else {
                System.out.println("THERE IS A TIE");
            }
            key.nextLine();
            System.out.println("Do you want play again? (S) (N)");
            String answer = key.nextLine();
            if (answer.equals("N")){
                playAgain= false;
            }
        }while (playAgain);
    }
}