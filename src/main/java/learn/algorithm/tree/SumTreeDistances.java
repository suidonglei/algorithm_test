package learn.algorithm.tree;

import java.util.*;

/**
 * 834. Sum of Distances in Tree
 *
 * An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
 *
 * The ith edge connects nodes edges[i][0] and edges[i][1] together.
 *
 * Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.
 *
 */
public class SumTreeDistances {
    int[] ans;
    int[] count;
    int N;
    List<Set<Integer>> tree = new ArrayList<>();

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        ans = new int[N];
        count = new int[N];

        //init
        Arrays.fill(count, 1);
        for(int i = 0; i < N; i ++) {
            tree.add(new HashSet<>());
        }
        for(int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        //dfs
        dfs(0, -1);
        dfs1(0, -1);

        return ans;
    }

    private void dfs(int node, int par) {
        for(int child : tree.get(node)) {
            if(child != par) {
                dfs(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }
    private void dfs1(int node, int par) {
        for(int child : tree.get(node)) {
            if(child != par) {
                ans[child] = ans[node] + N - count[child] - count[child];
                dfs1(child, node);
            }
        }
    }
}
