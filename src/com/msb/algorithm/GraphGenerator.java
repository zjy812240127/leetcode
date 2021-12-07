package com.msb.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 将题目给的图结构转化为我的图结构
 * @author Joya Zou
 * @date 2021年12月07日 10:00
 */
public class GraphGenerator {

    public static void main(String[] args) {
        Graph myGraph = getMyGraph();
        HashMap<Integer, Node> nodes = myGraph.nodes;
        for (Integer i:nodes.keySet()){
            System.out.println("节点："+nodes.get(i).value);
        }

        HashSet<Edge> edges = myGraph.edges;
        for (Edge edge:edges){
            System.out.println("边formNode->" + edge.from.value + "->toNode->" + edge.to.value);
        }

    }

    private static Graph getMyGraph() {
        Graph graph = new Graph();

        List<int[]> source = getSource();
        source.forEach(item->{
            int weight = item[0];
            // node的编号
            int from = item[1];
            int to = item[2];
            /** 1.先将点加入图 */
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }

            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }

            /**  2.连接点  */
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);
            if (!graph.edges.contains(edge)){
                graph.edges.add(edge);
            }

            /**  3.修改点的in out */
            fromNode.edges.add(edge);
            fromNode.nexts.add(toNode);
            fromNode.out ++;
            toNode.in ++;
        });
        return graph;
    }

    /**
     * 获得题目给定的原始图结构数据
     * @return
     */
    private static List<int[]> getSource() {
        // [weight, from, to]， 边的权重，起点，终点
        List<int[]> source = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int[] edge = new int[]{1,i,i+1};
            source.add(edge);
        }
        return source;
    }

}
