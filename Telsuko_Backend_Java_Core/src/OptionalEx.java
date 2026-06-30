//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//public class OptionalEx {
//    public static void main(String[] args){
//        List<String> names = Arrays.asList("Harsh", "Aditya", "Santosh", "Harshada", "Raj", "Karan");
//
//        Optional<String> name = names.stream() // Used to avoid null-pointerException if no data is found instead of null we not some default value which we set.
//                .filter(str -> str.contains("x"))
//                .findFirst();
//        System.out.println(name.orElse("Not Found"));
//
//        String name1 = names.stream()
//                .filter(str->str.contains("x"))
//                .findFirst()
//                .orElse("Not Found");
//        System.out.println(name1);
//    }
//}
