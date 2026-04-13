/*You have an array A of N integers A1 A2 .. An. Find the longest increasing subsequence Ai1 Ai2 .. Ak
(1 <= k <= N) that satisfies the following condition:
For every adjacent pair of numbers of the chosen subsequence Ai[x] and Ai[x+1] (1 < x < k), the expression( Ai[x] & Ai[x+1] ) * 2 < ( Ai[x] | Ai[x+1] ) is true

Note: ‘&’ is the bitwise AND operation, ‘ | ‘ is the bit-wise OR operation

Input:

The first line contains an integer, N, denoting the number of elements in A.
Each line i of the N subsequent lines (where 0 ≤ i < N) contains an integer describing Ai.
Sample cases:

Input	Output	Output Description
5
15
6
5
12
1

2	One possible subsequence is: 5 12
6
9
17
2
15
5
2

2	One possible subsequence is: 2 15
7
17
16
12
2
8
17
17*/


//mera code 

class Main
{
    public static int LIS(int[] arr, int i, int n, int prev)
    {
        if (i == n) {
            return 0;
        }
        int excl = LIS(arr, i + 1, n, prev);

        int incl = 0;
        if (arr[i] > prev) {
            incl = 1 + LIS(arr, i + 1, n, arr[i]);
        }

        return Integer.max(incl, excl);
    }

    public static void main(String[] args)
    {
        int[] arr = { 15, 6, 5, 12, 1 };

        System.out.print("The length of the LIS is "
                        + LIS(arr, 0, arr.length, Integer.MIN_VALUE));
    }
}

