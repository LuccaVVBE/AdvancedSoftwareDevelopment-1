package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PizzaFactory {

    private final Map<String, Supplier<Pizza>> factory 
    = new HashMap<>();

    public final void add(String type, 
    		Supplier<Pizza> supplier) {
        factory.put(type, supplier);
    }

    public PizzaFactory() {
        add("cheese", CheesePizza::new);
      //add("cheese", () -> new CheesePizza());
        add("pepperoni", PepperoniPizza::new);
        add("clam", ClamPizza::new);
        add("veggie", VeggiePizza::new);
    }

    public Pizza createPizza(String type) {
        Supplier<Pizza> supplier = 
        	factory.get(type.toLowerCase());
        return supplier != null ? supplier.get() : null;
        /*
        return switch (type.toLowerCase()) {
            case "cheese" ->
                new CheesePizza();
            case "pepperoni" ->
                new PepperoniPizza();
            case "clam" ->
                new ClamPizza();
            case "veggie" ->
                new VeggiePizza();
            default ->
                null;
        };*/

    }

}











