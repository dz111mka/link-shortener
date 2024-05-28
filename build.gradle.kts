plugins {
    id ("java")
    id("org.springframework.boot") version "3.3.0"

}

group = "ru.chepikov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.3.0")

}
