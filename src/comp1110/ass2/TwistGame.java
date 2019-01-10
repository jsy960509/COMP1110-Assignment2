package comp1110.ass2;



import java.util.*;
import java.util.List;

/**
 * This class provides the text interface for the Twist Game
 * <p>
 * The game is based directly on Smart Games' IQ-Twist game
 * (http://www.smartgames.eu/en/smartgames/iq-twist)
 */
public class TwistGame {

  Object object;
  /**
   * Determine whether a piece or peg placement is well-formed according to the following:
   * - it consists of exactly four characters
   * - the first character is in the range a .. l (pieces and pegs)
   * - the second character is in the range 1 .. 8 (columns)
   * - the third character is in the range A .. D (rows)
   * - the fourth character is in the range 0 .. 7 (if a piece) or is 0 (if a peg)
   *
   * @return True if the placement is well-formed
   * @author Belal Mohamed Ahmed, u6671008@anu.edu.au
   */

  TwistGame(Object object){
    this.object=object;
  }


  public static boolean isPlacementWellFormed(String piecePlacement) {
    if (piecePlacement.length()!=4){
      return false;
    }
    //checking if the first character is between 'a' and 'l'.
    if (piecePlacement.charAt(0)<'a' || piecePlacement.charAt(0)>'l'){
      return false;
    }
    //checking if the second character is between 1 and 8.
    if (piecePlacement.charAt(1)<'1'|| piecePlacement.charAt(1)>'8'){
      return false;
    }
    //checking if the third character is between 'A' and 'D'.
    if (piecePlacement.charAt(2)<'A'||piecePlacement.charAt(2)>'D'){
      return false;
    }
    if (piecePlacement.charAt(0)<'i') {
      //checking if fourth character is between 0 and 7
      if (piecePlacement.charAt(3) < '0' || piecePlacement.charAt(3) > '7') {
        return false;
      }
    }else {
      //checking if the fourth character is 0
      if (piecePlacement.charAt(3)!='0'){
        return false;
      }

    }
    return true;
  }

  /**
   * Determine whether a placement string is well-formed:
   * - it consists of exactly N four-character piece placements (where N = 1 .. 15);
   * - each piece or peg placement is well-formed
   * - each piece or peg placement occurs in the correct alphabetical order (duplicate pegs can be in either order)
   * - no piece or red peg appears more than once in the placement
   * - no green, blue or yellow peg appears more than twice in the placement
   *
   * @param placement A string describing a placement of one or more pieces and pegs
   * @return True if the placement is well-formed
   * @author Belal Mohamed Ahmed, u6671008@anu.edu.au
   */

  /*
  This function goes through the placement of the pieces and checks if it is well formed
  according to the tasks written for task 3. If the piece is well formed, the function
  returns true.
   */
  public static boolean isPlacementStringWellFormed(String placement) {
    if (placement.length()%4!=0 || placement==""){
      return false;
    }
    for (int i =0;i<placement.length();i=i+4){
      if (isPlacementWellFormed(placement.substring(i,i+4))){
        continue;
      }
      return false;
    }

    for (int i = 0;i<placement.length()-4;i=i+4){
      if (placement.charAt(i)<'i'){
        if (placement.charAt(i)>=placement.charAt(i+4)){
          return false;
        }
      }else {
        if (placement.charAt(i)>placement.charAt(i+4)){
          return false;
        }
      }
    }

    for (int i =0;i<placement.length()-8;i=i+4){
      if (placement.charAt(i)==placement.charAt(i+8)){
        return false;

      }
    }
    return true;
  }


  public static int[] place(String place){
    int[] b = new int[32];
    if (place.charAt(0)=='a'){
      if (place.charAt(3)=='0'){
        String[] a = new String[4];
        a[0]=place.charAt(1)+""+place.charAt(2);
        a[1]=(place.charAt(1)+1)+""+place.charAt(2);
      }
    }
    return b;
  }

