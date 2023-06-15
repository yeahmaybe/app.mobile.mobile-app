val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val postgres_version : String by project
val h2_version : String by project
val exposed_version: String by project

plugins {
    kotlin("jvm") version "1.8.21"
    id("io.ktor.plugin") version "2.2.3"
                id("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"
}

group = "app.mobile"
version = "0.0.1"
application {
    mainClass.set("app.mobile.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

ktor {
    docker {
        jreVersion.set(io.ktor.plugin.features.JreVersion.JRE_11)

        portMappings.set(listOf(
            io.ktor.plugin.features.DockerPortMapping(
                8081,
                8080,
                io.ktor.plugin.features.DockerPortMappingProtocol.TCP
            )
        ))
    }
}


dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-cio-jvm:$ktor_version")

    implementation("org.postgresql:postgresql:$postgres_version")
    //implementation("com.h2database:h2:$h2_version")
    //implementation("androidx.core:core-ktx:$kotlin_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposed_version")

    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlin_version")



    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")


}