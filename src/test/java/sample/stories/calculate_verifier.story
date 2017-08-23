Meta:
@regression

Scenario: Simple Interest calculate verifier

Given the url is http://localhost:8080/calculate
When principle amount is <principle>
And the interest is <roi>
And the years is <years> years
Then simple interest should equal <simpleInterest>
Examples:
|principle|roi|years|simpleInterest|
|10000|10.25|1|1025|
|20000|10.25|1|2050|
|0|0|0|0|

Scenario: Simple Imterest verifier without passing arguments

Given the url is http://localhost:8080/calculate
Then simple interest should equal 0