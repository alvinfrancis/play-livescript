package de.learnyousome.assets

import sbt._
import sbt.Keys._
import PlayProject._

object StylusPlugin extends Plugin {

  val stylusEntryPoints = SettingKey[PathFinder]("play-stylus-entry-points")
  val stylusOptions = SettingKey[Seq[String]]("play-stylus-options")
  val StylusWatcher = PlayProject.AssetsCompiler("stylus",
    (_ ** "*.styl"),
    stylusEntryPoints,
    { (name, min) => name.replace(".styl", if (min) ".min.css" else ".css") },
    { StylusCompiler.compile _ },
    stylusOptions
  )

  override val settings = Seq(
    stylusEntryPoints <<= (sourceDirectory in Compile).apply(base => ((base / "assets" ** "*.styl") --- base / "assets" ** "_*")),
    stylusOptions := Seq.empty[String],
    (resourceGenerators in Compile) <+= StylusWatcher
  )

}
