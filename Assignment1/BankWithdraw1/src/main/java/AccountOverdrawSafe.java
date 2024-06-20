package main.java;

public class AccountOverdrawSafe {
    public static void main(String[] args){
        Account account = new Account("Joint Account", 1000);

        Runnable safeWithdrawalTask = () -> {
            for(int i = 0; i<5; i++){
                synchronized (account){
                    account.withdraw(200);
                }
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        Thread person1 = new Thread(safeWithdrawalTask, "Person1");
        Thread person2 = new Thread(safeWithdrawalTask, "Person2");

        person1.start();
        person2.start();
    }
}
