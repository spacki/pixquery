package org.openehealth.ipf.pix;

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 09.01.11
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public class PIXConfiguration  {

    public static String enablePix;
	public static String pixManagerInfo;

    // ID domain of local ID submitted with local ID in PIX query

    public static String globalNameSpaceId;
    public static String globalUniversialId;
    public static String globalUniversalIdType;
    public static String globalIdentifierTypeCode;


    //PIX Global Query


    public String getEnablePix() {
    	return enablePix;
    }

    public void setEnablePix(String enablepix) {
    	PIXConfiguration.enablePix = enablepix;
    }

    public String getPixManagerInfo() {
    	return pixManagerInfo;
    }

    public void setPixManagerInfo(String dummy) {
    	PIXConfiguration.pixManagerInfo = dummy;
    }

    public String getGlobalNameSpaceId() {
        return globalNameSpaceId;
    }

    public void setGlobalNameSpaceId(String globalNameSpaceId) {
        PIXConfiguration.globalNameSpaceId = globalNameSpaceId;
    }

    public String getGlobalUniversialId() {
        return globalUniversialId;
    }

    public void setGlobalUniversialId(String globalUniversialId) {
        PIXConfiguration.globalUniversialId = globalUniversialId;
    }

    public String getGlobalUniversalIdType() {
        return globalUniversalIdType;
    }

    public void setGlobalUniversalIdType(String globalUniversalIdType) {
        PIXConfiguration.globalUniversalIdType = globalUniversalIdType;
    }

    public String getGlobalIdentifierTypeCode() {
        return globalIdentifierTypeCode;
    }

    public void setGlobalIdentifierTypeCode(String globalIdentifierTypeCode) {
        PIXConfiguration.globalIdentifierTypeCode = globalIdentifierTypeCode;
    }

}
