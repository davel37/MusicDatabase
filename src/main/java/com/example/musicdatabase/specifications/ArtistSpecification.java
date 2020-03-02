package com.example.musicdatabase.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import com.example.musicdatabase.entity.ArtistEntity;

public class ArtistSpecification implements Specification<ArtistEntity> {

	private ArtistEntity filter;

	public ArtistSpecification (ArtistEntity filter) {
		super();
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<ArtistEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		 Predicate p = cb.disjunction();

	        if (filter.getName() != null) {
	            p.getExpressions()
	                    .add(cb.equal(root.get("name"), filter.getName()));
	        }
	        if (filter.getCountry() != null) {
	            p.getExpressions()
	                    .add(cb.equal(root.get("country"), filter.getCountry()));
	        }
return p;
	}



}
