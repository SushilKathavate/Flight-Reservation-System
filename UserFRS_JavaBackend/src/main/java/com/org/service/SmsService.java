package com.org.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsService {

    // Twilio Account SID and Auth Token
    public static final String ACCOUNT_SID = "your_account_sid";
    public static final String AUTH_TOKEN = "your_auth_token";

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void sendSms(String to, String from, String body) {
        Message message = Message.creator(
            new PhoneNumber(to),  // To
            new PhoneNumber(from), // From
            body                  // Message Body
        ).create();
        
        System.out.println("Message SID: " + message.getSid());
    }
}
