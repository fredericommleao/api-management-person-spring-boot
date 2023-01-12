# Qualidade de código

### 1 - Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para 
### garantia de qualidade de software?

#### R: testes unitários, clean architecture( ou pelo menos o principios de responsabilidade única e aberto/fechado do SOLID), 
#### o design pattern a ser utilizado e uma boa documentação em relação a funcionalidade, com essas práticas podemos garantir uma melhor manutenibilidade
#### do código o que impacta diramente na sua qualidade.


### 2. Em qual etapa da implementação você considera a qualidade de software?
	
#### Desde a primeira etapa do ciclo de vida do software, ou seja, no levantamento de requisitos do usuário, 
#### pois é em cima dos requisitos que teremos os primeiros casos de uso do software, 
#### que posteriormente viram a ser os UMLs/diagramas.



# API Documentation

## Preview

API desenvolvida com spring-boot para o gerenciamento de cadastro de pessoas e o seu endereco,
foi utilizado o spring web e o banco de dados H2, na parte de teste foi utilizado o Junit e Mockito 
para testes unitário nas classes de controllers e services.



## Endpoints
Explicação e exemplos para uso dos endpoints da api.


### POST /person
Esse endpoint é responsável por criar uma pessoa, inicialmente os dados da pessoa
são criados apenas com o nome e a data de nascimento posteriormente os campos de endereco são colocados.

#### URL example: http://localhost:8090/person

#### Request body
```json
{
  "nome": "fred",
  "dataNascimento": "23/02/2003"
}
```
o campo dataNascimento deve ser preenchido no formato dd/mm/aaaa




### GET /person
Esse endpoint é responsável por buscar todos as pessoas criadas.

exemplo de retorno:
```json
 {
        "id": 2,
        "listAddress": [
            {
                "id": null,
                "logradouro": "O endereco ainda não foi cadastrado",
                "cep": null,
                "numero": null,
                "cidade": null,
                "principal": false
            }
        ],
        "nome": "fred",
        "dataNascimento": "2003-02-23"
    }
```
URL example :http://localhost:8090/person




### POST /person/{id}/addresses
#### URL example :http://localhost:8090/person/2/addresses

Esse endpoint é responsável por criar os enderecos da pessoa criada

### Request body
```json
{
    "logradouro" : "rua 15 rc 14 quuadra 22 , casa 2020 ",
    "cep" : "23/02/2000",
    "numero" : "443434",
    "cidade" : "goiania sao paulo"
}
```
caso o endpoint seja passado mais de uma vez com o mesmo ID,
teremos uma lista de enderecos de uma mesma pessoa.


### GET /person/{id}/addresses/primary
#### URL example: http://localhost:8090/person/1/addresses/primary

Esse endpoint retorna apenas os campos do endereco principal de uma pessoa,
porém a pessoa já deve ter enderecos criados e selecionado um como o principal.

exemplo de retorno:
```json
{
    "id": 1,
    "logradouro": "rua 15 rc 14 quuadra 22 , casa 2020 ",
    "cep": "23/02/2000",
    "numero": "443434",
    "cidade": "goiania sao paulo",
    "principal": true
}

```
observe que o campo "principal" aparece como true, 
indicando que é o principal.




### GET /person/{id}
#### URL example: http://localhost:8090/person/1

Esse endpoint retorna apenas uma pessoa, utilizando o seu ID,
caso a pessoa já tenha endereco(s) cadastrado irá aparecer também, 
caso não tenha os campos apareceram com valor null.

exemplo de retorno: 
```json
{
    "id": 1,
    "listAddress": [
        {
            "id": 1,
            "logradouro": "rua 15 rc 14 quuadra 22 , casa 2020 ",
            "cep": "23/02/2000",
            "numero": "443434",
            "cidade": "goiania sao paulo",
            "principal": true
        }
    ],
    "nome": "lucas",
    "dataNascimento": "2003-02-23"
}
```

### PUT /person/{id}
#### Url example: http://localhost:8090/person/1

Esse endpoint é reponsável por atualizar os campos
nome e endereco de uma pessoa


### Request body
```json


{
	"nome" : "pessoa de novo" ,
	"dataNascimento" : "23/02/2000"
}
```
