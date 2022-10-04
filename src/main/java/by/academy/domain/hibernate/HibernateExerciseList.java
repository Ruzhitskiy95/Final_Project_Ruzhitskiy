package by.academy.domain.hibernate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exercise_list")
public class HibernateExerciseList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exercise_name")
    private String exerciseName;

//    @ManyToOne
//    @JoinColumn(name = "exercise_id")
//
//    @JsonBackReference
//    private HibernateTrainingJournal exercise;
}
