package io.tdd.sys.yeongSu.response;

public class JsonBasicResponse extends CreateResponse{
    public JsonBasicResponse() {
        result = 200;
        resultMessage = "SUCCESS";
    }

    public JsonBasicResponse (int result, String resultMessage) {
        this.result = result;
        this.resultMessage = resultMessage;
    }

}
