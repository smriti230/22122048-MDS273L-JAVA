package lab7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class lab7 {
    public static void main(String[] args) {
        String csvFile = "Iris.csv";
        String line = "";
        String csvSplitBy = ",";
        Map<String, List<Double>> data = new HashMap<String, List<Double>>();
        List<String> species = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);
                String speciesName = values[4];
                species.add(speciesName);
                for (int i = 0; i < 4; i++) {
                    double value = Double.parseDouble(values[i]);
                    String attributeName = "Attribute " + (i+1);
                    if (data.containsKey(attributeName)) {
                        data.get(attributeName).add(value);
                    } else {
                        List<Double> valuesList = new ArrayList<Double>();
                        valuesList.add(value);
                        data.put(attributeName, valuesList);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Overall Summary Statistics:");
        for (Map.Entry<String, List<Double>> entry : data.entrySet()) {
            String attributeName = entry.getKey();
            List<Double> valuesList = entry.getValue();
            double mean = calculateMean(valuesList);
            double median = calculateMedian(valuesList);
            double mode = calculateMode(valuesList);
            double min = Collections.min(valuesList);
            double max = Collections.max(valuesList);
            System.out.println(attributeName + ":");
            System.out.println("\tMean = " + mean);
            System.out.println("\tMedian = " + median);
            System.out.println("\tMode = " + mode);
            System.out.println("\tMin = " + min);
            System.out.println("\tMax = " + max);
        }

        System.out.println("\nSummary Statistics by Species:");
        for (String s : species.stream().distinct().toArray(String[]::new)) {
            System.out.println(s + ":");
            for (Map.Entry<String, List<Double>> entry : data.entrySet()) {
                String attributeName = entry.getKey();
                List<Double> valuesList = entry.getValue();
                List<Double> speciesValues = new ArrayList<Double>();
                for (int i = 0; i < valuesList.size(); i++) {
                    if (species.get(i).equals(s)) {
                        speciesValues.add(valuesList.get(i));
                    }
                }
                double mean = calculateMean(speciesValues);
                double median = calculateMedian(speciesValues);
                double mode = calculateMode(speciesValues);
                double min = Collections.min(speciesValues);
                double max = Collections.max(speciesValues);
                System.out.println("\t" + attributeName + ":");
                System.out.println("\t\tMean = " + mean);
                System.out.println("\t\tMedian = " + median);
                System.out.println("\t\tMode = " + mode);
                System.out.println("\t\tMin = " + min);
                System.out.println("\t\tMax = " + max);
            }
        }
    }

    private static double calculateMean(List<Double> values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }

    private static double calculateMedian(List<Double> values) {
        Collections.sort(values);
        return 0;
    
    }

        private static double calculateMode(List<Double> values) {
        Map<Double, Integer> countMap = new HashMap<Double, Integer>();
        int maxCount = 0;
        double mode = 0;
        for (double value : values) {
            int count = countMap.getOrDefault(value, 0) + 1;
            countMap.put(value, count);
            if (count > maxCount) {
                maxCount = count;
                mode = value;
            }
        }
        return mode;
    }
    
}
