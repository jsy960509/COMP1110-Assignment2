package comp1110.ass2;

public enum Pegs {
    i,j,k,l;

    private Color color;
    private String position = "";
    private int used = 0;

    /**
     * this constructor is used to assign a color to the called pegs
     * @param
     */
    Pegs(){
       switch (this){
           case i: this.color=Color.RED;
           break;
           case j: this.color=Color.GREEN;
           break;
           case k: this.color=Color.YELLOW;
           break;
           default:this.color=Color.BLUE;
           break;
       }
    }

    /**
     * thie method is used to put the pegs on the board
     * @param position
     */
    public void putOn(String position){
        if(this.overUsed()) {
            this.position += position;
            used += 1;
        }
    }


    /**
     * this method is used to judge whether a peg is over used
     * @return
     */
    private boolean overUsed(){
        if (this.equals(i)){
            if (this.used<1){
                return true;
            }
        }else if(this.used < 2){
            return true;
        }
        return  false;
    }

}
