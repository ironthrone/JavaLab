import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

/**
 * Created by Administrator on 2017/4/6.
 */
public class GsonKeeper {
    private Gson gson;
    private static GsonKeeper INSTANCE = new GsonKeeper();

    public static GsonKeeper getINSTANCE() {
        return INSTANCE;
    }

    private GsonKeeper() {
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(String.class, new StringDefaultValueDeserializer());
        gson = gsonBuilder.create();
    }

    public Gson getGson() {
        return gson;
    }


    public static void main(String[] args) {
//        String test = "{\"ambition\":\"\",\"achievement\":\"confucius\"}";
//        String test2 = "{\"achievement\":\"confucius\"}";//ambition 字段不会进入JsonDeserializer
//        Gson gson = GsonKeeper.getINSTANCE().getGson();
//        Person person = gson.safeFromJson(test, Person.class);
//        Person person2 = gson.safeFromJson(test2, Person.class);
//        System.out.println(person);
//        System.out.println(person2);

//        Person person3 = new Person();
//        person3.ambition = "ambition";
//        Gson gson2 = new GsonBuilder().registerTypeAdapter(String.class, new StringDefaultValueAdapter()).create();
//        System.out.println(gson2.toJson(person3));

        String car = "{\"brand\":\"bench\",\"engine\":{\"calenderNum\":6}}";
        String carWithNoEngine = "{\"brand\":\"bench\",\"engine\":null}";
        String badJson = "{\"brand\":\"bench\",\"engine\":}";

        //为Model和他的子类注册adapter
        Gson gson3 = new GsonBuilder().registerTypeHierarchyAdapter(Model.class, new NullDeserializer()).create();
//        CarModel bench = gson3.safeFromJson(badJson, CarModel.class);
//        System.out.println(bench);
        System.out.println(safeFromJson(gson3,badJson,CarModel.class));

    }

    //捕获解析时的异常，阻止崩溃
    public static <T> T safeFromJson(Gson gson, String json, Class<T> classOfT) throws JsonSyntaxException {

        try {
            return gson.fromJson(json, classOfT);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    static class Person {
        String ambition;
        String achievement;

        @Override
        public String toString() {
            return "Person{" +
                    "ambition='" + ambition + '\'' +
                    ", achievement='" + achievement + '\'' +
                    '}';
        }
    }
}
