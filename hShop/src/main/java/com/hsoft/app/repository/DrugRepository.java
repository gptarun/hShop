package com.hsoft.app.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hsoft.app.model.Drug;

public interface DrugRepository extends JpaRepository<Drug, Long>, JpaSpecificationExecutor<Drug> {

	default List<Drug> findByLikeCriteria(String brandName, Date startDate, Date endDate, String classification,
			String formulation) {
		return findAll(new Specification<Drug>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Drug> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				if (brandName != null && !brandName.isEmpty()) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("brandName"), brandName)));
				}
				if (startDate != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("startDate"), startDate)));
				}
				if (endDate != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("endDate"), endDate)));
				}
				if (classification != null && !classification.isEmpty()) {
					predicates.add(
							criteriaBuilder.and(criteriaBuilder.equal(root.get("classification"), classification)));
				}
				if (formulation != null && !formulation.isEmpty()) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("formulation"), formulation)));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}

	
}
