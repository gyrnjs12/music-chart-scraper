plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

dependencies {
//    implementation(project(":chart-crawler-core"))
    implementation("org.springframework.cloud:spring-cloud-starter-function-web:4.0.5")
    implementation("org.springframework.cloud:spring-cloud-function-kotlin:4.0.5")
    implementation("org.springframework.cloud:spring-cloud-function-adapter-aws:4.0.5")
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

tasks.assemble {
    dependsOn("shadowJar")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveFileName.set("demo-function.jar")
    dependencies {
        dependency("org.springframework.cloud:spring-cloud-function-web:4.0.5")
    }
    mergeServiceFiles()
    append("META-INF/spring.handlers")
    append("META-INF/spring.schemas")
    append("META-INF/spring.tooling")
    append("META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports")
    append("META-INF/spring/org.springframework.boot.actuate.autoconfigure.web.ManagementContextConfiguration.imports")
    transform(com.github.jengelman.gradle.plugins.shadow.transformers.PropertiesFileTransformer::class.java) {
        paths.add("META-INF/spring.factories")
        mergeStrategy = "append"
    }
}