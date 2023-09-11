dependencies {
    implementation(project(":chart-crawler-core"))
    implementation("com.amazonaws:aws-lambda-java-core:1.2.2")
    implementation("com.amazonaws:aws-lambda-java-events:3.11.1")
    runtimeOnly("com.amazonaws:aws-lambda-java-log4j2:1.5.1")
}