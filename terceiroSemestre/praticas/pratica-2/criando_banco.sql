USE master;
GO

CREATE USER loja FOR LOGIN loja;
GO

CREATE DATABASE Loja;
GO

USE Loja;
GO


CREATE TABLE pessoa(
idPessoa INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
pessoa_tipo VARCHAR(100),
nome VARCHAR(255) NOT NULL,
logradouro VARCHAR(255) NOT NULL,
cidade VARCHAR(255) NOT NULL,
estado CHAR(2) NOT NULL,
telefone VARCHAR(11) NOT NULL,
email VARCHAR(255) NOT NULL,
CONSTRAINT check_tipo_pessoa CHECK (pessoa_tipo IN ('fisica', 'juridica'))
)
GO

CREATE TABLE pessoa_fisica(
idPessoaFisica INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
idPessoa INT NULL,
cpf VARCHAR(11) NOT NULL,
FOREIGN KEY (idPessoa) REFERENCES pessoa(idPessoa)
)

CREATE TABLE pessoa_juridica (
idPessoaJuridica INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
idPessoa INT NULL,
cnpj VARCHAR(14) NOT NULL
FOREIGN KEY (idPessoa) REFERENCES pessoa(idPessoa)
)

CREATE TABLE produto (
idProduto INT PRIMARY KEY NOT NULL,
nome VARCHAR(255) NOT NULL,
quantidade INT NOT NULL,
precoVenda DECIMAL(10,2) NOT NULL
)

CREATE TABLE movimento (
idMovimento INT PRIMARY KEY NOT NULL,
idProduto INT NOT NULL,
idPessoa INT NOT NULL,
idUsuario INT NOT NULL,
movimento_tipo VARCHAR(100), -- 'E' para entrada, 'S' para saída
quantidade INT NOT NULL,
precoUnitario DECIMAL(10,2) NOT NULL,
CONSTRAINT check_tipo_movimento CHECK (movimento_tipo IN ( 'entrada', 'saida')),
FOREIGN KEY (idProduto) REFERENCES produto(idProduto),
FOREIGN KEY (idPessoa) REFERENCES pessoa(idPessoa),
FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
)

CREATE TABLE usuario (
idUsuario INT UNIQUE NOT NULL,
login VARCHAR(255) NOT NULL,
senha VARCHAR(255) NOT NULL
)