import sbtrelease._
import ReleaseStateTransformations._

name := "test-api"

version := "1.0"

libraryDependencies ++= Seq(
     "joda-time" % "joda-time" % "2.3"
)

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/Projects/test-repo")))

releaseSettings
