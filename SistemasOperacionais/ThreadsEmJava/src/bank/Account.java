package bank;

public class Account {
    private Integer balance;
    


    public Account(Integer value){
        this.setBalance(value);
    }

   
    public boolean deposit(Integer value){
        setBalance(value + getBalance());
        return true;
    }

    public boolean withdraw(Integer value){
        if(value > getBalance()) return false;
        setBalance(getBalance() - value);
        return true;
    }
    public Integer getBalance() {
        return balance;
    }



    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
