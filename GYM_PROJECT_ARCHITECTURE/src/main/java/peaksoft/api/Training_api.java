package peaksoft.api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.user.SimpleResponse;


@RestController
@RequiredArgsConstructor
@RequestMapping("/training")
public class Training_api {


    public final TrainingService trainingService;



    @PostMapping("/create")
    public ResponseEntity<SimpleResponse> saveTraining(@RequestBody TrainingRequest trainingRequest) {
        SimpleResponse response= trainingService.saveTraining(trainingRequest);
        return ResponseEntity.status(response.getHttpStatus()).build();
    }


    @GetMapping("/username")
    public ResponseEntity<List<TrainerProfileRes2>> getNotAssignedTrainers(@RequestBody FreeRequest freeRequest) {
        List<TrainerProfileRes2> notAssignedTrainers = trainingService.getNotAssignedTrainers(freeRequest);
        return ResponseEntity.ok(notAssignedTrainers);
    }

}
