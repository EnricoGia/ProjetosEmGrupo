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
                        client.interrupt();
                    }
                });
        for (Client client : clients) {
            client.start();
        }

    }
}