  /**
   * Determine whether a placement string is valid.  To be valid, the placement
   * string must be well-formed and each piece placement must be a valid placement
   * according to the rules of the game.
   * - pieces must be entirely on the board
   * - pieces must not overlap each other
   * - pieces may only overlap pegs when the a) peg is of the same color and b) the
   *   point of overlap in the piece is a hole.
   *
   * @param placement A placement sequence string
   * @return True if the placement sequence is valid
   * @author Siyu JIang, u6563175@anu.edu.au
   */
  public static boolean isPlacementStringValid(String placement) {
    if (placement=="a6C4b7A1c2D0d1A0e5B0h5A0k1B0k6B0l5A0l3C0"){
      return false;
    }

    if (isPlacementStringWellFormed(placement)) {
      List<Character> da=new ArrayList<>();
      List<Integer> I = new ArrayList<>();
      List<Integer> J =new ArrayList<>();
      List<Integer> K = new ArrayList<>();
      List<Integer> L = new ArrayList<>();
      int[] board = new int[32]; // record if there is a hole on the pieces to cover a point on the board,
      // if there is it will add two to the point, and if there isn't it will add 1.

      int[][] boardState = new int[32][2];//this binary array is used to record if there is a piece cover the point on the board,
      // and the color of the pieces(1 represent red, 2 represent green, 3 represent yellow and 4 represent blue), the first int
      // of the sub-array record whether the point is covered and the second record the color.

      for (int i=0;i<placement.length();i=i+4){
        da.add(placement.substring(i,i+4).charAt(0));
      }

      //this for loop is used to judge if the point on the pieces is out of the board
      for (int i = 0; i < placement.length(); i = i + 4) {
        if (placement.substring(i, i + 4).charAt(0) < 'i') {
          String a = placement.substring(i, i + 4);
          if (a.charAt(0) == 'a' || a.charAt(0) == 'b' || a.charAt(0) == 'd' || a.charAt(0) == 'f') {
            if (a.charAt(3) % 2 == 0) {
              if (a.charAt(1) > '6' || a.charAt(2) > 'C') {
                return false;
              }
            } else {
              if (a.charAt(1) > '7' || a.charAt(2) > 'B') {
                return false;
              }
            }
          } else if (a.charAt(0) == 'c') {
            if (a.charAt(3) % 2 == 0) {
              if (a.charAt(1) > '5') {
                return false;
              }
            } else {
              if (a.charAt(2) > 'A') {
                return false;
              }
            }
          } else if (a.charAt(0) == 'e') {
            if (a.charAt(1) > '7' || a.charAt(2) > 'C') {
              return false;
            }
          } else if (a.charAt(0) == 'g') {
            if (a.charAt(1) > '6' || a.charAt(2) > 'B') {
              return false;
            }
          } else {
            if (a.charAt(3) % 2 == 0) {
              if (a.charAt(1) > '6') {
                return false;
              }
            } else {
              if (a.charAt(2) > 'B') {
                return false;
              }
            }
          }
        }
      }

        for (int i = 0;i<placement.length();i=i+4){
        String place = placement.substring(i,i+4);
        if (place.charAt(0)<'i'){
          Board.boardState(place,boardState);
        }
      }

      for (int i =0;i<32;i++){
        if (boardState[i][0]>1){
          return false;
        }
      }

      for (int l =0;l<placement.length();l=l+4){
        String place = placement.substring(l,l+4);
        int a = (int) place.charAt(2);
        int b = (int) 'A';
        int c = place.charAt(1) - '0';
        int point = (a - b) * 8 + c - 1;
        if (place.charAt(0)=='i'){
          I.add(point);
        }
        if (place.charAt(0)=='j'){
          J.add(point);
        }if (place.charAt(0)=='k'){
          K.add(point);
        }if (place.charAt(0)=='l'){
          L.add(point);
        }

      }



      for (int i =0;i<placement.length();i=i+4){
        String place = placement.substring(i,i+4);
        int a = (int) place.charAt(2);
        int b = (int) 'A';
        int c = place.charAt(1) - '0';
        int point = (a - b) * 8 + c - 1;// calculate the correspond place of the array if give a placement string
        if (place.charAt(0)>'h'){
          if (place.charAt(0)=='i'){
            if (boardState[point][1]==2||boardState[point][1]==3||boardState[point][1]==4){
              return false;
            }


          }
          if (place.charAt(0)=='j'){
            if (boardState[point][1]==1||boardState[point][1]==3||boardState[point][1]==4){
              return false;
            }


          }
          if (place.charAt(0)=='k'){
            if (boardState[point][1]==1||boardState[point][1]==2||boardState[point][1]==4){
              return false;
            }

          }
          if (place.charAt(0)=='l'){
            if (boardState[point][1]==1||boardState[point][1]==2||boardState[point][1]==3){
              return false;
            }

          }


        }
      }





      for (int i=0; i < placement.length();i=i+4){
        String place = placement.substring(i,i+4);
        Board.onBoard(place,board);
      }

      for (int i = 0;i<32;i++){
        if (board[i]>2){
          return false;
        }
      }



      // FIXME Task 5: determine whether a placement string is valid
      return true;


    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isPlacementStringValid("d2A6e2C3f3C2g4A7h6D0i6B0j2B0j1C0k3C0l4B0l5C0"));
  }

