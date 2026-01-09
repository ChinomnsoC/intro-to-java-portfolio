import java.util.List;

public class MaximumDataCalc extends AbstractDataCalc {
    public MaximumDataCalc(DataSet set) {
        super(set);
    }

    @Override
    public String getType() {
        return "MAX";
    }

    @Override
    public double calcLine(List<Double> line) {
        if (line == null || line.isEmpty()) {
            return 0.0;
        }

        double maxValue = line.get(0);

        for (Double value : line) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        return maxValue;
    }
}
