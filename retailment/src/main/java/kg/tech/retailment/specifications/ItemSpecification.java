package kg.tech.retailment.specifications;

import kg.tech.commons.utils.SpecificationHelper;
import kg.tech.retailment.entities.Item;
import kg.tech.retailment.models.ItemFilterPattern;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ItemSpecification implements Specification<Item> {
    private final ItemFilterPattern filterPattern;

    @Override
    public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        if (filterPattern.getName() != null) predicates.add(getPredicateByField("name", criteriaBuilder, root));

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }

    private Predicate getPredicateByField(String fieldName, CriteriaBuilder criteriaBuilder, Root<Item> root) {
        return criteriaBuilder.like(
                criteriaBuilder.lower(root.get(fieldName)),
                SpecificationHelper.getContainsLikePattern(filterPattern.getName())
        );
    }
}
