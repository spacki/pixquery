package org.openehealth.ipf.pix;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 19.01.11
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */
public class PrefixLookup {

    private static HashMap<String, String>  prefixMap;

    public HashMap<String, String> getPrefixMap() {
        return prefixMap;
    }

    public  void setPrefixMap(HashMap<String, String> prefixMap) {
        PrefixLookup.prefixMap = prefixMap;
    }
}
