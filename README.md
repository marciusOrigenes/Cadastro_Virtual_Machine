# **Cadastro_Virtual_Machine**

Foi utilizado o SGBD PostgreSQL.
Criado um banco chamado db_VirtualMachine com a senha *LKJ@09poc*
 
 ip: localhost

Porta: 5432

Segue scrip abaixo:
```
CREATE DATABASE "db_VirtualMachine"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;
```   
```    
Tabela:
create table tb_Pedidos_VM(
    Id                      SERIAL,
    Nome                    varchar(40),
    Sistema_Operacional     varchar(40),
    Quantidade              integer,
    Memoria                 integer,
    
    CONSTRAINT key_Id PRIMARY KEY(id)
);
``` 
Utilizei o Maven para instalar as dependências, Angular, Java, HTML e CSS.
Utilizei o servidor de aplicação TOMCAT 8.0
Banco de Dados PostgreSQL 9.5.6
