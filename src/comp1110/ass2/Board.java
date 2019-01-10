package comp1110.ass2;

public class Board {

public void a(){
    System.out.println("Board");
}


    /**
     * this method is used to record the situation( whether the point on the board covered by a piece has a hole)
     * after a piece is placed on the board, if there is a hole on the board, it will add 1 to the correspond element
     * in the array, and if not it will add two.
     * @param place
     * @param board
     */
    public static void onBoard(String place,int[] board) {
        int a = (int) place.charAt(2);
        int b = (int) 'A';
        int c = place.charAt(1) - '0';
        int point = (a - b) * 8 + c - 1;// calculate the correspond place of the array if give a placement string
        if (place.charAt(0) == 'a') {
            switch ((place.charAt(3))) {
                case '0':
                    board[point] = board[point] + 1;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 1;
                    board[point + 10] = board[point + 10] + 2;
                    break;
                case '1':
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 16] = board[point + 16] + 2;
                    board[point + 17] = board[point + 17] + 1;
                    break;
                case '2':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 10] = board[point + 10] + 1;
                    break;
                case '3':
                    board[point] = board[point] + 1;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 16] = board[point + 16] + 1;
                    break;
                case '4':
                    board[point + 2] = board[point + 2] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 10] = board[point + 10] + 1;
                    break;
                case '5':
                    board[point] = board[point] + 1;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 16] = board[point + 16] + 1;
                    board[point + 17] = board[point + 17] + 2;
                    break;
                case '6':
                    board[point] = board[point] + 1;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 1;
                    board[point + 8] = board[point + 8] + 2;
                    break;
                case '7':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 17] = board[point + 17] + 1;
                    break;
            }
        } else if (place.charAt(0) == 'b') {
            switch ((place.charAt(3))) {
                case '0':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 9] = board[point + 9] + 1;
                    board[point + 10] = board[point + 10] + 2;
                    break;
                case '1':
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 16] = board[point + 16] + 2;
                    break;
                case '2':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 10] = board[point + 10] + 2;
                    break;
                case '3':
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 9] = board[point + 9] + 1;
                    board[point + 16] = board[point + 16] + 2;
                    break;
                case '4':
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 2] = board[point + 2] + 2;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 9] = board[point + 9] + 2;
                    break;
                case '5':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 9] = board[point + 9] + 1;
                    board[point + 17] = board[point + 17] + 2;
                    break;
                case '6':
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 2;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 9] = board[point + 9] + 1;
                    break;
                case '7':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 17] = board[point + 17] + 2;
                    break;
            }


        } else if (place.charAt(0) == 'c') {
            switch ((place.charAt(3))) {
                case '0':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 2] = board[point + 2] + 2;
                    board[point + 3] = board[point + 3] + 2;
                    break;
                case '1':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 16] = board[point + 16] + 2;
                    board[point + 24] = board[point + 24] + 2;
                    break;
                case '2':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 1;
                    board[point + 3] = board[point + 3] + 2;
                    break;
                case '3':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 16] = board[point + 16] + 1;
                    board[point + 24] = board[point + 24] + 2;
                    break;
                case '4':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 2] = board[point + 2] + 2;
                    board[point + 3] = board[point + 3] + 2;
                    break;
                case '5':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 16] = board[point + 16] + 2;
                    board[point + 24] = board[point + 24] + 2;
                    break;
                case '6':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 1;
                    board[point + 3] = board[point + 3] + 2;
                    break;
                case '7':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 16] = board[point + 16] + 1;
                    board[point + 24] = board[point + 24] + 2;
                    break;
            }


        } else if (place.charAt(0) == 'd') {
            switch ((place.charAt(3))) {
                case '0':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 2;
                    board[point + 9] = board[point + 9] + 1;
                    board[point + 10] = board[point + 10] + 1;
                    break;
                case '1':
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 16] = board[point + 16] + 1;
                    board[point + 17] = board[point + 17] + 2;
                    break;
                case '2':
                    board[point] = board[point] + 1;
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 10] = board[point + 10] + 2;
                    board[point + 9] = board[point + 9] + 2;
                    break;
                case '3':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 16] = board[point + 16] + 2;
                    board[point + 9] = board[point + 9] + 1;
                    board[point + 1] = board[point + 1] + 1;
                    break;
                case '4':
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 2] = board[point + 2] + 1;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 10] = board[point + 10] + 2;
                    board[point + 9] = board[point + 9] + 2;
                    break;
                case '5':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 16] = board[point + 16] + 2;
                    board[point + 9] = board[point + 9] + 1;
                    board[point + 17] = board[point + 17] + 1;
                    break;
                case '6':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 1;
                    break;
                case '7':
                    board[point] = board[point] + 1;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 17] = board[point + 17] + 2;
                    break;
            }
        } else if (place.charAt(0) == 'e') {
            switch ((place.charAt(3))) {
                case '0':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 9] = board[point + 9] + 1;
                    break;
                case '1':
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 1;
                    break;
                case '2':
                    board[point] = board[point] + 1;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    break;
                case '3':
                    board[point] = board[point] + 1;
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 8] = board[point + 8] + 2;
                    break;
                case '4':
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 9] = board[point + 9] + 1;
                    break;
                case '5':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 1;
                    break;
                case '6':
                    board[point] = board[point] + 1;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    break;
                case '7':
                    board[point] = board[point] + 1;
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    break;
            }
        } else if (place.charAt(0) == 'f') {
            switch ((place.charAt(3))) {
                case '0':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 1;
                    board[point + 9] = board[point + 9] + 1;
                    break;
                case '1':
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 17] = board[point + 17] + 1;
                    break;
                case '2':
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 10] = board[point + 10] + 2;
                    break;
                case '3':
                    board[point] = board[point] + 1;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 16] = board[point + 16] + 2;
                    board[point + 9] = board[point + 9] + 1;
                    break;
                case '4':
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 10] = board[point + 10] + 1;
                    break;
                case '5':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 16] = board[point + 16] + 1;
                    board[point + 9] = board[point + 9] + 1;
                    break;
                case '6':
                    board[point] = board[point] + 1;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 2;
                    board[point + 9] = board[point + 9] + 1;
                    break;
                case '7':
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 17] = board[point + 17] + 2;
                    break;
            }


        } else if (place.charAt(0) == 'g') {
            switch ((place.charAt(3))) {
                case '0':
                    board[point] = board[point] + 1;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 10] = board[point + 10] + 2;
                    board[point + 17] = board[point + 17] + 1;
                    break;
                case '1':
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 2] = board[point + 2] + 1;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 17] = board[point + 17] + 2;
                    break;
                case '2':
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 10] = board[point + 10] + 1;
                    board[point + 18] = board[point + 18] + 1;
                    break;
                case '3':
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 10] = board[point + 10] + 1;
                    board[point + 16] = board[point + 16] + 1;
                    board[point + 17] = board[point + 17] + 1;
                    break;
                case '4':
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 10] = board[point + 10] + 2;
                    board[point + 16] = board[point + 16] + 1;
                    break;
                case '5':
                    board[point] = board[point] + 1;
                    board[point + 1] = board[point + 1] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 10] = board[point + 10] + 1;
                    board[point + 17] = board[point + 17] + 1;
                    break;
                case '6':
                    board[point + 2] = board[point + 2] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 10] = board[point + 10] + 1;
                    board[point + 17] = board[point + 17] + 1;
                    break;
                case '7':
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 8] = board[point + 8] + 1;
                    board[point + 9] = board[point + 9] + 2;
                    board[point + 17] = board[point + 17] + 1;
                    board[point + 18] = board[point + 18] + 1;
                    break;
            }
        } else if (place.charAt(0) == 'h') {
            switch ((place.charAt(3))) {
                case '0':
                    board[point] = board[point] + 1;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 2;
                    break;
                case '1':
                    board[point] = board[point] + 1;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 16] = board[point + 16] + 2;
                    break;
                case '2':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 1;
                    break;
                case '3':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 16] = board[point + 16] + 1;
                    break;
                case '4':
                    board[point] = board[point] + 1;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 2;
                    break;
                case '5':
                    board[point] = board[point] + 1;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 16] = board[point + 16] + 2;
                    break;
                case '6':
                    board[point] = board[point] + 2;
                    board[point + 1] = board[point + 1] + 2;
                    board[point + 2] = board[point + 2] + 1;
                    break;
                case '7':
                    board[point] = board[point] + 2;
                    board[point + 8] = board[point + 8] + 2;
                    board[point + 16] = board[point + 16] + 1;
                    break;
            }
        } else if (place.charAt(0) > 'h') {
            board[point] = board[point] + 1;
        }
    }


    /**
     * this method is used to record the color and if the point on the board is covered by a pieces
     * boardState is a binary array which each element is a int array with two int(this first int represent
     * whether is covered by a piece and the second int represent the color of the piece), I take red for 1, green
     * for 2, yellow for 3 and blue for 4.
     * @param place
     * @param boardState
     */
    public static void boardState(String place,int[][] boardState) {
        int a = (int) place.charAt(2);
        int b = (int) 'A';
        int c = place.charAt(1) - '0';
        int point = (a - b) * 8 + c - 1;// calculate the correspond place of the array if give a placement string
            if (place.charAt(0) == 'a') {
                switch ((place.charAt(3))) {
                    case '0':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point][1] = boardState[point][1] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 1;
                        boardState[point + 2][1] = boardState[point + 2][1] + 1;
                        boardState[point + 10][1] = boardState[point + 10][1] + 1;

                        break;
                    case '1':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 1;
                        boardState[point + 9][1] = boardState[point + 9][1] + 1;
                        boardState[point + 16][1] = boardState[point + 16][1] + 1;
                        boardState[point + 17][1] = boardState[point + 17][1] + 1;
                        break;
                    case '2':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point + 0][1] = boardState[point + 0][1] + 1;
                        boardState[point + 8][1] = boardState[point + 8][1] + 1;
                        boardState[point + 9][1] = boardState[point + 9][1] + 1;
                        boardState[point + 10][1] = boardState[point + 10][1] + 1;

                        break;
                    case '3':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point][1] = boardState[point][1] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 1;
                        boardState[point + 8][1] = boardState[point + 8][1] + 1;
                        boardState[point + 16][1] = boardState[point + 16][1] + 1;

                        break;
                    case '4':
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point + 2][1] = boardState[point + 2][1] + 1;
                        boardState[point + 8][1] = boardState[point + 8][1] + 1;
                        boardState[point + 9][1] = boardState[point + 9][1] + 1;
                        boardState[point + 10][1] = boardState[point + 10][1] + 1;

                        break;
                    case '5':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point][1] = boardState[point][1] + 1;
                        boardState[point + 8][1] = boardState[point + 8][1] + 1;
                        boardState[point + 16][1] = boardState[point + 16][1] + 1;
                        boardState[point + 17][1] = boardState[point + 17][1] + 1;

                        break;
                    case '6':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point][1] = boardState[point][1] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 1;
                        boardState[point + 2][1] = boardState[point + 2][1] + 1;
                        boardState[point + 8][1] = boardState[point + 8][1] + 1;

                        break;
                    case '7':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point][1] = boardState[point][1] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 1;
                        boardState[point + 9][1] = boardState[point + 9][1] + 1;
                        boardState[point + 17][1] = boardState[point + 17][1] + 1;
                        break;
                }

            } else if (place.charAt(0) == 'b') {
                switch ((place.charAt(3))) {
                    case '0':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point][1] = boardState[point][1] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 1;
                        boardState[point + 9][1] = boardState[point + 9][1] + 1;
                        boardState[point + 10][1] = boardState[point + 10][1] + 1;

                        break;
                    case '1':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 1;
                        boardState[point + 8][1] = boardState[point + 8][1] + 1;
                        boardState[point + 9][1] = boardState[point + 9][1] + 1;
                        boardState[point + 16][1] = boardState[point + 16][1] + 1;

                        break;
                    case '2':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point][1] = boardState[point][1] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 1;
                        boardState[point + 9][1] = boardState[point + 9][1] + 1;
                        boardState[point + 10][1] = boardState[point + 10][1] + 1;

                        break;
                    case '3':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 1;
                        boardState[point + 8][1] = boardState[point + 8][1] + 1;
                        boardState[point + 9][1] = boardState[point + 9][1] + 1;
                        boardState[point + 16][1] = boardState[point + 16][1] + 1;

                        break;
                    case '4':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 1;
                        boardState[point + 2][1] = boardState[point + 2][1] + 1;
                        boardState[point + 8][1] = boardState[point + 8][1] + 1;
                        boardState[point + 9][1] = boardState[point + 9][1] + 1;

                        break;
                    case '5':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point][1] = boardState[point][1] + 1;
                        boardState[point + 8][1] = boardState[point + 8][1] + 1;
                        boardState[point + 9][1] = boardState[point + 9][1] + 1;
                        boardState[point + 17][1] = boardState[point + 17][1] + 1;

                        break;
                    case '6':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 1;
                        boardState[point + 2][1] = boardState[point + 2][1] + 1;
                        boardState[point + 8][1] = boardState[point + 8][1] + 1;
                        boardState[point + 9][1] = boardState[point + 9][1] + 1;

                        break;
                    case '7':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point][1] = boardState[point][1] + 1;
                        boardState[point + 8][1] = boardState[point + 8][1] + 1;
                        boardState[point + 9][1] = boardState[point + 9][1] + 1;
                        boardState[point + 17][1] = boardState[point + 17][1] + 1;
                        break;
                }


            } else if (place.charAt(0) == 'c') {
                switch ((place.charAt(3))) {
                    case '0':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 3][0] = boardState[point + 3][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 1][1] = boardState[point + 1][1] + 2;
                        boardState[point + 2][1] = boardState[point + 2][1] + 2;
                        boardState[point + 3][1] = boardState[point + 3][1] + 2;

                        break;
                    case '1':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 24][0] = boardState[point + 24][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 8][1] = boardState[point + 8][1] + 2;
                        boardState[point + 16][1] = boardState[point + 16][1] + 2;
                        boardState[point + 24][1] = boardState[point + 24][1] + 2;
                        break;
                    case '2':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 3][0] = boardState[point + 3][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 1][1] = boardState[point + 1][1] + 2;
                        boardState[point + 2][1] = boardState[point + 2][1] + 2;
                        boardState[point + 3][1] = boardState[point + 3][1] + 2;
                        break;
                    case '3':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 24][0] = boardState[point + 24][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 8][1] = boardState[point + 8][1] + 2;
                        boardState[point + 16][1] = boardState[point + 16][1] + 2;
                        boardState[point + 24][1] = boardState[point + 24][1] + 2;

                        break;
                    case '4':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 3][0] = boardState[point + 3][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 1][1] = boardState[point + 1][1] + 2;
                        boardState[point + 2][1] = boardState[point + 2][1] + 2;
                        boardState[point + 3][1] = boardState[point + 3][1] + 2;
                        break;
                    case '5':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 24][0] = boardState[point + 24][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 8][1] = boardState[point + 8][1] + 2;
                        boardState[point + 16][1] = boardState[point + 16][1] + 2;
                        boardState[point + 24][1] = boardState[point + 24][1] + 2;

                        break;
                    case '6':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 3][0] = boardState[point + 3][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 1][1] = boardState[point + 1][1] + 2;
                        boardState[point + 2][1] = boardState[point + 2][1] + 2;
                        boardState[point + 3][1] = boardState[point + 3][1] + 2;
                        break;
                    case '7':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 24][0] = boardState[point + 24][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 8][1] = boardState[point + 8][1] + 2;
                        boardState[point + 16][1] = boardState[point + 16][1] + 2;
                        boardState[point + 24][1] = boardState[point + 24][1] + 2;
                        break;
                }


            } else if (place.charAt(0) == 'd') {
                switch ((place.charAt(3))) {
                    case '0':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 1][1] = boardState[point + 1][1] + 2;
                        boardState[point + 2][1] = boardState[point + 2][1] + 2;
                        boardState[point + 9][1] = boardState[point + 9][1] + 2;
                        boardState[point + 10][1] = boardState[point + 10][1] + 2;

                        break;
                    case '1':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 2;
                        boardState[point + 8][1] = boardState[point + 8][1] + 2;
                        boardState[point + 9][1] = boardState[point + 9][1] + 2;
                        boardState[point + 16][1] = boardState[point + 16][1] + 2;
                        boardState[point + 17][1] = boardState[point + 17][1] + 2;

                        break;
                    case '2':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 1][1] = boardState[point + 1][1] + 2;
                        boardState[point + 8][1] = boardState[point + 8][1] + 2;
                        boardState[point + 10][1] = boardState[point + 10][1] + 2;
                        boardState[point + 9][1] = boardState[point + 9][1] + 2;

                        break;
                    case '3':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 8][1] = boardState[point + 8][1] + 2;
                        boardState[point + 16][1] = boardState[point + 16][1] + 2;
                        boardState[point + 9][1] = boardState[point + 9][1] + 2;
                        boardState[point + 1][1] = boardState[point + 1][1] + 2;

                        break;
                    case '4':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 2;
                        boardState[point + 2][1] = boardState[point + 2][1] + 2;
                        boardState[point + 8][1] = boardState[point + 8][1] + 2;
                        boardState[point + 10][1] = boardState[point + 10][1] + 2;
                        boardState[point + 9][1] = boardState[point + 9][1] + 2;

                        break;
                    case '5':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 8][1] = boardState[point + 8][1] + 2;
                        boardState[point + 16][1] = boardState[point + 16][1] + 2;
                        boardState[point + 9][1] = boardState[point + 9][1] + 2;
                        boardState[point + 17][1] = boardState[point + 17][1] + 2;

                        break;
                    case '6':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 1][1] = boardState[point + 1][1] + 2;
                        boardState[point + 2][1] = boardState[point + 2][1] + 2;
                        boardState[point + 8][1] = boardState[point + 8][1] + 2;
                        boardState[point + 9][1] = boardState[point + 9][1] + 2;

                        break;
                    case '7':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point][1] = boardState[point][1] + 2;
                        boardState[point + 8][1] = boardState[point + 8][1] + 2;
                        boardState[point + 1][1] = boardState[point + 1][1] + 2;
                        boardState[point + 9][1] = boardState[point + 9][1] + 2;
                        boardState[point + 17][1] = boardState[point + 17][1] + 2;

                        break;
                }
            } else if (place.charAt(0) == 'e') {
                switch ((place.charAt(3))) {
                    case '0':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point][1] = boardState[point][1] + 3;
                        boardState[point + 1][1] = boardState[point + 1][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;

                        break;
                    case '1':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 3;
                        boardState[point + 8][1] = boardState[point + 8][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;

                        break;
                    case '2':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point][1] = boardState[point][1] + 3;
                        boardState[point + 8][1] = boardState[point + 8][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;

                        break;
                    case '3':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point][1] = boardState[point][1] + 3;
                        boardState[point + 1][1] = boardState[point + 1][1] + 3;
                        boardState[point + 8][1] = boardState[point + 8][1] + 3;

                        break;
                    case '4':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 3;
                        boardState[point + 8][1] = boardState[point + 8][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;

                        break;
                    case '5':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point][1] = boardState[point][1] + 3;
                        boardState[point + 8][1] = boardState[point + 8][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;

                        break;
                    case '6':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point][1] = boardState[point][1] + 3;
                        boardState[point + 1][1] = boardState[point + 1][1] + 3;
                        boardState[point + 8][1] = boardState[point + 8][1] + 3;

                        break;
                    case '7':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point][1] = boardState[point][1] + 3;
                        boardState[point + 1][1] = boardState[point + 1][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;

                        break;
                }
            } else if (place.charAt(0) == 'f') {
                switch ((place.charAt(3))) {
                    case '0':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point][1] = boardState[point][1] + 3;
                        boardState[point + 1][1] = boardState[point + 1][1] + 3;
                        boardState[point + 2][1] = boardState[point + 2][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;

                        break;
                    case '1':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 3;
                        boardState[point + 8][1] = boardState[point + 8][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;
                        boardState[point + 17][1] = boardState[point + 17][1] + 3;

                        break;
                    case '2':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 3;
                        boardState[point + 8][1] = boardState[point + 8][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;
                        boardState[point + 10][1] = boardState[point + 10][1] + 3;

                        break;
                    case '3':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point][1] = boardState[point][1] + 3;
                        boardState[point + 8][1] = boardState[point + 8][1] + 3;
                        boardState[point + 16][1] = boardState[point + 16][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;

                        break;
                    case '4':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 3;
                        boardState[point + 8][1] = boardState[point + 8][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;
                        boardState[point + 10][1] = boardState[point + 10][1] + 3;

                        break;
                    case '5':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point][1] = boardState[point][1] + 3;
                        boardState[point + 8][1] = boardState[point + 8][1] + 3;
                        boardState[point + 16][1] = boardState[point + 16][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;

                        break;
                    case '6':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point][1] = boardState[point][1] + 3;
                        boardState[point + 1][1] = boardState[point + 1][1] + 3;
                        boardState[point + 2][1] = boardState[point + 2][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;

                        break;
                    case '7':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 3;
                        boardState[point + 8][1] = boardState[point + 8][1] + 3;
                        boardState[point + 9][1] = boardState[point + 9][1] + 3;
                        boardState[point + 17][1] = boardState[point + 17][1] + 3;
                        break;
                }


            } else if (place.charAt(0) == 'g') {
                switch ((place.charAt(3))) {
                    case '0':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point][1] = boardState[point][1] + 4;
                        boardState[point + 8][1] = boardState[point + 8][1] + 4;
                        boardState[point + 9][1] = boardState[point + 9][1] + 4;
                        boardState[point + 10][1] = boardState[point + 10][1] + 4;
                        boardState[point + 17][1] = boardState[point + 17][1] + 4;

                        break;
                    case '1':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 4;
                        boardState[point + 2][1] = boardState[point + 2][1] + 4;
                        boardState[point + 8][1] = boardState[point + 8][1] + 4;
                        boardState[point + 9][1] = boardState[point + 9][1] + 4;
                        boardState[point + 17][1] = boardState[point + 17][1] + 4;

                        break;
                    case '2':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point + 18][0] = boardState[point + 18][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 4;
                        boardState[point + 8][1] = boardState[point + 8][1] + 4;
                        boardState[point + 9][1] = boardState[point + 9][1] + 4;
                        boardState[point + 10][1] = boardState[point + 10][1] + 4;
                        boardState[point + 18][1] = boardState[point + 18][1] + 4;

                        break;
                    case '3':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 4;
                        boardState[point + 9][1] = boardState[point + 9][1] + 4;
                        boardState[point + 10][1] = boardState[point + 10][1] + 4;
                        boardState[point + 16][1] = boardState[point + 16][1] + 4;
                        boardState[point + 17][1] = boardState[point + 17][1] + 4;

                        break;
                    case '4':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 4;
                        boardState[point + 8][1] = boardState[point + 8][1] + 4;
                        boardState[point + 9][1] = boardState[point + 9][1] + 4;
                        boardState[point + 10][1] = boardState[point + 10][1] + 4;
                        boardState[point + 16][1] = boardState[point + 16][1] + 4;

                        break;
                    case '5':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point][1] = boardState[point][1] + 4;
                        boardState[point + 1][1] = boardState[point + 1][1] + 4;
                        boardState[point + 9][1] = boardState[point + 9][1] + 4;
                        boardState[point + 10][1] = boardState[point + 10][1] + 4;
                        boardState[point + 17][1] = boardState[point + 17][1] + 4;

                        break;
                    case '6':
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 10][0] = boardState[point + 10][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point + 2][1] = boardState[point + 2][1] + 4;
                        boardState[point + 8][1] = boardState[point + 8][1] + 4;
                        boardState[point + 9][1] = boardState[point + 9][1] + 4;
                        boardState[point + 10][1] = boardState[point + 10][1] + 4;
                        boardState[point + 17][1] = boardState[point + 17][1] + 4;

                        break;
                    case '7':
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 9][0] = boardState[point + 9][0] + 1;
                        boardState[point + 17][0] = boardState[point + 17][0] + 1;
                        boardState[point + 18][0] = boardState[point + 18][0] + 1;
                        boardState[point + 1][1] = boardState[point + 1][1] + 4;
                        boardState[point + 8][1] = boardState[point + 8][1] + 4;
                        boardState[point + 9][1] = boardState[point + 9][1] + 4;
                        boardState[point + 17][1] = boardState[point + 17][1] + 4;
                        boardState[point + 18][1] = boardState[point + 18][1] + 4;

                        break;
                }
            } else if (place.charAt(0) == 'h') {
                switch ((place.charAt(3))) {
                    case '0':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point][1] = boardState[point][1] + 4;
                        boardState[point + 1][1] = boardState[point + 1][1] + 4;
                        boardState[point + 2][1] = boardState[point + 2][1] + 4;

                        break;
                    case '1':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point][1] = boardState[point][1] + 4;
                        boardState[point + 8][1] = boardState[point + 8][1] + 4;
                        boardState[point + 16][1] = boardState[point + 16][1] + 4;

                        break;
                    case '2':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point][1] = boardState[point][1] + 4;
                        boardState[point + 1][1] = boardState[point + 1][1] + 4;
                        boardState[point + 2][1] = boardState[point + 2][1] + 4;

                        break;
                    case '3':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point][1] = boardState[point][1] + 4;
                        boardState[point + 8][1] = boardState[point + 8][1] + 4;
                        boardState[point + 16][1] = boardState[point + 16][1] + 4;

                        break;
                    case '4':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point][1] = boardState[point][1] + 4;
                        boardState[point + 1][1] = boardState[point + 1][1] + 4;
                        boardState[point + 2][1] = boardState[point + 2][1] + 4;

                        break;
                    case '5':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point][1] = boardState[point][1] + 4;
                        boardState[point + 8][1] = boardState[point + 8][1] + 4;
                        boardState[point + 16][1] = boardState[point + 16][1] + 4;

                        break;
                    case '6':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 1][0] = boardState[point + 1][0] + 1;
                        boardState[point + 2][0] = boardState[point + 2][0] + 1;
                        boardState[point][1] = boardState[point][1] + 4;
                        boardState[point + 1][1] = boardState[point + 1][1] + 4;
                        boardState[point + 2][1] = boardState[point + 2][1] + 4;
                        break;
                    case '7':
                        boardState[point][0] = boardState[point][0] + 1;
                        boardState[point + 8][0] = boardState[point + 8][0] + 1;
                        boardState[point + 16][0] = boardState[point + 16][0] + 1;
                        boardState[point][1] = boardState[point][1] + 4;
                        boardState[point + 8][1] = boardState[point + 8][1] + 4;
                        boardState[point + 16][1] = boardState[point + 16][1] + 4;

                        break;
                }


            }
        }

}