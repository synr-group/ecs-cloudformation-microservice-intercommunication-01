package com.synr.user.mgmt.converter;

import org.springframework.stereotype.Component;

import com.synr.user.mgmt.common.Utils;
import com.synr.user.mgmt.dto.PermissionDto;
import com.synr.user.mgmt.entity.PermissionEntity;

@Component
public class PermissionDtoConverter implements CustomConverter<PermissionDto, PermissionEntity> {

	@Override
	public PermissionEntity convertPojoToEntity(PermissionDto source) {
		if (source == null)
			return null;
		PermissionEntity target = new PermissionEntity();
		Utils.copyProperties(source, target);
		return target;
	}

	@Override
	public PermissionDto convertEntityToPojo(PermissionEntity source) {
		if (source == null)
			return null;
		PermissionDto target = new PermissionDto();
		Utils.copyProperties(source, target);
		return target;
	}

}
