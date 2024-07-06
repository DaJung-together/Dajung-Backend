dependencies {
    implementation(project(":dajung-core"))
    testImplementation(testFixtures(project(":dajung-core")))

    // mysql
    runtimeOnly("com.mysql:mysql-connector-j")

    // h2
    runtimeOnly("com.h2database:h2")
}