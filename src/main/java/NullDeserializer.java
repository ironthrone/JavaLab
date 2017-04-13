import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * 如果字段不存在，它是不会参加反序列化的，所以为不存在的字段设置反序列化器是无效的
 */
public class NullDeserializer implements JsonDeserializer<Model> {
    private Gson gson = new Gson();

    public Model deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject == null) {
            try {
            Class clazz = typeOfT.getClass();
                return (Model) clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //False 这个jsonObject中的Model类型就不会进入当前的反序列化器
        return gson.fromJson(jsonObject,typeOfT);
    }
}
