# Assignment1

Problem Statement - 4

Write a multi threaded program that simulates bank withdrawal process by two individuals. The program should first demonstrate that the account will run overdraw if thread safety is not taken into account and then the thread safe version should demonstrate the measures taken that help protect the account balance integrity.

Create a class Account with properties name and balance. Initialize balance with 1000 indicating the current balance in the account. Also create a method named “withdraw” that deducts passed withdrawal amount from the account balance.
Create another class AccountOverdrawDemo with main method and demonstrate that if two threads (indicating two joint account holders with separate ATM cards) access the Account class at the same time and try to make withdrawal (call withdraw method) at the same time, account will overdraw at one point if both account holders keep withdrawing at the same time.
Create another class AccountOverdrawSafeDemo that fixes this problem. You need to clearly demonstrate that both threads are accessing the same account at the same time and thread safety measures keep the account from overdrawing.
Use System.out.println statements to your effect for demonstrating various information about Threads and showing the action that is being performed.

Account.java:
 - It has 2 properties:- name and balance.
 - Constructor initializes name and balance properties.
 - It has 2 methods:- getBalance() and withdraw(int amount).
 - getBalance returns the current balance.
 - withdraw method Deducts the speficied amount from the balance if there are sufficient amount.
 - Else it prints "Insufficient Balance" message.
 
AccountOverdraw.java:
 - Its main method create Account object with a name "Joint Account" and an initial balance of 1000.
 - Define withdrawalTask that attempts to withdraw 200 units 5 times in a loop.
 - Each withdrawal prints the current thread name and the amount being withdrawan.
 - If the balance is sufficient, it deducts the amount and prints a success message.
 - If the balance is insufficient, it prints an insuffieint balance message.
 - After each withdrawal, it prints the current balance.
 - 2 Threads were created named Person1 and Person2 to simulate 2 account holders trying to withdraw simultaneously.
 - Then both threads were started.
 - The outcome is that the account may go into an overdrawn state because both threads access and modify the balance property concurrently without synchronization, causing race conditions.
 
AccountOverdrawSafe.java:
  - Created account object with initial balance of 1000.
  - Defined a safeWithdrawalTask method.
  - The withdrawal operation is wrapped in synchronized block to ensure only one thread can be executed with the withdrawal method at a time.
  - Each withdrawal prints the current thread name and print the amount being withdrawan.
  - If the balance is sufficient, it deducts the amount and prints a success message.
  - If the balance is insufficient, it prints an insufficient balance message.
  - After each withdrawal, it prints the current balance.
  - Now 2 threads were created.
  - Both threads were started.
  - The account doesnot go into an overdrawn state because synchronization ensures that only one thread can access and modify the balance property at a time preventing race conditions.
