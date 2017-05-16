package json;

/**
 * Created by Administrator on 2017/4/12.
 */
public class CarModel extends Model {
    public String brand;
    public String country;
    public EngineModel engine;
    public int engineCount;

    @Override
    public String toString() {
        return "json.CarModel{" +
                "brand='" + brand + '\'' +
                ", engine=" + engine +
                '}';
    }
}
