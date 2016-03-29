# J+
Programming Language with version support built in


### Correr o interpretador

**É necessário a versão 4.0 do javacc**

```sh
make i
```

### Exemplos

```
let o = {
  a: 1,
  sum: fun x:int => this.a + x end,
  inc@1: fun => this.a + 1 end,
  inc@2: fun => this.sum(1) end
} in o.inc@2() end;;
```

### Notas

+ Pedir versões que não existem, retorna um erro _Undeclared version_
+ Pedir um objecto versionado sem versão, retorna a versão mais recente (ex ´let o = {a@1: 1, a@2: 2} in o.a end;;´ retorna 2)
