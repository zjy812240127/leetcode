package com.msb.algorithm.graph;

import java.util.*;

/**
 * todo 图的深度优先遍历 = stack（保证可以回溯） + set（保证不重复遍历）
 * @author Joya Zou
 * @date 2021年12月07日 11:08
 */
public class GraphDfs {


    public List<Node> getAllNodes(Graph graph){
        List<Node> resList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();

        Node root = graph.nodes.get(0);
        stack.push(root);
        set.add(root);
        while (stack.size()>0){
            Node node = stack.pop();
            ArrayList<Node> nextNodes = node.nexts;
            if (nextNodes.size()>0){
                for (Node nextNode : nextNodes) {
                    if (!set.contains(nextNode)){
                        set.add(nextNode);
                        stack.push(node);
                        stack.push(nextNode);
                        break;
                    }
                }
            }
        }

        for (Node node : set) {
            resList.add(node);
        }

        return  resList;
    }

    public static void main(String[] args) {
        GraphDfs graphDfs = new GraphDfs();
        List<Node> allNodes = graphDfs.getAllNodes(GraphGenerator.getMyGraph());
        long start = System.currentTimeMillis();
        for (Node node : allNodes) {
            System.out.println("节点：" + node.value);
        }
        long end = System.currentTimeMillis();
        System.out.println("DFS耗时=" + (end -start));
    }
}
