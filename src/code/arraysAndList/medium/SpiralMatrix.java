package code.arraysAndList.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    static void main(String[] args) {
        int matrix[][] = {
                {10,11,12,13,14},
                {15,16,17,18,19},
                {20,21,22,23,24},
                {25,26,27,28,29},
                {30,31,32,33,34}
        };
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;

        int top=0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(top <= bottom && left <= right) {
            for(int col=left;col<=right;col++)
                result.add(matrix[top][col]);
            top++;

            for(int row=top;row<=bottom;row++)
                result.add(matrix[row][right]);
            right--;

            if(top <= bottom) {
                for(int col=right;col>=left;col--)
                    result.add(matrix[bottom][col]);

                bottom--;
            }

            if(left <= right) {
                for(int row=bottom;row>=top;row--)
                    result.add(matrix[row][left]);
                left++;
            }
        }

        return result;
    }
}
