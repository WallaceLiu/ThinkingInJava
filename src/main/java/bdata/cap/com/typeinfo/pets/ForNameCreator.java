//: typeinfo/pets/ForNameCreator.java
package bdata.cap.com.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends bdata.cap.com.typeinfo.pets.PetCreator {
    private static List<Class<? extends bdata.cap.com.typeinfo.pets.Pet>> types =
            new ArrayList<Class<? extends bdata.cap.com.typeinfo.pets.Pet>>();
    // Types that you want to be randomly created:
    private static String[] typeNames = {
            "typeinfo.pets.Mutt",
            "typeinfo.pets.Pug",
            "typeinfo.pets.EgyptianMau",
            "typeinfo.pets.Manx",
            "typeinfo.pets.Cymric",
            "typeinfo.pets.Rat",
            "typeinfo.pets.Mouse",
            "typeinfo.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames)
                types.add(
                        (Class<? extends bdata.cap.com.typeinfo.pets.Pet>) Class.forName(name));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    public List<Class<? extends bdata.cap.com.typeinfo.pets.Pet>> types() {
        return types;
    }
} ///:~
