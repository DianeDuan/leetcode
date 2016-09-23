import algorithm.easy.IntersectionOfTwoArrays;
import algorithm.medium.LargestNumber;
import algorithm.medium.TopKFrequentElements;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        TopKFrequentElements o = new TopKFrequentElements();
        int[] nums = new int[]{1,1,1,2,2,3};
        List<Integer> res = o.topKFrequent(nums,2);

        for (Integer i : res) {
            System.out.println(i);
        }

    }
}
