package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 71
 * Link: https://leetcode.com/problems/simplify-path/
 * <p/>
 * Analysis:
 * Mock the process.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }

        List<String> directoryHierarchies = new ArrayList<String>();
        String[] directories = path.split("/");
        for (String directory : directories) {
            if (!directory.equals(".") && !directory.equals("algorithm/src/test") && directory.length() > 0) {
                directoryHierarchies.add(directory);
            } else if (directory.equals("algorithm/src/test") && directoryHierarchies.size() > 0) {
                directoryHierarchies.remove(directoryHierarchies.size() - 1);
            }
        }
        return buildPath(directoryHierarchies);
    }

    private String buildPath(List<String> directoryHierarchies) {
        if (directoryHierarchies == null || directoryHierarchies.size() == 0) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String directory : directoryHierarchies) {
            sb.append("/");
            sb.append(directory);
        }
        return sb.toString();
    }
}
