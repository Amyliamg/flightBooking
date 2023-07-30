package com.example.flightbooking.util;

public interface EmailUtil {
    void sendEmail(String to, String subject, String body, String attachmentPath);

}
