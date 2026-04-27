package code.arraysAndList.easy;

/*
    ======================
    PROBLEM STATEMENT
    ======================

    Given an integer numRows, return the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


    Example 1:

    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    Example 2:

    Input: numRows = 1
    Output: [[1]]


 */

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    void main() {
        int numRows = 5;
        List<List<Integer>> pascalsTriangle = pascalsTriangle(numRows);
        pascalsTriangle.forEach(System.out::println);
    }

    public List<List<Integer>> pascalsTriangle(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();

        for(int i=0;i<numRows;i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if(j==0 || j==i)
                    row.add(1);
                else
                    row.add(
                      pascalsTriangle.get(i-1).get(j-1) +
                      pascalsTriangle.get(i-1).get(j)
                    );
            }

            pascalsTriangle.add(row);
        }

        return pascalsTriangle;
    }
}
