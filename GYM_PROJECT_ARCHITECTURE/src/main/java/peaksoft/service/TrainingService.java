package peaksoft.service;

import peaksoft.dto.trainer.FreeRequest;
import peaksoft.dto.trainer.TrainerProfileRes2;
import peaksoft.dto.user.SimpleResponse;
import peaksoft.dto.yraning.TrainingReq;

import java.util.List;

public interface TrainingService {

    SimpleResponse saveTraining(TrainingReq trainingRequest);

    List<TrainerProfileRes2> getNotAssignedTrainers(FreeRequest freeRequest);
}