package peaksoft.service;

import peaksoft.dto.period.PeriodTrainingsList;
import peaksoft.dto.period.ResponseTrainers;
import peaksoft.dto.trainee.*;
import peaksoft.dto.user.SimpleResponse;
import peaksoft.dto.user.UserCheckReq;
import peaksoft.dto.user.UserCheckReq;

import java.util.List;


public interface TraineeService {



    List<ResponseTrainers> getTrainings(PeriodTrainingsList periodTrainingsList);
    TraineeResponse saveTrainee(TraineeRequest traineeRequest);
    TraineeProfileRes getTraineeProfile(ActivateRequest activateRequest);
    TraineeProfileRes update( UpdateRequest updateRequest);

    SimpleResponse delete(ActivateRequest activateRequest);

    SimpleResponse activateDeactivateTrainee( ActivateRequest activateRequest);

    Update2Response updateTrainersList(UpdateRequest0 updateRequest);

    public SimpleResponse checkCredentialsTrainee(UserCheckReq userCheckRequest);


}