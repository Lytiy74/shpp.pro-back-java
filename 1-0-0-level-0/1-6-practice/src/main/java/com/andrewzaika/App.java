package com.andrewzaika;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws IOException {

        String outPutType = System.getProperty("output_type", "xml");
        Properties properties = new Properties();
        System.out.println(System.getProperty("java.class.path"));


        try (InputStream inputStream =  Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.properties")) {
            properties.load(inputStream);
        }catch (NullPointerException e){
            logger.warn("No configuration properties. Using default",e);
        }

        String output;

        Message greetingMessage = new Message(String.format("Привіт %s!",properties.getProperty("user_name","Stranger")));
        switch (outPutType){
            case "json" -> output = new ObjectMapper().writeValueAsString(greetingMessage);
            case "xml" -> output = new XmlMapper().writeValueAsString(greetingMessage);
            default -> throw new InvalidParameterException("Wrong passed key for properties");
        }
        logger.info(output);
    }
}