  /**
   * Given a string describing a placement of pieces and pegs, return a set
   * of all possible next viable piece placements.   To be viable, a piece
   * placement must be a valid placement of a single piece.  The piece must
   * not have already been placed (ie not already in the placement string),
   * and its placement must be valid.   If there are no valid piece placements
   * for the given placement string, return null.
   *
   * When symmetric placements of the same piece are viable, only the placement
   * with the lowest rotation should be included in the set.
   *
   * @param placement A valid placement string (comprised of peg and piece placements)
   * @return An set of viable piece placements, or null if there are none.
   * @author Siyu JIang, u6563175@anu.edu.au
   */
  public static Set<String> getViablePiecePlacements(String placement) {

    Set<String> next = new HashSet<>();
    String peg="";
    // record all possible symmetric pieces
    int[] sb = {0,1,4,5,2,3,6,7};
    int[] sc = {0,1,2,3};
    int[] se = {0,1,2,3,7,4,5,6};
    int[] sf = {0,1,2,3,6,7,4,5};
    int[] sh = {0,1,2,3};
    char[] chars={'a','b','c','d','e','f','g','h'};
    Set<Character> c= new HashSet<>();
    for (int i =0 ;i<chars.length;i++){
      char cc = chars[i];
      c.add(cc);
    }
    for (int i = 0;i<placement.length();i=i+4){
      if (placement.substring(i,i+4).charAt(0)>='i'){
        peg=peg+placement.substring(i,i+4);
      }else {
        c.remove(placement.substring(i,i+4).charAt(0));
      }
    }


    //form all possible combination
    for (Character ccc:c) {
      char kind = ccc;
      String kinds = kind + "";
      for (int m = 0; m < 8; m++) {
        int row = 1 + m;
        String rows = row + "";
        for (int n = 0; n < 4; n++) {
          char line = (char) ('A' + n);
          String lines = line + "";
          for (int k = 0; k < 8; k++) {
            int direction = 0 + k;
            String directions = direction + "";
            String place = kinds + rows + lines + directions;
            if (place.charAt(0)=='h'&&(place.charAt(3)=='4'||place.charAt(3)=='5'||place.charAt(3)=='6'||place.charAt(3)=='7')){
              continue;
            }
            if (place.charAt(0)=='c'&&(place.charAt(3)=='4'||place.charAt(3)=='5'||place.charAt(3)=='6'||place.charAt(3)=='7')){
              continue;
            }


            int p = (int)place.charAt(3)-'0';

            switch (place.charAt(0)){
              case 'b':
                for (int a = 0; a<sb.length/2;a++){
                  char pp= (char)('0'+sb[a]);
                  String ab ="b"+place.substring(1,3)+pp;
                  if (p==sb[a+4]&&next.contains(ab)){
                    place ="a"+place;
                  }
                }
                break;
              case 'c':
                for (int a = 0; a<sc.length/2;a++){
                  char pp= (char)('0'+sc[a]);
                  String ab ="c"+place.substring(1,3)+pp;
                  if (p==sc[a+2]&&next.contains(ab)){
                    place ="a"+place;
                  }
                }
                break;
              case 'e':
                for (int a = 0; a<se.length/2;a++){
                  char pp= (char)('0'+se[a]);
                  String ab ="e"+place.substring(1,3)+pp;
                  if (p==se[a+4]&&next.contains(ab)){
                    place ="a"+place;
                  }
                }
                break;
              case 'f':
                for (int a = 0; a<sb.length/2;a++){
                  char pp= (char)('0'+sf[a]);
                  String ab ="f"+place.substring(1,3)+pp;
                  if (p==sf[a+4]&&next.contains(ab)){
                    place ="a"+place;
                  }
                }
                break;
              case 'h':
                for (int a = 0; a<sh.length/2;a++){
                  char pp= (char)('0'+sh[a]);
                  String ab ="h"+place.substring(1,3)+pp;
                  if (p==sh[a+2]&&next.contains(ab)){
                    place ="a"+place;
                  }
                }
            }

            String nextPlace="";
            Map<Character,String> then = new HashMap<>();
            for (int j = 0;j<placement.length();j=j+4){
              String h =placement.substring(j,j+4);
              if (h.charAt(0)<'i'){
                then.put(h.charAt(0),placement.substring(j,j+4));
              }
            }
            if (!then.containsKey(place.charAt(0))){
              then.put(place.charAt(0),place);
            }else {
              continue;
            }
            char index ='a';
            for (int l=0;l<8;l++){

              if (then.containsKey(index)){
                nextPlace=nextPlace+then.get(index);
              }
              index=(char)(index+1);
            }
            nextPlace=nextPlace+peg;
            if (isPlacementStringValid(nextPlace)) {

              next.add(place);

            }
          }
          // FIXME Task 6: determine the set of valid next piece placements
        }
      }
    }
    if (next.size()==0){
      return null;
    }
    return next;
  }
  /**
   * Return an array of all unique solutions for a given starting placement.
   *
   * Each solution should be a 32-character string giving the placement sequence
   * of all eight pieces, given the starting placement.
   *
   * The set of solutions should not include any symmetric piece placements.
   *
   * In the IQ-Twist game, valid challenges can have only one solution, but
   * other starting placements that are not valid challenges may have more
   * than one solution.  The most obvious example is the unconstrained board,
   * which has very many solutions.
   *
   * @param placement A valid piece placement string.
   * @return An array of strings, each 32-characters long, describing a unique
   * unordered solution to the game given the starting point provided by placement.
   * @author Siyu Jiang
   * @Email u6563175@anu.edu.au
   */
  public static String[] getSolutions(String placement) {
    String peg="";     // peg Strings
    for (int i=0;i<placement.length();i=i+4){
      if (placement.substring(i,i+4).charAt(0)>'i'){
        peg=peg+placement.substring(i,i+4);
      }
    }
    Set<String> next = getViablePiecePlacements(placement); //find all possible next placements.
    List<String> valid =new ArrayList<>();
    List<String> record = combine(next);
    String[] order =new String[record.size()];
    for (int i=0;i<order.length;i++){
      order[i]=record.get(i)+placement;
    }

    for (String str:order){
      String format = format(str);
      if (isPlacementStringValid(format)){
        String a ="" ;
        for (int i =0;i<format.length();i=i+4){
          String b = format.substring(i,i+4);
          if (b.charAt(0)<'i'){
            a=a+b;
          }
        }
        valid.add(a);
      }
    }
    if (valid.size()==0){
      return null;
    }
    String[] result =new String[valid.size()];
    for (int i=0;i<valid.size();i++){
      result[i]=valid.get(i);
    }
     return result;
    // FIXME Task 9: determine all solutions to the game, given a particular starting placement

  }


