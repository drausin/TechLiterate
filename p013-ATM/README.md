Write a program implementing a bank ATM interface. Upon logging in with a 
username and pin, a user should be able to make deposits, withdrawals, and 
transfers between accounts. The user should also be able to list the 
transactions for each account, so this program can be somewhat of a blend 
between the functionality of an ATM and that of an online banking system.

### example ###
An example of session where a user interacts with the ATM is given below.

New user Doe, John with ID 209635 created.  
  
  
Welcome to Bank of Drausin  
  
Enter user ID: 209635  
Enter pin: 1234  
  
  
John's accounts summary  
1) 6087306216 : $0.00 : Savings  
2) 9186453789 : $0.00 : Checking  
  
What would you like to do?  
  1) Show account transaction history  
  2) Withdraw  
  3) Deposit  
  4) Transfer  
  5) Quit  
  
Enter choice: 3  
Enter the number (1-2) of the account to deposit to: 1  
Enter the amount to deposit: $20  
Enter a memo: birthday money from grandma  
  
  
John's accounts summary  
1) 6087306216 : $20.00 : Savings  
2) 9186453789 : $0.00 : Checking  
  
What would you like to do?  
  1) Show account transaction history  
  2) Withdraw  
  3) Deposit  
  4) Transfer  
  5) Quit  
  
Enter choice: 4  
Enter the number (1-2) of the account to transfer from: 1  
Enter the number (1-2) of the account to transfer to: 2  
Enter the amount to transfer (max $20.00): $10  
  
  
John's accounts summary  
1) 6087306216 : $10.00 : Savings  
2) 9186453789 : $10.00 : Checking  
  
What would you like to do?  
  1) Show account transaction history  
  2) Withdraw  
  3) Deposit  
  4) Transfer  
  5) Quit  
  
Enter choice: 2  
Enter the number (1-2) of the account to withdraw from: 2  
Enter the amount to withdraw (max $10.00): $7.25  
Enter a memo: money for candy  
  
  
John's accounts summary  
1) 6087306216 : $10.00 : Savings   
2) 9186453789 : $2.75 : Checking  
  
What would you like to do?  
  1) Show account transaction history  
  2) Withdraw  
  3) Deposit  
  4) Transfer  
  5) Quit  
  
Enter choice: 1  
Enter the number (1-2) of the account  
whose transactions you want to see: 2  
  
Transaction history for account 9186453789  
Fri Jul 05 12:15:09 EDT 2013, $(7.25) : money for candy  
Fri Jul 05 12:14:52 EDT 2013, $10.00 : Transfer from account 6087306216  
  
  
  
John's accounts summary  
1) 6087306216 : $10.00 : Savings  
2) 9186453789 : $2.75 : Checking  
  
What would you like to do?  
  1) Show account transaction history  
  2) Withdraw  
  3) Deposit  
  4) Transfer  
  5) Quit  
  
Enter choice: 1  
Enter the number (1-2) of the account  
whose transactions you want to see: 1  
  
Transaction history for account 6087306216  
Fri Jul 05 12:14:52 EDT 2013, $(10.00) : Transfer to account 9186453789  
Fri Jul 05 12:14:39 EDT 2013, $20.00 : birthday money from grandma  
  
  
  
John's accounts summary  
1) 6087306216 : $10.00 : Savings  
2) 9186453789 : $2.75 : Checking  
  
What would you like to do?  
  1) Show account transaction history  
  2) Withdraw  
  3) Deposit  
  4) Transfer  
  5) Quit  
  
Enter choice: 5  
  
  
Welcome to Bank of Drausin  
  
Enter user ID: 209635  
Enter pin: 1234  
  
  
John's accounts summary  
1) 6087306216 : $10.00 : Savings  
2) 9186453789 : $2.75 : Checking  
  
What would you like to do?  
  1) Show account transaction history  
  2) Withdraw  
  3) Deposit  
  4) Transfer  
  5) Quit  
  
Enter choice: 5  


