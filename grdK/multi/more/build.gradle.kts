plugins {
    id("org.jetbrains.dokka") version "0.9.17"
    java
    `java-library`                                 //java
    groovy                                        //groovy
    kotlin("jvm") version "1.3.10"      //kotlin
//    scala                                        //scala
}
task<Copy>("copy") {
    description = "Copies sources to the dest directory"
    group = "Custom"

    from("src")
    into("dest")
}
task<Zip>("zip") {
    description = "Archives sources in a zip file"
    group = "Archive"

    from("src")
}
tasks {
    getByName<Jar>("jar") {
        manifest {
            attributes(
              mapOf("Implementation-Title" to project.name,
                "Implementation-Version" to project.version)
            )
        }
    }
    jar {
        manifest {
            attributes(
              mapOf("Implementation-Title" to project.name,
                "Implementation-Version" to project.version)
            )
        }
    }
    dokka {
        outputFormat = "html"
        outputDirectory = "$buildDir/javadoc"
    }
}
dependencies {
    api("org.apache.commons:commons-math3:3.6.1")
    implementation("com.google.guava:guava:23.0")
    implementation(kotlin("stdlib","1.3.10"))                           //kotlin
    implementation("org.codehaus.groovy:groovy:2.4.15")               //groovy
//    implementation("org.scala-lang:scala-library:2.13.0-M5")                      //scala
    testImplementation("junit:junit:4.12")
    testImplementation("org.spockframework:spock-core:1.1-groovy-2.4")         //groovy
//    testImplementation("org.scalatest:scalatest_2.13.0-M2:3.2.0-SNAP10")                                     //scala
//    testRuntime("org.scala-lang.modules:scala-xml_2.13.0-M5:1.1.1")                            //scala
}
tasks.withType<JavaCompile> {
    options.isIncremental = true
    options.isFork = true
    options.compilerArgs = listOf("-Xdoclint:none", "-Xlint:none", "-nowarn")
}
