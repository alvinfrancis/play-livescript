/// Project

name := "play-livescript"

sbtPlugin := true

version := "0.1.1"

organization := "com.github.otfoo"

description := "sbt plugin for handling LiveScript assets in Play"

/// Repositories

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

/// Dependencies

libraryDependencies ++= Seq(
)

addSbtPlugin("play" % "sbt-plugin" % "2.1.1")

/// Publish to local Play; specify this via sbt -Dplay.path=/your/play/path
publishTo := Some(playRepository)

publishMavenStyle := false
