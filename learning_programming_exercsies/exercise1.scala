 object Solution extends App {

   def f(n: Int): Unit = {
      println("Hello World")
      if(n!=1){
        f(n-1)
      }
    }

    var n = scala.io.StdIn.readInt
    f(n)
}


