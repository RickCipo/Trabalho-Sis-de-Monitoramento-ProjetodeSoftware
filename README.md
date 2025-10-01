# Trabalho-Sis-de-Monitoramento-ProjetodeSoftware

Enrique Cipolla Martins - RA: 10427834
Henrique Ferreira Marciano - RA: 10439797

Projeto da disciplina de Projeto de Software.

É um sistema simples em Java para gerenciar missões de drones em áreas agrícolas, salvando os dados coletados em um banco de dados.

O que ele faz?
Cadastro de Drones e Áreas Agrícolas

Agendamento de Missões de Voo

Armazenamento dos Dados Coletados

Tecnologias Usadas
Java

Maven

JDBC

MySQL (ou outro banco SQL)

Git / GitHub

Como Executar
Clone o projeto:

Bash

git clone https://github.com/seu-usuario/seu-repositorio.git
Configure o Banco de Dados:

Crie um banco de dados.

Execute os scripts SQL para criar as tabelas.

Ajuste os dados de conexão (URL, usuário, senha) no código, na classe ConnectionFactory.java.

**Execute a aplicação:**

Bash

# Compile o projeto
mvn clean install

# Execute a classe principal
mvn exec:java -Dexec.mainClass="Main"
