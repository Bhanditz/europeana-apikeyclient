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

/**
 * Created by luthien on 11/05/2017.
 */

/**
 *  Wrapper object for the parameters needed to validate an Apikey
 */
public class ValidationRequest {

    private String api;
    private String method;
    private String adminApikey;
    private String adminSecretkey;
    private String apikey;

    public ValidationRequest(String adminApikey, String adminSecretkey, String apikey, String api){
        setAdminApikey(adminApikey);
        setAdminSecretkey(adminSecretkey);
        setApikey(apikey);
        setApi(api);
    }

    public ValidationRequest(String adminApikey, String adminSecretkey, String apikey, String api, String method){
        this(adminApikey, adminSecretkey, apikey, api);
        setMethod(method);
    }

    String getApi() {
        return api;
    }

    /*
     * @param api (String) identifier of the API the apikey needs to be validated for (either 'search', 'entity' or 'annotation')
     */
    public final void setApi(String api) {
        this.api = api;
    }

    String getMethod() {
        return method;
    }

    /*
     * @param method (String) (optional) identifier of method the apikey needs to be validated for (either 'read' or 'write')
     */
    public final void setMethod(String method) {
        this.method = method;
    }

    String getAdminApikey() {
        return adminApikey;
    }

    /*
     * @param adminApikey (String) ADMIN level apikey, required to authorise request to the apikey service
     */
    public final void setAdminApikey(String adminApikey) {
        this.adminApikey = adminApikey;
    }

    String getAdminSecretkey() {
        return adminSecretkey;
    }

    /*
     * @param adminSecretkey (String) secret key of the ADMIN level apikey, required to authenticate that apikey
     */
    public final void setAdminSecretkey(String adminSecretkey) {
        this.adminSecretkey = adminSecretkey;
    }

    String getApikey() {
        return apikey;
    }
    /*
     * @param apikey (String) apikey to be validated
     */
    public final void setApikey(String apikey) {
        this.apikey = apikey;
    }



}
