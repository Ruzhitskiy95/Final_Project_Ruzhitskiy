package by.academy;

import by.academy.domain.TotalWeightOnDate;
import by.academy.domain.TrainingJournal;
import by.academy.domain.TrainingSessionsUsersResult;
import by.academy.domain.User;
import by.academy.service.TrainingJournalService;
import by.academy.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class SpringTest {

    public static HashMap<String, Long> statistic = new HashMap<>();
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext("by.academy");

//     UserRepositoryInterface userRepository = annotationConfigApplicationContext.getBean(
//             "userRepository", UserRepositoryInterface.class);
//        for (User user : userRepository.findAll()) {
//            System.out.println(user);
//        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
//        List<User> all = userService.findAll();
//        for (User user : all) {
//            System.out.println(user);
//
//        }
        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);

        System.out.println("=== findAll ===");
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user);
        }

        System.out.println("=== findAll with param ===");
        List<User> allParam = userService.findAll(5,1);
        for (User user : allParam) {
            System.out.println(user);
    }
        System.out.println("=== findByID ===");
        System.out.println(userService.findById(1L));

        System.out.println("=== finOne ===");
        System.out.println(userService.findOne(1L));

        System.out.println("=== create ===");

        User user = new User();
        user.setUserName("JDBC");
        user.setSurName("Template");
        user.setBirthDate(new Timestamp(new Date().getTime()));
        user.setIsDeleted(false);
        System.out.println(user);

        User user1 = userService.create(user);
        System.out.println(user1);

        System.out.println("=== delete ===");
        System.out.println(userService.delete(5L));

        System.out.println("=== update ===");
        User userUpdate = new User();
        userUpdate.setUserName("JDBC");
        userUpdate.setSurName("Template");
        userUpdate.setBirthDate(new Timestamp(new Date().getTime()));
        userUpdate.setIsDeleted(false);
        userUpdate.setId(4L);
        userService.update(userUpdate);

        System.out.println("////////////TrainingJournal////////");

        TrainingJournalService trainingJournalService = annotationConfigApplicationContext.getBean(TrainingJournalService.class);

        System.out.println("findAll");
        List<TrainingJournal> trainingJournalAll = trainingJournalService.findAll();
        for (TrainingJournal trainingJournal : trainingJournalAll) {
            System.out.println(trainingJournal);
        }
        System.out.println("findById");
        System.out.println(trainingJournalService.findById(2L));

        System.out.println("findOne");
        System.out.println(trainingJournalService.findOne(3L));

        System.out.println("=== create ===");

        TrainingJournal trainingJournal = new TrainingJournal();
        trainingJournal.setTrainingData(new Timestamp(new Date().getTime()));
        trainingJournal.setUserId(2L);
        trainingJournal.setExerciseId(2L);
        trainingJournal.setSets(3L);
        trainingJournal.setReps(8L);
        trainingJournal.setWeight(70L);
        trainingJournal.setIsDeleted(false);
        System.out.println(trainingJournal);


        System.out.println("=== Update ===");

        TrainingJournal trainingJournalUpdate = new TrainingJournal();
        trainingJournalUpdate.setTrainingData(new Timestamp(new Date().getTime()));
        trainingJournalUpdate.setUserId(2L);
        trainingJournalUpdate.setExerciseId(2L);
        trainingJournalUpdate.setSets(3L);
        trainingJournalUpdate.setReps(8L);
        trainingJournalUpdate.setWeight(70L);
        trainingJournalUpdate.setIsDeleted(false);
        System.out.println(trainingJournalUpdate);

        System.out.println("=== Delete ===");

        System.out.println(trainingJournalService.delete(5L));

        System.out.println("find trainingSessionsResult");
        List<TrainingSessionsUsersResult> trainingSessionsUsersResultList = trainingJournalService.trainingSessionsResult();
        for (TrainingSessionsUsersResult trainingSessionsUsersResult : trainingSessionsUsersResultList) {
            System.out.println(trainingSessionsUsersResult);
        }
        System.out.println("totalWeightOnDate");
        List<TotalWeightOnDate> totalWeightOnDate = trainingJournalService.totalWeightOnDate("Karpenko", Timestamp.valueOf("2022-08-27 20:13:26.0"));
        for (TotalWeightOnDate totalWeightOnDateResult : totalWeightOnDate) {
            System.out.println(totalWeightOnDateResult);
        }
        System.out.println("Statistic");
        System.out.println(statistic);

        }

        }







