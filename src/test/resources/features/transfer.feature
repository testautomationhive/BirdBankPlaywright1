Feature: Transfer amount - own/other account
  This feature file contains scenarios related to transfer amount from own or other account

  Rule: The users should have at least 2 own/other accounts,
  The users should have enough privileges and balance to make the transaction.

    Background:
      Given User navigated to the home page
      When User navigate to login page
      And User login with "testuser1" and "testpassword"
      And User click on transfer tab


   Scenario Outline: Transfer amount between two own accounts
      Given User navigated to the transfer page
      When User selects "Own Account"
      And User choose to account as "<to_account>"
      And User selects from account as "<from_account>"
      And User provides Amount as "<amount>" and Message as "<message>"
      And User confirms the payment
      Then User navigated to the confirmation page and "Transaction Completed" message displayed
   Examples:
     |to_account|from_account|amount|message|
     |9999000453354533|9999000453354527|100|payment|
     |9999000453354527|9999000453354533|400|loan repayment|
     |9999000453354527|9999000473354500|1000|credit|


