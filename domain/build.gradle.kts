plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.kotlin.corutiens.core)

    testImplementation(libs.junit)
    testImplementation(libs.kotlin.corutiens.test)
    testImplementation(libs.turbine)
    testImplementation(libs.mockk)
}
