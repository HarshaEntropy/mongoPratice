package com.Harry6081.CsvToMongodb.CsvFileHandeler.Preatice;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.gridfs.GridFsOperations;
//import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

// parse csv file code
@Service
public class File1 {
//    public static void main(String args[]){
//        String file = "C: \\ Users \\ wy \\ Desktop \\ \\ Yu Ya Ying student information .csv";
//
//        List<Document> documents = new ArrayList<Document>();
//        try {
//            // connection mongo Service
//            MongoClient mongoClient = new MongoClient("localhost", 27017);
//
//            //Connect to the database
//            MongoDatabase mongoDatabase = mongoClient.getDatabase("students");
//            System.out.println("connect to database successfully");
//
//            // Create Collection
//            mongoDatabase.createCollection("222");
//            System.out.println ( "Creating a collection of success");
//            // select a collection
//            MongoCollection<Document> collection = mongoDatabase.getCollection("222");
//            System.out.println ( "set 222 selects successfully");
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            reader.readLine (); // read each row of data represents
//            String line = null;
//            while((line = reader.readLine())!=null) {
//                String [] item = line.split ( ","); // csv file is "" separated
//                String name = item [0]; // get the value in the csv assign keywords
//                String sex = item[1];
//                String password = item[2];
//                String address = item[3];
//                Document document = new Document (); // create a document
//                document.put ( "name", name); // data into the database
//                document.put("sex", sex);
//                document.put("password", password);
//                document.put("address", address);
//                documents.add(document);
//            }
//            collection.insertMany (documents); // set the document into the database
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//    }

//
//    @Autowired
//    private static GridFsTemplate template;
//
//    @Autowired
//    private GridFsOperations operations;

    public static void main( String args[] ) {
//        MultipartFile upload=new File( "C:\\Users\\Vamsi\\Downloads\\addresses.csv");

try{
        // Creating a Mongo client
//        MongoClient mongo = new MongoClient( "localhost" , 27017 );
//
//        // Creating Credentials
//        MongoCredential credential;
//        credential = MongoCredential.createCredential("admon", "uploads",
//                "wlecome123".toCharArray());
//        System.out.println("Connected to the database successfully");
//
        // Accessing the database
//        MongoDatabase database = mongo.getDatabase("myDb");
//        System.out.println("Credentials ::"+ credential);
    Runtime r = Runtime.getRuntime();
    Process p = null;
    String command = "mongoimport --db uploads --collection contacts --type csv --file C:\\Users\\Vamsi\\Downloads\\addresses.csv --headerline" ;
    p = r.exec(command);
    System.out.println("Reading csv into Database"+p);
//
//
//
//    DBObject metadata = new BasicDBObject();
//    metadata.put("fileSize", upload.getSize());
//
//    Object fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);
//
//    return fileID.toString();

}catch (Exception r){
    System.out.println(r);
}
    }




}
