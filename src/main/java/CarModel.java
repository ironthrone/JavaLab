/**
 * Created by Administrator on 2017/4/12.
 */
public class CarModel extends Model {
    public String brand;
    public EngineModel engine;

    @Override
    public String toString() {
        return "CarModel{" +
                "brand='" + brand + '\'' +
                ", engine=" + engine +
                '}';
    }
}
