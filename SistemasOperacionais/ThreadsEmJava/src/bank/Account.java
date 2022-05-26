/*
T02-Barril
    Guilherme de Campos RA: 20.00089-8
    Leonardo Campos da Costa RA: 20.00786-8
    Luis Guilherme de Souza Munhoz RA: 20.01937-8
    Enrico Giannobile RA: 19.00610-0
*/

package bank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private Integer balance;
    private final Lock lock = new ReentrantLock();
    private final Condition lowBalance = lock.newCondition();

    public Account(Integer value) {
        this.setBalance(value);
    }

    // Deposita um valor na conta
    public boolean deposit(Integer value){
        lock.lock(); 

        try {
            setBalance(value + getBalance());
            System.out.println("Cliente: " + Thread.currentThread().getName() + " depositou " + value);
            System.out.println("Conta: saldo atualizado de " + getBalance());
            lowBalance.signalAll(); // "Acorda" demais Threads que estejam "dormindo"
 
            return true;
        }

        finally {
            lock.unlock();
        }

    }

    // Retira um valor da conta
    public boolean withdraw(Integer value) throws InterruptedException{
        lock.lock();
        try{
            // "Dorme" enquanto o valor da conta for insuficiente para ser retirado
            while(value > getBalance()){
                System.out.println("Saldo insuficiente, esperando...");
                lowBalance.await();
            }  
            
            setBalance(getBalance() - value);
            System.out.println("Cliente: " + Thread.currentThread().getName() + " retirou " + value);
            System.out.println("Conta: saldo atualizado de " + getBalance());
            return true;
        }
        finally{
            lock.unlock();
        }
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
