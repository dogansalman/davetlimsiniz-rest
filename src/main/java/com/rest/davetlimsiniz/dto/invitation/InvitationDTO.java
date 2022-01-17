package com.rest.davetlimsiniz.dto.invitation;

import com.rest.davetlimsiniz.dto.AbstractDTO;
import com.rest.davetlimsiniz.entity.Attachments;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InvitationDTO extends AbstractDTO {
    private String name;
    private String lastname;
    private String phone;
    private String description;
    private Boolean approved = Boolean.FALSE;
    private List<Attachments> attachments;
}
