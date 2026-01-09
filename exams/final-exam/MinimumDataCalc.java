import java.util.List;

public class MinimumDataCalc extends AbstractDataCalc {
    public MinimumDataCalc(DataSet set) {
        super(set);
    }

    @Override
    public String getType() {
        return "MIN";
    }

    @Override
    public double calcLine(List<Double> line) {
        if (line == null || line.isEmpty()) {
            return 0.0;
        }

        double minValue = line.get(0);

        for (Double value : line) {
            if (value < minValue) {
                minValue = value;
            }
        }

        return minValue;
    }
}
