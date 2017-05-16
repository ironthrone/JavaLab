package http;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * 从链条上游接收到request，交给下游链条处理，然后处理下游链条处理后返回的Response
 */

public class LogInterceptor implements Interceptor {

    private static final String TAG = LogInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        System.out.println(request.toString());
        Response response = chain.proceed(request);
        System.out.println(response.toString());
        return response;
    }
}
