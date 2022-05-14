package bank;


import java.util.concurrent.ThreadLocalRandom;

public class Client extends Thread{
    private String name;
    private Account account;
    public final Integer[] values = {10,20,50,100};

    public Client(String name, Account account){
        super(name);
        this.setAccount(account);
    }

    public void execute(){
        Integer action = ThreadLocalRandom.current().nextInt(0,2);      
        Integer value = values[ThreadLocalRandom.current().nextInt(0,4)];
        if(action ==  1){
           account.deposit(value);
        } else if(action == 0){
            account.withdraw(value);
        }
    }

    public Account getAccount() {
        return account;
    }


    public void setAccount(Account account) {
        this.account = account;
    }
       }
