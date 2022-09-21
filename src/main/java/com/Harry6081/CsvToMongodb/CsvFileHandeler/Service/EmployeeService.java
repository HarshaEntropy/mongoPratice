package com.Harry6081.CsvToMongodb.CsvFileHandeler.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeService {
public List<Document> getAll(){
    MongoClient mongo = new MongoClient("localhost", 27017);
    MongoDatabase database = mongo.getDatabase("uploads");
    MongoCollection<Document> collection = database.getCollection("contacts");
    FindIterable<Document> iterDoc = collection.find();
    Iterator it = iterDoc.iterator();
    List<Document> list =new ArrayList<>();
    while (it.hasNext()) {
        list.add((Document) it.next());
    }
//    list.addAll((Collection<?>) iterDoc);
    return list;
    }
    public List<Document> getByString(String name){
        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase database = mongo.getDatabase("uploads");
        MongoCollection<Document> collection = database.getCollection("contacts");
        BasicDBObject whereQuery = new BasicDBObject();
        List<BasicDBObject> andQuery = new ArrayList<>();
        andQuery.add(new BasicDBObject("first_name",new BasicDBObject("$regex", name).append("$options", "i")));
        andQuery.add(new BasicDBObject("last_name",new BasicDBObject("$regex", name).append("$options", "i")));
        whereQuery.put("$or",andQuery);
        FindIterable<Document> iterDoc = collection.find(whereQuery);
        Iterator it = iterDoc.iterator();
        List<Document> list =new ArrayList<>();
        while (it.hasNext()) {
            list.add((Document) it.next());
        }
//    list.addAll((Collection<?>) iterDoc);
        return list;
    }
}
