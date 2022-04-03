package com.it_academy.onliner_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EndPointsFileReader {
    private static final Logger LOG = LoggerFactory.getLogger(EndPointsFileReader.class);
    public static final String PATH_TO_ENDPOINTS_PROPERTIES =
            "/Users/kateradkevich/Desktop/FinalHomework/src/test/resources/endpoints.properties";
    private static final Properties properties = new Properties();

    private static FileInputStream fileInputStream;

    static {
        LOG.debug("Initializing properties");
        initialize(properties);
        LOG.debug("Finishing");
        finish();
        LOG.debug("Finished");
    }

    private EndPointsFileReader() {
    }

    private static void initialize(Properties properties) {
        try {
            fileInputStream = new FileInputStream(PATH_TO_ENDPOINTS_PROPERTIES);
            properties.load(fileInputStream);
        } catch (IOException ex) {
            LOG.error("IOException " + ex.getMessage());
        }
    }

    public static void finish() {
        try {
            fileInputStream.close();
        } catch (IOException ex) {
            LOG.error("IOException" + ex.getMessage());
        }
    }

    public static String getEndPointProperty(String key) {
        return properties.getProperty(key);
    }
}