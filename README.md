# Projet de base libGDX

Un projet [libGDX](https://libgdx.com/) généré avec [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

Ce projet a été généré avec un modèle incluant des lanceurs d'applications simples et une extension `ApplicationAdapter` qui dessine le logo de libGDX.

## Plateformes

- `core` : Module principal contenant la logique de l'application partagée par toutes les plateformes.
- `lwjgl3` : Plateforme principale pour le bureau utilisant LWJGL3 ; était appelé 'desktop' dans les documents plus anciens.

## Gradle

Ce projet utilise [Gradle](https://gradle.org/) pour gérer les dépendances.
Le wrapper Gradle est inclus, vous pouvez donc exécuter les tâches Gradle en utilisant les commandes `gradlew.bat` ou `./gradlew`.
Tâches et options utiles de Gradle :

- `--continue` : avec cette option, les erreurs n'arrêteront pas l'exécution des tâches.
- `--daemon` : grâce à cette option, le daemon Gradle sera utilisé pour exécuter les tâches choisies.
- `--offline` : avec cette option, les archives de dépendances mises en cache seront utilisées.
- `--refresh-dependencies` : cette option force la validation de toutes les dépendances. Utile pour les versions snapshot.
- `build` : compile les sources et crée des archives pour chaque projet.
- `cleanEclipse` : supprime les données de projet Eclipse.
- `cleanIdea` : supprime les données de projet IntelliJ.
- `clean` : supprime les dossiers `build`, qui contiennent les classes compilées et les archives créées.
- `eclipse` : génère les données de projet Eclipse.
- `idea` : génère les données de projet IntelliJ.
- `lwjgl3:jar` : construit le jar exécutable de l'application, que vous pouvez trouver dans `lwjgl3/build/libs`.
- `lwjgl3:run` : démarre l'application.
- `test` : exécute les tests unitaires (le cas échéant).

Notez que la plupart des tâches qui ne sont pas spécifiques à un projet unique peuvent être exécutées avec le préfixe `name:`, où `name` doit être remplacé par l'ID d'un projet spécifique.
Par exemple, `core:clean` supprime le dossier `build` uniquement du projet `core`.
