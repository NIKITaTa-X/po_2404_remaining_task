package by.itclass;

import by.itclass.model.Cat;
import by.itclass.model.Dog;
import by.itclass.model.Genus;
import by.itclass.utils.CompetitionUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static by.itclass.utils.CompetitionUtils.*;
public class Main {
    public static void main(String[] args) {
        var cats = new ArrayList<Cat>();
        var dogs = new ArrayList<Dog>();
        var errors = new HashMap<String, String>();

        parseFile(cats, dogs, errors);

        var sortedCats = CompetitionUtils.sortByBirthDay(cats);
        var sortedDogs = CompetitionUtils.sortByBirthDay(dogs);

        printResults(sortedCats, sortedDogs, errors);

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        var youngCats = filterAnimals(sortedCats, true);
        var oldCats = filterAnimals(sortedCats, false);
        var youngDogs = filterAnimals(sortedDogs, true);
        var oldDogs = filterAnimals(sortedDogs, false);

        printResults(youngCats,youngDogs,oldCats,oldDogs,errors);



    }
}
