package Animals;

import java.text.ParseException;
import java.util.Date;

public class Hamster extends Pets {


    public Hamster(String name, Date birthDate) {
        super(name, birthDate);
    }

    public Hamster(String name, String birthDate) throws ParseException {
        super(name, birthDate);
    }

    @Override
    public String getSpecies() {
        return "хомяк";
    }
}
