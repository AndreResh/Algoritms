package alg.programmingSkills_2;

public class DaySecond {
    public static void main(String[] args) {

    }
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()%2!=0) return false;
        if(s.substring(0, s.length()/2).equals(s.substring(s.length()/2))){
            return true;
        } else {
             return false;
        }
    }
}
