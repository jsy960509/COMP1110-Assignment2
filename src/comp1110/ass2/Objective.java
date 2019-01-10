package comp1110.ass2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

/**
 * this class is uese to store different start placement string and their solutions
 * @auther Siyu Jiang u6563175@anu.edu.au
 */
public class   Objective {
    public static final String[] difficulities1 ={ "e2C3f3C2g4A7h6D0i6B0j2B0j1C0k3C0l4B0l5C0",
            "c5A2e4A5f4C2g2B3h1A2i7D0j7A0k5B0k5C0l3A0l3D0",
            "c3A3d1A3e1C4h5D0i5A0j2B0j3C0k2C0k2D0l8C0l8D0",
            "e1C6f6A0g4A5h1A0j3B0j7D0k1C0k1D0l6B0l1A0",
            "c1B2d4C4e1C3f4A0g6A1h1A0j3B0j5C0",
            "c5A2e5B0f1A6g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0",
            "d7B1f2A2g4B2h4A2i7B0j3D0j7D0k3A0l6A0",
            "d1A0e5B4f1B3h5A0k1B0k6B0l5A0l3C0",
            "c5C0e7A1g1B3h6D0j4B0k8B0k5D0l3C0",
            "e5C2f1C4g6B7h4B0k3D0k5D0l6C0",
            "d2A6e2C3f3C2g4A7i6B0j2B0j1C0k3C0l4B0l5C0",
         //   "a6B0b6C0c5A2h1A2i7D0j7A0k5B0k5C0l3A0l3D0",
            "d1A3e1C4f4B3g6B2h5D0i5A0j2B0j3C0k2C0k2D0l8C0l8D0",
            "b2C4c1B2g4A5h1A0j3B0j7D0k1C0k1D0l6B0l1A0",
            "d4C4e1C3f4A0g6A1h1A0j3B0j5C0",
            "d7B7e5B0f1A6g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0",
            "a1C6b6A6d7B1g4B2h4A2i7B0j3D0j7D0k3A0l6A0",
            "c2D0d1A0e5B4f1B3h5A0k1B0k6B0l5A0l3C0",
            "a1A3d3A6e7A1g1B3h6D0j4B0k8B0k5D0l3C0",
            "d1A3e5C2f1C4g6B7h4B0k3D0k5D0l6C0"};
    public static final String[] difficulities2 ={"f3C2g4A7h6D0i6B0j2B0j1C0k3C0l4B0l5C0",
            "e4A5f4C2g2B3h1A2i7D0j7A0k5B0k5C0l3A0l3D0",
            "d1A3e1C4h5D0i5A0j2B0j3C0k2C0k2D0l8C0l8D0",
            "f6A0g4A5h1A0j3B0j7D0k1C0k1D0l6B0l1A0",
            "d4C4e1C3f4A0g6A1h1A0j3B0j5C0",
            "e5B0f1A6g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0",
            "f2A2g4B2h4A2i7B0j3D0j7D0k3A0l6A0",
            "e5B4f1B3h5A0k1B0k6B0l5A0l3C0",
            "e7A1g1B3h6D0j4B0k8B0k5D0l3C0",
            "f1C4g6B7h4B0k3D0k5D0l6C0" ,
            "d2A6e2C3f3C2g4A7i6B0j2B0j1C0k3C0l4B0l5C0",
          //  "b6C0c5A2h1A2i7D0j7A0k5B0k5C0l3A0l3D0",
            "e1C4f4B3g6B2h5D0i5A0j2B0j3C0k2C0k2D0l8C0l8D0",
            "c1B2g4A5h1A0j3B0j7D0k1C0k1D0l6B0l1A0",
            "e1C3f4A0g6A1h1A0j3B0j5C0",
            "e5B0f1A6g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0",
            "b6A6d7B1g4B2h4A2i7B0j3D0j7D0k3A0l6A0",
            "d1A0e5B4f1B3h5A0k1B0k6B0l5A0l3C0",
            "d3A6e7A1g1B3h6D0j4B0k8B0k5D0l3C0",
            "e5C2f1C4g6B7h4B0k3D0k5D0l6C0"};
    public static final String[] difficulities3 ={"g4A7h6D0i6B0j2B0j1C0k3C0l4B0l5C0",
            "g2B3h1A2i7D0j7A0k5B0k5C0l3A0l3D0",
            "h5D0i5A0j2B0j3C0k2C0k2D0l8C0l8D0",
            "h1A0j3B0j7D0k1C0k1D0l6B0l1A0",
            "e1C3g6A1h1A0j3B0j5C0",
            "g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0",
            "g4B2h4A2i7B0j3D0j7D0k3A0l6A0",
            "f1B3h5A0k1B0k6B0l5A0l3C0",
            "g1B3h6D0j4B0k8B0k5D0l3C0",
            "g6B7h4B0k3D0k5D0l6C0" ,
            "f3C2g4A7i6B0j2B0j1C0k3C0l4B0l5C0",
          //  "c5A2h1A2i7D0j7A0k5B0k5C0l3A0l3D0",
            "f4B3g6B2h5D0i5A0j2B0j3C0k2C0k2D0l8C0l8D0",
            "g4A5h1A0j3B0j7D0k1C0k1D0l6B0l1A0",
            "g6A1h1A0j3B0j5C0",
            "g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0",
            "d7B1g4B2h4A2i7B0j3D0j7D0k3A0l6A0",
            "f1B3h5A0k1B0k6B0l5A0l3C0",
            "e7A1g1B3h6D0j4B0k8B0k5D0l3C0",
            "f1C4g6B7h4B0k3D0k5D0l6C0"};
    public static final String[] difficulities4 ={"g4A7i6B0j2B0j1C0k3C0l4B0l5C0",
            "h1A2i7D0j7A0k5B0k5C0l3A0l3D0",
            "e1C4i5A0j2B0j3C0k2C0k2D0l8C0l8D0",
            "g4A5j3B0j7D0k1C0k1D0l6B0l1A0",
            "h1A0j3B0j5C0",
            "i1B0j7A0j7B0k1A0k2B0l3B0l4C0",
            "i7B0j3D0j7D0k3A0l6A0",
            "k1B0k6B0l5A0l3C0",
            "h6D0j4B0k8B0k5D0l3C0",
            "f1C4k3D0k5D0l6C0",
            "g4A7i6B0j2B0j1C0k3C0l4B0l5C0",
         //   "a6B0i7D0j7A0k5B0k5C0l3A0l3D0",
            "d1A3i5A0j2B0j3C0k2C0k2D0l8C0l8D0",
            "h1A0j3B0j7D0k1C0k1D0l6B0l1A0",
            "f4A0j3B0j5C0",
            "g3A7i1B0j7A0j7B0k1A0k2B0l3B0l4C0",
            "d7B1i7B0j3D0j7D0k3A0l6A0",
            "k1B0k6B0l5A0l3C0",
            "j4B0k8B0k5D0l3C0",
            "k3D0k5D0l6C0"};

