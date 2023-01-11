# api-management-person-spring-boot

## Endpoints

### POST/create person
Esse endpoint é responsável por criar uma pessoa, inicialmente os campos de endereco não são passados
e a pessoa é gerada apenas com o nome e data de nascimento.

example url: 

http://localhost:8090/person

#### Request body
```json
{
  "nome" : "fred" ,
  "dataNascimento" : "23/02/2003"
}

dataNascimento deve ser passado no formato: dd/mm/aaaa
caso contrário não será criado o usuário


### GET/list person
Esse endpoint é responsável por listar todas as pessoas criadas,

example url:

http://localhost:8090/person

resultado esperado:
```json
[
    {
        "id": 1,
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
]























