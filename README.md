<div align="center">

# ⚓ A.R.C.A
### Assistente de Registro, Controle e Acompanhamento de Embaixadores

**Sistema de gestão administrativa para o projeto social *Embaixadores do Rei***

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![Jackson](https://img.shields.io/badge/Jackson-JSON-brightgreen?style=flat-square)
![Maven](https://img.shields.io/badge/Build-Maven-red?style=flat-square&logo=apachemaven)
![Licença](https://img.shields.io/badge/Licença-Educacional-blue?style=flat-square)

</div>

---

## 📖 Sobre o Projeto

O **A.R.C.A** é um sistema de linha de comando (CLI) desenvolvido em Java para apoiar a gestão da **Embaixada do projeto Embaixadores do Rei** — um projeto social cristão da igreja batista voltado para discipulado, formação de caráter e desenvolvimento de meninos.

O sistema centraliza o cadastro de embaixadores (participantes), o lançamento semanal de pontos e presença, e a consulta de históricos individuais — tudo de forma simples, direto pelo terminal.

> 💡 Desenvolvido por um líder do projeto para facilitar a organização administrativa da embaixada.

---

## ✨ Funcionalidades

| Módulo | Descrição |
|---|---|
| 👤 **CRUD de Embaixadores** | Cadastrar, listar, editar e remover participantes |
| 📋 **Lançamento Semanal** | Registrar pontos e presença por semana |
| 🔍 **Consulta de Dados** | Ver perfil completo, histórico de pontos e frequência |

---

## 🛠️ Tecnologias

- **Java 21**
- **Jackson** — serialização e desserialização JSON
- **JSON** — persistência local de dados
- **Maven** — gerenciamento de dependências e build

### Estrutura do Projeto

```
src/
└── main/
    └── java/
        └── br/com/arca/
            ├── model/          # Domínio: Embaixador, RegistroPontos, RegistroFrequencia
            ├── repository/     # Persistência JSON com Jackson
            └── Main.java       # Interface de linha de comando (CLI)
embaixadores.json               # Arquivo de dados (gerado na raiz do projeto)
```

---

## 🚀 Como Executar

### Pré-requisitos

- [Java 21+](https://adoptium.net/)
- [Maven](https://maven.apache.org/) *(ou use o Maven Wrapper incluído no projeto)*

### Passos

**1. Clone o repositório**
```bash
git clone https://github.com/seu-usuario/arca.git
cd arca
```

**2. Compile o projeto**

```bash
# Linux / macOS
./mvnw -q -DskipTests package

# Windows
mvnw.cmd -q -DskipTests package
```

**3. Execute a aplicação**

```bash
# Linux / macOS
java -cp target/classes br.com.arca.Main

# Windows
java -cp target\classes br.com.arca.Main
```

---

## 💻 Exemplo de Uso

```
===== INTERFACE A.R.C.A =====
1 - CRUD DE EMBAIXADORES
2 - LANÇAMENTO SEMANAL (PONTOS + FREQUÊNCIA)
3 - VER DADOS DE UM EMBAIXADOR
0 - SAIR

Escolha uma opção: 1

===== CRUD DE EMBAIXADORES =====
1 - Cadastrar
2 - Listar
3 - Editar
4 - Remover
0 - Voltar

Escolha uma opção: 1
=== Cadastro de Embaixador ===
Nome: João da Silva
Data de nascimento (yyyy-MM-dd): 2012-05-10
Telefone: (11) 99999-9999
Nome do pai: Carlos da Silva
Nome da mãe: Maria da Silva
Telefone do responsável: (11) 98888-8888
Ano de ingresso: 2024

✔ Embaixador cadastrado com sucesso. ID: 1
```

---

## 🗺️ Melhorias Futuras

- [ ] Interface gráfica com **JavaFX**
- [ ] Persistência em banco de dados (**PostgreSQL**, **MySQL** ou **H2**)
- [ ] Sistema **web** para acesso multiusuário
- [ ] Relatórios e exportação de dados (**CSV / PDF**)
- [ ] Autenticação e perfis de acesso

---

## 📄 Licença e Uso

Este projeto pode ser utilizado livremente para **fins educacionais e de aprendizagem**.

Para uso em produção, avalie os requisitos de segurança, privacidade e conformidade com a realidade da sua organização. Para formalizar uma licença open-source (ex.: MIT), adicione o arquivo `LICENSE` correspondente ao repositório.

---

<div align="center">

Feito com ❤️ para o projeto **Embaixadores do Rei**

</div>