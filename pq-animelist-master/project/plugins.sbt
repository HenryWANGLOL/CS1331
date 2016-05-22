libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.10"

resolvers += "CS 1331 Repository" at "http://repo.tweedbathrobe.com"
addSbtPlugin("org.cs1331" % "git-submitter-plugin" % "0.6")
addSbtPlugin("com.etsy" % "sbt-checkstyle-plugin" % "0.5.2")
