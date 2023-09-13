package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/Purchase.feature",
        glue = "stepsdefinitions",
        snippets = CAMELCASE
        ,tags= "@confirmOrder")


public class Purchase {
}
