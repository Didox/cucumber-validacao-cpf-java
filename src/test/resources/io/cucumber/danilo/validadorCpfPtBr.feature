# language: pt

Funcionalidade: Validar CPF
  Cenario: Com CPF válido
    Dado que eu acesse a página de validação
    E preencho o nome
    E preencho o CPF "306.353.760-83"
    Entao devo ver um CPF válido

  Cenario: com CPF inválido
    Dado que eu acesse a página de validação
    E preencho o nome
    E preencho o CPF "306.353.760-81"
    Entao devo ver um CPF inválido
