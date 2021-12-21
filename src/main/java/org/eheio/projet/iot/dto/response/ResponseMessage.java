package org.eheio.projet.iot.dto.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResponseMessage {
    private String message;
    private LocalDateTime dateTime;
    private HttpStatus status;
    private int codeStatus;
    public ResponseMessage(String message,  HttpStatus status){
        this.message=message;
        this.dateTime=LocalDateTime.now();
        this.status=status;
        this.codeStatus=status.value();
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public int getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(int codeStatus) {
        this.codeStatus = codeStatus;
    }
}
