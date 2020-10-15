package packageTest

object helloWorld extends App {
  println("Hello world !")
  println("Calling methods from case class:")
  println(MyPackageClass(myClassParam = 6).myMethod(x = 10))
  println("Calling object from other package:")
  println(mainPackageProgram)
}
