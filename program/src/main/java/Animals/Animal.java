package Animals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Animal {
    private final String name;
    private final Date birthDate;

    private List<String> skills;

    public static SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");

    public Animal(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        skills = new ArrayList<>();
    }

    public Animal(String name, String birthDate) throws ParseException {
        this.name = name;
        this.birthDate = dateFormater.parse(birthDate);
        skills = new ArrayList<>();
    }



    public Animal addSkill (String skill) {
        this.skills.add(skill);
        return this;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<String> getSkills() {
        return skills;
    }

    public abstract String getSpecies();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getSpecies()).append(" ")
                .append(name).append(", ")
                .append("день рождения ").append(dateFormater.format(birthDate)).append(", ");
        if(skills.isEmpty()) {
            sb.append("Ничего не умеет");
        }
        else {
            sb.append("умеет ").append(String.join(", ", skills));
        }
        return sb.toString();
    }
}
