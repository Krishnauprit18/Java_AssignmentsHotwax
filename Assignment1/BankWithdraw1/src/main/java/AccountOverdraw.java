package main.java;

public class AccountOverdraw {
    public static void main(String[] args){
        Account account = new Account("Joint Account", 1000);

        Runnable withdrawalTask = () -> {
            for(int i = 0; i<5; i++){
                account.withdraw(200);
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        Thread person1 = new Thread(withdrawalTask, "Person1");
        Thread person2 = new Thread(withdrawalTask, "Person2");

        person1.start();
        person2.start();
    }
}
