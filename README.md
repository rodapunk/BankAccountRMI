# BankAccountRMI
Aplicação RMI onde um objeto remoto é uma conta bancária e vários clientes podem acessar essa conta.

1. Executar o servidor a partir da classe BankServer
    - Todos os métodos implementados são synchronized para garantir consistência de dados.

2. Existem duas classes de cliente, sejam elas:
    - BankClient e BankClientMultiLookup, executar uma de cada vez.

3. Executar o cliente a partir da classe BankClient
    - Essa classe cria um objeto BankAccount e a partir da criação e inicialização de múltiplos threads simula o acesso concorrente ao servidor com cada thread utilizando o mesmo objeto.

4. Executar o cliente a partir da classe BankClientMultipleLookup
    - Essa clase cria um objeto BankAccount para cada thread e a partir da criação e inicialização destas threads simula o acesso concorrente ao servidor com cada thread fazendo seu próprio lookup.

5. Considerações
    - Temos um cenário com 5 threads, cada uma executando 3 vezes as operações de depósito e retirada, totalizando 30 operações. Considerando um depósito de 100 seguido por uma retirada de 50, idealmente, o saldo final deve ser sempre 750. A garantia dessa consistência de dados é assegurada pelo modificador synchronized nos métodos. No entanto, se removermos esse modificador de todos os métodos, a estabilidade do resultado será comprometida. Sem a sincronização, múltiplas threads podem acessar os métodos de depósito e retirada simultaneamente, criando uma condição de corrida. Isso significa que não há garantia de que apenas uma thread possa acessar um método por vez, levando a inconsistências nos dados e, consequentemente, a um saldo final variável e imprevisível.
