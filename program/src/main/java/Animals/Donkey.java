package Animals;

import java.text.ParseException;
import java.util.Date;

public class Donkey extends PackAnimal {

    public Donkey(String name, Date birthDate) {
        super(name, birthDate);
    }

    public Donkey(String name, String birthDate) throws ParseException {
        super(name, birthDate);
    }

    @Override
    public String getSpecies() {
        return "осёл";
    }
}
