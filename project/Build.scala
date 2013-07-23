import sbt._
import Keys._

object RayBuild extends Build {
  val playPath = Option(System.getProperty("play.path")).getOrElse("../play")
  val playVersion = Option(System.getProperty("play.version")).getOrElse("2.1.1")

  val playRepository = Resolver.file("Local Play Repository", file(new File(playPath, "repository/local").getPath))(Resolver.ivyStylePatterns)

  lazy val root = Project(id = "play-livescript", base = file("."))
}
