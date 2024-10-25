# BankAccountRMI
RMI application where a remote object is a bank account, and multiple clients can access this account.

1. Run the server from the BankServer class
    - All implemented methods are synchronized to ensure data consistency.

2. There are two client classes, namely:
    - BankClient and BankClientMultiLookup. Execute one at a time.

3. Run the client from the BankClient class
    - This class creates a BankAccount object, and by creating and initializing multiple threads, it simulates concurrent access to the server, with each thread using the same object.

4. Run the client from the BankClientMultipleLookup class
    - This class creates a BankAccount object for each thread, and by creating and initializing these threads, it simulates concurrent access to the server, with each thread performing its own lookup.

5. Considerations
    - There is a scenario with 5 threads, each executing deposit and withdrawal operations 3 times, totaling 30 operations. Considering a deposit of 100 followed by a withdrawal of 50, ideally, the final balance should always be 750. This data consistency is ensured by the synchronized modifier in the methods. However, if we remove this modifier from all methods, the stability of the result will be compromised. Without synchronization, multiple threads can access the deposit and withdrawal methods simultaneously, creating a race condition. This means there is no guarantee that only one thread can access a method at a time, leading to data inconsistencies and, consequently, a variable and unpredictable final balance. To test the aforementioned data consistency/inconsistency, it is recommended to stop and restart the server each time before running one of the client classes.

6. Program running (click on the image for better resolution)
<img src="https://github.com/rodapunk/BankAccountRMI/blob/main/images/program_running.gif">

============================================================================================

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
    - Tem-se um cenário com 5 threads, cada uma executando 3 vezes as operações de depósito e retirada, totalizando 30 operações. Considerando um depósito de 100 seguido por uma retirada de 50, idealmente, o saldo final deve ser sempre 750. A garantia dessa consistência de dados é assegurada pelo modificador synchronized nos métodos. No entanto, se removermos esse modificador de todos os métodos, a estabilidade do resultado será comprometida. Sem a sincronização, múltiplas threads podem acessar os métodos de depósito e retirada simultaneamente, criando uma condição de corrida. Isso significa que não há garantia de que apenas uma thread possa acessar um método por vez, levando a inconsistências nos dados e, consequentemente, a um saldo final variável e imprevisível. Para testar a consistência/inconsistência de dados supracitada, recomenda-se parar e reiniciar o servidor toda vez antes de se executar uma das classes clientes.

6. Programa rodando (clicar na imagem para uma melhor resolução)
<img src="https://github.com/rodapunk/BankAccountRMI/blob/main/images/program_running.gif">
