# Analisador Léxico - Linguagem Jack

Implementação de um analisador léxico (scanner) para a linguagem Jack, desenvolvido em Java como parte da disciplina de Compiladores. O programa lê arquivos `.jack`, identifica os tokens e gera uma saída em formato XML conforme o padrão do nand2tetris.

Este projeto representa a etapa inicial da construção de um compilador, focando na análise léxica da linguagem Jack.
---

## Autora

- Samara Santos Viegas  
- Matrícula: 2022042898  

---

## Tecnologias

- Java  
- Sem uso de geradores automáticos 

---

##  Funcionalidades

- Leitura de arquivos `.jack`  
- Remoção de espaços e comentários (`//` e `/* */`)  
- Identificação de tokens:
  - `keyword`
  - `symbol`
  - `identifier`
  - `integerConstant`
  - `stringConstant`
- Geração de saída em XML  

---

## Exemplo de saída

```xml
<tokens>
<keyword> class </keyword>
<identifier> Main </identifier>
<symbol> { </symbol>
...
</tokens>
```

---

## Observações

- Caracteres especiais são tratados:
  - `<` → `&lt;`
  - `>` → `&gt;`
  - `&` → `&amp;`

---

## Como executar

### No Eclipse
1. Abrir o projeto  
2. Ajustar o caminho do arquivo `.jack`  
3. Executar `JackTokenizer` como Java Application  

---

## Estrutura

```
jacklexer/
├── JackTokenizer.java
├── Main.jack
├── MainT.xml
└── README.md
```
