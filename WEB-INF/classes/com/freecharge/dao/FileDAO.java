package com.freecharge.dao;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import java.util.concurrent.ConcurrentHashMap;

import com.freecharge.utility.GlobalResources;

public class FileDAO {

    public static Map<String,Integer> counts=new ConcurrentHashMap<String, Integer>();
    
    public int getCount(String word) throws FileNotFoundException,IOException{
    	word=word.toLowerCase();
    	int count=0;
        Integer cacheCount=counts.get(word);
        if(cacheCount==null){
        	System.out.println("Word not present in cache.Searching in file");
        	try(BufferedReader inputFile=new BufferedReader(new FileReader(GlobalResources.FILE_PATH))){
            	String line=inputFile.readLine();
            	StringTokenizer tokenizer=null;
            	while(line!=null){
            		tokenizer=new StringTokenizer(line);
            		String token=null;
            		while(tokenizer.hasMoreElements()){
            			token=(String)tokenizer.nextElement();
            			if(token.equalsIgnoreCase(word))count++;
            		}
            		line=inputFile.readLine();
            	}
            }catch(FileNotFoundException fnfe){
            	System.out.println("FileNotFoundException in class FileDAO : method : getCount(String) "+fnfe.getMessage());
            }catch(IOException ioe){
            	System.out.println("IOException in class FileDAO : method : getCount(String) "+ioe.getMessage());
            }
            counts.put(word, count);
        }else{
        	System.out.println("Word Present in cache.");
        	count=cacheCount.intValue();
        }
        return count;
    }
}
