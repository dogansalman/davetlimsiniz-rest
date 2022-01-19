package com.rest.davetlimsiniz.entity.attachments;

import com.rest.davetlimsiniz.entity.AbstractEntity;
import com.rest.davetlimsiniz.entity.invitation.Invitation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attachments extends AbstractEntity {
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    private Invitation invitation;
}
