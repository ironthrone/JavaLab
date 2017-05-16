package json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by Administrator on 2017/4/6.
 */
public class StringDefaultValueAdapter extends TypeAdapter<String> {

    public void write(JsonWriter out, String value) throws IOException {
        out.value(value == null ? "writenull" : value);
    }

    public String read(JsonReader in) throws IOException {
        String value = in.nextString();
        return value == null? "nullread":value;
    }
}
