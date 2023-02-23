import Animals.Animal;
import Animals.Cat;
import Animals.Dog;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) throws Exception {
//        Map<Integer, Animal> animals = new HashMap<>() ;
//        Animal a = null;
//        int key = 0;
//        try {
//            animals.put(key++, (new Dog("Бобик", "2020-04-15"))
//                                    .addSkill("бегать")
//                                    .addSkill("пригать"));
//            animals.put(key++, (new Cat("Барсик", "2022-06-10"))
//                                    .addSkill("бегать")
//                                    .addSkill("пригать"));
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(animals);

        try (Counter c =new Counter()){
            c.add();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Counter c2 =new Counter();
        c2.add();
        c2.close();

        System.out.println(Counter.GetCount());
    }
}
