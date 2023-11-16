package shparos.admin.global.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shparos.admin.global.common.response.ResponseCode;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private final ResponseCode responseCode;

}
