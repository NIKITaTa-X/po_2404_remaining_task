package by.itclass.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@AllArgsConstructor
public enum Genus {
    CAT("Cat"), DOG("Dog");
    @Getter
    private String value;

    public static Genus of(String value){
        return Arrays.stream(values())
                .filter(it -> StringUtils.equalsIgnoreCase(it.value, value))
                .findAny()
                .orElse(null);

    }
}