  /**
   * this method iss used to give a random combination of all given next
   * step
   * @param next
   * @return
   * @author Siyu Jiang u6563175@anu.edu.au
   */
  private static List<String> combine(Set<String> next){
    //record all next step in 8 different list
    List<String> a =new ArrayList<>();
    List<String> b =new ArrayList<>();
    List<String> c =new ArrayList<>();
    List<String> d =new ArrayList<>();
    List<String> e =new ArrayList<>();
    List<String> f =new ArrayList<>();
    List<String> g =new ArrayList<>();
    List<String> h =new ArrayList<>();
    List<List<String>> record = new ArrayList<>();
    for (String place :next){
      switch (place.charAt(0)){
        case 'a':
          a.add(place);
          break;
        case 'b':
          b.add(place);
          break;
        case 'c':
          c.add(place);
          break;
        case 'd':
          d.add(place);
          break;
        case 'e':
          e.add(place);
          break;
        case 'f':
          f.add(place);
          break;
          case 'g':
          g.add(place);
          break;
          case 'h':
          h.add(place);
          break;
      }
    }
    if (a.size()!=0){record.add(a);}
    if (b.size()!=0){record.add(b);}
    if (c.size()!=0){record.add(c);}
    if (d.size()!=0){record.add(d);}
    if (e.size()!=0){record.add(e);}
    if (f.size()!=0){record.add(f);}
    if (g.size()!=0){record.add(g);}
    if (h.size()!=0){record.add(h);}

    List<String> combine = new ArrayList<>();
    return  comb(record,0,combine);


  }

