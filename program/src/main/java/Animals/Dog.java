package Animals;

import java.text.ParseException;
import java.util.Date;

public class Dog extends Pets {


    public Dog(String name, Date birthDate) {
        super(name, birthDate);
    }

    public Dog(String name, String birthDate) throws ParseException {
        super(name, birthDate);
    }

    @Override
    public String getSpecies() {
        return "собака";
    }
}
