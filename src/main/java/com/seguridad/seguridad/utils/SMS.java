package com.seguridad.seguridad.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMS {
    
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure

//    public static final String ACCOUNT_SID = System.getenv("AC7e70ec88da2805b70cc05c4b9c3c1d0c");
//    public static final String AUTH_TOKEN = System.getenv("098112325da1f721a133dae93f55bb40");
    
    public static final String ACCOUNT_SID = "AC7e70ec88da2805b70cc05c4b9c3c1d0c";
    public static final String AUTH_TOKEN = "098112325da1f721a133dae93f55bb40";

    public static void main(String[] args) {
        System.out.println("1 ---------");
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        System.out.println("2 ---------");
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+593968500339"),
                new com.twilio.type.PhoneNumber("+593962726474"),
                "Hola :)")
                .create();
System.out.println("3 ---------");
        System.out.println(message.getSid());
    }
    
}
