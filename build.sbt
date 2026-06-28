import com.peknight.build.gav
import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val fastjson = (project in file("."))
  .settings(name := "fastjson")
  .aggregate(fastjsonDemo.projectRefs *)

lazy val fastjsonDemo = (projectMatrix in file("fastjson-demo"))
  .settings(name := "fastjson-demo")
  .settings(libraryDependencies ++= testDependencies(scalaTest.flatSpec))
  .jvmPlatform(
    scalaVersions = Seq(scala.scala3.version),
    settings = Seq(
      javacOptions ++= lombok.processorOptions,
      Compile / doc / javacOptions := {
        val originalOptions = (Compile / doc / javacOptions).value
        originalOptions.filterNot(lombok.processorOptions.contains)
      },
      libraryDependencies ++= jvmDependencies(
        alibaba.fastjson2,
        lombok,
      ),
    )
  )
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))
