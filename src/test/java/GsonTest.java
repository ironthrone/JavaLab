import com.google.gson.*;
import json.*;
import org.junit.Test;


/**
 * Created by Administrator on 2017/4/13.
 */
public class GsonTest {
    /**
     * 这样的反序列化器没有用，因为穿入JsonDeserializer的JsonElement一定是有值的，不会是null
     */
    @Test
    public void nullDeserializer() {
        String car = "{\"brand\":\"bench\",\"engine\":{\"calenderNum\":6}}";
        String carWithNoEngine = "{\"brand\":\"bench\",\"engine\":null}";

        //为Model和他的子类注册adapter
        Gson gson = new GsonBuilder().registerTypeHierarchyAdapter(Model.class, new NullDeserializer()).create();
        CarModel bench = gson.fromJson(carWithNoEngine, CarModel.class);
        System.out.println(bench);
    }

    @Test
    public void safeDeserializer() {
        String badJson = "{\"brand\":\"bench\",\"engine\":}";
        Gson gson = new Gson();
        System.out.println(GsonToolkit.safeFromJson(gson,badJson,CarModel.class));
    }

    @Test
    public void numberDeserializer() {
        String car = "{\"brand\":\"bench\",\"country\":\"\",\"engineCount\":\"\"}";
        Gson gson = new GsonBuilder().registerTypeAdapter(Integer.class, new BadIntegerDeserializer())
                .registerTypeAdapter(int.class,new BadIntegerDeserializer()).create();
        System.out.println(gson.fromJson(car,CarModel.class));
    }

    /**
     * 反序列化的时候没有string字段的值不能为空，为空的json根本进不去TypeAdapter
     */
    @Test
    public void defaultString() {
        CarModel BMW = new CarModel();
        BMW.brand = "BMW";
        Gson gson = new GsonBuilder().registerTypeAdapter(String.class, new StringDefaultValueAdapter()).create();
        System.out.println(gson.toJson(BMW));
        String car = "{\"brand\":,\"engine\":{\"calenderNum\":6}}";
        CarModel bench = gson.fromJson(car, CarModel.class);
        System.out.println(bench);
    }


}
