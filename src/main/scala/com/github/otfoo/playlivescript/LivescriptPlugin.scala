package com.github.otfoo.playlivescript

import sbt._
import sbt.Keys._
import PlayProject._

object LivescriptPlugin extends Plugin {

  val lsEntryPoints = SettingKey[PathFinder]("play-livescript-entry-points")
  val lsOptions = SettingKey[Seq[String]]("play-livescript-options")
  val LivescriptWatcher = PlayProject.AssetsCompiler("livescript",
    (_ ** "*.ls"),
    lsEntryPoints,
    { (name, min) => name.replace(".ls", ".js") },
    { LivescriptCompiler.compile _ },
    lsOptions
  )

  override val settings = Seq(
    lsEntryPoints <<= (sourceDirectory in Compile).apply(base => ((base / "assets" ** "*.ls") --- base / "assets" ** "_*")),
    lsOptions := Seq.empty[String],
    resourceGenerators in Compile <+= LivescriptWatcher
  )

}
