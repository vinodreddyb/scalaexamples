
trait TestPartial {
  type Receive = PartialFunction[Any, String]

  def receive:Receive
}

class TestPartialFunctions extends TestPartial {

  case class Greeting(greeting: String)


  def receive = {
    case Greeting(greeting) =>
      "Greeting received (from " + "): " + greeting
  }
}

object TestPartialFunctions {
  def main(args: Array[String]): Unit = {
    val pf = new TestPartialFunctions
    val ss = pf.receive(pf.Greeting("HI"));
    println(ss)
  }
}
