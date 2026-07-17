package code.companies.easy;

public class RemoveDuplicates {
    static void main() {
        int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
        int n = arr.length;

        // removeDuplicates() returns new size of array
        n = removeDuplicates(arr, n);

        // Print updated array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    static int removeDuplicates(int arr[], int n){
        // n=9
        if (arr.length == 0) {
            return 0;
        }

        int write = 0;

        for (int read = 1; read < arr.length; read++) {
            if (arr[read] != arr[write]) {
                write++;
                arr[write] = arr[read];
            }
        }

        return write + 1;
    }
}
