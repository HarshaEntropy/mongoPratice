package com.Harry6081.CsvToMongodb.CsvFileHandeler.Preatice.RealTime;

import com.mongodb.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

public class CsvFileReaderToMongo {
    public static void main(String[] args) throws ParseException, IOException {

        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("uploads");
        DBCollection collection = db.getCollection("contacts");

        WriteResult result = collection.remove(new BasicDBObject());
        System.out.println(result.toString());
        String fileName ="C:\\Users\\Vamsi\\Downloads\\MOCK_DATA.csv";

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line =  null;
        HashMap<String,String> map = new HashMap<String, String>();
        String headerLine=br.readLine();
        String hed[]=headerLine.split(",");
        while((line=br.readLine())!=null){
            String str[] = line.split(",");
            for(int i=0;i<=hed.length;i++){
                try{
                map.put(hed[i], str[i]);}
                catch (ArrayIndexOutOfBoundsException ignored){
                    break;
                }

            }
            collection.insert(new BasicDBObject(map));
        }
     }
}
