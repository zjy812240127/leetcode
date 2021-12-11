package com.msb.algorithm.graph;

import java.util.*;

/**
 * 迪杰斯特拉算法求解起点到每一个终点的最短距离
 * @author Joya Zou
 * @date 2021年12月10日 10:59
 */
public class Dijkstra {

    /**
     * 准备一张表，每加入一个节点更新起点到该点的toNode的最短距离
     * 更新完后该节点加入set被锁定
     */
    public HashMap<Node, Integer> getDistanceMap(Graph graph){
        // 最短路径表，没加入的节点表示起点距离为无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        // 被锁定的已用的节点
        Set<Node> usedNodesSet = new HashSet<>();
        // 要遍历的点
        LinkedList<Node> path = new LinkedList<>();

        HashMap<Integer, Node> sourceNodes = graph.nodes;
        Node startNode = sourceNodes.get(0);
        path.add(startNode);
        distanceMap.put(startNode, 0);

        while (path.size()>0){
            Node node = path.removeFirst();
            if (!usedNodesSet.contains(node)) {
                ArrayList<Edge> edges = node.edges;

                for (Edge edge : edges) {
                    Node toNode = edge.to;
                    path.add(toNode);
                    if (!distanceMap.containsKey(toNode)) {
                        // 第一次从无穷改为一个从起点可达的距离
                        distanceMap.put(toNode, distanceMap.get(node) + edge.weight);
                    } else {
                        // 更新最近的距离
                        distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distanceMap.get(node) + edge.weight));
                    }

                }
                usedNodesSet.add(node);
            }
        }

        return distanceMap;
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        HashMap<Node, Integer> distanceMap = dijkstra.getDistanceMap(GraphGenerator.getMyGraph());
        for (Node node: distanceMap.keySet()){
            System.out.println("到点" + node.value + "的距离为：" +distanceMap.get(node));
        }
    }
}
