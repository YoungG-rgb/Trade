package kg.tech.commons.rest;

import kg.tech.commons.enums.ResultCode;
import kg.tech.commons.models.ResponseModel;

public abstract class BaseController {

    protected <T> ResponseModel<T> successResponse(T result) {
        ResponseModel<T> responseModel = new ResponseModel<>();
        responseModel.setResult(result);
        responseModel.setResultCode(ResultCode.SUCCESS);
        return responseModel;
    }

    protected <T> ResponseModel<String> exceptionResponse(String details) {
        ResponseModel<String> responseModel = new ResponseModel<>();
        responseModel.setResult(null);
        responseModel.setDetails(details);
        responseModel.setResultCode(ResultCode.SUCCESS);
        return responseModel;

    }

    protected <T> ResponseModel<String> badRequestResponse() {
        ResponseModel<String> responseModel = new ResponseModel<>();
        responseModel.setResult(null);
        responseModel.setResultCode(ResultCode.BAD_REQUEST);
        return responseModel;
    }
}
