package com.msb.algorithm.graph;

import java.util.*;

/**
 * 拓扑逻辑算法，依次找出入度为零的点删除 ----》 找到节点先后顺序
 * @author Joya Zou
 * @date 2021年12月08日 10:09
 */
public class ToplogicSort {

    public List<Node> getToplogicSort(Graph graph){
        List<Node> resList = new ArrayList<>();
        // 记录每个节点的入度
        Map<Node, Integer> inMap = new HashMap<>();
        // 所有入度为0的节点入队，遍历输出
        LinkedList<Node> zeroInQueue = new LinkedList<>();

        HashMap<Integer, Node> nodes = graph.nodes;
        for (Integer i : nodes.keySet()){
            Node node = nodes.get(i);
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        while (zeroInQueue.size()>0){
            Node node = zeroInQueue.removeFirst();
            resList.add(node);
            ArrayList<Node> nextNodes = node.nexts;
            for (Node nextNode : nextNodes) {
                nextNode.in --;
                if (nextNode.in == 0){
                    zeroInQueue.add(nextNode);
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        ToplogicSort toplogicSort = new ToplogicSort();
        List<Node> sort = toplogicSort.getToplogicSort(GraphGenerator.getMyGraph());
        for (Node node : sort) {
            System.out.println("节点："+node.value);
        }
    }
}
