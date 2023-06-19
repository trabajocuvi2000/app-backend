package com.seguridad.seguridad.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaRegistro {

    public java.sql.Date getFecha() {

        java.util.Date today = new Date();
        java.sql.Date date = new java.sql.Date(today.getTime()); //your SQL date object
        SimpleDateFormat simpDate = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        java.util.Date myDate = new java.util.Date(simpDate.format(date));
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        return sqlDate;
    }
}
