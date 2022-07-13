# API Rest de Gestão 'Paciente/Encaminhamento Hospitalar'

Buscando entregar melhores resultados e experiências mais positivas para os pacientes, minha 
API REST tem por objetivo otimizar a rastreabilidade entre 'enfermos e seus
respectivos encaminhamentos a hospitais', prevenindo ocupação disforme que possa 
gerar superlotação hospitalar e, consequentemente, aumentando a eficiência dos profissionais de saúde.


**Incrementei ao projeto os seguintes recursos:**
```
>>> Spring Security, com suporte a token JWT e biblioteca Spring Cloud OAuth2;
>>> Consumi o Webservice 'ViaCep', adotando o Spring Cloud OpenFeign;
>>> 'Swagger 2' para interpretar a estrutura da API e gerar documentação;
>>> Dois ambientes de desenvolvimento (Test e Dev);
>>> Spring Validation (ao utilizar o Postman, requisição 'POST ViaCepCadastro', necessário 
        buscar CEP, CPF e E-mail no site 'https://www.4devs.com.br/gerador_de_pessoas');
>>> Listagem com paginação (contendo seis parâmetros, inclusive filtragem por 
        limitação de tempo inicial/final).
>>> Auditoria, onde ficará registrado o momento em que as informações são atualizadas.
```




* Quanto ao Postman: 

Implementei 112 testes de ponta a ponta de forma automatizada por meio do envio de requisições HTTP e da análise do seu retorno. Ver aba codificação de testes. Com este recurso foi sim possível ordenar/validar o comportamento de modo automatizado das requisições praticamente com ‘um clique’ (Run Collection). O arquivo de testes está incluso na raiz do projeto e foi nomeado como **‘TEST_Postman_AdministracaoHospitalar.postman_collection’**. Já o arquivo contendo as variáveis de ambiente está nomeado como **'TEST_8080_AdministracaoHospitalar.postman_environment'**.
    
No Postman (requisição **'POST New user role admin/operator'**), devido à necessidade recorrente de autenticação 'OAuth2' no período de testes, optei por não deixar estático o campo **'email'** . Deste modo, implementamos a criação **randomizada/aleatória** de emails (ver aba **'Pre-request Script'**).
    
Quanto à variável de ambiente, deixar em **branco/não preenchidos** ambos os campos INITIAL VALUE e CURRENT VALUE referentes à variável **'token'**. 

