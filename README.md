# Mapper

[![pipeline status](https://gitlab.com/LeMilliard/Mapper/badges/master/pipeline.svg)](https://gitlab.com/LeMilliard/Mapper/commits/master)

Librairie qui permet d'analyser et traiter des phrases en se basant sur un ensemble de dictionnaires.

### Sommaire

* [Configuration](#configuration)
  * [Configuration d'une version en cours de développement](#configuration-dune-version-en-cours-de-développement)
* [Utilisation](#utilisation)

### Configuration

Avant toute chose, il est conseillé de consulter le fichier [LEMILLIARD.md](LEMILLIARD.md)

Veillez à bien utiliser Maven comme gestionnaire de dépendances.

Il vous suffit alors d'ajouter la dépendance suivante à votre `pom.xml`:

```xml
<dependencies>
    <!-- Other dependencies -->
    <dependency>
        <groupId>com.lemilliard</groupId>
        <artifactId>mapper</artifactId>
        <version>${version}</version>
    </dependency>
</dependencies>
```

Remplacez `${version}` par le tag de la version désirée.

##### Configuration d'une version en cours de développement

Afin d'utiliser la dernière version de cette librairie, 

```sh
mvn install
```

### Utilisation

// TODO