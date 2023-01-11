# API Documentation

## Endpoints



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
Esse endpoint é responsável por buscar todos as pessoas criadas, um exemplo de como ele retorna:
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
Esse endpoint é responsável por criar os enderecos da pessoa criada

URL example :http://localhost:8090/person/2/addresses

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




### GET /person/{id}/full
Retrieve addresses for a person by ID.

Path parameters
id: The ID of the person
URL example


http://localhost:8090/person/2/full


### PUT /person/{id}/address/{address_id}/primary
Update primary address for a person by ID.

Path parameters
id: The ID of the person
address_id: The ID of the address

URL example


http://localhost:8090/person/1/address/2/primary


### GET /person/{id}/addresses/primary
Retrieve primary address for a person by ID.

Path parameters
id: The ID of the person

URL example

http://localhost:8090/person/1/addresses/primary


### GET /person/{id}
Retrieve a person by ID.

Path parameters
id: The ID of the person
URL example


http://localhost:8090/person/1

### PUT /person/{id}
Update a created person by ID.

Path parameters
id: The ID of the person
URL example


http://localhost:8090/person/1


### Request body
```json


{
	"nome" : "pessoa de novo" ,
	"dataNascimento" : "23/02/2000"
}
```
