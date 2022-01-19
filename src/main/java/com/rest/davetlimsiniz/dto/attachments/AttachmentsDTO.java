package com.rest.davetlimsiniz.dto.attachments;

import com.rest.davetlimsiniz.dto.AbstractDTO;
import com.rest.davetlimsiniz.entity.invitation.Invitation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentsDTO extends AbstractDTO {
    private String url;
    private Invitation invitation;
}
