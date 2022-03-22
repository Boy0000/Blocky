val idofrontVersion: String by project

plugins {
    id("com.mineinabyss.conventions.kotlin")
    id("com.mineinabyss.conventions.papermc")
    id("com.mineinabyss.conventions.nms")
}

repositories {
    mavenCentral()
    maven("https://repo.mineinabyss.com/releases")
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.spongepowered.org/maven/") // Mixins
}

dependencies {
    // Shaded
    implementation("com.mineinabyss:idofront:$idofrontVersion")

    // Mixins
    compileOnly("space.vectrix.ignite:ignite-api:0.7.4")
    compileOnly("org.spongepowered:mixin:0.8.5")
}

//tasks {
//    register<Copy>("copyMod") {
//        from(shadowJar)
//        into(modPath)
//        doLast {
//            println("Copied to plugin directory $modPath")
//        }
//    }
//
//    build {
//        dependsOn("copyMod")
//    }
//}
