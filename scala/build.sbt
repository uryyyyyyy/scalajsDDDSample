name := """scalajsDDDSample"""

lazy val commonSettings = Seq(
  organization := "com.github.uryyyyyyy",
  scalaVersion := "2.11.8",
  version := "0.1.0"
)

lazy val server = (project in file("server"))
  .dependsOn(core)
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
    )
  ).enablePlugins(PlayScala)

lazy val core = (project in file("core"))
  .settings(commonSettings)

lazy val front = (project in file("front"))
  .settings(commonSettings)
  .dependsOn(core)
  .settings(
    scalaJSModuleKind := ModuleKind.CommonJSModule
  ).enablePlugins(ScalaJSPlugin)
