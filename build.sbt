
ThisBuild / scalaVersion := "2.13.6"
ThisBuild / organization := "ru.megains"

val lwjglVersion = "3.2.3"

lazy val mge = (project in file("."))
        .settings(

            name := "MGE",

            version := "0.1",

            libraryDependencies ++= Seq(
                "org.joml" % "joml" % "1.9.0",
                "org.lwjgl" % "lwjgl" % lwjglVersion,
                "org.lwjgl" % "lwjgl-glfw" % lwjglVersion,
                "org.lwjgl" % "lwjgl-opengl" % lwjglVersion,
                "org.lwjgl" % "lwjgl-stb" % lwjglVersion,


                "org.lwjgl" % "lwjgl" % lwjglVersion classifier "natives-windows" classifier "natives-linux" classifier "natives-macos",
                "org.lwjgl" % "lwjgl-glfw" % lwjglVersion classifier "natives-windows" classifier "natives-linux" classifier "natives-macos",
                "org.lwjgl" % "lwjgl-opengl" % lwjglVersion classifier "natives-windows" classifier "natives-linux" classifier "natives-macos",
                "org.lwjgl" % "lwjgl-stb" % lwjglVersion classifier "natives-windows" classifier "natives-linux" classifier "natives-macos",
            )
        )




