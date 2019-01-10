package comp1110.ass2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * this class is use to calculate the start peg placements which only have one solution
 * @Siyu Jiang u6563175@anu.edu.au
 */
public class Pieces {

    private static void combine(Set<String> next){
        //record all next step in 8 different list
        List<String> a =new ArrayList<>();
        List<String> b =new ArrayList<>();
        List<String> c =new ArrayList<>();
        List<String> d =new ArrayList<>();
        List<String> e =new ArrayList<>();
        List<String> f =new ArrayList<>();
        List<String> g =new ArrayList<>();
        List<String> h =new ArrayList<>();
        List<String> I= new ArrayList<>();
        List<String> J1= new ArrayList<>();
        List<String> J2= new ArrayList<>();
        List<String> K1= new ArrayList<>();
        List<String> K2= new ArrayList<>();
        List<String> L1= new ArrayList<>();
        List<String> L2= new ArrayList<>();

        I.add("");
        J1.add("");
        J2.add("");
        K1.add("");
        K2.add("");
        L1.add("");
        L2.add("");

        //store the possible peg placements
        for (int i=1;i<=8;i++){
            for (char j='A';j<='D';j++){
                for (int k =0;k<8;k++){
                    String str = "i"+Integer.toString(i)+Character.toString(j)+Integer.toString(k);
                    I.add(str);
                }
            }
        }

        //store the possible peg placements
        for (int i=1;i<=8;i++){
            for (char j='A';j<='D';j++){
                for (int k =0;k<8;k++){
                    String str = "j"+Integer.toString(i)+Character.toString(j)+Integer.toString(k);
                    J1.add(str);
                    J2.add(str);
                }
            }
        }

        //store the possible peg placements
        for (int i=1;i<=8;i++){
            for (char j='A';j<='D';j++){
                for (int k =0;k<8;k++){
                    String str = "k"+Integer.toString(i)+Character.toString(j)+Integer.toString(k);
                    K1.add(str);
                    K2.add(str);
                }
            }
        }

        //store the possible peg placements
        for (int i=1;i<=8;i++){
            for (char j='A';j<='D';j++){
                for (int k =0;k<8;k++){
                    String str = "l"+Integer.toString(i)+Character.toString(j)+Integer.toString(k);
                    L1.add(str);
                    L2.add(str);
                }
            }
        }

        //sort the pieces according their types
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


        //form all possible combinations
        List<String> record = new ArrayList<>();
        try {
            RandomAccessFile file = new RandomAccessFile("solution.txt", "rw");
        for (int A=0;A<a.size();A++){
            String combined = a.get(A);
            for (int B=0;B<b.size();B++){
                String combined1=combined+b.get(B);
              //  System.out.println(combined1);
                if (TwistGame.isPlacementStringValid(combined1)) {
                    for (int C = 0; C < c.size(); C++) {
                       String combined2=combined1+c.get(C);
                      //  System.out.println(combined2);
                        if (TwistGame.isPlacementStringValid(combined2)) {
                            for (int D = 0; D < d.size(); D++) {
                                String combined3=combined2+d.get(D);
                              //  System.out.println(combined3);

                                if (TwistGame.isPlacementStringValid(combined3)){
                                for (int E = 0; E < e.size(); E++) {
                                   String combined4=combined3+e.get(E);
                                   // System.out.println(combined4);

                                    if (TwistGame.isPlacementStringValid(combined4)){
                                    for (int F = 0; F < f.size(); F++) {
                                       String combined5=combined4+f.get(F);
                                    //    System.out.println(combined5);
                                        if (TwistGame.isPlacementStringValid(combined5)){
                                        for (int G = 0; G < g.size(); G++) {
                                           String combined6=combined5+g.get(G);
                                    //        System.out.println(combined6);
                                            if (TwistGame.isPlacementStringValid(combined6)){
                                            for (int H = 0; H < h.size(); H++) {
                                               String combined7=combined6+h.get(H);
                                                if (TwistGame.isPlacementStringValid(combined7)){
                                                    System.out.println(combined7);
                                                    record.add(combined7);
                                                }
                                                }
                                                }
                                                }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
                }
            }
            System.out.println("Finished"+": "+record.size());
            for (int i=0;i<I.size();i++){
                for (int j1=0;i<J1.size();j1++){
                    for (int j2=0;i<J2.size();j2++){
                        for (int k1=0;k1<K1.size();k1++){
                            for (int k2=0;k2<K2.size();k2++){
                                for (int l1=0;l1<L1.size();l1++){
                                    for (int l2=0;l2<L2.size();l2++){
                                        String pegs =I.get(i)+J1.get(j1)+J2.get(j2)+K1.get(k1)+K2.get(k2)+L1.get(l1)+L2.get(l2);
                                        List<String> complete = new ArrayList<>();
                                        for (String pieces :record){
                                            String com=pieces+pegs;

                                            if (TwistGame.isPlacementStringValid(com)){
                                                complete.add(com);{
                                                    if (complete.size()==1){
                                                        byte[] bytes = (complete.get(0)+"  ").getBytes();
                                                        try {
                                                            file.write(bytes);
                                                        } catch (IOException e1) {
                                                            e1.printStackTrace();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }






        }
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }




    public static void main(String[] args) {
        Set<String> set = TwistGame.getViablePiecePlacements("");
        combine(set);
    }


}
