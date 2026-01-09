import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDataCalc {

    // Instance variables
    private DataSet dataSet;
    private List<Double> calculationResults;

    public AbstractDataCalc(DataSet set) {
        this.calculationResults = new ArrayList<>();
        setAndRun(set);
    }

    public void setAndRun(DataSet set) {
        this.dataSet = set;

        if (dataSet != null) {
            runCalculations();
        }

    }

    private void runCalculations() {
        calculationResults.clear();

        for (int i = 0; i < dataSet.rowCount(); i++) {
            List<Double> row = dataSet.getRow(i);

            double result = calcLine(row);

            calculationResults.add(result);
        }
    }

    @Override
    public String toString() {
        String result = "Dataset Results (Method: " + getType() + ")\n";

        for (int i = 0; i < calculationResults.size(); i++) {
            double roundedCalculationResults = Math.round(calculationResults.get(i) * 10.0) / 10.0;
            result += "Row " + (i + 1) + ": " + roundedCalculationResults + "\n";
        }

        return result;
    }

    public abstract String getType();

    public abstract double calcLine(List<Double> line);
}