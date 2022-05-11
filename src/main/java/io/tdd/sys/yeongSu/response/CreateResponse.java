package io.tdd.sys.yeongSu.response;

import lombok.Getter;

import java.io.Serializable;

public class CreateResponse implements Serializable {
    @Getter
    protected int result;
    @Getter
    protected String resultMessage;

    public static CreateResponse create() { return new JsonBasicResponse(); }
}
