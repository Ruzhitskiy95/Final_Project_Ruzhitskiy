package by.academy.repository.springdata;

import by.academy.domain.hibernate.HibernateTrainingJournal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessSpringDataRepository extends
        CrudRepository<HibernateTrainingJournal, Long>,
        JpaRepository<HibernateTrainingJournal, Long>,
        PagingAndSortingRepository<HibernateTrainingJournal, Long>
{

//    @Query(value = "select user_name, sur_name, training_data, exercise_name, sets, reps, weight, total_weight " +
//            "from training_records_schema.users inner join training_records_schema.training_journal on " +
//                    "users.id = training_journal.user_id " +
//                    "inner join training_records_schema.exercise_list el on el.id = training_journal.exercise_id",nativeQuery = true)
//    @Query(value = "select user_name, sur_name, training_data, exercise_name, sets, reps, weight, total_weight " +
//            "from training_records_schema.users inner join training_records_schema.training_journal on " +
//                    "users.id = training_journal.user_id " +
//                    "inner join training_records_schema.exercise_list el on el.id = training_journal.exercise_id",nativeQuery = true)

    @Query(value = "select * from training_records_schema.training_journal order by total_weight desc limit 5",nativeQuery = true)
    List<HibernateTrainingJournal> trainingSessionResult();

}
