# API Documentation

## Endpoints

### POST /person
Create a new person.

#### URL example

http://localhost:8090/person


#### Request body
```json
{
  "nome": "fred",
  "dataNascimento": "23/02/2003"
}
```


### GET /person
Retrieve a list of all people.

URL example

http://localhost:8090/person

### POST /person/{id}/addresses
Create a new address for a person by ID.

Path parameters
id: The ID of the person
URL example

http://localhost:8090/person/2/addresses


### Request body
```json
{
    "logradouro" : "rua 15 rc 14 quuadra 22 , casa 2020 ",
    "cep" : "23/02/2000",
    "numero" : "443434",
    "cidade" : "goiania sao paulo"
}
```

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
