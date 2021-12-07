package com.msb.algorithm;

import java.util.*;

/**
 * 图的表示
 * @author Joya Zou
 * @date 2021年12月07日 9:54
 */
public class Graph {

    HashMap<Integer, Node> nodes;
    HashSet<Edge> edges;

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

}
