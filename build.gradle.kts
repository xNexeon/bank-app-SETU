plugins {
    kotlin("jvm") version "2.0.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.thoughtworks.xstream:xstream:1.4.20") // Add XStream dependency
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}




kotlin {
    jvmToolchain(16)
}