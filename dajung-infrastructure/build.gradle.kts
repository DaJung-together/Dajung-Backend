dependencies {
    compileOnly(project(":dajung-core"))
    testImplementation(testFixtures(project(":dajung-core")))

    // querydsl
    implementation ("com.querydsl:querydsl-jpa:5.0.0:jakarta")

    // mysql
    runtimeOnly("com.mysql:mysql-connector-j")

    // h2
    runtimeOnly("com.h2database:h2")
}

