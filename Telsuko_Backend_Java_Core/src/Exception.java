//public class Exception {
//    public static void main(String[] args){
//        int i = 10;
//        int j = 9;
//        int nums[] = new int[5];
//        try{
//            int result = j/i;
//            Class.forName("Harsh");
//            System.out.println(nums[4]);
//            if(i == 10){
//                throw new HarshException("Don't do this again");
//            }
//        } catch (ArithmeticException e ){
//            System.out.println("You cannot divide by zero " + e);
//        } catch(ArrayIndexOutOfBoundsException e){
//            System.out.println("You index is out of bound");
//        } catch (HarshException e) {
//            System.out.println(e);
//        }
//        catch(ClassNotFoundException e){
//            System.out.println("Class is missing buddy! wake up to realityyyy" + e);
//        }
//        finally {
//            System.out.println("Code executed successfully");
//        }
//    }
//}
//class HarshException extends java.lang.Exception {
//    public HarshException(String string){
//    super(string);
//    }
//}