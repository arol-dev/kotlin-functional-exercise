repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm") version "2.0.20"
    application
}

group = "dev.arol"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}

