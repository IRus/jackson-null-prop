plugins {
    kotlin("jvm")
}

var jackson = "2.9.9"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compileOnly("com.fasterxml.jackson.core:jackson-databind:$jackson")
}
