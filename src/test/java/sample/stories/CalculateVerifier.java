package sample.stories;

import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import sample.AcceptanceTest;
import sample.steps.CalculateVerifierSteps;

public class CalculateVerifier extends AcceptanceTest {
    @Override
    public InjectableStepsFactory stepsFactory() {

        return new InstanceStepsFactory(configuration(),
                new CalculateVerifierSteps());
    }
}