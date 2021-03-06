package com.tutorial.graphX

import com.tutorial.utils.SparkCommon
import org.apache.spark.graphx._

import org.apache.spark.rdd.RDD

/**
  * Basic operations
  * Created by ved on 20/2/16.
  */
object Operations {

  val sc = SparkCommon.sparkContext

  def main(args: Array[String]) {

    /**
      * First we Load the vertex data in an array:
      */

    val vertices = Array(
      (1L, ("Delhi", "India")),
      (2L, ("Agra" ,"India")),
      (3L, ("Lucknow", "India")))

    /**
      * Load the array of vertices into the RDD of vertices:
      *
      */

    val verticeRdd = sc.parallelize(vertices)

    /**
      *
      * Load the edge data in an array:
      */
    val edges = Array(
      Edge(1L, 2L, 210),
      Edge(2L, 3L, 296),
      Edge(3L, 1L, 420))


    /**
      * Load the data into the RDD of edges:
      */

    val edgesRdd = sc.parallelize(edges)

    /**
      * Create the graph:
      */

    val graph = Graph(verticeRdd, edgesRdd)

    /**
      * Print all the vertices of the graph:
      */

    graph.vertices.collect.foreach(println)

    /**
      * Print all the edges of the graph:
      */

    graph.edges.collect.foreach(println)

    /**
      * Triplet
      * Print the edge triplets;
      * a triplet is created by adding source and destination attributes
      * to an edge:
      */

    graph.triplets.collect.foreach(println)

    /**
      * In-degree of a graph is the number of inward-directed edges it has. Print the in-degree
      * of each vertex (as VertexRDD[Int] ):
      */

    graph.inDegrees.foreach(println)




  }

}
