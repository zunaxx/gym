package peaksoft.dto.period;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PeriodTrainingsList {

    private String userName;
    private LocalDate periodFrom;
    private LocalDate periodTo;

}