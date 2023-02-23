package Animals;

import java.text.ParseException;
import java.util.Date;

public class Camel extends PackAnimal {


    public Camel(String name, Date birthDate) {
        super(name, birthDate);
    }

    public Camel(String name, String birthDate) throws ParseException {
        super(name, birthDate);
    }

    @Override
    public String getSpecies() {
        return "верблюд";
    }
}
