name := """prueba"""
organization := "co.com.ceiba.prueba"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.7"

libraryDependencies += guice
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"
libraryDependencies += javaJpa
libraryDependencies += "org.hibernate" % "hibernate-core" % "5.2.17.Final"
libraryDependencies += "com.rabbitmq" % "amqp-client" % "5.5.2"
libraryDependencies += "org.jdbi" % "jdbi3-core" % "3.5.1"
//libraryDependencies += "org.jdbi" % "jdbi3-jpa" % "3.5.1"












