package com.rest.davetlimsiniz.controller.attachments;

import com.rest.davetlimsiniz.controller.AbstractController;
import com.rest.davetlimsiniz.dto.attachments.AttachmentsDTO;
import com.rest.davetlimsiniz.entity.attachments.Attachments;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("attachments")
public class AttachmentsController extends AbstractController<Attachments, AttachmentsDTO> {
}