Configurações necessárias para a variável de ambiente (constantes do arquivo **‘TEST_8080_AdministracaoHospitalar.postman_environment’**):
  
 ![Environment_8080_MedicalCare](https://user-images.githubusercontent.com/57645281/148706500-b28ace67-8ca5-498a-a61d-213221477ca7.png)




* Quanto ao desenvolvimento de autenticação e autorização de usuários através do Spring Security, 
com suporte a token JWT e biblioteca Spring Cloud OAuth2:
```
- A requisição oferece as credenciais e meu sistema retorna o token JWT já com OAuth2.


- São 2 os tipos GrantedAuthority: ROLE_ADMIN ou ROLE_OPERATOR.


- Adotei o 'email' como Username para autenticaçao e autorização de usuários (lembrando que 
'email' é um atributo do usuário).


- No Postman, implementei a criação randomizada/aleatória de emails nas requisições 
'POST {{baseUrl}}/users' ( ver aba 'Pre-request Script').


- No arquivo ‘data.sql’ fiz seed com dois perfis de usuários: perfil operador(ROLE_OPERATOR) e 
perfil administrador(ROLE_ADMIN), sendo que o prefixo ‘ROLE + underline’ é um padrão do Spring Secutity.


- No arquivo ‘data.sql’ a variável ‘password’ foi previamente criptografada com o algoritmo ‘decript’.


- Para proteger as senhas criei Bean ‘BCryptPasswordEncoder’ na classe de configuração ‘AppConfig’, 
que transforma a senha inserida pelo usuário em Hash.

- Adicionei ao Token as seguintes informações customizadas: ‘E-mail’, ‘userFirstName’ e 
‘userId’ (ver Postman, requisição ‘POST: {{baseUrl}}/oauth/token’). Response Body:

                        {
                            "access_token": 
                            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NDE4NjIzMTcsInVzZXJfbmF   
                            tZSI6InNpbHZpYUBnbWFpbC5jb20iLCJhdXRob3JpdGllcyI6WyJST0xFX09QRVJBVE9SIiwiUk9MR
                            V9BRE1JTiJdLCJqdGkiOiJmYmYwYmVhMC03Y2Q2LTQyMDUtYjVlMi05OWI0YWJlZmUzOWMiLCJjbGl
                            lbnRfaWQiOiJBcGkiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.ipeSsZPhqzKMPC-eTrfNd5XY
                            RHUJacpQ90Px4Yc6-fw",
                            "token_type": "bearer",
                            "expires_in": 86399,
                            "scope": "read write",
                            "E-mail": "silvia@gmail.com",
                            "userFirstName": "Silvia",
                            "userId": 2
                        }
```



```

>>> São 2 os tipos GrantedAuthority:
    - para testar 'ROLE_ADMIN', inserir no campo 'username': 'silvia@gmail.com'
                Possui autorização para realizar todas as requisições HTTP implementadas.
    
    
    - para testar 'ROLE_OPERATOR', inserir em 'username': 'pedro@gmail.com'
                Possui autorização apenas para:
                                HttpMethod.POST, "/paciente/**"
                                HttpMethod.GET, "/paciente/**"
                                HttpMethod.PUT, "/paciente/**"     
                                        
```




* Quanto à listagem com paginação:
```
Implementei requisição paginada (contendo seis parâmetros), inclusive com filtragem por 
limitação de datas inicial/final. Conferir no Postman.
```





* Quanto ao Swagger 2 para a documentação de todos os endpoints, acessar o seguinte link:
```
http://localhost:8080/swagger-ui.html
```



* Quanto ao Spring Validation:
```
Validação é uma regra de negócio.

Lembrando que CEP, CPF e E-mail devem ser válidos e únicos (não repetidos).

Deste modo, ao utilizar o Postman, requisição 'POST {{baseUrl}}/paciente', necessário 
buscar CEP, CPF e E-mail no site 'https://www.4devs.com.br/gerador_de_pessoas'.

Como uma das validações que implementei foi que, ao inserir novo usuário o meu banco de 
dados não aceitará email repetido, criei validação customizada no 
Bean Validation implementando o ConstraintValidator.

```






* Quanto aos dois os ambientes de desenvolvimento: 
    - Ambiente de teste (configuração application-test.properties): banco de dados H2. 
    - Ambiente Dev (configuração application-dev.properties):  utilizamos o banco de dados Postgre.

```
>>> Definir ambiente de desenvolvimento Test/dev em 'APPLICATION.PROPERTIES' ( em 'spring.profiles.active').

>>> Banco de dados H2 (modo teste):

    Acessar o Link:  http://localhost:8080/h2-console

    JDBC URL: jdbc:h2:mem:testdb 
    User Name: sa 
    Password: ‘não preencher’
  
  
>>> Banco de dados Postgres (modo Dev):

    - Está na raiz do projeto e foi nomeado como **'SCRIPT_TABELA_BCO_DADOS_POSTGRES'** o arquivo com os Scripts SQL.
    
    - Em ‘application-dev.properties’ devem ser customizados (para 'rodar' no Postgres instalado em 
    seu sistema, caro leitor):
          > nome da base de dados: 'medical'
          > username: 'SEU USERNAME'
          > password: 'SUA PASSWORD'
````

 





# Requisições HTTP implementadas:
![Swagger_Medical_Care](https://user-images.githubusercontent.com/57645281/148706224-ceef9ee7-21e2-462d-ab01-133e9cc33bca.png)









*__POST {{baseUrl}}/hospital
>>>Novo hospital credenciado é cadastrado no banco de dados.

>>>Request Body:
```
                {
                  "nomeDoHospital": "Real Hospital Português",
                  "enderecoDoHospital": "Av. Conselheiro Aguiar, 2502, Recife - PE",
                  "bairroDoHospital": "Boa Viagem",
                  "cepDoHospital": "51020-020",  
                  "telefoneDoHospital": "(81) 3416-1800"
                }
```


>>>Response Body:
```
                {
                    "id": 8,
                    "nomeDoHospital": "Real Hospital Português",
                    "enderecoDoHospital": "Av. Conselheiro Aguiar, 2502, Recife - PE",
                    "bairroDoHospital": "Boa Viagem",
                    "cepDoHospital": "51020-020",
                    "telefoneDoHospital": "(81) 3416-1800",
                    "moment": "2022-01-10T13:25:02.909257300Z"
                }

```

*__GET {{baseUrl}}/hospital/boa/bairroDoHospitalIgnoreCase
>>>Busca de hospitais por bairro, lembrando que é possível realizar a busca usando apenas trecho da palavra.

>>>(levando em consideração possível erro de digitação ou variações de digitação de palavra realizadas pelo usuário).



*__GET {{baseUrl}}/hospital/2/findById
>>>Buscar hospital previamente cadastrado pelo seu 'Id'. 



*__GET {{baseUrl}}/hospital/esp/nomeDoHospitalIgnoreCase
>>>Busca de hospitais por nome da instituição, lembrando que é possível realizar a busca usando apenas trecho da palavra.

>>>(levando em consideração possível erro de digitação ou variações de digitação de palavra realizadas pelo usuário).



*__GET {{baseUrl}}/hospital/paginacaoComSeisParametros?min=2021-01-01T05:00:00Z&max=2021-01-27T19:00:00Z&direction=DESC&linesPerPage=0&orderBy=moment&page=0
>>>Implementamos recurso de auditoria.

>>>O operador informa, opcionalmente, uma data inicial e data final de cadastro do hospital (intervalo de tempo).

>>>para filtrar os dados. Foi implementado requisição paginada (contendo seis parâmetros). 



*__PUT {{baseUrl}}/hospital/8
>>>Atualizar por 'Id' hospital previamente cadastrado. 



*__DELETE {{baseUrl}}/hospital/7
>>>Apagar hospital previamente cadastrado.

>>>Lembrando que não é possível deletar hospital ainda associado a paciente em tratamento.



*__POST {{baseUrl}}/paciente
>>>Para complementar as informações referentes ao endereço, implementamos o consumo do Webservice 'ViaCep', adotando o Spring Cloud OpenFeign.

>>>Devido ao Spring Validation, ao utilizar o Postman para testar a requisição, necessário buscar CEP, CPF e E-mail no site 'https://www.4devs.com.br/gerador_de_pessoas'.

>>>Lembrando que CPF e E-mail devem ser válidos e únicos (não repetidos).

>>>Request Body:
```
                {
                  "nome": "Márcio Gabriel Ian da Costa",
                  "cep": "29126-572",
                  "complemento": "Apt 802",
                  "numero": 599,
                  "cpf": "497.499.315-13",
                  "email": "marciogabrieliandacosta@metododerose.org",
                  "tipoSanguineo": "B+",
                  "dataDeNascimento": "07-01-1942",
                  "idade": 80,
                  "dataDeInternamento": "07-01-2022",
                  "alaHospitalar": "enfermaria",
                  "enfermidade": "Diabetes",
                  "gravidadeDaEnfermidade": "LEVE"
                }

```


>>>Response Body:
```
                {
                    "id": 13,
                    "nome": "Márcio Gabriel Ian da Costa",
                    "email": "marciogabrieliandacosta@metododerose.org",
                    "cpf": "497.499.315-13",
                    "dataDeNascimento": "07-01-1942",
                    "logradouro": "Rua das Palmeiras",
                    "numero": 599,
                    "complemento": "Apt 802",
                    "bairro": "Morada da Barra",
                    "localidade": "Vila Velha",
                    "uf": "ES",
                    "cep": "29126-572",
                    "idade": 80,
                    "tipoSanguineo": "B+",
                    "enfermidade": "Diabetes",
                    "dataDeInternamento": "07-01-2022",
                    "alaHospitalar": "enfermaria",
                    "gravidadeDaEnfermidade": "LEVE",
                    "updatedAt": null
                }

```



*__GET {{baseUrl}}/paciente/032.544.534-68/findByCpf
>>>Busca de pacientes previamente cadastrados por CPF. 



*__GET {{baseUrl}}/paciente/1/findById
>>>Buscar paciente previamente cadastrado pelo seu 'Id'. 



*__GET {{baseUrl}}/paciente/paginacao?direction=ASC&linesPerPage=24&orderBy=nome&page=0
>>>Para filtrar os dados. Foi implementado requisição paginada.



*__GET {{baseUrl}}/paciente/somentePacientesGravesnameAsc
>>>Busca que traz relação apenas dos pacientes com grau da enfermidade assinalado como 'GRAVE'
>>>Nomes em ordem ascendente



*__GET {{baseUrl}}/paciente/freitas/nameIgnoreCase
 >>>Busca por paciente por nome, lembrando que é possível realizar a busca usando apenas trecho da palavra (levando em consideração possível erro de digitação do usuário) 



*__PUT {{baseUrl}}/paciente/1/caracteristicasDeCadastro
>>>Atualizar por 'Id' dados de um paciente previamente cadastrado.

>>>Esta requisição permite apenas a atualização/edição cadastral do paciente.

>>>Request Body:
```
                {
                  "nome": "xxx Daiane Ana Bernardes",  
                  "dataDeNascimento": "04-10-2006",
                  "idade": 16, 
                  "logradouro": "xxx Rua Santa Agripina",
                  "numero": 470,
                  "complemento": "xxx Apt 02",
                  "localidade": "xxx Recife",
                  "bairro": "xxx Linha do Tiro",
                  "cep": "52131-600",
                  "uf": "xxx PE"
                }
```

>>>Response Body:
```
                {
                    "pacienteId": 1,
                    "nome": "xxx Daiane Ana Bernardes",
                    "dataDeNascimento": "04-10-2006",
                    "logradouro": "xxx Rua Santa Agripina",
                    "numero": 470,
                    "complemento": "xxx Apt 02",
                    "bairro": "xxx Linha do Tiro",
                    "localidade": "xxx Recife",
                    "uf": "xxx PE",
                    "cep": "52131-600",
                    "idade": 16
                }
```

*__PUT {{baseUrl}}/paciente/1/caracteristicasDeSaude
>>>Atualizar por 'Id' dados de um paciente previamente cadastrado.

>>>Esta requisição permite apenas a atualização/edição das características de saúde do paciente.

>>>Request Body:
```
                {  
                  "tipoSanguineo": "*** B+",  
                  "enfermidade": "*** Diabetes",
                  "dataDeInternamento": "07-01-2022",
                  "alaHospitalar": "*** enfermaria",
                  "gravidadeDaEnfermidade": "LEVE"
                }
```

>>>Response Body:
```
                {
                    "pacienteId": 1,
                    "tipoSanguineo": "*** B+",
                    "enfermidade": "*** Diabetes",
                    "dataDeInternamento": "07-01-2022",
                    "alaHospitalar": "*** enfermaria",
                    "gravidadeDaEnfermidade": "LEVE"
                }
```

*__DELETE {{baseUrl}}/paciente/2
>>>Apagar paciente previamente cadastrado e que ainda não esteja associado a hospital.

>>>Como não implementamos (ainda) informações adicionais que possa atestar que o paciente foi 'liberado' de seu respectivo hospital (tais como se o paciente obteve 'alta médica' ou 'morreu'), somente será possível deletar paciente não previemente cadastrado/associado a hospital.


*__POST {{baseUrl}}/encaminhamentoHospitalar
>>>Encaminhamento de paciente para hospital.

>>>É informado o 'Id' do paciente e o 'Id' do Hospital (ambos previamente cadastrados).

>>>Request Body:
```
                {
                    "pacienteId": 4,    
                    "hospital": [
                            {     
                                "id": 5    
                            }            
                    ]  
                }	
```

>>>Response Body:
```
                {
                    "id": 1,
                    "moment": "2022-01-10T13:18:55.673453300Z",
                    "pacienteId": 4,
                    "nome": "Flávia Liz Emily Dias",
                    "cpf": "965.787.194-82",
                    "email": "flavializemilydias_@spamgourmet.com",
                    "dataDeNascimento": "30-04-1972",
                    "logradouro": "Rua Mauricéia",
                    "numero": 577,
                    "complemento": "casa 74",
                    "bairro": "Iputinga",
                    "localidade": "Recife",
                    "uf": "PE",
                    "cep": "50670-480",
                    "idade": 49,
                    "tipoSanguineo": "A+",
                    "enfermidade": "Miocardiopatias",
                    "dataDeInternamento": "25-07-2021",
                    "alaHospitalar": "UTI",
                    "gravidadeDaEnfermidade": "MODERADA",
                    "hospital": [
                        {
                            "id": 5,
                            "nomeDoHospital": "Hospital Agamenon Magalhães",
                            "enderecoDoHospital": "Estr. do Arraial, 2723, Recife - PE",
                            "bairroDoHospital": "Casa Amarela",
                            "cepDoHospital": "52070-230",
                            "telefoneDoHospital": "(81) 3184-1600",
                            "moment": "2021-02-10T16:00:00Z"
                        }
                    ]
                }
```


*__GET {{baseUrl}}/encaminhamentoHospitalar/3/findById
>>>Buscar por 'Id' de encaminhamento hospitalar previamente cadastrado.



*__GET {{baseUrl}}/encaminhamentoHospitalar/Encaminhamento
>>>Busca relação de todos os encaminhamentos hospitalares previamente cadastrados.
