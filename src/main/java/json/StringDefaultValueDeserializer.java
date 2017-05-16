package json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/4/6.
 */
public class StringDefaultValueDeserializer implements JsonDeserializer<String>{

    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String result = json.getAsString();
        //合法的json中值String的值不会为null，
        return result == null ? "" : result;
    }
}
