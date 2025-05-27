package com.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Клас для представлення журналу.
 */
@Entity
@Table(name = "journals")
@Getter
@Setter
public class Journal extends PrintedDoc {
    @Column(name = "issue_number")
    private Integer issueNumber; // Номер випуску

    public void setIssueNumber(Integer number) {
        if (number == null || number < 1) {
            throw new IllegalArgumentException("Номер випуску має бути більше 0");
        }
        this.issueNumber = number;
    }
}