package com.msb.algorithm.graph;

/**
 * 图的边
 * @author Joya Zou
 * @date 2021年12月07日 9:51
 */
public class Edge {

    int weight = 0;
    Node from;
    Node to;

    public Edge(int weight, Node from, Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}
