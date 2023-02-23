package Animals;

import java.text.ParseException;
import java.util.Date;

public class Cat extends Pets {


    public Cat(String name, Date birthDate) {
        super(name, birthDate);
    }

    public Cat(String name, String birthDate) throws ParseException {
        super(name, birthDate);
    }

    @Override
    public String getSpecies() {
        return "кот";
    }
}
