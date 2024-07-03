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
//    implementation(project(":data"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}