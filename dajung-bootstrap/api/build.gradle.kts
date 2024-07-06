plugins {
    id ("org.asciidoctor.jvm.convert") version ("3.3.2")
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    // module
    implementation(project(":dajung-core"))
    runtimeOnly(project(":dajung-infrastructure"))

    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
}
