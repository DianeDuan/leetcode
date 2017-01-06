package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Problem:
 * No: 406
 * Link: https://leetcode.com/problems/queue-reconstruction-by-height/
 * <p>
 * Analysis:
 * Sort the people first to make sure shorter people are before taller people.
 * Then scan the sorted result and put people on the right position in the queue.
 * During the scan, every time the people we pick up is the shortest of the people who are not put on the right position.
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null) {
            return null;
        }

        List<int[]> sortedPeople = sortByHeight(people);
        int[][] queue = initQueue(people.length);
        for (int i = 0; i < people.length; i++) {
            int position = findPosition(sortedPeople.get(i)[0], sortedPeople.get(i)[1], queue);
            queue[position][0] = sortedPeople.get(i)[0];
            queue[position][1] = sortedPeople.get(i)[1];
        }
        return queue;
    }

    private int[][] initQueue(int length) {
        int[][] queue = new int[length][2];
        for (int i = 0; i < length; i++) {
            queue[i][0] = -1;
        }
        return queue;
    }

    private int findPosition(int height, int higherCount, int[][] queue) {
        int count = 0;
        for (int i = 0; i < queue.length; i++) {
            if (queue[i][0] == -1) {
                if (count == higherCount) {
                    return i;
                }
                count++;
            } else if (queue[i][0] >= height) {
                count++;
            }
        }
        return -1;
    }

    private List<int[]> sortByHeight(int[][] people) {
        List<int[]> list = Arrays.asList(people);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // first sort people by their height in ascending order
                int h1 = o1[0], h2 = o2[0];
                if (h1 > h2) {
                    return 1;
                } else if (h1 < h2) {
                    return -1;
                } else {
                    // if two people's heights are same, sort them by their k in asceding order
                    int k1 = o1[1], k2 = o2[1];
                    if (k1 > k2) {
                        return 1;
                    } else if (k1 < k2) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        return list;
    }
}
