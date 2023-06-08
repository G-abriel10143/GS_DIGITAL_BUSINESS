## Recurso Cultivo

### Criar Cultivo

`POST` /api/cultivo

Cria um novo cultivo.

**Corpo da Requisição**

| Campo               | Tipo    | Obrigatório | Descrição                                            |
| ------------------- | ------- | ----------- | ---------------------------------------------------- |
| nome_planta         | string  | sim         | Nome da planta cultivada.                            |
| metodo_cultivo      | string  | sim         | Método de cultivo utilizado.                          |
| tempo_crescimento   | integer | sim         | Tempo de crescimento da planta (em dias).             |
| dificuldade         | integer | sim         | Nível de dificuldade do cultivo (em escala de 1 a 5). |
| temperatura_minima  | float   | sim         | Temperatura mínima ideal para o cultivo.              |
| temperatura_maxima  | float   | sim         | Temperatura máxima ideal para o cultivo.              |

**Exemplo de corpo da requisição**

```js
{
    "nome_planta": "Tomate",
    "metodo_cultivo": "Hidroponia",
    "tempo_crescimento": 60,
    "dificuldade": 3,
    "temperatura_minima": 18.5,
    "temperatura_maxima": 25.0
}
```

**Códigos de Resposta**

| Código | Descrição                               |
| ------ | --------------------------------------- |
| 201    | Cultivo criado com sucesso.             |
| 400    | Erro na requisição.                      |

---

### Recuperar Cultivo

`GET` /api/cultivo/{id}

Recupera os dados de um cultivo específico.

**Códigos de Resposta**

| Código | Descrição                               |
| ------ | --------------------------------------- |
| 200    | Cultivo recuperado com sucesso.         |
| 404    | Cultivo não encontrado.                 |

**Exemplo de corpo da resposta**

```js
{
    "id": 1,
    "nome_planta": "Tomate",
    "metodo_cultivo": "Hidroponia",
    "tempo_crescimento": 60,
    "dificuldade": 3,
    "temperatura_minima": 18.5,
    "temperatura_maxima": 25.0,
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/cultivo/1"
        }
    }
}
```

---

### Atualizar Cultivo

`PUT` /api/cultivo/{id}

Atualiza os dados de um cultivo específico.

**Corpo da Requisição**

| Campo               | Tipo    | Obrigatório | Descrição                                            |
| ------------------- | ------- | ----------- | ---------------------------------------------------- |
| nome_planta         | string  | sim         | Nome da planta cultivada.                            |
| metodo_cultivo      | string  | sim         | Método de cultivo utilizado.                          |
| tempo_crescimento   | integer | sim         | Tempo de crescimento da planta (em dias).             |
| dificuldade         | integer | sim         | Nível de dificuldade do cultivo (em escala de 1 a 5). |
| temperatura_minima  | float   | sim         | Temperatura mínima ideal para o cultivo.              |
| temperatura_maxima  | float   | sim         | Temperatura máxima ideal para o cultivo.

              |

**Exemplo de corpo da requisição**

```js
{
    "nome_planta": "Tomate",
    "metodo_cultivo": "Hidroponia",
    "tempo_crescimento": 60,
    "dificuldade": 3,
    "temperatura_minima": 18.5,
    "temperatura_maxima": 25.0
}
```

**Códigos de Resposta**

| Código | Descrição                                  |
| ------ | ------------------------------------------ |
| 200    | Cultivo atualizado com sucesso.            |
| 404    | Cultivo não encontrado.                    |
| 400    | Erro na requisição.                         |

---

### Deletar Cultivo

`DELETE` /api/cultivo/{id}

Deleta um cultivo específico.

**Códigos de Resposta**

| Código | Descrição                                 |
| ------ | ----------------------------------------- |
| 204    | Cultivo deletado com sucesso.             |
| 404    | Cultivo não encontrado.                   |
| 400    | Erro na requisição.                        |



## Recurso Composteira

### Criar Composteira

`POST` /api/composteira

Cria uma nova composteira.

**Corpo da Requisição**

| Campo           | Tipo         | Obrigatório | Descrição                                     |
| --------------- | ------------ | ----------- | --------------------------------------------- |
| quantidade      | integer      | sim         | Quantidade de resíduos a serem descartados.     |
| data_descarte   | string       | sim         | Data e hora do descarte dos resíduos.          |
| tipo_descarte   | string       | sim         | Tipo de resíduos descartados.                  |
| motivo_descarte | string       | sim         | Motivo do descarte dos resíduos.               |

**Exemplo de corpo da requisição**

```js
{
    "quantidade": 10,
    "data_descarte": "2023-06-07T10:30:00",
    "tipo_descarte": "Alimentos orgânicos",
    "motivo_descarte": "Excesso de alimentos perecíveis"
}
```

**Códigos de Resposta**

| Código | Descrição                               |
| ------ | --------------------------------------- |
| 201    | Composteira criada com sucesso.          |
| 400    | Erro na requisição.                      |

---

### Recuperar Composteira

`GET` /api/composteira/{id}

Recupera os dados de uma composteira específica.

