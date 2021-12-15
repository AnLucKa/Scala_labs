import scala.collection.mutable
import scala.math.pow
import scala.collection.mutable.ArrayBuffer
//import scala.collection.immutable.ArraySeq

object tasks extends App {
  println("Задание 12:")

  def countdown(n: Int) {
    for (i <- (0 to n).reverse) println(i)
  }

  countdown(10)

  println
  println("Задание 13:")
  var s13: Long = 1
  for (i <- "World!") s13 = s13 * i.toLong
  println(s13)

  println
  println("Задание 14:")
  val str14: String = "World!"

  def toL(x: Char) = x.toLong

  def func14(str: String): mutable.Buffer[Long] = str.map(toL: Char => Long).toBuffer

  def product(ar: mutable.Buffer[Long]): Long = {
    if (ar.length == 1) ar(0)
    else {
      var result = ar.remove(0)
      result * product(ar)
    }
  }

  print(product(func14(str14)))

  println
  println("Задание 16:")

  def func16(str: String): Long = {
    if (str.length == 1)
      str.charAt(0).toLong
    else {
      str.take(1).charAt(0).toLong * func16(str.drop(1))
    }
  }

  println(func16(str14))

  println
  println("Задание 17:")

  def F16(x: Double, n: Int): Double = {
    if (n == 0) 1
    else if (n > 0) {
      if (n % 2 == 1) x * F16(x, n - 1)
      else x * F16(x, n / 2)
    }
    else 1 / F16(x, -n)
  }

  print(F16(3.0, 8))

  println
  println("Задание 18:")

  def f18(n: Int, m: Int) = (n to m).filter(x => x.toString.toSet.mkString == x.toString).sum

  print(f18(21, 23))

  println
  println("Задание 19:")
  def flatList(ls: List[Any]): List[Any]= {
    ls.flatMap{case i: List[_] => flatList(i)
    case e => List(e)
    }
  }
  println(flatList((List(List(1, 1), 2, List(3, List(5, 8))))))


  println
  println("Задание 20:")
  def func20(n: Int) = {
    var N = n
    var k = 2
    while (k != N) {
      if (N % k == 0) N = N/k
      else k +=1
    }
    N.toString().map(_-'0').sum
  }
  print(func20(13195))

  println
  println("Задание 21:")
  def repeatK(k:Int, l :List[Any]) :List[Any] = l.flatMap(x => List.fill(k) (x))
  println(repeatK(3, List(3,65,7,3)))

  println("Задание 23:")
  def deleteK(k:Int, l :List[Any]) :List[Any] = l.filter(x => (l.indexOf(x)+1) % k != 0)
  println(deleteK(3, List(3,65,7,3)))

  println("Задание 24:")
  def leastCmmonMltiple(a: BigInt, b: BigInt): BigInt = a * b / a.gcd(b)
  println(leastCmmonMltiple(5,12))

  println("Задание 26:")
  def func26(n: Int, k:Int) :Int = {
    if ((n==k) || (k == 0)) {return 1}
    else if (k == 1) {return n}
    else func26(n-1,k) + func26(n-1,k-1)
  }
  println(func26(7,3))

  println("Задание 27:")
  def moveToLeft[Any](k: Int, list: List[Any]): List[Any] ={
    val kK = if (list.isEmpty) 0 else k % list.length
    if (kK < 0) moveToLeft(kK + list.length, list)
    else (list drop kK) ::: (list take kK)
  }
  println(moveToLeft(2,List('a','b','c','d','e')))

  println("Задание 28:")
  def maxPerfectNum(N: Int):Unit ={
    var n = 0
    for (i <- (1 to N)) {
      var sum = 0;
      for (n <- (1 to i)){
        if(i % n == 0 && i != n){
          sum = sum + n
        }
      }
      if (sum == i){
        n = i
      }
    }
    n
  }
  print(maxPerfectNum(99))

  println("Задание 29:")
  def getTwoLits[A](list: List[A]) = {
    val odd= list.filter(x => (list.indexOf(x)) % 2 != 0)
    val even = list.filter(x => (list.indexOf(x)) % 2 != 1)
    (odd,even)
  }
  println(getTwoLits(List(1,2,3,4,5)))

  println("Задание 30:")
  def getNumber(n:Int) = {
    var magicNumber = 0;
    for (i <- 0 to n){
      for (j <- 2 to 50){
        var powNum = BigInt(i) pow j
        if (powNum.toString().toCharArray.map(x => x.toString.toInt).sum == i){
          if(i > magicNumber){
            magicNumber = i}
        }
      }
    }
    magicNumber
  }
  println(getNumber(512))

  println("Задание 31:")
  def getListsFromTuple(list: List[(Int, String)]) = {
    var a = new ArrayBuffer[Int]
    var b = new ArrayBuffer[String]
    (0 to list.size - 1).foreach(x => {
      a += list(x)._1
      b += list(x)._2
    })
    List(a.toList, b.toList)
  }
  println(getListsFromTuple(List((1,"abc"),(2,"zxc"),(3,"asd"))))
}

