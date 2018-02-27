package sfbay;

public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int lo=0, hi = nums.length-1;
        int p1 = hi/2;
        int p2 = hi/2;

        while (hi-lo > 1) {
            if (nums[lo+p1]>=target) {
                hi = lo + p1;
            }else  {
                lo = lo + p1;
            }
            p1 = (hi-lo)/2;
        }
        p1=lo;
        lo=0; hi = nums.length-1;
        while (hi-lo > 1) {
            if (nums[lo+p2]<=target) {
                lo = lo+p2;
            } else  {
                hi = lo + p2;
            }
            p2 = (hi-lo)/2;
        }
        p2=lo;
        if (nums[hi]==target)
            p2 = hi;
        if (p1!=0) {
            p1++;
        }
        return new int[]{p1,p2};
    }
    static public void main(String ...s) {
        int[] obj = new SearchForARange().searchRange(new int[]{1,1}, 1);
        System.out.print("" + obj[0] +" " + obj[1]);
    }
}