**Códigos de Resposta**

| Código | Descrição                               |
| ------ | --------------------------------------- |
| 200    | Composteira recuperada com sucesso.      |
| 404    | Composteira não encontrada.              |

**Exemplo de corpo da resposta**

```js
{
    "id": 1,
    "quantidade": 10,
    "data_descarte": "2023-06-07T10:30:00",
    "tipo_descarte": "Alimentos orgânicos",
    "motivo_descarte": "Excesso de alimentos perecíveis",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/composteira/1"
        }
    }
}
```

---

### Atualizar Composteira

`PUT` /api/composteira/{id}

Atualiza os dados de uma composteira específica.

**Corpo da Requisição**

| Campo           | Tipo         | Obrigatório | Descrição                                     |
| --------------- | ------------ | ----------- | --------------------------------------------- |
| quantidade      | integer      | sim         | Quantidade de resíduos a serem descartados.     |
| data_descarte   | string       | sim         | Data e hora do descarte dos resíduos.          |
| tipo_descarte   | string       | sim         | Tipo de resíduos descartados.                  |
| motivo_descarte | string       | sim         | Motivo do descarte dos resíduos.               |

**Exemplo de corpo da requisição**

```js
{
    "quantidade": 15,
    "data_descarte": "2023-06-07T10:30:00",
    "tipo_descarte": "Alimentos orgânicos",
    "motivo_descarte": "Excesso de alimentos perecíveis"
}
```

**Códigos de Resposta**

| Código | Descrição                                  |
| ------ | ------------------------------------------ |


| 200    | Composteira atualizada com sucesso.         |
| 404    | Composteira não encontrada.                 |
| 400    | Erro na requisição.                         |

---

### Deletar Composteira

`DELETE` /api/composteira/{id}

Deleta uma composteira específica.

**Códigos de Resposta**

| Código | Descrição                                 |
| ------ | ----------------------------------------- |
| 204    | Composteira deletada com sucesso.          |
| 404    | Composteira não encontrada.                |
| 400    | Erro na requisição.                        |


## Recurso Administrador

### Criar Administrador

`POST` /api/administrador

Cria um novo administrador.

**Corpo da Requisição**

| Campo       | Tipo   | Obrigatório | Descrição                                 |
| ----------- | ------ | ----------- | ----------------------------------------- |
| nome        | string | sim         | Nome do administrador.                    |
| email       | string | sim         | Email do administrador.                   |
| telefone    | string | sim         | Número de telefone do administrador.       |
| nascimento  | string | sim         | Data de nascimento do administrador.       |
| ativo       | boolean| sim         | Status de atividade do administrador.      |

**Exemplo de corpo da requisição**

```js
{
    "nome": "João da Silva",
    "email": "joao.silva@example.com",
    "telefone": "(11) 98765-4321",
    "nascimento": "1990-05-15",
    "ativo": true
}
```

**Códigos de Resposta**

| Código | Descrição                               |
| ------ | --------------------------------------- |
| 201    | Administrador criado com sucesso.       |
| 400    | Erro na requisição.                      |

---

### Recuperar Administrador

`GET` /api/administrador/{id}

Recupera os dados de um administrador específico.

**Códigos de Resposta**

| Código | Descrição                                |
| ------ | ---------------------------------------- |
| 200    | Administrador recuperado com sucesso.    |
| 404    | Administrador não encontrado.            |

**Exemplo de corpo da resposta**

```js
{
    "id": 1,
    "nome": "João da Silva",
    "email": "joao.silva@example.com",
    "telefone": "(11) 98765-4321",
    "nascimento": "1990-05-15",
    "ativo": true,
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/administrador/1"
        }
    }
}
```

---

### Atualizar Administrador

`PUT` /api/administrador/{id}

Atualiza os dados de um administrador específico.

**Corpo da Requisição**

| Campo       | Tipo   | Obrigatório | Descrição                                 |
| ----------- | ------ | ----------- | ----------------------------------------- |
| nome        | string | sim         | Nome do administrador.                    |
| email       | string | sim         | Email do administrador.                   |
| telefone    | string | sim         | Número de telefone do administrador.       |
| nascimento  | string | sim         | Data de nascimento do administrador.       |
| ativo       | boolean| sim         | Status de atividade do administrador.      |

**Exemplo de corpo da requisição**

```js
{
    "nome": "João da Silva",
    "email": "joao.silva@example.com",
    "telefone": "(11) 98765-4321",
    "nascimento": "1990-05-15",
    "ativo": false
}
```

**Códigos de Resposta**

| Código | Descrição                                  |
| ------ | ------------------------------------------ |
| 200    | Administrador atualizado com sucesso.      |
| 404    | Administrador não encontrado.              |
| 400    | Erro na requisição.                         |

---

### Deletar Administrador



`DELETE` /api/administrador/{id}

Deleta um administrador específico.

**Códigos de Resposta**

| Código | Descrição                                 |
| ------ | ----------------------------------------- |
| 204    | Administrador deletado com sucesso.       |
| 404    | Administrador não encontrado.             |
| 400    | Erro na requisição.                        |
