package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trainee")
public class Trainee_api {

    private final TraineeService traineeService;
    private final TraineeRepo traineeRepo;


    @PostMapping("/create1")
    public TraineeResponse saveTrainee(@RequestBody TraineeRequest traineeRequest) {
        return traineeService.saveTrainee(traineeRequest);

    }

    @PutMapping("/change-password")
    public LoginChangeResponse changeTraineePassword(@RequestBody LoginChange loginChange) {
        String username = loginChange.getUsername();
        String oldPassword = loginChange.getOldPassword();
        String newPassword = loginChange.getNewPassword();

        Optional<Trainee> traineeOptional = traineeRepo.findByUser_UserNameAndUser_Password(username, oldPassword);

        if (traineeOptional.isPresent()) {
            Trainee trainee = traineeOptional.get();
            User user = trainee.getUser();
            user.setPassword(newPassword);
            traineeRepo.save(trainee);

            return new LoginChangeResponse(HttpStatus.OK, "Password changed successfully");
        } else {
            return new LoginChangeResponse(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }
    }


    @GetMapping("/profile")
    public TraineeProfileRes getTraineeProfile(@RequestBody ActivateRequest activateRequest) {
        return traineeService.getTraineeProfile(activateRequest);

    }



    @PutMapping("/update")
    public ResponseEntity<TraineeProfileRes> updateTraineeProfile(
            @RequestBody UpdateRequest updateRequest) {
        TraineeProfileRes updatedProfile = traineeService.update( updateRequest);
        return ResponseEntity.ok(updatedProfile);
    }


    @DeleteMapping("/delete")
    public SimpleResponse delete(@RequestBody ActivateRequest activateRequest) {
        return traineeService.delete(activateRequest);
    }




    @PatchMapping("/activate-deactivate-trainee")
    public ResponseEntity<SimpleResponse> activateDeactivateTrainee(@RequestBody ActivateRequest activateRequest) {
        SimpleResponse response = traineeService.activateDeactivateTrainee(activateRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update-trainers")
    public ResponseEntity<Update2Response> updateTrainersList(
            @RequestBody @Valid UpdateRequest2 updateRequest
    ) {
        Update2Response response = traineeService.updateTrainersList( updateRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getTrainings")
    public ResponseEntity<List<ResponseTrainers>> getTrainings(@RequestBody PeriodTrainingsList periodTrainingsList) {
        List<ResponseTrainers> trainings = traineeService.getTrainings(periodTrainingsList);
        return ResponseEntity.ok(trainings);
    }

    @PostMapping("/check-credentials")
    public ResponseEntity<SimpleResponse> checkCredentials(@RequestBody UserCheckRequest userCheckRequest) {
        SimpleResponse response = traineeService.checkCredentialsTrainee(userCheckRequest);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}