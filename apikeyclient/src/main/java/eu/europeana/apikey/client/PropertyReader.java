/*
 * Copyright 2007-2017 The Europeana Foundation
 *
 *  Licenced under the EUPL, Version 1.1 (the "Licence") and subsequent versions as approved
 *  by the European Commission;
 *  You may not use this work except in compliance with the Licence.
 *
 *  You may obtain a copy of the Licence at:
 *  http://joinup.ec.europa.eu/software/page/eupl
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under
 *  the Licence is distributed on an "AS IS" basis, without warranties or conditions of
 *  any kind, either express or implied.
 *  See the Licence for the specific language governing permissions and limitations under
 *  the Licence.
 */

package eu.europeana.apikey.client;

import eu.europeana.apikey.client.exception.ApiKeyValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by luthien on 14/06/2017.
 */
public class PropertyReader {

    private static final Logger         LOG      = LogManager.getLogger(PropertyReader.class);
    private static       PropertyReader instance = null;

    private Properties props = null;
    String propFileName = "config.properties";

    private PropertyReader() throws ApiKeyValidationException {
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propFileName)) {
            props = new Properties();
            if (inputStream != null) { props.load(inputStream); }
            else {
                LOG.error("Could not find property file");
                throw new ApiKeyValidationException("Error: property file '" + propFileName + "' not found in the classpath");
            }
        } catch (IOException e) {
            LOG.error("Could not read property file");
            throw new ApiKeyValidationException("IOException thrown when trying to read 'apikeyserviceurl' property " +
                    "from property file " + propFileName, e);
        }
    }

    public static synchronized PropertyReader getInstance() throws ApiKeyValidationException {
        if (instance == null)
            instance = new PropertyReader();
        return instance;
    }

    public String getApiKeyServiceUrl(){
        return this.props.getProperty("apikeyserviceurl");
    }
}
