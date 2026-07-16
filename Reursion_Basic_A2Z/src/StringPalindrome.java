public class StringPalindrome {
    public static void main(String[] args){
        String s = "Harsh";
        boolean result = checkPali(s,0,s.length()-1);
        System.out.println(result);
    }
    public static boolean checkPali(String s,int first,int last){
        if(first>=last){
            return true;
        } else {
            if(!Character.isLetterOrDigit(s.charAt(first))) {
                return checkPali(s, first+1, last);
            }
            if(!Character.isLetterOrDigit(s.charAt(last))) {
                return checkPali(s, first, last-1);
            }
            if(Character.toLowerCase(s.charAt(first)) != Character.toLowerCase(s.charAt(last))) {
                return false;
            }
            return checkPali(s,first+1,last-1);

        }

    }
}
