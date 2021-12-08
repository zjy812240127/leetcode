package com.msb.algorithm.graph;

import java.util.*;

/**
 * K算法求解最小生成树（保持每个节点都连在一起，所需要的边的权重最小）
 *
 * @author Joya Zou
 * @date 2021年12月08日 10:42
 */
public class Kruskal {

    /**
     * todo 结合 并查集
     * 1. 把每条边按权重从小到大排序
     * 2. 初始将每一个节点封装成一个独立的集合
     * 3. 从小到大取出边，合并边的节点到一个集合，当节点已经在一个集合时不取该边
     */
    Map<Node, Node> parentMap = new HashMap<>();
    Map<Node, Integer> sizeMap = new HashMap<>();

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();
        //  todo 空指针
        Graph minTree = kruskal.getMinTree(GraphGenerator.getMyGraph());
        HashSet<Edge> edges = minTree.edges;
        for (Edge edge : edges) {
            System.out.println("边：" + edge.weight);
        }
    }

    public Graph getMinTree(Graph graph){
        Graph resultGraph = new Graph();

        HashMap<Integer, Node> nodes = graph.nodes;
        HashSet<Edge> edges = graph.edges;
        /** 1.封装UnionSet  */
        // 装入所有节点
        for (Integer i : nodes.keySet()){
            resultGraph.nodes.put(i, nodes.get(i));
            parentMap.put(nodes.get(i), nodes.get(i));
            sizeMap.put(nodes.get(i),1);
        }


        /**  2.排序边   */
        PriorityQueue<Edge> edgeSort = edgeSort(edges);

        /** 3.加入边  */
        // todo 遍历堆 *****************报空指针异常
        while (!edgeSort.isEmpty()){
            Edge edge = edgeSort.poll();
            Node fromNode = edge.from;
            Node toNode = edge.to;
            if (!isSame(fromNode,toNode)){
                resultGraph.edges.add(edge);
                unionSet(fromNode,toNode);
            }
        }
        return resultGraph;
    }

    /**
     * 给边按权重排序
     * @param edges
     * @return
     */
    private PriorityQueue<Edge> edgeSort(HashSet<Edge> edges) {
        PriorityQueue<Edge> edgsSort = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        for (Edge edge : edges) {
            edgsSort.add(edge);
        }

        // Edge[] newEdges = (Edge[]) edgsSort.toArray();
        return edgsSort;
    }

    /**
     * 并查集找每个节点是否属于一个父节点
     * @param node
     * @return
     */
    public Node findParent(Node node){

        Stack<Node> stack = new Stack<>();
        if (parentMap.get(node) != node){
            stack.push(node);
            node = parentMap.get(node);
        }

        while(stack.size() >0){
            Node tmpNode = stack.pop();
            parentMap.put(tmpNode, node);
        }
        return node;

    }

    /**
     * 判断两个点是否属于一个集合
     * @param node1
     * @param node2
     * @return
     */
    public boolean isSame(Node node1, Node node2){
        if (parentMap.get(node1) == parentMap.get(node2)) {
            return true;
        }
        return false;
    }

    /**
     * 合并两个节点的集合
     * @param node1
     * @param node2
     */
    public void unionSet(Node node1, Node node2){
        Node parentNode1 = findParent(node1);
        Node parentNode2 = findParent(node2);
        if (parentNode1 == parentNode2) {
            return;
        }

        Integer size1 = sizeMap.get(parentNode1);
        Integer size2 = sizeMap.get(parentNode2);
        Node big =  size1 >= size2? parentNode1:parentNode2;
        Node small =  size1 >= size2? parentNode2:parentNode1;
        parentMap.put(small,big);
        sizeMap.put(big, size1 + size2);
        sizeMap.remove(small);


    }
}
