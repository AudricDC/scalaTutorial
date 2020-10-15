package packageTest

case class MyPackageClass(myClassParam: Int) {
  def myValue: Int = 5 + myClassParam

  def myMethod(x: Double): Double = myValue + 5
}


object MyPackageObjects {
  def unexhaustive(): String = {
    sealed trait Symbol
    case class Note(name: String, duration: String, octave: Int) extends Symbol
    case class Rest(duration: String) extends Symbol

    def nonExhaustiveDuration(symbol: Symbol): String =
      symbol match {
        case Note(name, duration, octave) => return duration; "50"
      }

    nonExhaustiveDuration(Rest("12"))
  }
}

object mainPackageProgram {
  println(MyPackageClass(myClassParam = 6).myMethod(x = 10))
}


object myPackageProgram extends App {
  """Play with functions"""
  println("Playing with functions")
  val xs = List(1, 2, 3)
  val myFunctions = new myFunctions

  val myList = myFunctions.insert(4, xs)
  println(myList)
  println(myFunctions.sqrt(12).toString)
  for (x <- Range(0, 10)) yield println(myFunctions.f.apply(x))
  println(xs.flatMap(x => Range(1, 3).flatMap(y => List(x, y))))
  println(myFunctions.f.apply(9))
  println(Product.reduce(xs))
  println(Sum.reduce(xs))

  """ Play with classes """
  println("Playing with classes")
  val account1 = new BankAccount(id = 0)
  val account2 = account1
  account2.deposit(50)
  println(account1 == account2)

  val myNewNote = new Note("DO", "Quarter", 3)
  val myNote = Note("DO", "Quarter", 3)
  println(myNewNote.equals(myNote))

  """ Play with lazy evaluations"""
  println("Playing with lazy evaluations")
  var rec = 0

  def llRange(lo: Int, hi: Int): LazyList[Int] = {
    rec = rec + 1
    if (lo >= hi) LazyList.empty
    else LazyList.cons(lo, llRange(lo + 1, hi))
  }

  println(llRange(1, 10).take(3).toList)
  println(rec)

  val builder = new StringBuilder

  val x = {
    builder += 'x';
    1
  }
  lazy val y = {
    builder += 'y';
    2
  }

  def z = {
    builder += 'z';
    3
  }

  z + y + x + z + y + x
  println(builder.result())

  """ Play with list and map"""
  println("Playing with list and map")
  val ages : List[(String, Int)] = List(("ADC",1),("ADC",2),("adc",5),("aDC",1))
  println(ages.groupBy(_._1).map{case (k, v) => k -> v.map { _._2}.sum})
  println(0.until(10).contains(10))
}
