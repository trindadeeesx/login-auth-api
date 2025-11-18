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
git clone https://github.com/trindadeeesx/login-auth-web.git
cd login-auth-web
```

2. Instale as dependencias:

```bash
npm install
```

3. Inicie a aplicação:

```bash
npm run dev
```

4. Acesse no navegador:

```
http://localhost:5173 (ou outra porta, se for configurada)
```

---

### CONFIGURAÇÃO PARA INTEGRAR COM A API

Crie um arquivo .env (ou .env.local) baseado no .env.example:

```env
VITE_API_URL=http://localhost:8080
```

No código, configure seu cliente HTTP (por exemplo, axios):

```ts
import axios from "axios";

const api = axios.create({
	baseURL: import.meta.env.VITE_API_URL,
});

export default api;
```

Use esse api para fazer requisições para endpoints de login, registro, etc.

---

### DIAGRAMA DE ARQUITETURA (ASCII)

```
+-----------------------+        HTTP         +----------------------------+
|     Interface React   | <------------------ |        API Backend         |
|  (Registro / Login)   |                     |    (Spring Boot + JWT)     |
+-----------+-----------+                     +-----------+----------------+
            |                                           |
            |                                           |
            v                                           v
+-------------------------+                 +----------------------------+
|   Auth Context / State  |                 |   Controllers / Services   |
|  (Guarda token e user)  |                 |   Validações + Segurança   |
+-------------------------+                 +----------------------------+
            |                                           |
            v                                           v
+-------------------------+                 +----------------------------+
|    Rotas Protegidas     |                 | Persistent User / Role DB  |
| (Ex: /dashboard, /home) |                 |       (Spring Data JPA)    |
+-------------------------+                 +----------------------------+
```

Fluxo:

- Usuário preenche login / registro no React
- React envia request para a API (login-auth-api)
- Se autenticação for bem-sucedida, API retorna JWT
- React salva token no AuthContext + armazenamento local
- Usuário navega por rotas protegidas
- Logout limpa token e redireciona para a página de entrada

---

MELHORIAS FUTURAS (ROADMAP)

- Implementar refresh token no frontend
- Feedback visual mais elaborado (modais, alerts)
- Validação de formulário mais robusta
- Interface mais bonita com biblioteca UI (Material-UI, Tailwind, etc)
- Testes (unitários e de integração) para componentes e hooks
- Internacionalização (i18n)
- Responsividade (mobile-first design)
- Deploy em Vercel ou Netlify

---

## Autor

Trindade — Desenvolvedor Back-End
GitHub: https://github.com/trindadeeesx
