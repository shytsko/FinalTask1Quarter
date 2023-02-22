package Animals;

import java.text.ParseException;
import java.util.Date;

public class Horse extends PackAnimal {


    public Horse(String name, Date birthDate) {
        super(name, birthDate);
    }

    public Horse(String name, String birthDate) throws ParseException {
        super(name, birthDate);
    }

    @Override
    public String getSpecies() {
        return "лошадь";
    }
}
