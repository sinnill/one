plugins {
    `java-library`                                 //java
    groovy                                        //groovy
    kotlin("jvm") version "1.3.10"      //kotlin
//    scala                                        //scala
}
dependencies {
    api("org.apache.commons:commons-math3:3.6.1")
    implementation("com.google.guava:guava:23.0")
    implementation(kotlin("stdlib","1.3.10"))                           //kotlin
    compile("org.codehaus.groovy:groovy:2.4.15")               //groovy
//    implementation("org.scala-lang:scala-library:2.13.0-M5")                      //scala
    testImplementation("junit:junit:4.12")
    testCompile("org.spockframework:spock-core:1.1-groovy-2.4")         //groovy
//    testImplementation("org.scalatest:scalatest_2.13.0-M2:3.2.0-SNAP10")                                     //scala
//    testRuntime("org.scala-lang.modules:scala-xml_2.13.0-M5:1.1.1")                            //scala
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
}