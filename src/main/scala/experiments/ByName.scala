package experiments

object ByName extends App {
  def myByFunc(f: () => Int) = {
    println("myByFunc")
    f()
    f()
  }
  def myByName(f: => Int) = {
    println("myByName")
    f
    f
  }

  def testFunc(a: Int) = {
    println("hello")
    a * a
  }

  myByFunc(() => testFunc(123))                   //> res0: Int = 15129
  myByName(testFunc(123))                         //> res1: Int = 15129

}