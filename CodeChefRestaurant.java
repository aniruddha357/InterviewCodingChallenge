package codingninjas.searching;

/*
Chef is a cook and he has recently opened a restaurant.

The restaurant is open during N time intervals [L1,R1),[L2,R2),…,[LN,RN). No two of these intervals overlap — formally,
for each valid i, j such that i≠j, either Ri<Lj or Rj<Li.

M people (numbered 1 through M) are planning to eat at the restaurant; let's denote the time when the i-th person arrives by Pi.
If the restaurant is open at that time, this person does not have to wait, but if it is closed, this person will wait until it is open.
Note that if this person arrives at an exact time when the restaurant is closing, they have to wait for the next opening time.

For each person, calculate how long they have to wait (possibly 0 time), or determine that they will wait forever for the restaurant to open.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of the input contains two space-separated integers N and M.
N lines follow. For each valid i, the i-th of these lines contains two space-separated integers Li and Ri.
M lines follow. For each valid i, the i-th of these lines contains a single integer Pi.

Output
For each test case, print M lines.
For each valid i, the i-th of these lines should contain a single integer — the time person i has to wait, or −1 if person i has to wait forever.

Constraints
1≤T≤100
1≤N,M≤105
1≤Li<Ri≤109 for each valid i
1≤Pi≤109 for each valid i
the intervals are pairwise disjoint
the sum of N for all test cases does not exceed 3⋅105
the sum of M for all test cases does not exceed 3⋅105

Subtasks
Subtask #1 (30 points):

the sum of N for all test cases does not exceed 1,000
the sum of M for all test cases does not exceed 1,000
Subtask #2 (70 points): original constraints

Sample Input 1
1
4 5
5 7
9 10
2 3
20 30
5
6
7
35
1
Sample Output 1
0
0
2
-1
1
 */


import java.util.NavigableMap;
import java.util.TreeMap;

public class CodeChefRestaurant {
    public static void main(String[] args) {
        int arr[][] = {{4,5}, {5,7}, {9, 10}, {2, 3}, {20, 30}};
        int timing[] = {5, 6, 7, 35, 1};

        process(arr,timing);
    }

    private static void process(int[][] arr, int[] timing) {
        NavigableMap<Integer, Integer> restaurantTiming = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            restaurantTiming.put(start,end);
        }


        for (int i = 0; i < timing.length; i++) {
            int num = timing[i];
            Integer start = restaurantTiming.lowerKey(num);
            Integer after = restaurantTiming.ceilingKey(num);

            if(start!=null){
                Integer end = restaurantTiming.get(start);
                if(num < end && num>=start){
                    System.out.println(0);
                    continue;
                }
            }

            if(after == null){
                System.out.println(-1);
            }else{
                System.out.println(after-num);
            }
        }

    }

}
