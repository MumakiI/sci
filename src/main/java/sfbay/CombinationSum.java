package sfbay;

import java.util.*;

public class CombinationSum {

    /**
     [1, 2, 3]
     */
    List<List<Integer>> rec(int target, int start, int[] a) {
        if(start >= a.length || target < 0)
            return Collections.emptyList();
        if (a[start] - target == 0) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(target);
            ArrayList<List<Integer>> r = new ArrayList<>();
            r.add(l);
            return r;
        }
        List<List<Integer>> res1 = rec(target - a[start], start, a);

        res1.forEach(l -> {
            if (l.stream().mapToInt(Integer::valueOf).sum() + a[start] == target) {
                l.add(a[start]);
            }
        });

        List<List<Integer>> res2 = rec(target, start + 1, a);
        res2.forEach(l -> {
            if (l.stream().mapToInt(Integer::valueOf).sum() + a[start] == target) {
                l.add(a[start]);
            }
        });

        ArrayList<List<Integer>> r = new ArrayList<>();
        if (!res1.isEmpty()) r.addAll(res1);
        if (!res2.isEmpty()) r.addAll(res2);
        return  r;
    }
    public static void main(String ...a) {
        int target = 4;
        int[] candidates = {1, 2, 3, 4};
        List<List<Integer>> acc =
                combinationSum(candidates, target);
        if (true);
System.out.print("");
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return new CombinationSum().rec(target, 0, candidates);
    }
}
