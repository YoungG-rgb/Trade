package kg.tech.commons.utils;

public class SpecificationHelper {
    public static String getContainsLikePattern(String searchTerm) {
        return searchTerm == null || searchTerm.isEmpty() ? "%" : "%" + searchTerm.toLowerCase() + "%";
    }
}