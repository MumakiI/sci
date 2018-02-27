package sfbay;

import java.util.Arrays;

public class WinterSummer  {
    static public int solution(int[] T) {

       int[] mins = new int[T.length];
       int min = T[T.length-1];
       mins[mins.length-1] = min;
       for (int i = mins.length-2; i >= 0; i--) {
           if (T[i]<min) {
               min = T[i];
           }
           mins[i] = min;
       }

       int max=Integer.MIN_VALUE;
       for (int i=0; i< T.length-1; i++) {
           if (T[i]>max)
               max = T[i];
           if (max < mins[i+1]) {
               return i+1;
           }
       }
       return -1;
    }
    static public void main(String[]a) {
        System.out.print( solution(new int[]{-5, -5, -5, -42, 6, 12}));
    }
}
