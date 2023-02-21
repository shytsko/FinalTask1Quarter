package Animals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Animal {
    private final String name;
    private final Date birthDate;

    private List<Skill> skills;

    public Animal(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        skills = new ArrayList<>();
    }

    public void addSkill (Skill skill) {
        this.skills.add(skill);
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
