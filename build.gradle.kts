plugins {
    java
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
}

val applicationVersion : String by project
val group : String by project

allprojects {
    group = group
    version = applicationVersion

    repositories {
        mavenCentral()
    }

}

subprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    java {
        sourceCompatibility = JavaVersion.VERSION_17
    }

    dependencies {
        // lombok
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")

        // jackson
        implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")

        // test
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.getByName("bootJar") {
        enabled = false
    }

    tasks.getByName("jar") {
        enabled = true
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

