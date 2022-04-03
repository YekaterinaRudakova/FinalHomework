package com.it_academy.onliner_functional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigFileReader {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigFileReader.class);
    public static final String PATH_TO_CONFIGURATION_PROPERTIES =
            "/Users/kateradkevich/Desktop/FinalHomework/src/test/resources/config.properties";
    private static final Properties properties= new Properties();;
    private static FileInputStream fileInputStream;

    static {
        LOG.debug("Initializing properties");
        initialize(properties);
        LOG.debug("Finishing");
        finish();
        LOG.debug("Finished");
    }

    private ConfigFileReader() {
    }

    private static void initialize(Properties properties) {
        try {
            fileInputStream = new FileInputStream(PATH_TO_CONFIGURATION_PROPERTIES);
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

    public static String readConfigurationStringProperties(String key) {
        return properties.getProperty(key);
    }

    public static int readConfigurationIntegerProperties(String key) {
        try {
            return Integer.parseInt(readConfigurationStringProperties(key));
        } catch (Exception ex) {
            LOG.error("Exception "+ ex.getMessage());
            return 0;
        }
    }

    public static boolean readConfigurationBooleanProperties(String key) {
        try {
            return Boolean.parseBoolean(readConfigurationStringProperties(key));
        } catch (Exception ex) {
            LOG.error("Exception "+ ex.getMessage());
            return false;
        }
    }
}