package org.openehealth.ipf.pix;

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 21.02.11
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
public class Hospital {

    public static String domainName;
    public static String domainId;
    public static String prefix;

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        Hospital.domainName = domainName;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        Hospital.domainId = domainId;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        Hospital.prefix = prefix;
    }

    public String toString() {
        return this.getDomainName() + ":" + this.getDomainId() + ":" + this.getPrefix();
    }
}
