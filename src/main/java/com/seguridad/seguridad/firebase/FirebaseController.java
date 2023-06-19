/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seguridad.seguridad.firebase;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import static com.google.common.base.Predicates.equalTo;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.gson.JsonObject;
import com.seguridad.seguridad.json.EmergencyJson;
import com.seguridad.seguridad.json.Json;
import com.seguridad.seguridad.model.FirebaseData;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"firebase"})
public class FirebaseController {

    static public FirebaseData firebaseData = new FirebaseData();

    private static final String MESSAGING_SCOPE = "https://www.googleapis.com/auth/firebase.messaging";
    private static final String[] SCOPES = {MESSAGING_SCOPE};

    @PostMapping(path = {"/mensaje"})
    public FirebaseData mensajes(@RequestBody Json jsonBody) throws UnsupportedEncodingException, IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://fcm.googleapis.com/v1/projects/flutter-notificaciones-7cba0/messages:send");

        String json = getJsonEmergency(jsonBody);

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

    @PostMapping
    public FirebaseData whenPostJsonUsingHttpClient_thenCorrect(@RequestBody Json jsonBody)
            throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://fcm.googleapis.com/v1/projects/flutter-notificaciones-7cba0/messages:send");

//        String json = "{\n"
//                + "  \"message\": {\n"
//                + "    \"topic\": \"com1\",\n"
//                + "    \"notification\": {\n"
//                + "      \"title\": \"Java\",\n"
//                + "      \"body\": \"Este es un ejemplo desde java\"\n"
//                + "    },\n"
//                + "    \"data\": {\n"
//                + "      \"story_id\": \"story_12345\"\n"
//                + "    }\n"
//                + "  }\n"
//                + "}";
//System.out.println(jsonBody);
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
//        System.out.println(response.getStatusLine().getStatusCode());
//        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
        client.close();

        return firebaseData;
    }

    private static String getAccessToken() throws IOException {

//        C:\Users\Jonnathan\Downloads\\service-account.json
//        C:\\Users\\Admin\\Downloads\\service-account.json
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new FileInputStream("C:\\\\Users\\\\Admin\\\\Downloads\\\\service-account.json"))
                .createScoped(Arrays.asList(SCOPES));
        AccessToken accessToken = googleCredentials.refreshAccessToken();
        String token = accessToken.getTokenValue();
        firebaseData.setTookenTopics(token);
        return token;
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

}
