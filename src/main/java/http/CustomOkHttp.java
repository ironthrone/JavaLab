package http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by Administrator on 2017/5/3.
 */

public class CustomOkHttp {
    public static void main(String[] args) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .build();

        Request request = new Request.Builder()
                .url("https://api.github.com/users/ironthrone")
                .get().build();
        try {
            Response response = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
