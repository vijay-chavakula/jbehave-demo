package sample.steps;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import sample.HttpUtility;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CalculateVerifierSteps {
    String url;

    @Given("the url is $url")
    public void principleAmountProvided(String url) {
        this.url = url;
    }

    @When("principle amount is $principle")
    public void setPrinciple(@Named("principle") float principle){
        this.url = this.url+ "?principle="+ principle;
    }

    @When("the years is $years years")
    public void setYears(@Named("years") float years){
        this.url = this.url+ "&years="+ years;
    }

    @When("the interest is $roi")
    public void setInterestRate(@Named("roi") float roi){
        this.url = this.url+ "&roi="+ roi;
    }

    @Then("simple interest should equal $simpleInterest")
    public void assertSimpleInterestRates(@Named("simpleInterest")float simpleInterest){
        Map<String,Object> response = HttpUtility.hit(this.url);
        float simpInterest = Float.parseFloat((String)response.get("body"));
        assertEquals(simpInterest,simpleInterest,0);
    }
}
