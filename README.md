<div align="center">
<img src="https://github.com/felipevitorino/importxml/assets/8423063/4aba1c88-2884-47dd-b746-5d227d696717" width="1000px" />
</div>

# Nanodata ImportXML

Esse serviço tem como objetivo importar e baixar arquivos xml de NFe

## 🔨 Funcionalidades Principais

Importação de NFe no formato XML.

Listagem de arquivos processados e download dos mesmos.

## 🚀 Getting Started

Para iniciar a aplicação é necessario criar um banco de dados no Postgres.

## 🔩 Pre requisitos

Faça o download do Postgres em https://www.postgresql.org/download/ e seguir as instruções de instalação para o seu sistema operacional.
 - Após logar no terminal do Postgres execute
```
CREATE USER nanodata WITH PASSWORD 'nano';
ALTER USER nanodata WITH SUPERUSER;
CREATE DATABASE importxml OWNER nanodata;

```

## ⚙️ Execução em ambiente de desenvolvimento

Clone o projeto com Git para seu repositório e importe como Maven Project em sua IDE de preferência.

Execute a classe ImportaXmlApplication como Java Application. Após isso, o serviço estará em funcionamento e poderá ser acessado localmente pelo endereço http://localhost:8080/

## ✔️ Técnicas e tecnologias utilizadas

- ``Java 17``
- ``Spring``
- ``JPA``
- ``JUnit 4``
- ``Postgres``
- ``Eclipse IDE``
- ``Git``
- ``Maven``

## Autores

* **Felipe Vitorino**
