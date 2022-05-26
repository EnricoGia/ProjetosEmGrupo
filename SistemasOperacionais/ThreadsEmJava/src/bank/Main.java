/*
T02-Barril
    Guilherme de Campos RA: 20.00089-8
    Leonardo Campos da Costa RA: 20.00786-8
    Luis Guilherme de Souza Munhoz RA: 20.01937-8
    Enrico Giannobile RA: 19.00610-0
*/

package bank;

import sun.misc.Signal;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1000);
        Client clients[] = {
                new Client("Jeff Beijos", account),
                new Client("Elon Mosca", account),
                new Client("Steve Processos", account),
                new Client("Bill Games", account) };

        Signal.handle(new Signal("INT"), // CTRL+C
                (Signal signal) -> {
                    System.out.println("Terminando a simulação...");
                    for (Client client : clients) {
                        System.out.println("Cliente " + client.getName() + " encerrando..."
                        );
                        client.interrupt();
                        
                    }
                });
        for (Client client : clients) {
            client.start();
        }

    }
}

