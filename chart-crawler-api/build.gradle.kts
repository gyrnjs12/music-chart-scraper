plugins {
    id("java")
}

group = "org.chart"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":chart-crawler-core"))
    implementation(project(":chart-crawler-infra"))
    implementation("org.springframework:spring-web")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}