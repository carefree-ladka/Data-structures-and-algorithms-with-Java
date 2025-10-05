package DSA.Arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate dc = new ContainsDuplicate();
        System.out.println(dc.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num))
                return true;
            else
                set.add(num);
        }
        return false;
    }
}
