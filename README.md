<div align="center">

# 🌱 Spring Boot 3.5.7 – API REST da Clínica Voll Med  ☕
### _CRUD, Validações, Paginação, Migrations e Boas Práticas com Java 25 e Spring Boot_

[![Java](https://img.shields.io/badge/Java-25+-orange?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen?logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Hibernate](https://img.shields.io/badge/JPA%2FHibernate-ORM-blue?logo=hibernate&logoColor=white)](https://hibernate.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.x-blue?logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Flyway](https://img.shields.io/badge/Flyway-Migrations-red?logo=flyway&logoColor=white)](https://flywaydb.org/)
[![Lombok](https://img.shields.io/badge/Lombok-Ativa-green?logo=lombok&logoColor=white)](https://projectlombok.org/)
[![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](#-como-contribuir)

</div>

---

## 🧭 Sobre o Projeto

Este repositório reúne meus estudos do curso **“Spring Boot 3: desenvolva uma API Rest em Java”**, onde desenvolvo do zero uma API REST moderna utilizando **Java 25** e **Spring Boot 3.5.7**.

O projeto simula o backend de uma **clínica médica fictícia (Voll Med)**, permitindo o gerenciamento completo de:

- 👨‍⚕️ Médicos  
- 🧑‍🦽 Pacientes  
- 📅 Consultas (agendamento e cancelamento)  

Durante o curso, são aplicadas validações, paginação, ordenação, migrations, versionamento de banco e boas práticas do ecossistema Spring.

> “A API perfeita não existe: ela evolui conforme o domínio e o aprendizado.”  
> — *Rodrigo Ferreira (Instrutor do curso)*

---

## 🧩 Conteúdos Abordados

### ✅ Desenvolvimento de API REST com Spring Boot 3.5.7
- Controllers, Services e Repositories  
- Estruturação limpa e organizada  
- Respostas padronizadas

### ✅ CRUD Completo (Create, Read, Update, Delete)
- Cadastro, listagem, atualização e exclusão  
- DTOs de entrada e saída  
- Mapeamento JPA/Hibernate

### ✅ Validações com Bean Validation
- `@NotNull`, `@Email`, `@Size`, `@Pattern`  
- Tratamento de erros estruturado  
- Mensagens amigáveis ao cliente

### ✅ Paginação e Ordenação
- Uso do `Pageable`  
- Parâmetros dinâmicos  
- Respostas paginadas

### ✅ Flyway – Migrations Versionadas
- Criação automática do schema  
- Histórico de evolução do banco  

### ✅ Boas práticas
- Lombok para reduzir boilerplate  
- Camadas separadas corretamente  
- DTOs para evitar exposição de entidades  
- SOLID aplicado no backend

---

## 🧰 Tecnologias Utilizadas

| Categoria | Ferramenta |
|------------|-------------|
| Linguagem | ![Java](https://img.shields.io/badge/Java-25+-orange?logo=openjdk&logoColor=white) |
| Framework | ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen?logo=spring&logoColor=white) |
| Persistência | ![Hibernate](https://img.shields.io/badge/JPA%2FHibernate-blue?logo=hibernate&logoColor=white) |
| Banco de Dados | ![MySQL](https://img.shields.io/badge/MySQL-8.x-blue?logo=mysql&logoColor=white) |
| Migrations | ![Flyway](https://img.shields.io/badge/Flyway-red?logo=flyway&logoColor=white) |
| Build | ![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?logo=apachemaven&logoColor=white) |
| Utilitário | ![Lombok](https://img.shields.io/badge/Lombok-green?logo=lombok&logoColor=white) |
| Testes de API | ![Insomnia](https://img.shields.io/badge/Insomnia-Client-4000BF?logo=insomnia&logoColor=white) |

---

## ⚙️ Requisitos

Antes de iniciar, certifique-se de ter instalado:

- ☕ **Java 25+**  
- 🧱 **Maven 3.x**  
- 🗄️ **MySQL 8.x**  
- 🌱 Conhecimento básico em **Spring Boot**  
- 🌐 Familiaridade com **APIs REST**

---

## 🚀 Como Executar o Projeto

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/vollmed-api-springboot.git

# Entre na pasta
cd vollmed-api-springboot

# Execute as migrations e inicialize o projeto
./mvnw spring-boot:run
