package com.Harry6081.CsvToMongodb.CsvFileHandeler.Preatice;

import com.Harry6081.CsvToMongodb.CsvFileHandeler.Preatice.ExecutionsClass;

public class FileTransfer {
    public static void main(String[] args) {
        String db="uploads";
        String collection="contact";
        String fileType="csv";
        String filePath="C:\\Users\\Vamsi\\Downloads\\addresses.csv";
        Process p = null;
        String command = "mongoimport --db "+db+" --collection "+collection+" --type "+fileType+" --file "+filePath+" --headerline" ;

        ExecutionsClass.execute(command);
    }
}
