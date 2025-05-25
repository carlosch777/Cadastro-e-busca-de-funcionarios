# Sistema de Cadastro de Funcionários (Java Swing)

Este é um sistema desktop desenvolvido em **Java** com **Swing** para realizar o cadastro, busca e visualização de diferentes tipos de funcionários em uma empresa.

## 💻 Funcionalidades

- Cadastro de funcionários com diferentes cargos:
  - Gerente
  - Vendedor
  - Operador
  - Estagiário
- Campos específicos para cada cargo (ex: bônus para gerente, horas para estagiário).
- Cálculo automático de salário com desconto de INSS.
- Listagem de funcionários cadastrados.
- Busca de funcionário por ID.
- Interface gráfica amigável usando `JFrame`, `JPanel`, `JComboBox`, `JTextArea`, etc.

## 🛠️ Tecnologias Utilizadas

- **Java** (versão 8+)
- **Swing** para interface gráfica
- **Orientação a Objetos**
- **ArrayList** para gerenciamento dinâmico dos funcionários

## 📁 Estrutura do Projeto
trabalhoJAVA/
├── src/
│ ├── Main.java
│ ├── Funcionario.java
│ ├── Gerente.java
│ ├── Vendedor.java
│ ├── Operador.java
│ └── Estagiario.java

> As classes `Funcionario`, `Gerente`, `Vendedor`, `Operador` e `Estagiario` implementam a lógica de cada tipo de funcionário.

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/Cadastro-e-busca-de-funcionarios.git
   cd "Cadastro e busca de funcionarios"

2. Compile e execute o projeto no seu IDE preferido (como IntelliJ ou Eclipse), ou pelo terminal:

javac src/*.java
java -cp src Main

✅ Pré-requisitos
Java JDK 8 ou superior

IDE de sua preferência (Eclipse, IntelliJ, NetBeans) ou terminal com javac/java

Desenvolvido por Carlos Henrique. 🧠
