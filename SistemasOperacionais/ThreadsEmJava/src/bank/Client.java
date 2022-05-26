/*
T02-Barril
    Guilherme de Campos RA: 20.00089-8
    Leonardo Campos da Costa RA: 20.00786-8
    Luis Guilherme de Souza Munhoz RA: 20.01937-8
    Enrico Giannobile RA: 19.00610-0
*/

package bank;

import java.util.concurrent.ThreadLocalRandom;

public class Client extends Thread {
    private Account account;
    public final Integer[] values = { 10, 20, 50, 100 };

    public Client(String name, Account account) {
        super(name);
        setAccount(account);
    }

    public void execute() throws InterruptedException {
        Integer action = ThreadLocalRandom.current().nextInt(0, 2);
        Integer value = values[ThreadLocalRandom.current().nextInt(0, 4)];
        if (action == 1) {
            account.deposit(value);
        } else if (action == 0) {
            account.withdraw(value);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.execute();
                Thread.sleep(200);
            }
        }

        catch (InterruptedException e) {
        }

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}