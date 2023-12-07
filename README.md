# JavaWeb-IoT-MySQL-CRUD

## Descrição
Este repositório contém uma aplicação Java web que opera um CRUD (Create, Read, Update, Delete) para gerenciar dados provenientes de dispositivos IoT. Utilizando o MySQL como banco de dados, esta aplicação permite a interação e gestão dos dados coletados, oferecendo funcionalidades de criação, leitura, atualização e remoção de informações provenientes dos dispositivos e registros no banco.

## Funcionalidades Principais
- Criação, leitura, atualização e remoção de dados dos dispositivos IoT armazenados no banco.
  
## Tecnologias Utilizadas
- HTML
- CSS
- JavaScript
- Java
- JSP
- Servlet
- MySQL Connector/J
- Apache Tomcat
- MySQL

## Arquitetura MVC (Model-View-Controller)
Este projeto segue o padrão de arquitetura Model-View-Controller (MVC). Abaixo está uma visão geral de como esse padrão é aplicado neste projeto:

#### Model: As classes de modelo são responsáveis por representar os dados e a lógica de negócios. No contexto deste projeto, elas lidam com a interação com o banco de dados e a manipulação dos dados provenientes dos dispositivos IoT.

#### View: As camadas de visualização são representadas por páginas JSP, HTML, CSS e JavaScript que exibem as informações e interagem com os usuários. Elas são responsáveis pela apresentação dos dados e interação com o cliente.

#### Controller: Os controladores, implementados como Servlets, gerenciam as solicitações dos usuários, interagem com o modelo e selecionam as visualizações apropriadas para enviar ao cliente. Eles controlam o fluxo de dados e a lógica por trás das operações do CRUD.
