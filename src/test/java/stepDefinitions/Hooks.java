package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@VerifyNames")
	public void beforeScenario() throws IOException {
		NameValidationStepDef nameValidationStepDef = new NameValidationStepDef();
		System.out.println("Hooks Before");
	}

}
