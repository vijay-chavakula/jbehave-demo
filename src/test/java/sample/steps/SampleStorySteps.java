package sample.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SampleStorySteps {
    private float principle;
    private float interestRate;
    private float simpleInterest;

    public SampleStorySteps(){

    }

    @Given("principle amount for a year with: $principle")
    public void principleAmountProvided(float principle) {
       this.principle = principle;
    }

    @When("the interest rate is $interest")
    public void setInterestRate(float interest){
        this.interestRate = interest;
        this.simpleInterest = (this.principle * 1 * this.interestRate) / 100;
    }

    @Then("simple interest should equal $simpleInterest")
    public void assertSimpleInterestRates(float simpleInterest){
        assertEquals(this.simpleInterest,simpleInterest,0);
    }
}
