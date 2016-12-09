package algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 93
 * Link: https://leetcode.com/problems/restore-ip-addresses/
 * <p/>
 * Analysis:
 * Recursive backtrace solution.
 * Pay attention that a non-zero octet starts with a zero is illegal.
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return new ArrayList<String>();
        }
        return restoreIpAddresses(s, new ArrayList<String>(), 0);
    }

    private List<String> restoreIpAddresses(String s, List<String> current, int start) {
        if (s == null || current == null || start > s.length()) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<String>();
        if (current.size() == 4 && start == s.length()) {
            result.add(buildIp(current));
        } else {
            for (int i = 1; i < 4; i++) {
                int end = start + i;
                if (isLegalIpOctet(s, start, end)) {
                    current.add(s.substring(start, end));
                    result.addAll(restoreIpAddresses(s, current, end));
                    current.remove(current.size() - 1);
                }
            }
        }
        return result;
    }

    private String buildIp(List<String> octets) {
        if (octets == null || octets.size() != 4) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(octets.get(i));
            sb.append('.');
        }
        sb.append(octets.get(3));
        return sb.toString();
    }

    private boolean isLegalIpOctet(String s, int start, int end) {
        if (start < 0 || end > s.length()) {
            return false;
        }
        String octetStr = s.substring(start, end);
        if (octetStr.length() != 1 && octetStr.startsWith("0")) {
            return false;
        }
        Integer num = Integer.parseInt(octetStr);
        return num >= 0 && num <= 255;
    }
}
