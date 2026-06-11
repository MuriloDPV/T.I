# Coringa: Desafio Loja de Jogos

## Descrição

Desenvolva uma API REST para gerenciamento de jogos cadastrados em uma game store.

---

# Entidade Principal

## Coringa

| Campo                   | Tipo       | Regras                           |
| ----------------------- | ---------- | -------------------------------- |
| id                      | Long       | Gerado automaticamente           |
| titulo                  | String     | Obrigatório, mínimo 3 caracteres |
| preco                   | BigDecimal | Deve ser maior ou igual a 0      |
| estoque                 | Integer    | Deve ser maior ou igual a 0      |
| classificacaoIndicativa | Integer    | Deve ser maior ou igual a 0      |
| codigoInterno           | String     | Gerado automaticamente           |
| disponivel              | Boolean    | Gerado de acordo com o estoque   |

---

# DTOs

## CoringaRequestDTO

Utilizado para cadastro e atualização de jogos.

Deve conter apenas os seguintes campos:

| Campo                   | Tipo       |
| ----------------------- | ---------- |
| titulo                  | String     |
| preco                   | BigDecimal |
| estoque                 | Integer    |
| classificacaoIndicativa | Integer    |

### Regras

* O id e o código interno não devem ser enviados pelo cliente.
* O status `disponivel` deve ser gerado a partir do estoque:

  * “True” quando estoque > 0
  * “False” quando estoque = 0

* Utilize validações com:

  * `@Size`
  * `@Positive`
  * `@NotNull`

---

## CoringaResponseDTO

Utilizado para retorno da API.

Deve conter os seguintes campos:

| Campo                   | Tipo       |
| ----------------------- | ---------- |
| id                      | Long       |
| titulo                  | String     |
| preco                   | BigDecimal |
| classificacaoIndicativa | Integer    |
| disponivel              | Boolean    |

### Regras

* O estoque não deve ser retornado.
* O código interno não deve ser retornado.

---

# Endpoints Obrigatórios

## 1. Cadastrar coringa

### POST `/api/coringa`

### Recebe:

`CoringaRequestDTO`

### Retorna:

`CoringaResponseDTO`

### Regras:

* Todos os campos devem ser validados.

---

## 2. Buscar todos os coringas

### GET `/api/coringa`

### Retorna:

Lista de `CoringaResponseDTO`

---

## 3. Buscar coringa por ID

### GET `/api/coringa/{id}`

### Retorna:

`CoringaResponseDTO`

### Regras:

* Retornar erro caso o ID não exista.

---

## 4. Atualizar coringa

### PUT `/api/coringa/{id}`

### Recebe:

`CoringaRequestDTO`

### Retorna:

`CoringaResponseDTO`

### Regras:

* Validar os dados recebidos.
* Retornar erro caso o ID não exista.

---

## 5. Remover coringa

### DELETE `/api/coringa/{id}`

### Regras:

* Retornar erro caso o ID não exista.

---

# Estrutura Esperada

```text
controller
service
repository
entity
dto
handler
```

---

# Tratamento de Erros

Implemente tratamento global de exceções utilizando:

* `@ControllerAdvice`
* `@ExceptionHandler`

A API deve retornar mensagens claras de erro.

