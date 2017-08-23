package sample;

import okhttp3.*;
import okhttp3.OkHttpClient.Builder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpUtility {
    public static OkHttpClient httpClient;
    private static final long OK_HTTP_CONNECTION_TIMEOUT = 360000;
    private static final boolean OK_HTTP_FOLLOW_REDIRECTS = true;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    static {
        httpClient = initializeClient();
    }

    private static OkHttpClient initializeClient() {
        Builder builder = new Builder();
        builder.connectTimeout(OK_HTTP_CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);
        builder.followRedirects(OK_HTTP_FOLLOW_REDIRECTS);
        return builder.build();
    }

    public static Map<String,Object> hit(Object params){
        Map<String,Object> response = new HashMap<>();
        try{
            Request request = null;
            MediaType type = null;
            if(params instanceof java.lang.String){
                request = new Request.Builder().url((String)params).build();
            }
            else if(params instanceof java.util.Map){
                Map paramsRef = (Map) params;
                if(((String)paramsRef.get("type")).equals("POST")) {
                    request = new Request.Builder()
                            .url((String)paramsRef.get("url"))
                            .post(RequestBody.create(JSON, (String)paramsRef.get("data")))
                            .build();
                }
            }
            Response okhttpResponse = httpClient.newCall(request).execute();
            response.put("body", okhttpResponse.body().string());
            response.put("code", okhttpResponse.code());
        }catch(Exception e){
            response = null;
        }
        return response;
    }
}

