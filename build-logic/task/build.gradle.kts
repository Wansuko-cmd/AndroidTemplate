plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("ktlint") {
            id = "com.template.ktlint"
            implementationClass = "KtlintPlugin"
        }
    }
}
