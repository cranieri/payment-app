# Test specification
As the payment team of Currencycloud we need to manage the full lifecycle of a payment.

A payment entity consists of the following information:
- amount: the amount of the payment
- payer name: the name of the payer in the form of "name surname"
- beneficiary name: the name of the receiver of the payment in the form of "name surname"

Validation and submission are the steps a payment must go through when a payment submission request is received.
Below is a detailed description of each operation:
- validation: it checks the presence of amount, and checks payer name and beneficiary name length is not greater than 15 characters
- submission: it receives a valid payment and simply returns that back. This operation does not need to be executed if a payment is invalid

The candidate is required to model the domain and provide an implementation of the two operations described above, **along with tests**.
The entry point of the application will be the Main object the candidate has been provided with.

The code implemented by the candidate is required to create a valid payment and take it through validation and submission.
**Functional Programming** is the preferred programming paradigm the candidate should choose to complete the test.

The application will be run via the command line with the `sbt run` command and will print the amount, payer name and beneficiary name of the submitted payment.

In order to make the test easier for the candidate, the payment fields can be hardcoded in the application instead of passing them via command line.
