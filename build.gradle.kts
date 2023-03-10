import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.4"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("plugin.jpa") version "1.7.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-tomcat")
	implementation("org.springframework.boot:spring-boot-starter-web-services")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springdoc", "springdoc-openapi-kotlin", "1.6.11")
	implementation("org.springdoc", "springdoc-openapi-ui", "1.6.11")
	implementation("mysql:mysql-connector-java")
	implementation("io.github.microutils", "kotlin-logging-jvm", "2.1.23")
	implementation("org.springframework.cloud", "spring-cloud-starter-sleuth", "3.1.3")
    implementation("com.vladmihalcea:hibernate-types-52:2.21.1")
	implementation("com.google.code.gson", "gson", "2.8.8")
	implementation("com.amazonaws:aws-java-sdk-s3:1.11.1015")
	implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE")
	implementation ("org.springframework.boot:spring-boot-configuration-processor:2.6.3")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
