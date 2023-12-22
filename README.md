
# Ekan teste

projeto teste para oportunidade ekan 

## Running Tests

Se você não estiver com o docker ligado não se esqueça de colocar o -DskipTests no comand maven

```bash
  mvn spring-boot:run -DskipTests
```


## Run Locally

Clone the project

```bash
  git clone https://github.com/lamegom/ekan.git
```

Go to the project directory

```bash
  cd ekan
```

Install dependencies

```bash
  mvn clean install
```

Start the server

```bash
  mvn spring-boot:run
```


## Roadmap

- Acesse http://localhost:8080/swagger-ui.html

- Para gerar o token vá em authentication-controller >> api/auth/login e preencha username=admin, password=admin para gerar o token

- Copie e cole clicando no botão Authorize

- Depois vá em beneficiario-controller >> /api/benficiarios e liste os beneficiarios existentes
