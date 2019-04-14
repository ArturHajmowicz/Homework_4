package com.infoshareacademy.homeworks;

import java.text.DecimalFormat;
import java.util.*;


public class GradeService {

    public String[][] calculateAverage(String[][] data) {

        GradeService gradeService = new GradeService();

        if (gradeService.checkIfEmptyOrNull(data)) {
            String[][] emptyArray = new String[][]{{}};
            return emptyArray;
        };

        Map<String, String> map = new TreeMap<>();

        for (String[] mapping : data) {
            map.put(mapping[0], mapping[1]);
        }

        Object[][] arr = new String[map.size()][2];
        Set entries = map.entrySet();
        Iterator entriesIterator = entries.iterator();

        int i = 0;
        while (entriesIterator.hasNext()) {

            Map.Entry mapping = (Map.Entry) entriesIterator.next();

            arr[i][0] = mapping.getKey();
            arr[i][1] = mapping.getValue();

            i++;

        }

        String[][] arr2 = Arrays.copyOf(arr, arr.length, String[][].class);

        gradeService.parseWithDecimal(arr2);


        return arr2;
    }


    public boolean checkIfEmptyOrNull(String[][] data) {

        if (data == null || data.length == 0) {
            return true;
        }

        return false;
    }


    public String[][] parseWithDecimal(String[][] arr2) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        for (int g = 0; g < arr2.length; g++) {
            arr2[g][1] = decimalFormat.format(Double.valueOf(arr2[g][1]));
            arr2[g][1] = arr2[g][1].replace(',', '.');
        }

        return arr2;
    }


}

