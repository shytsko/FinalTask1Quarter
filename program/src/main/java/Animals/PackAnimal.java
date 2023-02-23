package Animals;

import java.text.ParseException;
import java.util.Date;

public abstract class PackAnimal extends Animal {

    public PackAnimal(String name, Date birthDate) {
        super(name, birthDate);
    }

    public PackAnimal(String name, String birthDate) throws ParseException {
        super(name, birthDate);
    }
}
