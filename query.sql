CREATE DATABASE desafio_kafka;

drop table if exists cliente;

create table cliente(
  id serial not null primary key,
  nome varchar(50) not null
);

drop table if exists produto;

create table produto(
  id serial not null primary key,
  nome varchar(50) not null,
  descricao varchar(150) not null,
  quantidade int not null,
  valor int not null, 
  data timestamp default current_timestamp
);

drop table if exists pedido;

create table pedido(
  id serial not null primary key,
  data_criacao timestamp default current_timestamp,
  valor_total integer not null,
  endereco_entrega text not null,
  id_cliente int not null,
  constraint fk_cliente foreign key (id_cliente) references cliente(id)

);

drop table if exists item_pedido;

create table item_pedido(
  id serial not null primary key,
  id_pedido integer not null,
  id_produto integer not null,
  quantidade int not null,
  valor int not null,
  constraint fk_pedido foreign key (id_pedido) references pedido(id),
  constraint fk_produto foreign key (id_produto) references produto(id)
);


