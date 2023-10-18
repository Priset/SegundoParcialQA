package api.factoryRequest;

import java.util.HashMap;
import java.util.Map;

public class FactoryRequest {

    private static Map<String, IRequest> iRequestMap = new HashMap<>();

    public static IRequest make(String type) {
        iRequestMap.put("put", new RequestPUT());
        iRequestMap.put("post", new RequestPOST());
        iRequestMap.put("get", new RequestGET());
        iRequestMap.put("delete", new RequestDELETE());

        return iRequestMap.containsKey(type.toLowerCase())? iRequestMap.get(type.toLowerCase()):iRequestMap.get("get");
    }

}
