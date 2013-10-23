import sbtrelease._
import ReleaseStateTransformations._

name := "test-api"

libraryDependencies ++= Seq(
     "joda-time" % "joda-time" % "2.3"
)

publishMavenStyle := false

publishTo <<= (isSnapshot, s3credentials) {
    (snapshot, credentials) =>
    val prefix = if(snapshot) "snapshots" else "releases"
    credentials map S3Resolver(
        "KonciergeMD Repo",
        "s3://konciergemd-repo",
        Resolver.ivyStylePatterns
        ).toSbtResolver
}

releaseSettings
