Meta:
@regression

Scenario: Price in default category

Given principle amount for a year with: 10000
When the interest rate is 10.25
Then simple interest should equal 1025