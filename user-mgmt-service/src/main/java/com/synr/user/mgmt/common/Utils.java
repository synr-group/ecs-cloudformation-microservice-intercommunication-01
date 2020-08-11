package com.synr.user.mgmt.common;

import static java.util.Locale.ROOT;

import java.beans.FeatureDescriptor;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public final class Utils {

	/**
	 * This method is used to generate the unique random Id
	 */
	public static String createObjectIdentifier() {
		return UUID.randomUUID().toString().toUpperCase(ROOT).replace("-", "");
	}

	/**
	 * Wrapper around BeanUtils method to force ignoreProperties
	 * 
	 * @param source the source bean
	 * @param target the target bean
	 */
	public static void copyProperties(Object source, Object target) {
		String[] ignoreProperties = Utils.getNullPropertyNames(source);
		BeanUtils.copyProperties(source, target, ignoreProperties);

	}

	/**
	 * 
	 * Used to get the list of null property names for a provided Object
	 * 
	 * @param source the source bean
	 * @return List of null property names
	 */
	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
		return Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName)
				.filter(propertyName -> {
					try {
						return wrappedSource.getPropertyValue(propertyName) == null;
					} catch (Exception e) {
						return false;
					}
				}).toArray(String[]::new);
	}
}
