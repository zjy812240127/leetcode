package com.msb.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 并查集
 *      1. 查询两个元素是否属于同一个集合(每一个元素的根节点指向同一个节点就属于一个集合)
 *      2. 合并两个集合（一个根节点指向另一个根节点）
 * @author Joya Zou
 * @date 2021年12月05日 10:10
 */
public class UnionFind {

    public static class Node<V>{
        V value;
        public Node(V v){
            this.value = v;
        }
    }

    public static class UnionSet<V>{
        // 每一个元素都对应一个Node节点
        Map<V, Node<V>> nodeMap = new HashMap<>();
        // 每一个节点的祖父节点
        Map<Node<V>, Node<V>> parentMap = new HashMap<>();
        // 每一个祖父节点形成的集合大小
        Map<Node<V>, Integer> sizeMap = new HashMap<>();

        /**
         * 初始化每一个元素为单独的集合
         * @param vs
         * @return
         */
        public  UnionSet(List<V> vs){
            for (V item : vs) {
                Node<V> vNode = new Node<>(item);
                nodeMap.put(item, vNode);
                parentMap.put(vNode,vNode);
                sizeMap.put(vNode,1);
            }
        }

        /**
         * 查找每个节点的祖父节点
         * @param node
         * @return
         */
        public Node<V> findParent(Node node){
            if (!nodeMap.containsKey(node)){
                return null;
            }

            Stack<Node> stack = new Stack<>();
            while(parentMap.get(node) != node){
                stack.push(node);
                node = parentMap.get(node);
            }
            Node<V> parentNode = parentMap.get(node);
            while (!stack.isEmpty()){
                parentMap.put(stack.pop(), parentNode);
            }

            return parentNode;
        }

        /**
         * 判断两个元素是否是同一个集合
         * @param v1
         * @param v2
         * @return
         */
        public boolean isSameSet(V v1, V v2){
            if (!nodeMap.containsKey(v1) || !nodeMap.containsKey(v2)){
                return false;
            }
            return parentMap.get(nodeMap.get(v1)) == parentMap.get(nodeMap.get(v2));
        }

        /**
         * 将两个元素合为一个集合
         * @param v1
         * @param v2
         */
        public void union(V v1, V v2){
            if (!nodeMap.containsKey(v1) || !nodeMap.containsKey(v2)
                    || parentMap.get(v1) == parentMap.get(v2)){
                return;
            }

            Node<V> vNode1 = nodeMap.get(v1);
            Node<V> vNode2 = nodeMap.get(v2);
            Node<V> pNode1 = findParent(vNode1);
            Node<V> pNode2 = findParent(vNode2);

            Node<V> big = sizeMap.get(pNode1) >= sizeMap.get(pNode2) ? vNode1 : vNode2;
            Node<V> small = sizeMap.get(pNode1) < sizeMap.get(pNode2) ? vNode1 : vNode2;
            parentMap.put(small,big);
            sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));
            parentMap.remove(small);

        }
    }
}
