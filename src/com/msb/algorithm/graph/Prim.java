package com.msb.algorithm.graph;

import java.util.*;

/**
 * P算法求解最小生成树（一张图联通的最短权重和)
 * @author Joya Zou
 * @date 2021年12月10日 9:45
 */
public class Prim {

    /**
     * 1. 任意取一个起点，解锁其边，找到其中最小的一条边，判断边的toNode是否已被选过，
     * 2. toNode未被选过，解锁该点的边加入已有的边集，重复寻找当前所有已解锁的最短边，找toNode
     * 3. 所有边遍历完了即完成
     */

    public Set<Edge> getSmallestTree(Graph graph){
        Set<Edge> resultEdgeSet = new HashSet<>();
        // 已遍历过的点和边
        HashSet<Node> existNode = new HashSet<>();
        HashSet<Edge> existEdge = new HashSet<>();

        // 初始化加入第一个节点和其边
        HashSet<Edge> edges = graph.edges;
        HashMap<Integer, Node> nodes = graph.nodes;
        Node root = nodes.get(0);
        existNode.add(root);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge edge1, Edge edge2) {
                return edge1.weight - edge2.weight;
            }
        });
        for (Edge edge : root.edges) {
            priorityQueue.add(edge);
            existEdge.add(edge);
        }
        /** **********核心部分**********  */
        while(priorityQueue.size()>0){
            // 找到最小的一条边
            Edge edge = priorityQueue.poll();
            Node toNode = edge.to;
            if(!existNode.contains(toNode)){
                existNode.add(toNode);
                /** 新的一条边，每次加入结果集的边一定对应一个新的node，保证一个节点只有一条路  */
                resultEdgeSet.add(edge);
                ArrayList<Edge> toEdges = toNode.edges;
                for (Edge toEdge : toEdges) {
                    if (!existEdge.contains(toEdge)){
                        existEdge.add(toEdge);
                        priorityQueue.add(toEdge);
                    }
                }

            }
        }

        return  resultEdgeSet;
    }

    public static void main(String[] args) {
        Prim prim = new Prim();
        Set<Edge> edges = prim.getSmallestTree(GraphGenerator.getMyGraph());
        for (Edge edge : edges) {
            System.out.println("edge:" + edge.weight);
        }
    }
}
