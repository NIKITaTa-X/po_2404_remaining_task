package by.itclass.utils;

import by.itclass.exception.CompetitionException;
import by.itclass.model.Animal;
import by.itclass.model.Cat;
import by.itclass.model.Dog;
import by.itclass.model.Genus;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static by.itclass.constants.CompetitionConstants.*;

@UtilityClass
public class AnimalFactory {

    public static Animal getInstance(String textString) throws CompetitionException {
        var stringArray = textString.split(DELIMETER);
        try {
            var chipNumber = Long.parseLong(validateStringByPattern(stringArray[0], CHIP_REGEX));
            var name = validateStringForEmpty(stringArray[2]);
            var birthDate = LocalDate.parse(stringArray[3], FORMATTER);
            var breed = validateStringForEmpty(stringArray[4]);
            var email = validateStringByPattern(stringArray[5], EMAIL_REGEX);
            return StringUtils.equals("cat", stringArray[1])
                    ? new Cat(chipNumber, Genus.of(stringArray[1]), name, birthDate, breed, email)
                    : new Dog(chipNumber, Genus.of(stringArray[1]), name, birthDate, breed, email);

        } catch (IllegalStateException exception) {
            throw new CompetitionException(exception, textString);
        }
    }

    private static String validateStringByPattern(String value, String regex) {
        if (value.matches(regex)) {
            return value;
        }
        throw new IllegalStateException("Chip number or email has wrong format");
    }

    private static String validateStringForEmpty(String value) {
        if (StringUtils.isNotBlank(value)) {
            return value;
        }
        throw new IllegalStateException("Name or Breed is empty");
    }
}
