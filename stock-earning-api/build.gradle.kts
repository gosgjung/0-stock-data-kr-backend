tasks.getByName("bootJar"){
	enabled = true
}

tasks.getByName("jar"){
	enabled = false
}

dependencies {
	// spring-boot-starter
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	// h2
	runtimeOnly("com.h2database:h2")
	// kafka
	implementation("org.apache.kafka:kafka-streams")
	implementation("org.springframework.kafka:spring-kafka")
	// jackson
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	//gson
	implementation("com.google.code.gson:gson:2.8.9")
	// selenium
	implementation("org.seleniumhq.selenium:selenium-java:4.5.0")
	implementation("org.seleniumhq.selenium:selenium-chrome-driver:4.5.0")
	// jsoup
	implementation("org.jsoup:jsoup:1.14.3")
	// test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")
}