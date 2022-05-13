package alg.programmingSkills;

public class DayFirst {
    public int countOdds(int low, int high) {
        int a=high-low;
        if(a%2==0){
            return a/2;
        } else {
            return a/2+1;
        }
    }
}
