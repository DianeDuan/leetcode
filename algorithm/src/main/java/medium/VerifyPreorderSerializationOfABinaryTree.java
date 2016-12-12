package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 331
 * Link: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * <p/>
 * Analysis:
 * Use a stack to remove leaves layer by layer.
 * <p/>
 * Reference:
 * https://www.hrwhisper.me/leetcode-verify-preorder-serialization-of-a-binary-tree/
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] tokens = preorder.split(",");
        List<String> stack = new ArrayList<String>();
        for (String token : tokens) {
            stack.add(token);
            processStackTop(stack);
        }
        processStackTop(stack);
        return stack.size() == 1 && stack.get(0).equals("#");
    }

    private void processStackTop(List<String> stack) {
        while (stack.size() >= 3 && stack.get(stack.size() - 1).equals("#") &&
                stack.get(stack.size() - 2).equals("#") && !stack.get(stack.size() - 3).equals("#")) {
            stack.remove(stack.size() - 1);
            stack.remove(stack.size() - 1);
            stack.remove(stack.size() - 1);
            stack.add("#");
        }
    }
}
