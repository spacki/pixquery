package org.openehealth.ipf.pix;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 21.02.11
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
public class HospitalServiceImpl implements  HospitalService {

    protected final Log logger = LogFactory.getLog(getClass());
    private static HospitalDao hospitalDao;

    public static Hospital hospital;

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        HospitalServiceImpl.hospital = hospital;
    }

    public Hospital getHospitalByDomainId(String domainId) {
        logger.info("Getting hospital by id " + domainId);
        return hospitalDao.getHospitalByDomainId(domainId);
    }

    public void setHospitalDao(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }
}
