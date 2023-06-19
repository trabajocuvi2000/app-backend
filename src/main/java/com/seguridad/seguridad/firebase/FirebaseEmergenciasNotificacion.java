package com.seguridad.seguridad.firebase;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.seguridad.seguridad.json.EmergencyJson;
import com.seguridad.seguridad.json.Json;
import com.seguridad.seguridad.model.FirebaseData;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class FirebaseEmergenciasNotificacion {

    static public FirebaseData firebaseData = new FirebaseData();

    private static final String MESSAGING_SCOPE = "https://www.googleapis.com/auth/firebase.messaging";
    private static final String[] SCOPES = {MESSAGING_SCOPE};

    public FirebaseData notificarEmergencias(Json jsonBody)
            throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://fcm.googleapis.com/v1/projects/flutter-notificaciones-7cba0/messages:send");

        String json = getJsonEmergency(jsonBody);
//        String json = jsonBody.toString();
        System.out.println(json);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + getAccessToken());

        CloseableHttpResponse response = client.execute(httpPost);
        firebaseData.setStatus(response.getStatusLine().getStatusCode());
        client.close();

        return firebaseData;
    }

    private static String getJsonEmergency(Json jsonBody) {
        EmergencyJson emergencyJson = new EmergencyJson();

        emergencyJson.setTitle(jsonBody.getMessage().getNotification().getTitle());
        emergencyJson.setBody(jsonBody.getMessage().getNotification().getBody());

        emergencyJson.setTopic(jsonBody.getMessage().getTopic());
        emergencyJson.setEmergenciaReportadaId(jsonBody.getMessage().getData().getEmergenciaReportadaId());
        emergencyJson.setComunidadId(jsonBody.getMessage().getData().getComunidadId());
        emergencyJson.setUsuarioSenderId(jsonBody.getMessage().getData().getUsuarioSenderId());
        emergencyJson.setEmergenciaId(jsonBody.getMessage().getData().getEmergenciaId());

        String json = emergencyJson.getEmergencyJson().toString();

        return json;
    }

    private static String getAccessToken() throws IOException {

        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new FileInputStream("C:\\Users\\Jonnathan\\Downloads\\service-account.json"))
                .createScoped(Arrays.asList(SCOPES));
        AccessToken accessToken = googleCredentials.refreshAccessToken();
        String token = accessToken.getTokenValue();
        firebaseData.setTookenTopics(token);
        return token;
    }

}
