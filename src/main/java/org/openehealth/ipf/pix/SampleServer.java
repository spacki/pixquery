package org.openehealth.ipf.pix;

import org.apache.camel.spring.Main;

public class SampleServer {

    public static void main(String[] args) throws Exception {
        Main.main("-ac", "/conf/context.xml");
    }
    
}
