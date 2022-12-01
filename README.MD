# Projet Team Manager

## Description

Ce projet permet de gérer une équipe de personnes avec des compétences différentes avec un niveau dans chacune des compétences.

## Prérequis

* Java 11+
* [docker](https://www.docker.com/products/docker-desktop)
* [docker-compose](https://docs.docker.com/compose/install/)
* Un IDE Java ([Eclipse](https://www.eclipse.org/downloads/), [IntelliJ](https://www.jetbrains.com/fr-fr/idea/))

## Installation

### Installation de la base de données

Dans un terminal, exécutez la commande suivante :

```bash
docker-compose up -d
```
### Installation du projet

Dans votre IDE, chargez le projet Maven `pom.xml`.

## Utilisation

### Lancement de l'application sans IDE

Pour lancer l'application, il faut se placer dans le dossier 'teamsmanager' et lancer la commande :

```bash
./mvnw bootRun
```

### Lancement de l'application avec un IDE

Dans votre IDE, lancez la classe `fr.ropi.spring.teamsmanager.TeamsmanagerApplication`.

### Utilisation de l'application

L'application est accessible à l'adresse suivante: [http://localhost:8080](http://localhost:8080)