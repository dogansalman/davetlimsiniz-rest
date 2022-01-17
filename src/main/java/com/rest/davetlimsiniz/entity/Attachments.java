package com.rest.davetlimsiniz.entity;

import com.rest.davetlimsiniz.entity.invitation.Invitation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Attachments extends AbstractEntity{
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    private Invitation invitation;
}
