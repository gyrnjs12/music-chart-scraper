dependencies {
    implementation(project(":chart-crawler-core"))
    implementation("org.springframework.cloud:spring-cloud-starter-function-web:3.2.8")
    implementation("org.springframework.cloud:spring-cloud-function-kotlin:3.2.8")
    implementation("org.springframework.cloud:spring-cloud-function-adapter-aws:3.2.8")
    implementation("com.amazonaws:aws-lambda-java-events:3.11.0")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.2")
    runtimeOnly("com.amazonaws:aws-lambda-java-log4j2:1.5.1")
}

tasks.register<Zip>("buildZip") {
    from(tasks.named("compileJava", JavaCompile::class))
    from(tasks.named("processResources"))
    into("lib") {
        from(configurations.named("runtimeClasspath"))
    }
}