package peaksoft.dto.trainee;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class LoginChangeRes {

    private HttpStatus httpStatus;
    private String message;

    public void LoginChangeResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}