package com.zjut;

import java.util.*;

/**
 * @author Joya Zou
 * @date 2021年12月14日 9:26
 */
public class TestDemo {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        TestDemo testDemo = new TestDemo();
        int[] order = testDemo.findOrder(numCourses, prerequisites);
        for (int i : order) {
            System.out.println(i);
        }
    }

    // 标志当前是否已经搜索到可行解
    boolean flag;
    List<List<Node>> res;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        flag = false;
        res = new ArrayList<>();


        if(prerequisites.length == 0) {
            int[] resArr = new int[numCourses];
            for(int i=0; i<numCourses; i++){
                resArr[i] = i;
            }
            return resArr;
        }


        Map<Integer, Node> existNodes = new HashMap<>();
        Set<Edge> existEdges = new HashSet<>();

        // 生成所有Nodes
        for(int i=0; i<numCourses; i++){
            Node tmpNode = new Node(i);
            existNodes.put(i, tmpNode);
        }

        // 生成所有edges
        for(int i=0; i<prerequisites.length; i++){
            Node tmpFrom = existNodes.get(prerequisites[i][1]);
            Node tmpTo = existNodes.get(prerequisites[i][0]);
            Edge tmpEdge = new Edge(tmpFrom, tmpTo);
            existEdges.add(tmpEdge);
            tmpFrom.nexts.add(tmpTo);
            tmpFrom.edges.add(tmpEdge);
            tmpFrom.out += 1;
            tmpTo.in += 1;
        }

        // 找到所有入度为零的作为起始点
        List<Node> startNodes = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            if(existNodes.get(i).in == 0) {
                startNodes.add(existNodes.get(i));
            }
        }

        // dfs遍历
        for(int i=0; i<startNodes.size(); i++){
            LinkedList<Node> path = new LinkedList<>();
            path.add(startNodes.get(i));
            Set<Node> usedNodes = new HashSet<>();
            usedNodes.add(startNodes.get(i));

            dfs(startNodes.get(i), 1, numCourses, path, usedNodes, existNodes);
            if(flag) {
                break;
            }
        }

        // 得到结果

        if(!flag) {
            int[] resArr = new int[0];
            return resArr;
        }
        // List<Integer> resList = res.get(0);
        int[] resArr = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            // resArr[i] = existNodes.get(resList.get(i)).val ;
            resArr[i] = res.get(0).get(i).val;
        }

        return resArr;
    }

    public void dfs(Node node, int count, int numCourses, LinkedList<Node> path, Set<Node> usedNodes, Map<Integer, Node> existNodes) {
        if(flag) {
            return;
        }
        if(node.out == 0 && count < numCourses) {
            return;
        }
        if(count == numCourses){
            res.add(new ArrayList(path));
            flag = true;
            return;
        }

        for (Edge e: node.edges){
            Node toNode = e.to;
            toNode.in --;
        }
        // 遍历所有节点
        for(Integer i: existNodes.keySet()){
            // todo 逻辑错误，不能将所有节点按照次序排
            if (usedNodes.contains(existNodes.get(i))){
                continue;
            }
            Node tmpNode = existNodes.get(i);
            if (tmpNode.in == 0){
                path.add(tmpNode);
                usedNodes.add(tmpNode);
                dfs(tmpNode, count +=1, numCourses, path, usedNodes, existNodes);
            }
            // path.removeLast();
        }

    }

}

class Node{
    int val;
    int in;
    int out;
    List<Node> nexts;
    List<Edge> edges;

    public Node(int val){
        this.val = val;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}

class Edge{
    Node from;
    Node to;
    int weight;

    public Edge(Node from, Node to){
        this.from = from;
        this.to = to;
        this.weight = 1;
    }
}
