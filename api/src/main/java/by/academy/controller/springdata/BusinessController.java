package by.academy.controller.springdata;

import by.academy.domain.TrainingSessionsUsersResult;
import by.academy.repository.springdata.BusinessSpringDataRepository;
import by.academy.repository.springdata.UserSpringDataRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/business")
public class BusinessController {

        private final BusinessSpringDataRepository businessSpringDataRepository;

        @Tag(name = "Endpoint for business", description = "Business operation")
        @Operation(summary = "Training session result", description = "Training session result")
        @GetMapping("/trainingSessionResult")
        public ResponseEntity<Object> trainingSessionEndPoint() {

////                List<TrainingSessionsUsersResult> trainingSessionsUsersResultList;
////
////                trainingSessionsUsersResultList = businessSpringDataRepository.trainingSessionResult();
////                System.out.println(trainingSessionsUsersResultList.toString());
////
////                return new ResponseEntity<>(Collections.singletonMap("result",
////                        trainingSessionsUsersResultList.toString()), HttpStatus.OK);
//            return  new ResponseEntity<>(Collections.singletonMap("result",
//                   businessSpringDataRepository.trainingSessionResult()), HttpStatus.OK);

                return  new ResponseEntity<>(Collections.singletonMap("result",
                       businessSpringDataRepository.trainingSessionResult()), HttpStatus.OK);

        }






}
