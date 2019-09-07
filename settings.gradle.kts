rootProject.name = "jackson"

include("test-case")
include("jakson-old")
include("jakson-new")

pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
    }
}
