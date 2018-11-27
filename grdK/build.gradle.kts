allprojects {
    group = "one"
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }
}
version = "1.0-SNAPSHOT"
subprojects {
    version = "1.0-SNAPSHOT"
}
task<Copy>("cacheToLocalMavenRepository"){
    from(File(gradle.gradleUserHomeDir.path ,"caches/modules-2/files-2.1"))
    into(repositories.mavenLocal().url)
    eachFile {
        val parts = this.path.split("/")
        print(this.path)
        this.path = (parts[0] + '/' + parts[1]).replace('.', '/') + '/' + parts[2] + '/' + parts[4]
    }
    includeEmptyDirs = false
}