class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        back(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void back(String s, int start, List<String> cur, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(cur)); // add a valid partition
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String substr = s.substring(start, end + 1);
            if (isPalindrome(substr)) {
                cur.add(substr);
                back(s, end + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }
}
