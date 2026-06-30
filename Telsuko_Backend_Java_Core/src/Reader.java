//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Reader {
//    public static void main(String[] agrs) throws IOException {
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader bf = new BufferedReader(isr);
//        int num = Integer.parseInt(bf.readLine());
//
//
//        bf.close();
//
//        try(BufferedReader br = new BufferedReader(isr)){ // this closes automactially because it extends autoclosable
//            num = Integer.parseInt(br.readLine());
//
//        }
//    }
//}
