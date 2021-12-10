package com.msb.algorithm.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

        HashMap<Integer, Node> sourceNodes = graph.nodes;
        Node startNode = sourceNodes.get(0);




    }
}
