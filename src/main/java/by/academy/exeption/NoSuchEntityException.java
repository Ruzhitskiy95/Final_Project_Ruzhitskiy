package by.academy.exeption;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class NoSuchEntityException extends RuntimeException{
    private String customMessage;
    private Integer errorCode;

}
