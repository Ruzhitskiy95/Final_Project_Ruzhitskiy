package by.academy.domain;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TrainingSessionsUsersResult {
    private String userName;
    private String surName;
    private Timestamp trainingData;
    private String exerciseName;
    private Long sets;
    private Long reps;
    private Long weight;
    private Long totalWeight;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

