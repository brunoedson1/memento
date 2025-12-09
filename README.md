# 🧠 Padrão Comportamental Memento – Relatório Financeiro

O **Memento** foi utilizado no projeto de Relatório Financeiro para permitir que o relatório **guarde e restaure estados anteriores** — como **Rascunho**, **Revisado** e **Aprovado** — **sem expor detalhes internos** da implementação.  
Assim, o relatório pode ter um “histórico de versões” controlado.

---

## 🎯 Ideia Central do Memento

O padrão define **três papéis fundamentais**:

### 🔹 Originator  
O objeto cujo estado pode mudar e precisa ser salvo/restaurado.

### 🔹 Memento  
Uma “foto” do estado em um momento específico.

### 🔹 Caretaker  
Armazena os mementos e escolhe qual estado restaurar.

No projeto, esses papéis foram implementados de forma simples, seguindo o mesmo modelo usado no *Memento do Aluno*.

---

# 🏗 Como ficou no Relatório Financeiro

## Estados Concretos (Singletons)

Três estados foram criados como instâncias únicas:
- RelatorioEstadoRascunho → "Rascunho"
- RelatorioEstadoRevisado → "Revisado"
- RelatorioEstadoAprovado → "Aprovado"

Cada classe:
implementa RelatorioEstado possui private static instância única fornece getInstance() para acesso

---

## Originator + Caretaker — RelatorioFinanceiroMemento

A classe responsável por:
- manter o estado atual
- guardar o histórico de estados
- permitir restauração

---

## 🧪 O que os testes garantem
✔ Armazenar estados corretamente
- Vários setEstado(...) adicionam estados ao histórico.

✔ Restaurar o estado inicial
- Após rascunho → revisado → aprovado, restaurar índice 0 volta ao Rascunho.

✔ Restaurar estados intermediários
- O relatório pode voltar ao meio da timeline (ex.: voltar de Aprovado para Revisado).

✔ Evitar erros de índice
- Chamadas como restauraEstado(-1) ou restauraEstado(999) lançam:
Índice inválido

---

## 📌 Benefícios do Memento no Relatório Financeiro
✔ Versionamento do relatório
- Permite registrar etapas da construção do relatório (rascunho → revisado → aprovado).

✔ Histórico seguro e encapsulado
- O estado interno não é exposto ao mundo exterior.

✔ Undo simples e elegante
- Voltar estados sem lógica complicada de if/else.

✔ Consistência
- Segue o mesmo padrão aplicado anteriormente ao estado do Aluno.
