import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/4/12.
 */
public class CatchExceptionDeserializer implements JsonDeserializer<Object> {
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {

            //行不通，这是递归调用
            return context.deserialize(json, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
