package com.synr.user.mgmt.converter;

import org.springframework.stereotype.Component;

import com.synr.user.mgmt.common.Utils;
import com.synr.user.mgmt.dto.ConsentDto;
import com.synr.user.mgmt.entity.ConsentEntity;

@Component
public class ConsentDtoConverter implements CustomConverter<ConsentDto, ConsentEntity> {

	@Override
	public ConsentEntity convertPojoToEntity(ConsentDto source) {
		if (source == null)
			return null;
		ConsentEntity target = new ConsentEntity();
		Utils.copyProperties(source, target);
		return target;
	}

	@Override
	public ConsentDto convertEntityToPojo(ConsentEntity source) {
		if (source == null)
			return null;
		ConsentDto target = new ConsentDto();
		Utils.copyProperties(source, target);
		return target;
	}

}
