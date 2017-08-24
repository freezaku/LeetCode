Given n, how many structurally unique BSTs (binary search trees) that store values 1...n?

Have you met this question in a real interview? Yes
Example
Given n = 3, there are a total of 5 unique BSTs.

1           3    3       2      1
 \         /    /       / \      \
  3      2     1       1   3      2
 /      /       \                  \
2     1          2                  3

public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        if(n == 0)  return 1;
        
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for(int i = 2; i <= n; i ++) {
            for(int j = 1; j <= i; j ++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        
        return G[n];
    }
}

/*
G(n): the number of unique BST for a sequence of length n.

F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.

G(n) = F(1, n) + F(2, n) + ... + F(n, n). 

G(0)=1, G(1)=1. 

G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
*/