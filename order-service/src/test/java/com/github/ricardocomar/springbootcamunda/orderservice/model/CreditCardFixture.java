package com.github.ricardocomar.springbootcamunda.orderservice.model;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CreditCardFixture implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(CreditCard.class).addTemplate("valid-john", new Rule() {
            {
                add("name", "JOHN");
                add("number", "1234567890");
                add("expirity", "05/2022");
                add("ccv", "123");
            }
        });
    }

}
