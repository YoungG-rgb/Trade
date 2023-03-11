package kg.tech.commons.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SpecificationHelper {
    public static String getContainsLikePattern(String searchTerm) {
        return searchTerm == null || searchTerm.isEmpty() ? "%" : "%" + searchTerm.toLowerCase() + "%";
    }
}