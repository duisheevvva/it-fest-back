package itFest.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ExceptionResponse(
        HttpStatus httpStatus, String exceptionName, String exceptionMessage
) {
}
