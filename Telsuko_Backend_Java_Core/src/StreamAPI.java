//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class StreamAPI {
//    public static void main(String[] args){
//        int size = 10_000;
//        List<Integer> list = new ArrayList<>(size);
//        Random random = new Random();
//        for(int i = 1; i<=size; i++) {
//            list.add(random.nextInt(100));
//        }
////        int result = list.stream()
////                .map(n->n*2)
////                .reduce(0,(c,e)->c+e);
//
//        long startSeq = System.currentTimeMillis();
//        int result2 = list.stream()
//                .map(n->{
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return n+2;
//                })
//                .mapToInt(i->i)// return an intStream which can be added with help of sum method.
//                //.reduce(0,(c,e)->c+e);
//                .sum();
//        long endSeq = System.currentTimeMillis();
//
//        long startPara = System.currentTimeMillis();
//        int result3 = list.parallelStream()
//                .map(n->{
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return n+2;
//                })
//                .mapToInt(i->i)// return an intStream which can be added with help of sum method.
//                //.reduce(0,(c,e)->c+e);
//                .sum();
//        long endPara = System.currentTimeMillis();
//        System.out.println(result2);
//        System.out.println(result3);
//        System.out.println("Sequential : Start = "+startSeq+". End = "+endSeq+ " Difference : "+(endSeq-startSeq));
//        System.out.println("Parallel : Start = "+startPara+". End = "+endPara+ " Difference : "+(endPara-startPara));
//    }
//}
