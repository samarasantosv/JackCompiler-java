# 🛠️ Analisador Léxico - Linguagem Jack

Implementação de um analisador léxico (scanner) para a linguagem Jack, desenvolvido em Java. O programa lê automaticamente todos os arquivos `.jack` de uma pasta e gera seus respectivos arquivos `.xml`.

---

## 👩‍💻 Autora

- Samara Santos Viegas  
- Matrícula: 2022042898  

---

## 💻 Tecnologias

- Java  
- Implementação manual (sem Lex/Yacc)

---

## 🎯 Funcionalidades

- Leitura automática de múltiplos arquivos `.jack`
- Remoção de espaços e comentários (`//` e `/* */`)
- Identificação de tokens:
  - keyword
  - symbol
  - identifier
  - integerConstant
  - stringConstant
- Geração automática de arquivos XML

---

## 📁 Estrutura do Projeto

```
jacklexer/
├── JackTokenizer.java
├── teste/
│   ├── Main.jack
│   ├── Square.jack
│   ├── SquareGame.jack
│   ├── MainT.xml
│   ├── SquareT.xml
│   └── SquareGameT.xml
└── README.md
```

---

## ▶️ Como executar

1. Abrir o projeto no Eclipse  
2. Garantir que os arquivos `.jack` estejam na pasta `teste`  
3. Executar `JackTokenizer` como Java Application  

---

## 📤 Saída

Para cada arquivo `.jack`, é gerado automaticamente um `.xml` correspondente:

- Main.jack → MainT.xml  
- Square.jack → SquareT.xml  
- SquareGame.jack → SquareGameT.xml  

---

## ⚠️ Observações

- Caracteres especiais são tratados:
  - `<` → `&lt;`
  - `>` → `&gt;`
  - `&` → `&amp;`

---

## 🚀 Sobre

Este projeto representa a etapa de análise léxica na construção de um compilador para a linguagem Jack.
