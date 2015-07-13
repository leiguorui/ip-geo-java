package com.cyhz.ip.geo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 为了properties文件只被读取一次，所有使用了单例，在创建实例时读取properties
 * User: Green lei
 * Date: 15-4-22
 * Time: 上午11:54
 */
public class PropertiesRead {
    private static PropertiesRead instance = null;
    private static Properties prop = new Properties();
    InputStream input = null;

    // 在构造函数中读取文件
    protected PropertiesRead() {
        try {
            input = PropertiesRead.class.getResourceAsStream("/config.properties");
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static PropertiesRead getInstance() {
        if(instance == null) {
            instance = new PropertiesRead();
        }
        return instance;
    }

    public String getValue(String key){

        String value = null;

        // get the property value
        value = prop.getProperty(key);

        return value;
    }
}
