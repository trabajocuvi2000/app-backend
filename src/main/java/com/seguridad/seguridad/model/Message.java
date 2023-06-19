package com.seguridad.seguridad.model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {
    private String senderName;
    private int senderId;
    private String receiverName;
    private int receiveGroup;
    private String message;
    private String date;
    private Status status;
}
