val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val prometeus_version: String by project
val jdbi3_version: String by project
val postgresql_version: String by project
val koin_version: String by project
val hikari_version: String by project

plugins {
    application
    kotlin("jvm") version "1.6.10"
}

group = "com.tbarauskas"
version = "0.0.1"
application {
    mainClass.set("com.tbarauskas.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-metrics-micrometer:$ktor_version")
    implementation("io.micrometer:micrometer-registry-prometheus:$prometeus_version")
    implementation("io.ktor:ktor-thymeleaf:$ktor_version")
    implementation("io.ktor:ktor-jackson:$ktor_version")
    implementation("io.ktor:ktor-server-jetty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

//    koin
    implementation("io.insert-koin:koin-core:$koin_version")
    implementation("io.insert-koin:koin-ktor:$koin_version")

    //    dataBase
    implementation("org.jdbi:jdbi3-core:$jdbi3_version")
    implementation("org.jdbi:jdbi3-kotlin:$jdbi3_version")
    implementation("org.jdbi:jdbi3-sqlobject:$jdbi3_version")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject:$jdbi3_version")
    implementation("org.postgresql:postgresql:$postgresql_version")
    implementation("com.zaxxer:HikariCP:$hikari_version")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
