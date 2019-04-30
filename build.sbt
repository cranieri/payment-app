name := "provider"

version := "0.1"

scalaVersion := "2.12.6"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

scalacOptions += "-Ypartial-unification"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "com.example",
      scalaVersion    := "2.12.6"
    )),
    name := "My Akka HTTP Project",
    libraryDependencies ++= Seq(
      "org.scalatest"     %% "scalatest"            % "3.0.5"         % Test,
      "org.scalactic" %% "scalactic" % "3.0.5",
      "org.typelevel"              %% "cats-core"            % "1.6.0",
      "org.typelevel"              %% "cats-effect"          % "1.2.0"
    )
  )
