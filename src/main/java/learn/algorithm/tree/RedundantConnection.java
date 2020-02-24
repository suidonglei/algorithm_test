package learn.algorithm.tree;

import java.util.*;

/**
 * 685. Redundant Connection II
 *
 */
public class RedundantConnection {

    List<Set<Integer>> tree = new ArrayList<>();
    boolean endFlag = false;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        for(int i = 0; i <= edges.length; i++) {
            tree.add(new HashSet<>());
        }
        int[] indegrees = new int[edges.length + 1];
        int inde = 0;
        for(int[] edge: edges) {
            tree.get(edge[0]).add(edge[1]);
            indegrees[edge[1]] ++;
            if(indegrees[edge[1]] > 1) {
                inde = edge[1];
            }
        }
        int root = findRoot(tree, indegrees);
        if(root == 0) root = 1;
        int[] result = new int[2];
        Set<Integer> visited = new HashSet<>();
        dfs(result, visited, root, -1);

        if(result[0] == 0) {
            result = findResult(edges, inde);
        }

        return result;
    }

    private void dfs(int[] result, Set<Integer> visited, int node, int par) {
        if(endFlag) return;
        if(visited.contains(node)) {
            result[0] = par;
            result[1] = node;
            endFlag = true;
            return;
        }
        visited.add(node);
        for(int child : tree.get(node)) {
            dfs(result, visited, child, node);
        }
        visited.remove(node);
    }

    private int findRoot(List<Set<Integer>> tree, int[] indegrees) {
        int root = 0;
        for(int i = 1; i < indegrees.length - 1; i ++) {
            if(!tree.get(i).isEmpty() && indegrees[i] == 0) {
                root = i;
                break;
            }
        }
        if(root == 0) {

        }
        return root;
    }

    private int[] findResult(int[][] edges, int inNode) {
        int[] result = new int[2];
        for(int i = edges.length -1; i >=0; i--) {
            if(edges[i][1] == inNode) {
                result[0] = edges[i][0];
                result[1] = edges[i][1];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RedundantConnection redundantConnection = new RedundantConnection();



        redundantConnection.findRedundantDirectedConnection(new int[][]{{6,3},{8,4},{4,9},{3,2},{5,10},{10,7},{2,1},{7,6},{4,5},{1,8}});
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public class Edge{
        int to;
        int next;
    }
    public static int[] deg;
    public static Edge[] g;
    public static int cnt;
    public static int[] head;
    public static boolean[] vis;
    public static int[] res;
    public void add(int u,int v){ //存图
        g[cnt]=new Edge();
        g[cnt].to=v;
        g[cnt].next=head[u];
        head[u]=cnt++;
    }
    public boolean dfs1(int st,int pre){ //下一个点 前一个点 即(v,u)
        if(vis[st]){ //若再次访问的话 即为环的最后一条边 为答案
            res=new int[]{pre,st};
            return true;
        }
        vis[st]=true; //设为访问
        for(int i=head[st];i!=-1;i=g[i].next){ //遍历该点的所有边
            int to=g[i].to;
            if(dfs1(to,st)){
                return true;
            }
        }
        vis[st]=false;
        return false;
    }
    public int[] findRedundantDirectedConnection1(int[][] edges) {
        if(edges==null||edges[0].length==0){
            return new int[2];
        }
        int n=edges.length;
        cnt=0;
        g=new Edge[n+1];
        deg=new int[n+1];
        head=new int[n+1];
        vis=new boolean[n+1];
        java.util.Arrays.fill(head,-1);
        for(int i=0;i<n;++i){
            int u=edges[i][0];
            int v=edges[i][1];
            add(u,v); //建图
            deg[v]++; //入度
        }
        int st=0;
        for(int i=1;i<=n;++i){ //判断起点 若没有入度为0的点 就从1开始
            if(deg[i]==0){
                st=i;
                break;
            }
        }
        if(st==0){
            st=1;
        }
        boolean flag=dfs1(st,0);
        if(flag){ //说明成环 有答案
            return res;
        }else{
            int t=-1;
            for(int i=1;i<=n;++i){ //找入度为2的点
                if(deg[i]==2){
                    t=i;
                }
            }
            for(int i=n-1;i>=0;--i){ //从后往前遍历
                if(edges[i][1]==t){
                    return edges[i];
                }
            }
        }
        return new int[2];
    }
}