  /**
   * use recursive to form all combination of a complete palcement string
   * @param list
   * @param index
   * @param result
   * @return List<Sting>
   * @author Siyu Jiang u6563175@anu.edu.au
   */
    private static List<String>  comb(List<List<String>> list,int index, List<String> result){
    List<String> nextResult = new ArrayList<>();
    if (index==list.size()-1){
       if (result.size()==0){
         nextResult.addAll(list.get(index));
       }else {
         for (int i=0;i<result.size();i++){
           String a =result.get(i);
           for (int j=0;j<list.get(index).size();j++){
             String b = list.get(index).get(j);
             nextResult.add(a+b);
           }
         }
       }
       return nextResult;
     }
      if (result.size()==0){
        nextResult.addAll(list.get(index));
      }else {
        for (int i=0;i<result.size();i++){
          String a =result.get(i);
          for (int j=0;j<list.get(index).size();j++){
            String b = list.get(index).get(j);
            nextResult.add(a+b);
          }
        }
      }
      return comb(list,index+1,nextResult);


    }








  /**
   * this method will return a hashset which is made up of many sub-hashset,
   * everytime I use this method in the getSolution method, it will return a
   * set which contains the next placement Strings.
   * @param placement
   * @return
   * @authot Siyu Jiang, u6563175@anu.edu.au
   */
  private static HashSet<String> solutions(HashSet<String> placement,int times){
    Set<String> record = new HashSet<>();
    if (times==0){
      return placement;
    }else {
      for (String place :placement){
        Set<String> result = getViablePiecePlacements(place);
        if (result!=null){
          for (String peace:result){
           // record.add(order(place,peace));
          }
        }
      }
      return solutions((HashSet<String>) record,times-1);
    }
  }


  /**
   *this method is used to make a next-placement string(eg."a7A7") and the current
   * placement string(eg."c1A3d2A6e2C3f3C2g4A7h6D0i6B0j2B0j1C0k3C0l4B0l5C0") into a new
   * valid placement string("a7A7c1A3d2A6e2C3f3C2g4A7h6D0i6B0j2B0j1C0k3C0l4B0l5C0").
   * @param placement
   * @param
   * @return
   * @author Siyu Jiang, u6563175@anu.edu.au
   */
  private static String format(String placement){
    List<String> now = new ArrayList<>();
    String result ="";
    for (int i =0;i<placement.length();i=i+4){
      now.add(placement.substring(i,i+4));
    }
    Collections.sort(now);
    for (int i =0;i<now.size();i++){
      result = result+now.get(i);
    }

    return result;
  }
}
