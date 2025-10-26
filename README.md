# README — Jogo Turn-Based (MVP)

## Índice

* [Objetivo](#objetivo)
* [Requisitos / Setup](#requisitos--setup)
  * [JDK](#jdk)
  * [Maven](#maven)
* [Como compilar](#como-compilar)
  * [Usando Maven](#usando-maven)
* [Como rodar](#como-rodar)
  * [Executável JAR](#executável-jar)
  * [Executando via IDE](#executando-via-ide)
* [Estrutura do projeto](#estrutura-do-projeto)

---

## Objetivo

Exercitar conceitos de Programação Orientada a Objetos (POO) e boas práticas de desenvolvimento por meio de um MVP de jogo turn-based em terminal.

---

## Requisitos / Setup

### JDK

* Requisito mínimo: **JDK 17**.
* Como verificar: `java -version`
* Como instalar: `https://www.oracle.com/br/java/technologies/downloads/`

### Maven

* Versão mínima recomendada: `Apache Maven 3.9.11 ou mais recente`
* Verificar: `mvn -v`
* Como instalar: `https://maven.apache.org/download.cgi`

---

## Como compilar

### Usando Maven

```bash
# limpar, compilar e empacotar
mvn clean package

# compilar sem testes
mvn -DskipTests=true clean package

# apenas compilar
mvn compile
```

---

## Como rodar

### Executável JAR

```bash
# após package/build: executável gerado em target/ (Maven)
java -jar target/<nome-do-jar>.jar
```

Preencha `<nome-do-jar>` com o artefato gerado.

### Executando via IDE

* Importar o projeto (Maven/Gradle) na sua IDE (IntelliJ/Eclipse/VS Code).
* Executar a classe principal: `com.stanczak.pokegame.Main`

---


## Estrutura do projeto

```
pokegame/
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ com/stanczak/pokegame/
│  │  │     ├─ ai/
│  │  │     ├─ engine/
│  │  │     ├─ model/
│  │  │     │  └─ messages/
│  │  │     ├─ persistence/
│  │  │     ├─ ui/
│  │  │     ├─ util/
│  │  │     └─ Main.java
│  │  └─ resources/
│  │     └─ messages/pt-BR/
│  └─ test/
│     └─ java/
│        └─ ... (testes)
├─ pom.xml         # ou build.gradle
├─ README.md
```
