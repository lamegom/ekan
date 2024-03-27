
# Ekan teste

projeto teste para oportunidade ekan 

## Run Locally

Clone the project

```bash
  git clone https://github.com/lamegom/ekan.git
```

Go to the project directory

```bash
  cd ekan
  git checkout master
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


- Cadastrar um beneficiário junto com seus documentos; beneficiario-controller >> /api/benficiarios POST
- Listar todos os beneficiários cadastrados; beneficiario-controller >> /api/benficiarios GET
- Listar todos os documentos de um beneficiário a partir de seu id; beneficiario-controller >> /api/benficiarios/{id} GET
- Atualizar os dados cadastrais de um beneficiário; beneficiario-controller >> /api/benficiarios/{id} PUT
- Remover um beneficiário. beneficiario-controller >> /api/benficiarios/{id} DELETE

