import org.jetbrains.kotlin.gradle.utils.extendsFrom

plugins {
    kotlin("jvm") version "2.0.21"
    id("fabric-loom") version "1.8-SNAPSHOT"
    id ("com.github.johnrengelman.shadow") version "8.1.1"
}

version = project.property("mod_version") as String
group = project.property("maven_group") as String

base {
    archivesName.set(project.property("archives_base_name") as String)
}

java {
    targetCompatibility = JavaVersion.VERSION_21
}

loom {
    splitEnvironmentSourceSets()

    mods {
        register("dneko") {
            sourceSet("client")
        }
    }
}

repositories {
    maven ("https://maven.parchmentmc.org/") {
        content {
            includeGroup("org.parchmentmc.data")
        }
    }
    // TerraformersMC
    maven("https://maven.terraformersmc.com/releases/") {
        content {
            includeGroup("com.terraformersmc")
        }
    }

    // Fuzss modresources
    maven("https://raw.githubusercontent.com/Fuzss/modresources/main/maven/") {
        content {
            includeGroup("fuzs.forgeconfigapiport")
        }
    }

    // Izzel Releases
    maven("https://maven.izzel.io/releases/")

    // Meteor Maven
    maven("https://maven.meteordev.org/releases") {
        name = "Meteor Maven"
    }
    maven("https://maven.meteordev.org/snapshots") {
        name = "Meteor Maven Snapshots"
    }

    // Ladysnake Mods
    maven("https://maven.ladysnake.org/releases") {
        name = "Ladysnake Mods"
        content {
            includeGroup("io.github.ladysnake")
            includeGroup("org.ladysnake")
            includeGroupByRegex("dev\\.onyxstudios.*")
        }
    }

    // JitPack
    maven("https://jitpack.io") {
        name = "JitPack"
    }

    // Modrinth
    maven("https://api.modrinth.com/maven") {
        name = "Modrinth"
        content {
            includeGroup("maven.modrinth")
        }
    }

    // Vram
    maven("https://maven.vram.io//") {
        name = "Vram"
    }

    // Chinese Repo
    maven("https://repository.hanbings.io/proxy") {
        name = "Chinese Repo"
    }

    // Seedfinding Maven
    maven("https://maven.seedfinding.com/") {
        name = "Seedfinding Maven"
    }
    maven("https://maven-snapshots.seedfinding.com/") {
        name = "Seedfinding Maven Snapshots"
    }

    // Curse Maven
    maven("https://www.cursemaven.com") {
        name = "Curse Maven"
    }

    // Masa
    maven("https://masa.dy.fi/maven") {
        name = "Masa"
    }

    // QuiltMC
    maven("https://maven.quiltmc.org/repository/release") {
        name = "QuiltMC"
    }

    // OpenCollab Snapshots
    maven("https://repo.opencollab.dev/maven-snapshots/") {
        name = "OpenCollab Snapshots"
    }

    // Lenni0451
    maven("https://maven.lenni0451.net/everything") {
        name = "Lenni0451"
    }

    // FabricMC
    maven("https://maven.fabricmc.net/")

    // Local flat directory for dependencies
    flatDir {
        dirs("${rootProject.projectDir}/libs")
    }

    mavenCentral()
    mavenLocal()
}

dependencies {
    // To change the versions see the gradle.properties file
    minecraft("com.mojang:minecraft:${project.property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${project.property("yarn_mappings")}:v2")
    modImplementation("net.fabricmc:fabric-loader:${project.property("loader_version")}")
    modImplementation("net.fabricmc:fabric-language-kotlin:${project.property("kotlin_loader_version")}")

    modImplementation("net.fabricmc.fabric-api:fabric-api:${project.property("fabric_version")}")

    implementation("meteordevelopment:orbit:${project.property("orbit_version")}")
    implementation("javazoom:jlayer:1.0.1")
    implementation("com.google.zxing:core:3.5.3")

    implementation("icyllis.modernui:ModernUI-Core:${project.property("core_version")}")
    implementation("icyllis.modernui:ModernUI-Markdown:${project.property("core_version")}")
    implementation("org.vineflower:vineflower:1.10.1")

    implementation("com.github.ben-manes.caffeine:caffeine:${project.property("caffeine_version")}")
    implementation("com.vladsch.flexmark:flexmark:${project.property("flexmark_version")}")

    implementation("com.github.ben-manes.caffeine:caffeine:${project.property("caffeine_version")}")
    implementation("com.vladsch.flexmark:flexmark:${project.property("flexmark_version")}")
    implementation("com.vladsch.flexmark:flexmark-util-ast:${project.property("flexmark_version")}")
    implementation("com.vladsch.flexmark:flexmark-util-builder:${project.property("flexmark_version")}")
    implementation("com.vladsch.flexmark:flexmark-util-collection:${project.property("flexmark_version")}")
    implementation("com.vladsch.flexmark:flexmark-util-data:${project.property("flexmark_version")}")
    implementation("com.vladsch.flexmark:flexmark-util-dependency:${project.property("flexmark_version")}")
    implementation("com.vladsch.flexmark:flexmark-util-format:${project.property("flexmark_version")}")
    implementation("com.vladsch.flexmark:flexmark-util-html:${project.property("flexmark_version")}")
    implementation("com.vladsch.flexmark:flexmark-util-misc:${project.property("flexmark_version")}")
    implementation("com.vladsch.flexmark:flexmark-util-sequence:${project.property("flexmark_version")}")
    implementation("com.vladsch.flexmark:flexmark-util-visitor:${project.property("flexmark_version")}")

    implementation(fileTree(mapOf("dir" to "libs", "includes" to listOf("*.jar"))))

    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
}

configurations {
    shadow.extendsFrom(implementation)
}


tasks.processResources {
    inputs.property("version", project.version)
    inputs.property("minecraft_version", project.property("minecraft_version"))
    inputs.property("loader_version", project.property("loader_version"))
    filteringCharset = "UTF-8"

    filesMatching("fabric.mod.json") {
        expand(
            "version" to project.version,
            "minecraft_version" to project.property("minecraft_version"),
            "loader_version" to project.property("loader_version"),
            "kotlin_loader_version" to project.property("kotlin_loader_version")
        )
    }
}

tasks.withType<JavaCompile>().configureEach {
    // ensure that the encoding is set to UTF-8, no matter what the system default is
    // this fixes some edge cases with special characters not displaying correctly
    // see http://yodaconditions.net/blog/fix-for-java-file-encoding-problems-with-gradle.html
    // If Javadoc is generated, this must be specified in that task too.
    options.encoding = "UTF-8"
}

tasks.jar {
    from("LICENSE")
}

tasks.shadowJar {
    configurations = listOf(project.configurations.getByName("shadow"))

    destinationDirectory.set(tasks.jar.get().archiveFile.get().asFile.parentFile)
    from(tasks.jar.get().archiveFile)

    dependencies {
        exclude {
            it.moduleGroup == "org.slf4j" || it.moduleGroup .startsWith("it.unimi")
        }
    }
}

tasks.remapJar {
    dependsOn(tasks.shadowJar)
    inputFile.set(tasks.shadowJar.get().archiveFile)
}
