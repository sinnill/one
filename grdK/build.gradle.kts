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
tasks.create<Copy>("cacheToLocalMavenRepository"){
    from(file(gradle.gradleUserHomeDir.path + "caches/modules-2/files-2.1"))
    into(repositories.mavenLocal().url)
    eachFile {
        val parts = this.path.split('/')
        this.path = (parts[0] + '/' + parts[1]).replace('.', '/') + '/' + parts[2] + '/' + parts[4]
    }
    includeEmptyDirs = false
}