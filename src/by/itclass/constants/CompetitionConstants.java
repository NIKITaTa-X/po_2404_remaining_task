package by.itclass.constants;

import by.itclass.model.Animal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

public class CompetitionConstants {
    public static final String DELIMETER = "[;,]";
    public static final String CHIP_REGEX = "(?=\\d{15}\\b)(?:112|663)09(?:81|56)\\d{8}";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-y");
    public static final String EMAIL_REGEX = "[\\w!#$%&*+/=?^'`{|}~\\-]+(?:\\.[\\w!#$%&*+/=?^'`{|}~\\-]+)*@(?:[a-zA-Z\\d](?:[a-zA-Z\\d\\-]*[a-zA-Z\\d])?\\.)+[a-zA-Z\\d][a-zA-Z\\d\\-]*[a-zA-Z\\d]";

    private static final LocalDate ageDelimiter = LocalDate.now().minusYears(3);
    public static  final Predicate<Animal> YOUNG_PREDICATE = it -> it.getBirthDate().isAfter(ageDelimiter);
    public static final Predicate<Animal> OLD_PREDICATE = it -> it.getBirthDate().isBefore(ageDelimiter);
}
