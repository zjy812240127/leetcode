package com.msb.algorithm.graph;

import java.util.*;

/**
 * todo 图的宽度优先遍历 = queue + set(保证不重复遍历)
 * @author Joya Zou
 * @date 2021年12月07日 11:07
 */
public class GraphBfs {

    /**
     * 遍历图中的每个节点
     * @param graph
     * @return
     */
    public List<Node> getAllNodes(Graph graph){
        List<Node> arrayList = new ArrayList<>();

        HashMap<Integer, Node> nodes = graph.nodes;
        Node root = nodes.get(0);
        LinkedList<Node> queue = new LinkedList<>();
        Set<Node> existNodes = new HashSet<>();

        queue.add(root);
        existNodes.add(root);
        while (queue.size()>0){
            Node node = queue.removeFirst();
            ArrayList<Node> nextNodes = node.nexts;
            for (Node nextNode : nextNodes) {
                if(!existNodes.contains(nextNode)){
                    queue.add(nextNode);
                    existNodes.add(nextNode);
                }
            }
        }

        for (Node existNode : existNodes) {
            arrayList.add(existNode);
        }

        return arrayList;
    }

    public static void main(String[] args) {
        Graph myGraph = GraphGenerator.getMyGraph();
        GraphBfs graphBfs = new GraphBfs();
        List<Node> allNodes = graphBfs.getAllNodes(myGraph);
        long start = System.currentTimeMillis();
        for (Node allNode : allNodes) {
            System.out.println("节点：" + allNode.value);
        }
        long end = System.currentTimeMillis();
        System.out.println("BFS耗时=" + (end -start));
    }
}
