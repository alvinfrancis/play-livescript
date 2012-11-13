/// Project

name := "play-livescript"

sbtPlugin := true

version := "0.1"

scalaVersion := "2.9.1"

organization := "com.github.otfoo"

description := "sbt plugin for handling LiveScript assets in Play"

/// Repositories

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

/// Dependencies

libraryDependencies ++= Seq(
  "play" %% "play" % "2.0.4",
  "play" % "sbt-plugin" % "2.0"
)

/// Publish to local Play; specify this via sbt -Dplay.path=/your/play/path
publishTo := Some(playRepository)

publishMavenStyle := false
