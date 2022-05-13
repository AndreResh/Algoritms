package alg.binarysearch;

public class FourthDay {
    public static void main(String[] args) {
        System.out.println(new FourthDay().mySqrt(25));
    }

    public char nextGreatestLetter(char[] letters, char target) {
//        for (int i = 0; i < letters.length; i++) {
//            if(letters[i]>target){
//                return letters[i];
//            }
//        }
//        return target;

        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        return letters[lo % letters.length];
    }

    public int mySqrt(int x) {
        int left = 0;
        int right = x/2;
        int middle;
        while (left<right){
            middle = (left+right);
            if(middle*middle==x){
                return middle;
            } else if (middle*middle>x) {
                right = middle-1;
            } else {
                left = middle;
            }
        }
        return left;
    }
}
