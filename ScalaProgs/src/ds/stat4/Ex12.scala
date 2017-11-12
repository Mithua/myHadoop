package ds.stat4

package com {
  package nimbletech {
    package scala1 {
      class Employee(id: Int) {
        def description = "Employee id is: " + id
      }      
    }
  }
}

package org {
  package nimbletech {
    class Counter {
      private var value = 0 
      def increment() { value += 1 } 
      def description = "Counter Value is " + value
    }
  }
}

object Main12 extends App {
  val jay = new com.nimbletech.scala1.Employee(1729)
  // val vishal = new com.nimbletech.scala1.Manager("Vishal")
  // val myCounter = new org.nimbletech.Counter
  println(jay + ": " + jay.description)
  //println(vishal + ": " + vishal.description)
  //println(myCounter + ": " + myCounter.description)
}
