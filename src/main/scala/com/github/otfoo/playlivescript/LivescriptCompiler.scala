package com.github.otfoo.playlivescript

import sbt.PlayExceptions._
import scala.sys.process._
import sbt.File
import scala.util.control.Exception.catching

object LivescriptCompiler {

  def compile(source: File, options: Seq[String]): (String, Option[String], Seq[File]) = {
    val command = "livescript" +: "-c" +: "-p" +: options :+ source.getAbsolutePath

    try {
      val out = captureOutput(command)
      val minified = None
      (out, minified, Seq(source))
    } catch {
      case ex: LivescriptException => {
        throw AssetCompilationException(Some(source), ex.message, Some(ex.line), None)
      }
    }
  }

  private val xMessageLine = """(.*)on line (\d+).*""".r

  private class LivescriptException(error: String) extends RuntimeException {
    val (message: String, line: Int) = error match {
      case xMessageLine(m, l) => (m, Some(l.toInt).getOrElse(0))
      case e => (e, 0)
    }
  }

  private def captureOutput(command: ProcessBuilder): String = {
    var err: String = ""
    val out = new StringBuilder

    val capturer = ProcessLogger(
      (output: String) => out.append(output + "\n"),
      (error: String) => err = error)

    val process = command.run(capturer)
    if (process.exitValue == 0)
      out.toString()
    else
      throw new LivescriptException(err)
  }

}
