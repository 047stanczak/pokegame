# Checklist: Jogo Turn-Based em Java — MVP (Foco: POO e Boas Práticas)

**Objetivo:** construir um *MVP funcional 1v1 no terminal* para aprender modelagem orientada a objetos e boas práticas. Dados em JSON. Sem GUI nem autenticação.

---

## Como usar este checklist

* Marque cada item ao completar (Markdown checklist).
* Cada item tem um critério de aceitação objetivo (como saber que está pronto).
* Comece pelo design e modelagem, depois implemente e por fim escreva testes.

---

## 0 — Pré-requisitos

* [ ] JDK 17+ instalado.
  *Critério:* `java -version` mostra 17 ou superior.
* [ ] Maven ou Gradle configurado.
  *Critério:* `mvn -v` ou `gradle -v` funciona.
* [ ] IDE (IntelliJ/VSCode/Eclipse) pronto para Java.
  *Critério:* consegue compilar um projeto Java simples.

---

## 1 — Design e especificação mínima

* [ ] Escrever resumo do jogo (5–10 linhas).
  *Critério:* descreve seleção de creature, 3 moves, turnos por iniciativa, vitória ao desmaiar.
* [ ] Definir atributos mínimos de `Creature` (nome, level, Stats, currentHp, moves).
  *Critério:* lista documentada.
* [ ] Definir `Move` (nome, power, accuracy, pp, category: DAMAGE/HEAL).
  *Critério:* exemplos de moves.
* [ ] Documentar fluxo de um turno (iniciativa → escolha → acerto → aplicar efeito → checar fim).
  *Critério:* passo a passo escrito.

---

## 2 — Estrutura do projeto (pacotes)

* [ ] Criar pacotes esqueleto: `model`, `engine`, `ui`, `persistence`, `ai`, `util`.
  *Critério:* pacotes existem e README explica responsabilidades.

---

## 3 — Modelagem (POO)

* [ ] `Stats` com campos (maxHp, attack, defense, speed).
  *Critério:* classe testável com getters.
* [ ] `Move` com campos e método para decrementar PP (`use()`).
  *Critério:* usar `use()` reduz PP e retorna sucesso/falha.
* [ ] `Creature` encapsulado (private fields) com `receiveDamage(int)`, `heal(int)`, `isFainted()`.
  *Critério:* invariantes mantidas (HP entre 0 e max).
* [ ] Decidir quais objetos são imutáveis (e.g., `Move` imutável).
  *Critério:* campos `final` quando aplicável.

---

## 4 — Engine de batalha

* [ ] `DamageCalculator` isolado com fórmula simples (configurável).
  *Critério:* método `calculateDamage(...)` testável.
* [ ] `BattleEngine` / `TurnResolver` que orquestra turnos e checa vitória.
  *Critério:* loop termina quando `Creature.isFainted()`.
* [ ] Iniciativa: `initiative = speed + random(-3..3)`.
  *Critério:* RNG injetável para testes.
* [ ] Implementar accuracy (verificação de acerto) ao usar move.
  *Critério:* move com 100% acerto não erra com RNG controlado.

---

## 5 — Dados (JSON)

* [ ] Definir esquema JSON para `moves.json` e `creatures.json` (campos obrigatórios).
  *Critério:* esquema documentado em README.
* [ ] Implementar `JsonLoader` (Gson/Jackson) que valida campos.
  *Critério:* carregamento falha com mensagem clara em caso de JSON inválido.
* [ ] Criar ≥5 creatures e ≥6 moves de exemplo.
  *Critério:* arquivos carregam sem exceção.

---

## 6 — Interface (Console)

* [ ] `ConsoleUI` para escolher perfil (nome simples), escolher creature e selecionar moves por índice.
  *Critério:* jogador consegue jogar um turno interativamente.
* [ ] Logs claros: ação, acerto/erro, dano, HP restante.
  *Critério:* saída fácil de entender.
* [ ] Tratamento de input inválido sem crash.
  *Critério:* pede reentrada.

---

## 7 — IA do oponente

* [ ] `AiController` básico: escolha aleatória; prioriza cura se HP < 30% e possui HEAL.
  *Critério:* IA respeita PP e usa heurística quando aplicável.
* [ ] Simular N partidas (por exemplo, 100) no modo headless para análises.
  *Critério:* gera estatísticas simples (vitórias/derrotas, turns médios).

---

## 8 — Testes (JUnit 5)

* [ ] Teste `DamageCalculator` com RNG mockado (limites e comportamento).
  *Critério:* testes determinísticos com RNG injetado.
* [ ] Teste de iniciativa e tie-breakers.
  *Critério:* ordem previsível com RNG controlado.
* [ ] Testes para `Creature` (`receiveDamage`, `heal`, `isFainted`).
  *Critério:* invariantes asseguradas.
* [ ] Teste de PP (`use()` decrementar e impedir uso em 0).
  *Critério:* coberto por unit tests.
* [ ] Teste de integração mínimo: simular 1 batalha sem UI e verificar término.
  *Critério:* retorna vencedor e não lança exceção.

---

## 9 — Boas práticas de código

* [ ] Encapsulamento: evitar fields públicos mutáveis.
  *Critério:* revisão rápida do código.
* [ ] SRP: cada classe com responsabilidade única.
  *Critério:* BattleEngine não mistura IO.
* [ ] Injeção de dependências simples via construtores (sem frameworks).
  *Critério:* facilita mock em testes.
* [ ] Documentação mínima (Javadoc ou comentários) para classes públicas.
  *Critério:* README indica convenção adotada.
* [ ] Controle de RNG via injeção para testes.
  *Critério:* testes usam RNG mockado.

---

## 10 — Build e README

* [ ] `pom.xml` ou `build.gradle` configurado (compile + testes).
  *Critério:* `mvn test` / `gradle test` executa e passa os testes.
* [ ] `README.md` com instruções: compilar, rodar, editar JSONs, executar simulações.
  *Critério:* seguir README reproduz jogo em ambiente limpo.

---

## 11 — Critérios finais do MVP

Para considerar concluído, todos os itens essenciais acima devem estar marcados **e** as validações manuais devem ser confirmadas:

* [ ] Jogador joga 1v1 contra IA no terminal.
* [ ] Movimentos consomem PP; accuracy afeta acerto; cura funciona.
* [ ] Batalha termina com vencedor declarado.
* [ ] Cobertura de testes para pontos críticos.

---

## Notas finais e armadilhas comuns

* Não misturar lógica de negócio com IO.
* Controlar RNG em testes.
* Comece com números conservadores e ajuste via simulações.
* Evitar padrões excessivos cedo; aplique onde agregam clareza.

---

Se preferir, eu posso agora:

* Gerar (apenas no documento) o **esquema JSON** sugerido para `moves.json` e `creatures.json`, ou
* Transformar os itens em issues com estimativas, ou
* Detalhar como injetar RNG nos testes.

Diga o que prefere e eu atualizo o documento.
