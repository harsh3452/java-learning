//import java.util.*;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.stream.Stream;
//
//class Student implements Comparable<Student>{
//    int age;
//    String name;
//
//    public Student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "age=" + age +
//                ", name='" + name + '\'' +
//                '}';
//    }
//
//    @Override
//    public int compareTo(Student that) {
//        if(this.age>that.age){
//            return 1;
//        } else if (this.age<that.age) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
//
//
//}
//public class Sorting {
//    public static void main(String[] args){
////        List<Integer> list = new ArrayList<>();
////        Comparator<Integer> comparator = new Comparator<Integer>() { // this is custom comprators for the integer for only last digits we paass with collegions.sort() if we want a new logic of comparing the elements
////            public int compare(Integer o1, Integer o2) {
////                if(o1%10 > o2%10){
////                    return 1;
////                } else {
////                    return -1;
////                }
////            }
////        };
////        list.add(52);
////        list.add(58);
////        list.add(29);
////        list.add(55);
////        list.add(74);
////        Collections.sort(list,comparator);
//       // System.out.println(list);
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("harsh", 100));
//        students.add(new Student("harsh", 77));
//        students.add(new Student("harsh", 78));
//        students.add(new Student("harsh", 85));
//        Collections.sort(students); // no need to write custom comparator object because made student implments comparable and override the method of compare with custom logic
//        for(Student s : students){
//            System.out.println(s);
//        }
//
//            List<Integer> numbers = Arrays.asList(3,4,7,6,554,54,43,324);
//            //numbers.forEach(n -> System.out.println(n));// without lambda we might had to create a consumer object and pass things to it, but it reduced the code so much.
//    //        Stream<Integer> s1 = numbers.stream(); // can be only used once
//    //        Stream<Integer> s2 = s1.filter(n -> n%2==0); //filters based on the condition
//    //        Stream<Integer> s3 = s2.map(n -> n*2);
//    //        int result = s3.reduce(0,(c,e)->c+e); //return sum
//    //        //s3.forEach(n-> System.out.println(n));
//    //        System.out.println(result);
//
//        Predicate<Integer> p = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer n) {
//                if(n%2==0)
//                    return true;
//                else
//                    return false;
//            }
//        };
//        Predicate<Integer> p1 = (n) -> n%2==0; // same as the above and can be written asa below directly
//
//        Function<Integer,Integer> function = new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer integer) {
//                return integer*2;
//            }
//        };
//        Function<Integer,Integer> function1 = (n) -> n*2;  // this one above it are similar. which can be replaced my .map equation
//
//            int result = numbers.stream()
//                                .filter(n->n%2==0) //it needs and predicate object
//                                .map(n->n*2)
//                                .reduce(0,(c,e)->c+e); //identity is the initial value and rest are variable used to add the next values
//            System.out.println(result);
//            Stream<Integer> sortedValues = numbers.stream() //parallelstream makes it faster but don't use sorted as it needs all the elmements for processing few threads might finish early or late.
//                    .filter(n->n%2==0)
//                    .sorted();
//            sortedValues.forEach(n-> System.out.println(n));
//        }
//}
