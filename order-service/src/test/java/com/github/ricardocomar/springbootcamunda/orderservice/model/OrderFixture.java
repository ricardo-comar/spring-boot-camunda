package com.github.ricardocomar.springbootcamunda.orderservice.model;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class OrderFixture implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Order.class).addTemplate("valid-john", new Rule() {
            {
                add("customer", "John Snow");
                add("value", 123.0);
                add("state", OrderStateEnum.CREATED);
                add("card", one(CreditCard.class, "valid-john"));
            }
        });

        Fixture.of(Order.class).addTemplate("valid-john-saved").inherits("valid-john", new Rule() {
            {
                add("id", 123L);
                add("orderId", "a030406b-16b8-4785-9d04-0589fbd088b5");
            }
        });
    }
}
