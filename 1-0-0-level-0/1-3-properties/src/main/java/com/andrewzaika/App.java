package com.andrewzaika;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class App
{

    public static final String ROOT_PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    public static void main(String[] args ) {
        System.out.println("\n====READING FROM .PROPERTIES====");
        readFromProperties();
        System.out.println("\n====READING FROM XML====");
        readFromXMLProperties();



        readCyrillicProperties();

        writeToPropertiesFile();
    }

    private static void writeCyrillicProperties() {
        String appConfigPath = ROOT_PATH + "createdCyrillic.properties";

        Properties properties = new Properties();
        properties.setProperty("key","українські літери");

        System.out.println("\n====WRITE CYRILLIC IN FILE====");
        try(Writer outputStream = new FileWriter(appConfigPath)){
            properties.store(outputStream, "NO COMMENTS");
            for (String stringPropertyName : properties.stringPropertyNames()) {
                System.out.println(properties.getProperty(stringPropertyName));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readCyrillicProperties() {
        String appConfigPath = ROOT_PATH + "createdCyrillic.properties";

        Properties properties = new Properties();

        System.out.println("\n====READING BY FILE READER====");
        try(InputStream inputStream = new FileInputStream(appConfigPath)){
            properties.load(inputStream);
            for (String stringPropertyName : properties.stringPropertyNames()) {
                System.out.println(properties.getProperty(stringPropertyName));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void writeToPropertiesFile() {
        String appConfigPath = ROOT_PATH + "createdProperties.properties";

        Properties properties = new Properties();
        properties.setProperty("key1","value1");
        try(OutputStream outputStream = new FileOutputStream(appConfigPath)) {
            properties.store(outputStream, "Some comments in properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFromXMLProperties() {
        String appConfigPath = App.ROOT_PATH + "appConfig.xml";

        Properties defaultProperties = new Properties();
        defaultProperties.setProperty("TABLE_NAME","cars");

        Properties properties = new Properties(defaultProperties);

        try(InputStream inputStream = new FileInputStream(appConfigPath)) {
            properties.loadFromXML(inputStream);
            Set<String> strings = properties.stringPropertyNames();
            for (String key : strings) {
                System.out.println(key + "=" + properties.getProperty(key));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFromProperties() {
        String appConfigPath = ROOT_PATH + "app.properties";

        Properties defaultProperties = new Properties();
        defaultProperties.setProperty("TABLE_NAME","cars");

        Properties properties = new Properties(defaultProperties);

        try(FileInputStream inputStream = new FileInputStream(appConfigPath)) {
            properties.load(inputStream);
            Set<String> strings = properties.stringPropertyNames();
            for (String key : strings) {
                System.out.println(key + "=" + properties.getProperty(key));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
