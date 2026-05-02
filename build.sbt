import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val fastjson = (project in file("."))
  .settings(name := "fastjson")
  .aggregate(
    fastjsonDemo.jvm,
    fastjsonDemo.js,
  )

lazy val fastjsonDemo = (crossProject(JVMPlatform, JSPlatform) in file("fastjson-demo"))
  .settings(name := "fastjson-demo")
  .settings(crossTestDependencies(scalaTest.flatSpec))
  .jvmSettings(
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

