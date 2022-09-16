package com.Harry6081.CsvToMongodb.CsvFileHandeler.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
@Service
public class FileService {

    public String addFile(MultipartFile upload) throws IOException {
        JSONObject jsonObject=new JSONObject();
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("uploads");
        DBCollection collection = db.getCollection("contacts");

        WriteResult result = collection.remove(new BasicDBObject());
        System.out.println(result.toString());

        BufferedReader br = new BufferedReader(new InputStreamReader(upload.getInputStream()));
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
        jsonObject.put("Status","Successfully CSV file has Uploaded");
        //return as a string

        return jsonObject.toString();

    }
}
