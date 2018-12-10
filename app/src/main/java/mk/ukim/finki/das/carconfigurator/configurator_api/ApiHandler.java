package mk.ukim.finki.das.carconfigurator.configurator_api;

import org.json.JSONObject;

import java.net.URL;

public interface ApiHandler {

    public JSONObject sendRequest(URL url);
}
