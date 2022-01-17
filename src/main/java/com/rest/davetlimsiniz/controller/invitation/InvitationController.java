package com.rest.davetlimsiniz.controller.invitation;

import com.rest.davetlimsiniz.controller.AbstractController;
import com.rest.davetlimsiniz.dto.invitation.InvitationDTO;
import com.rest.davetlimsiniz.entity.invitation.Invitation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invitation")
public class InvitationController extends AbstractController<Invitation, InvitationDTO> {
}
