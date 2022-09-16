package com.Harry6081.CsvToMongodb.CsvFileHandeler.Preatice.RealTime;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Testing {
            public static void main(String[] args) throws ParseException, IOException {
            // TODO Auto-generated method stub
            String fileName ="C:\\Users\\Vamsi\\Downloads\\MOCK_DATA.csv";
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line =  null;
            HashMap<String,String> map = new HashMap<String, String>();
                line=br.readLine();
                String hed[]=line.split(",");
            while((line=br.readLine())!=null){
                String str[] = line.split(",");
                for(int i=0;i<hed.length;i++){
                    map.put(hed[i], str[i]);
                }
            }
            System.out.println(map);
//
//                final Scanner scanner = new Scanner(fileName);
//                String[] keys = scanner.nextLine().split(",");
//
//                Map<String, String> resultMap = new HashMap<>();
//
//                while (scanner.hasNextLine()) {
//                    String[] values = scanner.nextLine().split(",");
//
//                    for (int i = 0; i < keys.length; i++) {
//                        resultMap.put(keys[i], values[i]);
//                    }
//        }
//                System.out.println(resultMap.values());

}
}
