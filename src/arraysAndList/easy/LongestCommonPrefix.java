package arraysAndList.easy;

/*
    ======================
    PROBLEM STATEMENT
    ======================

    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".



    Example 1:

    Input: strs = ["flower","flow","flight"]
    Output: "fl"
    Example 2:

    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.


    Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters if it is non-empty.

 */

public class LongestCommonPrefix {
    void main() {
        String[] strs = new String[]{"flower","flow","flight"};
        String common = longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: " + common);
    }

    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];

        if(strs.length == 1)
            return strs[0];

        for(int i = 0;i<first.length();i++) {
            char ch = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    return first.substring(0,i);
                }
            }
        }
        return first;
    }
}
