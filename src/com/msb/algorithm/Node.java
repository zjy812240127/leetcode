package com.msb.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 图中的点
 * @author Joya Zou
 * @date 2021年12月07日 9:43
 */
public class Node {
    // 点的编号
    int value;
    // 该点的入度，指向该点的点数
    int in;
    // 点的出度，该点指向的点数
    int out;
    // 该点指向的所有点（出方向）
    ArrayList<Node> nexts;
    // 该点指向的所有边（出方向）
    ArrayList<Edge> edges ;

    public Node(int value){
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

}
