# 🖥️ Sistema de Gerenciamento Unificado — Java

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/POO-Programação_Orientada_a_Objetos-blue?style=for-the-badge)
![GitHub](https://img.shields.io/badge/GitHub-Versionamento-181717?style=for-the-badge&logo=github&logoColor=white)

## 📌 Sobre o Projeto

O **Sistema de Gerenciamento Unificado** é um projeto acadêmico desenvolvido em Java durante a disciplina de Programação Orientada a Objetos (POO), do curso de Ciência da Computação.

O objetivo é aplicar conceitos de programação orientada a objetos por meio do desenvolvimento de três sistemas integrados:

- 🏥 **Clínica Médica:** gerenciamento de pacientes, médicos e consultas.
- 🎫 **Sistema de Eventos:** gerenciamento de eventos, inscrições e participantes.
- 🍽️ **Restaurante:** gerenciamento de mesas, pedidos, itens do cardápio e relatórios de vendas.

O projeto permite explorar a organização do código em classes e objetos, além de conceitos como encapsulamento, herança e reutilização de código.

---

## 🛠️ Tecnologias e Ferramentas

- **Java:** linguagem principal de desenvolvimento.
- **Programação Orientada a Objetos:** paradigma utilizado na construção dos módulos.
- **UML:** modelagem e documentação da estrutura do sistema.
- **Draw.io (diagrams.net):** elaboração de diagramas e fluxogramas.
- **Git e GitHub:** versionamento e colaboração no projeto.

---

## ⚙️ Módulos do Sistema

### 🏥 1. Clínica Médica

Módulo desenvolvido para auxiliar no gerenciamento de informações relacionadas a pacientes, médicos e consultas.

**Funcionalidades documentadas:**
- Cadastro de pacientes.
- Cadastro e identificação de médicos por especialidade.
- Agendamento de consultas.
- Verificação da disponibilidade de médicos.
- Consulta às informações dos agendamentos.

### 🎫 2. Sistema de Eventos

Módulo voltado à organização de eventos e ao gerenciamento de participantes.

**Funcionalidades documentadas:**
- Cadastro e consulta de eventos.
- Inscrição de participantes.
- Verificação da disponibilidade de vagas.
- Consulta de informações dos participantes.
- Controle da capacidade dos eventos.

### 🍽️ 3. Restaurante

Módulo desenvolvido para auxiliar no gerenciamento das operações de um restaurante.

**Funcionalidades documentadas:**
- Gerenciamento de mesas disponíveis e ocupadas.
- Registro de pedidos.
- Gerenciamento dos itens do cardápio.
- Cálculo do valor total dos pedidos.
- Geração de relatórios de vendas.

---

## ❓ Perguntas Frequentes

Esta seção reúne as perguntas e respostas documentadas durante o desenvolvimento do projeto. Algumas operações de relatórios e consultas devem ser conferidas no código para verificar se estão implementadas na versão publicada.

### 🏥 Clínica Médica

**1. Como posso adicionar um novo paciente ao sistema?**

Utilizando a funcionalidade de cadastro de pacientes, é possível inserir as informações solicitadas, como nome e CPF.

**2. É possível adicionar um médico com uma especialidade específica?**

O sistema contempla informações sobre médicos e suas especialidades. O cadastro é descrito na documentação original do módulo.

**3. Como agendar uma consulta entre um paciente e um médico?**

Através da funcionalidade de agendamento, informando os dados necessários para identificar o paciente e o médico. O sistema considera a disponibilidade do profissional.

**4. Posso verificar todas as consultas agendadas?**

A documentação prevê a consulta aos agendamentos, com informações como paciente, médico e data.

**5. O que acontece se eu tentar agendar uma consulta com um médico indisponível?**

O sistema deve informar que o médico não está disponível para o agendamento.

### 🎫 Sistema de Eventos

**1. Quantos participantes estão inscritos em um evento específico?**

A quantidade pode ser obtida consultando os participantes cadastrados no evento.

**2. Há vagas disponíveis para novos participantes?**

A disponibilidade pode ser verificada comparando a capacidade do evento com a quantidade de participantes inscritos.

**3. Quais são os eventos agendados em uma data específica?**

A documentação prevê a consulta aos eventos programados, considerando suas respectivas datas.

**4. Quem são os participantes inscritos em um evento?**

A consulta aos participantes pode apresentar informações como nome, idade e e-mail.

**5. Qual é a lotação máxima e quantos participantes estão cadastrados?**

O sistema pode fornecer informações sobre a capacidade total do evento e a quantidade de inscrições realizadas.

### 🍽️ Restaurante

**1. Qual é o item mais pedido pelos clientes?**

A documentação prevê a identificação do item mais solicitado a partir da contagem dos pedidos realizados.

**2. Qual é o valor total da conta de uma mesa específica?**

O valor pode ser calculado considerando os itens registrados no pedido e seus respectivos preços e quantidades.

**3. Quantas mesas estão ocupadas e quantas estão disponíveis?**

O gerenciamento de mesas permite acompanhar o estado de ocupação do restaurante.

**4. Quantos itens de determinado tipo foram pedidos em um dia?**

A documentação original descreve a possibilidade de consultar os itens registrados em determinado período.

**5. Quantos pedidos foram cancelados em um dia específico?**

A documentação original também prevê o registro e a consulta de cancelamentos por período.

---

## 📐 Modelagem UML — Parte II

Na segunda etapa do projeto, foi desenvolvida a documentação UML, utilizando a ferramenta **Draw.io (diagrams.net)**.

A modelagem foi utilizada para representar visualmente a organização e as relações entre os componentes do sistema, auxiliando no entendimento de sua estrutura.

### Diagrama UML

![Documentação UML do Sistema de Gerenciamento Unificado](https://github.com/user-attachments/assets/5c064b9f-5a03-47f5-a949-c7851b26df8b)

---

## 🚀 Como Executar o Projeto

Para obter o código-fonte, clone o repositório:

```bash
git clone https://github.com/DavidCands/Projeto-de-POO.git
```

Em seguida, abra o projeto em uma IDE com suporte a Java, configure o JDK compatível com o projeto e execute sua classe principal.

> **Observação:** As instruções específicas de compilação e a classe de inicialização devem ser identificadas na estrutura atual do código.

---

## 👥 Equipe de Desenvolvimento

O projeto foi desenvolvido em equipe, com a seguinte divisão de responsabilidades:

| Módulo | Desenvolvedores |
|---|---|
| 🏥 Clínica Médica | Antônio Edson Alves de Holanda Neto |
| 🎫 Sistema de Eventos | Danilo Teixeira de Carvalho e Lucas Mourato Aureliano de Melo |
| 🍽️ Restaurante | Eduardo José Rocha Alexandre e David Cândido de Souza |

---

## 🎓 Contexto Acadêmico

Projeto desenvolvido como atividade acadêmica da disciplina de **Programação Orientada a Objetos**, no curso de Ciência da Computação da Universidade Católica de Pernambuco (UNICAP).

O desenvolvimento proporcionou a aplicação prática de conceitos fundamentais de orientação a objetos, organização de classes, colaboração em equipe e documentação de software.
