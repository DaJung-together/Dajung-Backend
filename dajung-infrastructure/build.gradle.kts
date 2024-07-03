dependencies {
    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // mysql
    runtimeOnly("com.mysql:mysql-connector-j")

    // h2
    runtimeOnly("com.h2database:h2")
}