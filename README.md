# Test specification
As the payment team of Currencycloud we need to manage the full lifecycle of a payment.

A payment entity consists of the following information:
- amount: the amount of the payment
- payer name: the name of the payer in the form of "name surname"
- beneficiary name: the name of the receiver of the payment in the form of "name surname"

When a request for payment instruction is received the payment must be sanitised, validated
and submitted.
Below is a description of each operation:
- sanitisation: it removes any "-" character from the payer and beneficiary name
- validation: it checks the presence of amount, payer name and beneficiary name and it returns an error if any of those fields are missing
- submission: it receives a valid payment and simply returns that back

The candidate is required to provide an implementation of the three operations described above, along with tests.
The entry point of the application will be the Main object the candidate has been provided with, where the payment data will be passed in for the payment to go through its full lifecycle: sanitisation, validation and submission.
The application will be run via the command line with the `sbt run` command and print the amount, payer name and beneficiary name of the submitted payment.
In order to make the test easier for the candidate, the payment data can be hardcoded in the application instead of passing them via command line.
