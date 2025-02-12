package com.sachin.MainWS.exception;

public class UserServiceException extends RuntimeException
{
    private static final long serialVersionUID = 1348771109171435607L;

    public UserServiceException(String msg)
    {
        super(msg);
    }
}
