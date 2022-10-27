package by.academy.domain.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TrainingResultDTO {


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
