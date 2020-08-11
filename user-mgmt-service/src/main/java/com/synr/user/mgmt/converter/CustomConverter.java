package com.synr.user.mgmt.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.lang.Nullable;

/**
 * 
 * Copy the property values of the given source Object into the target object.
 *
 */
public interface CustomConverter<A, B> {

	/**
	 * Convert the source object of type {A} to target type {B}.
	 * <p>
	 * This method follow the application data flow from GUI to DB i.e.
	 * Type->DTO->Entity OR Type->Entity Objects etc.
	 * 
	 * @param source the source object to convert (never {@code null})
	 * @return the converted object (potentially {@code null})
	 * @throws IllegalArgumentException if the source cannot be converted to the
	 *                                  desired target type
	 * 
	 */
	@Nullable
	B convertPojoToEntity(A source);

	/**
	 * @param source the list of object to convert (never {@code null})
	 * @return the converted object (potentially {@code null})
	 * @throws IllegalArgumentException if the source cannot be converted to the
	 *                                  desired target type
	 */
	@Nullable
	default Set<B> convertPojoToEntitySet(Set<A> source) {
		Set<B> targetObject = new HashSet<B>();
		if (source != null && source.size() > 0) {
			source.forEach(element -> {
				B b = this.convertPojoToEntity(element);
				targetObject.add(b);
			});
		}
		return targetObject;
	};

	/**
	 * Convert the source object of type {B} to target type {A}. *
	 * <p>
	 * This method follow the application data flow from DB to GUI i.e. ENTITY-> DTO
	 * OR Entity-> Type Objects etc.
	 * 
	 * @param source the source object to convert (never {@code null})
	 * @return the converted object (potentially {@code null})
	 * @throws IllegalArgumentException if the source cannot be converted to the
	 *                                  desired target type
	 */
	@Nullable
	A convertEntityToPojo(B source);

	/**
	 * @param source the list of object to convert (never {@code null})
	 * @return the converted object (potentially {@code null})
	 * @throws IllegalArgumentException if the source cannot be converted to the
	 *                                  desired target type
	 */
	@Nullable
	default Set<A> convertEntityToPojoSet(Set<B> source) {
		Set<A> targetObject = new HashSet<A>();
		if (source != null && source.size() > 0) {
			source.forEach(element -> {
				A a = this.convertEntityToPojo(element);
				targetObject.add(a);
			});
		}
		return targetObject;
	};

}
