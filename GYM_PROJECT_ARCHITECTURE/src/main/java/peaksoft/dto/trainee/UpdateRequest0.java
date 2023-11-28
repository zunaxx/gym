package peaksoft.dto.trainee;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateRequest0 {

    private String traineeUsername;
    private List<String> usernames;

}