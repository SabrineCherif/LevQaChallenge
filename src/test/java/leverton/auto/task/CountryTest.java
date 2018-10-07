package leverton.auto.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.useRelaxedHTTPSValidation;
import static leverton.auto.task.TestProperties.getCountriesRestUrl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.codehaus.groovy.runtime.InvokerHelper.asList;

public class CountryTest {

    @Test
    public void should_contains_germany() {
        Optional<Country> germany = getCountries()
                .stream()
                .filter(Country::isGermany)
                .findFirst();

        assertThat(germany.isPresent()).isTrue();
    }

    private List<Country> getCountries() {
        useRelaxedHTTPSValidation();
        return asList(get(getCountriesRestUrl())
                .getBody()
                .as(Country[].class));
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Country {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        boolean isGermany() {
            return name.equalsIgnoreCase("germany");
        }

    }
}
