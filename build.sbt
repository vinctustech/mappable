ThisBuild / versionScheme := Some("semver-spec")

lazy val mappable = crossProject(JSPlatform, JVMPlatform, NativePlatform).in(file(".")).
  settings(
    name := "mappable",
    version := "0.1.2",
    scalaVersion := "2.13.6",
    scalacOptions ++=
      Seq(
        "-deprecation", "-feature", "-unchecked",
        "-language:postfixOps", "-language:implicitConversions", "-language:existentials", "-language:dynamics",
        "-Xasync"
      ),
    organization := "com.vinctus",
    githubOwner := "vinctustech",
    githubRepository := "mappable",
    resolvers += Resolver.githubPackages("edadma", "cross-platform"),
    mainClass := Some("com.vinctus.mappable.Main"),
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.5" % "test",
    libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value % Provided,
    publishMavenStyle := true,
    Test / publishArtifact := false,
    licenses += "ISC" -> url("https://opensource.org/licenses/ISC")
  ).
  jvmSettings(
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % "1.0.0" % "provided"
  ).
  nativeSettings(
    nativeLinkStubs := true
  ).
  jsSettings(
    jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv(),
//    Test / scalaJSUseMainModuleInitializer := true,
//    Test / scalaJSUseTestModuleInitializer := false,
    Test / scalaJSUseMainModuleInitializer := false,
    Test / scalaJSUseTestModuleInitializer := true,
    scalaJSUseMainModuleInitializer := true,
  )
