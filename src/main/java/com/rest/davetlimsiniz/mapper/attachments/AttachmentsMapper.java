package com.rest.davetlimsiniz.mapper.attachments;

import com.rest.davetlimsiniz.dto.attachments.AttachmentsDTO;
import com.rest.davetlimsiniz.entity.attachments.Attachments;
import com.rest.davetlimsiniz.mapper.GenericMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttachmentsMapper extends GenericMapper<Attachments, AttachmentsDTO> {

    @Override
    AttachmentsDTO clone(Attachments entity);

    @Override
    Attachments toEntity(AttachmentsDTO dto);

    @Override
    List<AttachmentsDTO> toDtos(List<Attachments> entities);
}
