//abstract class Computer { //abstract class can have normal as well as abstract methods we cannot create and object of itx
//    abstract public void code();
//}
//
//class Laptop extends Computer{
//    public void code(){
//        System.out.println("Code Coder Codest");
//    }
//}
//class Developer {
//    public void developApp(Computer computer){
//        computer.code();
//    }
//}
//class Desktop extends Computer{
//    public void code(){
//        System.out.println("Faster Code Coder Codest");
//    }
//}
//public class Company {
//    public static void main(String[] args){
//        Developer dev1 = new Developer();
//        Laptop laptop = new Laptop();
//        Desktop desktop = new Desktop();
//        dev1.developApp(laptop);
//        dev1.developApp(desktop);
//        //dev1.developApp(desk);//we Cannot pass desktop as we accept laptop only so lets go with interface
//    }
//}
