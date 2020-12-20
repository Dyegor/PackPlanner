package com.dmitriy.packplanner.util;


import com.dmitriy.packplanner.entity.Item;
import com.dmitriy.packplanner.entity.Pack;

import java.text.DecimalFormat;
import java.util.List;

public class ResultsPrinter {
    public static void readResults(StringBuilder builder, Pack pack) {
        for (Item item : pack.getListOfItems()) {
            builder.append(item.getId()).append(",");
            builder.append(item.getLength()).append(",");
            builder.append(item.getQuantity()).append(",");
            builder.append(item.getItemWeight()).append(",");
            builder.append("\n");
        }
    }

    public static double totalWeightOutputFormat(double totalWeight) {
        DecimalFormat df = new DecimalFormat("#.###");
        totalWeight = Double.parseDouble(df.format(totalWeight));
        return totalWeight;
    }

    public static void printResults(List<Pack> result) {
        for (Pack pack : result) {
            StringBuilder builder = new StringBuilder();

            builder.append("Pack Number: ").append(pack.getPackId());
            builder.append("\n");

            readResults(builder, pack);

            builder.append("Pack Length: ").append(pack.getTotalLength());
            builder.append(", Pack Weight: ").append(totalWeightOutputFormat(pack.getTotalWeight()));
            builder.append("\n");

            System.out.println(builder.toString());
        }
    }
}
