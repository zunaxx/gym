package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trainer")
public class Trainer_api {

    private final TrainerService trainerService;



    @PostMapping("/create")
    public TrainerResponse saveTrainer(@RequestBody TrainerRequest trainerRequest) {
        return trainerService.saveTrainer(trainerRequest);
    }


    @GetMapping("/profile")
    public TrainerProfileRes getTrainerProfile(@RequestBody UpdateRequest updateRequest) {
        return trainerService.getTrainerProfile(updateRequest);

    }

    @PutMapping("/update")
    public ResponseEntity<TrainerProfileRes> updateTrainerProfile(
            @RequestBody UpdateRequest updateRequest) {
        TrainerProfileRes updatedProfile = trainerService.update(updateRequest);
        return ResponseEntity.ok(updatedProfile);
    }

    @PatchMapping("/activate-deactivate-trainer")
    public ResponseEntity<SimpleResponse> activateDeactivateTrainee(@RequestBody ActivateRequest activateRequest) {
        SimpleResponse response = trainerService.activateDeactivateTrainer(activateRequest);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getTrainings")
    public ResponseEntity<List<ResponseTrainee>> getTrainings(@RequestBody PeriodTrainingsList periodTrainingsList) {
        List<ResponseTrainee> trainings = trainerService.getTrainings(periodTrainingsList);
        return ResponseEntity.ok(trainings);

    }

    @PostMapping("/check-credentials")
    public ResponseEntity<SimpleResponse> checkCredentials(@RequestBody UserCheckRequest userCheckRequest) {
        SimpleResponse response = trainerService.checkCredentialsTrainer(userCheckRequest);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
