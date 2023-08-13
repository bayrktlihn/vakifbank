package io.bayrktlihn.vakifbank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseEntity {

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime passiveDate;

    @Builder.Default
    @Column(columnDefinition = "boolean not null default true")
    private boolean active = true;


    @Builder.Default
    @Column(columnDefinition = "bigint not null default 0")
    private Long version = 0L;


    @PrePersist
    void prePersist() {
        createdDate = LocalDateTime.now();
    }


    @PreUpdate
    void preUpdate() {
        updatedDate = LocalDateTime.now();
    }

    public void doPassive() {
        active = false;
        passiveDate = LocalDateTime.now();
    }


}
