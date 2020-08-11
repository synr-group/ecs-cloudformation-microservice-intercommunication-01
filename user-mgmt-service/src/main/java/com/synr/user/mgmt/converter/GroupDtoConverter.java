package com.synr.user.mgmt.converter;

import org.springframework.stereotype.Component;

import com.synr.user.mgmt.common.Utils;
import com.synr.user.mgmt.dto.GroupDto;
import com.synr.user.mgmt.entity.GroupEntity;

@Component
public class GroupDtoConverter implements CustomConverter<GroupDto, GroupEntity> {

	private ConsentDtoConverter consentDtoConverter;
	private RoleDtoConverter roleDtoConverter;

	public GroupDtoConverter(ConsentDtoConverter consentDtoConverter, RoleDtoConverter roleDtoConverter) {
		super();
		this.consentDtoConverter = consentDtoConverter;
		this.roleDtoConverter = roleDtoConverter;
	}

	@Override
	public GroupEntity convertPojoToEntity(GroupDto source) {
		if (source == null)
			return null;
		GroupEntity target = new GroupEntity();
		Utils.copyProperties(source, target);
		if (source.getConsents() != null && source.getConsents().size() > 0)
			target.getConsents().addAll(consentDtoConverter.convertPojoToEntitySet(source.getConsents()));

		if (source.getRoles() != null && source.getRoles().size() > 0)
			target.getRoles().addAll(roleDtoConverter.convertPojoToEntitySet(source.getRoles()));
		return target;
	}

	@Override
	public GroupDto convertEntityToPojo(GroupEntity source) {
		if (source == null)
			return null;
		GroupDto target = new GroupDto();
		Utils.copyProperties(source, target);

		if (source.getConsents() != null && source.getConsents().size() > 0)
			target.getConsents().addAll(consentDtoConverter.convertEntityToPojoSet(source.getConsents()));

		if (source.getRoles() != null && source.getRoles().size() > 0)
			target.getRoles().addAll(roleDtoConverter.convertEntityToPojoSet(source.getRoles()));

		return target;
	}

}
