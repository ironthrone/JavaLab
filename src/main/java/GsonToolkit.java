import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Created by Administrator on 2017/4/13.
 */
public class GsonToolkit {
    //捕获解析时的异常，阻止崩溃
    public static <T> T safeFromJson(Gson gson, String json, Class<T> classOfT) throws JsonSyntaxException {

        try {
            return gson.fromJson(json, classOfT);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
