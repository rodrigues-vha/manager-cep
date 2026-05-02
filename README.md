# Documentação manager-cep

### Esse programa gerencia algumas chamadas para a API Externa ViaCep
##### __site: https://viacep.com.br/__


## Serviços disponíveis:

* manager-cep1/viacep/{codigo_cep}

Esse serviço obtem os dados do cep passado para o serviço


* manager-cep1/relatoriocep/estado-mais-acessado

Esse serviço mostra o estado federal mais acessado até o momento


* manager-cep1/relatoriocep/todas-consultas-feitas

Esse serviço mostra todos as consultas já realizadas


## Plano de Execução

_Nota: é necessário ter o docker instalado na máquina_



Esse projeto está configurado para executar containers docker. Uma para o banco de dados postgres e outro para a aplicação manager-cep
O programa manager-cep roda na porta 8080 e o banco de dados na porta 5433 para quem vai acessar de fora do container


### Na raíz do projeto basta executar algum dos comandos abaixo para rodar o programa


Para construir a imagem e executar o container fazemos:

* docker compose up --build


Já com a imagem construida podemos somente executar os containers:

* docker compose up 

Já com a imagem construida podemos somente executar os containers em segundo plano:

* docker compose up -d





