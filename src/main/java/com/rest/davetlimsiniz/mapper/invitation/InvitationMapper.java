package com.rest.davetlimsiniz.mapper.invitation;

import com.rest.davetlimsiniz.dto.invitation.InvitationDTO;
import com.rest.davetlimsiniz.entity.invitation.Invitation;
import com.rest.davetlimsiniz.mapper.GenericMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvitationMapper extends GenericMapper<Invitation, InvitationDTO> {
    @Override
    InvitationDTO clone(Invitation entity);

    @Override
    List<InvitationDTO> toDtos(List<Invitation> entities);

    @Override
    Invitation toEntity(InvitationDTO dto);
}
