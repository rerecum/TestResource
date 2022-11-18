package com.example.testresource

import kotlin.math.abs

data class Edge(val node1: Node, val node2: Node, val distance: Int)

class Graph {
    data class IntNode(val i: Int) : Node
    var nodes: List<Edge> = listOf()

    fun addNewEdge(source:Int,destination:Int){
        nodes = nodes + Edge(IntNode(source), IntNode(destination), abs(destination-source))
    }

    fun containsEdge(source: Int,destination: Int):Boolean{
        for (edge in nodes)
            if (edge.node1==IntNode(source) && edge.node2==IntNode(destination))
                return true
        return false
    }

    fun findP(source:Int,destination:Int): String{
        val res = findShortestPath(nodes,IntNode(source),IntNode(destination))

        if (res.shortestPath().isEmpty())
            return "No path available"

        var result: String =""
        for(node in res.shortestPath())
            result+=" ${(node as IntNode).i} ->"
        return "Path found: ${result.substring(0,result.length-3)}"
    }
}