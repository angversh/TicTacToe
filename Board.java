public class Board {
    public final char[] arr;

    public Board() {
        this.arr = new char[9];
        for (int x = 1; x <= 9; x++) {
            this.arr[x - 1] = ' ';
        }
    }

    public void setArr(int position, char player) {
        if (player == 'X') {
            this.arr[position-1] = 'X';
        } else {
            this.arr[position -1] = 'O';
        }
    }

    public void printBoard() {
        System.out.format("%-3c ! %-3c ! %-3c\n----+----+----\n%-3c ! %-3c ! %-3c\n----+----+----\n%-3c ! %-3c ! %-3c\n",
                this.arr[0], this.arr[1], this.arr[2], this.arr[3], this.arr[4], this.arr[5], this.arr[6], this.arr[7], this.arr[8]
        );
    }


    /**
     * @param x
     * @return the value of the char at a given position
     */
    public char getBoardValue(int x) {
        return arr[x-1];
    }


    /**
     * Go through the board and check for win (horizontal, diagonal, vertical)
     * @param player
     * @return whether a win has occurred
     */
    public boolean checkWin(char player) {
        if(this.arr[0] == player && this.arr[1] == player && this.arr[2] == player)
            return true;


        if(this.arr[3] == player && this.arr[4] == player && this.arr[5] == player)
            return true;


        if(this.arr[6] == player && this.arr[7] == player && this.arr[8] == player)
            return true;

        if(this.arr[0] == player && this.arr[4] == player && this.arr[8] == player)
            return true;

        if(this.arr[2] == player && this.arr[4] == player && this.arr[6] == player)
            return true;

        if(this.arr[0] == player && this.arr[3] == player && this.arr[6] == player)
            return true;

        if(this.arr[1] == player && this.arr[4] == player && this.arr[7] == player)
            return true;

        return this.arr[2] == player && this.arr[5] == player && this.arr[8] == player;
    }
    public boolean checkDraw() {
        if(!this.checkWin('X') && !this.checkWin('O')) {
            return this.getBoardValue(1) != ' ' && this.getBoardValue(2) != ' ' && this.getBoardValue(3) != ' ' && this.getBoardValue(4) != ' ' && this.getBoardValue(5) != ' ' && this.getBoardValue(6) != ' ' && this.getBoardValue(7) != ' ' && this.getBoardValue(8) != ' ' && this.getBoardValue(9) != ' ';
        }

        return false;
    }
    /**
     * Reset the board
     */
    public void clear() {
        for (int x = 1; x <= 9; x++) {
            this.arr[x - 1] = ' ';
        }
    }

}