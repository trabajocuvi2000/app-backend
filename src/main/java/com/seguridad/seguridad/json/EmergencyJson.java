package com.seguridad.seguridad.json;

import com.google.gson.JsonObject;

public class EmergencyJson {

    private String title;
    private String body;
    private String topic;
    private String emergenciaReportadaId;
    private String comunidadId;
    private String usuarioSenderId;
    private String emergenciaId;

    public EmergencyJson() {
    }

    public EmergencyJson(String topic, String emergenciaReportadaId, String comunidadId, String usuarioSenderId, String emergenciaId) {
        this.topic = topic;
        this.emergenciaReportadaId = emergenciaReportadaId;
        this.comunidadId = comunidadId;
        this.usuarioSenderId = usuarioSenderId;
        this.emergenciaId = emergenciaId;
    }
    
    public JsonObject getEmergencyJson() {
        JsonObject json = new JsonObject();
        json.add("message", getMessageBody());
        return json;
    }

    public JsonObject getMessageBody() {
        JsonObject json = new JsonObject();
        json.addProperty("topic", getTopic());
        json.add("notification", getNotificationBody());
        json.add("data", getDataBody());
        return json;
    }

    public JsonObject getNotificationBody() {
        JsonObject json = new JsonObject();
        json.addProperty("title", getTitle());
        json.addProperty("body", getBody());
        return json;
    }

    public JsonObject getDataBody() {
        JsonObject json = new JsonObject();
        json.addProperty("emergenciaReportadaId", getEmergenciaReportadaId());
        json.addProperty("comunidadId", getComunidadId());
        json.addProperty("usuarioSenderId", getUsuarioSenderId());
        json.addProperty("emergenciaId", getEmergenciaId());
        return json;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getEmergenciaReportadaId() {
        return emergenciaReportadaId;
    }

    public void setEmergenciaReportadaId(String emergenciaReportadaId) {
        this.emergenciaReportadaId = emergenciaReportadaId;
    }

    public String getComunidadId() {
        return comunidadId;
    }

    public void setComunidadId(String comunidadId) {
        this.comunidadId = comunidadId;
    }

    public String getUsuarioSenderId() {
        return usuarioSenderId;
    }

    public void setUsuarioSenderId(String usuarioSenderId) {
        this.usuarioSenderId = usuarioSenderId;
    }

    public String getEmergenciaId() {
        return emergenciaId;
    }

    public void setEmergenciaId(String emergenciaId) {
        this.emergenciaId = emergenciaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
    

}
