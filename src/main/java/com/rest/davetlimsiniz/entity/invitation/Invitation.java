package com.rest.davetlimsiniz.entity.invitation;

import com.rest.davetlimsiniz.entity.AbstractEntity;
import com.rest.davetlimsiniz.entity.attachments.Attachments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invitation extends AbstractEntity {

    private String name;
    private String lastname;
    private String phone;
    private String description;
    private Boolean approved = Boolean.FALSE;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Attachments> attachments;

}
