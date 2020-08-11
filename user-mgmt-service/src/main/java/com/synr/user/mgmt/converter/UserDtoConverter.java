package com.synr.user.mgmt.converter;

import org.springframework.stereotype.Component;

import com.synr.user.mgmt.common.Utils;
import com.synr.user.mgmt.dto.UserDto;
import com.synr.user.mgmt.entity.UserEntity;

@Component
public class UserDtoConverter implements CustomConverter<UserDto, UserEntity> {

	private GroupDtoConverter groupDtoConverter;

	public UserDtoConverter(GroupDtoConverter groupDtoConverter) {
		super();
		this.groupDtoConverter = groupDtoConverter;
	}

	@Override
	public UserEntity convertPojoToEntity(UserDto source) {
		if (source == null)
			return null;
		UserEntity target = new UserEntity();
		Utils.copyProperties(source, target);
		if (source.getGroups() != null && source.getGroups().size() > 0)
			target.getGroups().addAll(groupDtoConverter.convertPojoToEntitySet(source.getGroups()));
		return target;
	}

	@Override
	public UserDto convertEntityToPojo(UserEntity source) {
		if (source == null)
			return null;
		UserDto target = new UserDto();
		Utils.copyProperties(source, target);

		if (source.getGroups() != null && source.getGroups().size() > 0)
			target.getGroups().addAll(groupDtoConverter.convertEntityToPojoSet(source.getGroups()));
		return target;
	}

}
