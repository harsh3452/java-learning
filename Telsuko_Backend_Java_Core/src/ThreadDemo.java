//////class A extends Thread{
//////     public void run(){
//////         for(int i = 0; i<10;i++){
//////             System.out.println("hello");
//////             try {
//////                 Thread.sleep(10);
//////             } catch (InterruptedException e) {
//////                 throw new RuntimeException(e);
//////             }
//////         }
//////     }
//////}
//////class B extends Thread{
//////    public void run(){
//////        for(int i = 0; i<10;i++){
//////            System.out.println("Hi");
//////            try {
//////                Thread.sleep(10);
//////            } catch (InterruptedException e) {
//////                throw new RuntimeException(e);
//////            }
//////        }
//////    }
//////}
////class A implements Runnable{
////    public void run(){
////        for(int i = 0; i<10;i++){
////           System.out.println("Hi");
////            try {
////               Thread.sleep(10);
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
////        }
////    }
////}
////class B implements Runnable{
////    public void run(){
////        for(int i = 0; i<10;i++){
////            System.out.println("helo");
////            try {
////                Thread.sleep(10);
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
////        }
////    }
////}
//public class ThreadDemo {
//    public static void main(String[] args) throws InterruptedException {
//////        A obj1 = new A();
//////        B obj2 = new B();
////////        obj1.getPriority();
////////        obj2.getPriority();
////////        obj1.setPriority(Thread.MAX_PRIORITY); // set priority. 1 to 10. 10 is the max priority
////////        obj1.start(); // they need run method implemented in the class always
////////        try {
////////            Thread.sleep(10);
////////        } catch (InterruptedException e) {
////////            throw new RuntimeException(e);
////////        }
////////        obj2.start();
//////        Thread t1 = new Thread(obj1);
//////        Thread t2 = new Thread(obj2);
//////        t1.start();
//////        t2.start();
////
//        Runnable obj1 = () ->{
//            for(int i = 0; i<10;i++){
//                System.out.println("helo");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//Runnable obj2 = () ->{
//            for(int i = 0; i<10;i++){
//                System.out.println("ho");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//        Thread t1 = new Thread(obj1);
//        Thread t2 = new Thread(obj2);
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//
//    }
//}
