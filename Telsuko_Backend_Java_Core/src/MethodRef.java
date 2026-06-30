//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//class Student{
//    private String name;
//    private int age;
//
//    public Student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//    public Student(String name){
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}
//public class MethodRef {
//    public static void main(String[] args){
//        List<String> names = Arrays.asList("Harsh", "Aditya", "Santosh", "Harshada", "Raj", "Karan");
//        // Method Reference
//
////        List<String> uNames = names.stream()
////                .map(String::toUpperCase) //similar to name -> name.toUpperClass()
////                .toList(); //convert stream to list and returns it
////        uNames.forEach(System.out::println);
//
//        List<Student> studentsList = new ArrayList<>();
//
//        // Constructor Reference
//        //Method 1
////        for(String name : names){
////            studentsList.add(new Student(name));
////        }
//
//        //Method 2  or use // map(name -> new Student(name) in map
//        studentsList = names.stream()
//                        .map(Student::new)
//                                .toList();
//        System.out.println(studentsList);
//    }
//}