    public static final String[] solution={
            "a7A7b6A7c1A3d2A6e2C3f3C2g4A7h6D0",
            "a6B0b6C0c5A2d1B3e4A5f4C2g2B3h1A2",
            "a6A0b4A2c3A3d1A3e1C4f4B3g6B2h5D0",
            "a4C4b2C4c1B2d7B1e1C6f6A0g4A5h1A0",
            "a7B1b2C4c1B2d4C4e1C3f4A0g6A1h1A0",
            "a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D0",
            "a1C6b6A6c2D0d7B1e1A3f2A2g4B2h4A2",
            "a6C4b7A1c2D0d1A0e5B4f1B3g3A3h5A0",
            "a1A3b5A4c5C0d3A6e7A1f3C4g1B3h6D0",
            "a7A7b3B5c3A0d1A3e5C2f1C4g6B7h4B0",
            "a7A7b6A7c1A3d2A6e2C3f3C2g4A7h6D0",
         //   "a6B0b6C0c5A2d1B3e4A5f4C2g2B3h1A2",
            "a6A0b4A2c3A3d1A3e1C4f4B3g6B2h5D0",
            "a4C4b2C4c1B2d7B1e1C6f6A0g4A5h1A0",
            "a7B1b2C4c1B2d4C4e1C3f4A0g6A1h1A0",
            "a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D0",
            "a1C6b6A6c2D0d7B1e1A3f2A2g4B2h4A2",
            "a6C4b7A1c2D0d1A0e5B4f1B3g3A3h5A0",
            "a1A3b5A4c5C0d3A6e7A1f3C4g1B3h6D0",
            "a7A7b3B5c3A0d1A3e5C2f1C4g6B7h4B0"};



    public static void main(String[] args) {

        try {
            RandomAccessFile file = new RandomAccessFile("solution.txt", "rw");
            for (String str:difficulities4){
                String[] a =TwistGame.getSolutions(str);
                byte[] s="[".getBytes();
                try {
                    file.write(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (String ss:a){
                    byte[] b = (ss+", ").getBytes();
                    try {
                        file.write(b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                byte[] end="]".getBytes();
                try {
                    file.write(end);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
