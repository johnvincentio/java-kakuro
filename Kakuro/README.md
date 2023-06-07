# Kakuro

* [KakuroConquest](https://www.kakuroconquest.com/)
* [Kakuro](https://www.kakuros.com/)
* [Puzzle Kakuro](https://www.puzzle-kakuro.com/0

Use this application as an aid:

* Count = the number provided
* Squares = the number of squares used to create the number provided

## Github

At Github, create repository `java-kakuro`

repo: https://github.com/johnvincentio/java-kakuro

```
cd /Users/jv/Desktop/MyDevelopment/github/java/Games
create-repo java-kakuro
```

Remove non-relevant files.

## Add `README.md`

```
cd java-kakuro
```

Create `README.md`

```
For details, see Kakuro/README.md
```

## Start Eclipse

in Finder

* select `/Users/jv/Desktop/MyDevelopment/github/java/Games/java-kakuro`
* Right click, Services
  * eclipse-jee

## Create Java Project

* File, New, Project
* Java Project

Settings

* Project Name: Kakuro
* Use default location
* JRE; Use an execution environment JRE: JavaSE-1.8
* Create separate folders for sources and class files

* Default output folder: `Kakuro/classes`

## Package

Select `src`

* Right click, New, Package
* `io.johnvincent.kakuro`

Copy code to this package and change package names.

## Script file

`/Users/jv/Desktop/MyDevelopment/github/java/Games/java-kakuro/Kakuro/app.command`

```
#!/bin/sh
#
# script to run java app kakuro
#
echo "begin"
#
DEV_HOME=/Users/jv/Desktop/MyDevelopment/github/java/Games/java-kakuro/Kakuro/classes
#
MYCP=$DEV_HOME
#
java -cp $MYCP io.johnvincent.kakuro.Appgui
#
echo "end"
```

## Create Alias

In Finder

* select `app.command`
* right click, Make Alias
* rename to `kakuro.command`
* move alias to `/Users/jv/Desktop/MyDevelopment/github/repo_shell_scripts/mac/unix-scripts/bin/`

