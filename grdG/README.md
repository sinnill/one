# gradle
- plugins & dependencies 
- build-scan
- docs
- publish

## plugins & dependencies 
- KLib
```$xslt
kotlin("jvm") version "1.2.31"

implementation(kotlin("stdlib", "1.2.31")) 
```
- g
- j
- js
- and
- saca
```$xslt
plugins {
    kotlin("jvm") version "1.2.31" //kotlin lib
    id 'scala' //scala
}
dependencies {
    implementation(kotlin("stdlib", "1.2.31")) //kotlin lib
    compile 'org.scala-lang:scala-library:2.11.12' //scala

    testCompile 'junit:junit:4.12' 
    testCompile 'org.scalatest:scalatest_2.11:3.0.5' //scala

    testRuntime 'org.scala-lang.modules:scala-xml_2.11:1.1.0' //scala
}
```






## build-scan
```$xslt
`build-scan`

buildScan {
    setLicenseAgreementUrl("https://gradle.com/terms-of-service") 
    setLicenseAgree("yes")

    publishAlways() 
}
```
## docs
### KLib

- for KLib
```$xslt
id("org.jetbrains.dokka") version "0.9.16"
val dokka by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class) {    
    outputFormat = "html"
    outputDirectory = "$buildDir/javadoc"
}
```
- for KLib to jar
```$xslt
import org.gradle.jvm.tasks.Jar

val dokkaJar by tasks.creating(Jar::class) { 
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles KLib docs with Dokka"
    classifier = "javadoc"
    from(dokka) 
}
```

## publish
- maven-publish
```$xslt
`maven-publish`

publishing {
    publications {
        create("default", MavenPublication::class.java) { 
            from(components["java"])
            artifact(dokkaJar) 
        }
    }
    repositories {
        maven {
            url = uri("$buildDir/repository") 
        }
    }
}
```
- gradle-publish
