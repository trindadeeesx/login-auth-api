# Login Auth API (Spring Boot)

API REST de autenticação e registro de usuários, construída com Spring Boot, usando JWT para segurança. Permite registrar novos usuários, realizar login, emitir e validar tokens, e gerenciar sessões.

---

## SOBRE O PROJETO

Esse projeto foi criado para treino e portfólio, com o objetivo de demonstrar habilidades em backend Java, autenticação segura e estruturação de uma API escalável. É ideal para mostrar para recrutadores ou usar como base para aplicações mais complexas.

---

### FUNCIONALIDADES

- Registro de usuário (signup)
- Login (signin)
- Emissão de JWT (access token)
- Validação de token para proteger rotas
- Refresh token (se implementado)
- Exemplo de controle de roles ou permissões
- Endpoints protegidos apenas para usuários autenticados
- Uso de banco H2 para armazenamento rápido e simples

### TECNOLOGIAS UTILIZADAS

- Java
- Spring Boot
- Spring Web
- Spring Security
- Spring Data JPA
- JWT
- H2 Database
- Maven

### COMO RODAR O PROJETO

1. Clonar o repositório:

```bash
git clone https://github.com/trindadeeesx/login-auth-api.git
cd login-auth-api
```

2. Compile e rode a aplicação:
```bash
mvn clean package
mvn spring-boot:run
```

3. Acesse a API em:
```bash
http://localhost:8080
```

4. Acesse o console H2 (se configurado):
```bash
http://localhost:8080/h2-console
```

JDBC URL típica: `jdbc:h2:mem:testdb`

Usuário e senha conforme sua configuração (ex: sa / password)

---

### Rotas Principais (Endpoints)

Aqui estão alguns dos endpoints principais dessa API:

| Método |	Caminho       |	Descrição                                       |
|--------|----------------|-------------------------------------------------|
| POST   | /auth/register	| Registra um novo usuário                        |
| POST   | /auth/login	  | Faz login e retorna JWT                         |
| GET    | /auth/me	      | Retorna dados do usuário autenticado (exemplo)  |
| POST   | /auth/refresh  | (Opcional) Gera um novo token com Refresh Token |

---

### Requisições

---

Exemplo de request de registro

```json
POST /auth/register
Content-Type: application/json

{
	"name": "John Doe",
  "email": "john.doe@email.com",
  "password": "RedHotChilliPeppers"
}
```

Resposta
```json
{
  "name": "John Doe",
  "email": "john.doe@email.com",
  "password": "$2a$12$XYH1DPoER6L8Wv/QuqXWl.z5wdb.iShYdpv3YECrJ1eGw6tY7Bdw2",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

---

Exemplo de request de login:

```json
POST /auth/login
Content-Type: application/json

{
  "email": "john.doe@email.com",
  "password": "RedHotChilliPeppers"
}
```

Resposta
```json
{
  "name": "John Doe",
  "email": "john.doe@email.com",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

---

### Como Usar com o Frontend

Se você tiver um frontend (por exemplo, em React) rodando localmente, configure:

- No backend: habilite CORS para permitir requisições da origem do frontend (ex: http://localhost:3000 ou http://localhost:5173).

- No frontend: configure a base da API, por exemplo, em um arquivo .env:


```ini
REACT_APP_API_URL=http://localhost:8080
```

Depois use uma biblioteca como axios para fazer chamadas à API:

```ini
axios.post(`${process.env.API_URL}/auth/login`, { email, password })
```

### Roadmap / Próximos Passos

Aqui vão algumas ideias que eu pretendo implementar no futuro para evoluir esse projeto:

- Implementar refresh token corretamente (salvar no banco, blacklisting de tokens)
- Adicionar controle de roles/permissões (admin, usuário normal)
- Enviar e-mail de confirmação no registro
- Limitar tentativas de login (evitar brute-force)
- Logout (invalidar token)
- Logs estruturados (ex: com SLF4J)
- Documentação da API com Swagger / OpenAPI

---

## Autor

Trindade — Desenvolvedor Back-End
GitHub: https://github.com/trindadeeesx
