package experiments

import java.net.{URLDecoder, URLClassLoader}
import java.util.jar.JarInputStream
import java.io.FileInputStream

object ClassLoaderUtil extends App {

  val isWindows = {
    val osName = System.getProperty("os.name")
    val isWin = osName.startsWith("Windows")
    println("os.name=" + osName + " isWindows=" + isWin)
    isWin
  }

  def currentJars: Array[String] = {
    val classloader = ClassLoader.getSystemClassLoader

    var jars = classloader.asInstanceOf[URLClassLoader].getURLs.map(_.getFile).map(URLDecoder.decode(_, "UTF-8"))
    if (jars.length == 1 && jars(0).contains("surefirebooter")) {
      jars = surefirebooterJars(jars(0))
    }

    jars = jars.filter(j => !(
      j.contains("/jre/lib/") ||
      j.contains("idea_rt.jar") ||
      j.contains("surefire/surefire-") ||
      j.contains("junit_rt.jar")))

    if (isWindows) jars = jars.map(_.tail)
    jars
  }

  def surefirebooterJars(surefireJar: String): Array[String] = {
    val is = new FileInputStream(surefireJar)
    val jarStream = new JarInputStream(is)
    val mf = jarStream.getManifest
    val mainAttributes = mf.getMainAttributes
    val classpath = mainAttributes.getValue("Class-Path")
    classpath.replaceAll("file:", "").split(" ").toArray
  }

//  val jars = currentJars
  val jars = surefirebooterJars("surefirebooter.jar")
  jars.foreach(println)


}
