package com.synr.user.mgmt.converter;

import org.springframework.stereotype.Component;

import com.synr.user.mgmt.common.Utils;
import com.synr.user.mgmt.dto.RoleDto;
import com.synr.user.mgmt.entity.RoleEntity;

@Component
public class RoleDtoConverter implements CustomConverter<RoleDto, RoleEntity> {

	private PermissionDtoConverter permissionDtoConverter;

	public RoleDtoConverter(PermissionDtoConverter permissionDtoConverter) {
		super();
		this.permissionDtoConverter = permissionDtoConverter;
	}

	@Override
	public RoleEntity convertPojoToEntity(RoleDto source) {
		if (source == null)
			return null;
		RoleEntity target = new RoleEntity();
		Utils.copyProperties(source, target);
		if (source.getPermissions() != null && source.getPermissions().size() > 0)
			target.getPermissions().addAll(permissionDtoConverter.convertPojoToEntitySet(source.getPermissions()));
		return target;
	}

	@Override
	public RoleDto convertEntityToPojo(RoleEntity source) {
		if (source == null)
			return null;
		RoleDto target = new RoleDto();
		Utils.copyProperties(source, target);
		if (source.getPermissions() != null && source.getPermissions().size() > 0)
			target.getPermissions().addAll(permissionDtoConverter.convertEntityToPojoSet(source.getPermissions()));
		return target;
	}

}
