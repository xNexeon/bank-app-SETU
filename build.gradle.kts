plugins {
    kotlin("jvm") version "2.0.10"
    id("org.jetbrains.dokka") version "1.9.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.thoughtworks.xstream:xstream:1.4.21") // Add XStream dependency
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0") //JUnit dependency
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}




kotlin {
    jvmToolchain(16)
}