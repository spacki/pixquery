package org.openehealth.ipf.pix;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 21.02.11
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 */
public class HospitalDaoImpl extends SimpleJdbcDaoSupport implements HospitalDao {

    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public Hospital getHospitalByDomainId(String domainId) {
        logger.info("Getting hospital by id " + domainId);
        try {
           Hospital hospital = getSimpleJdbcTemplate().queryForObject(
                "select HOSPITAL_DOMAIN_NAME," +
                "       HOSPITAL_DOMAIN_ID," +
                "       HOSPITAL_PID_PREFIX" +
                "       from HOSPITAL_DETAILS" +
                "       where HOSPITAL_DOMAIN_ID = ? ",
                getMapper(), domainId);
           return hospital; }
        catch(Exception e) {
            return null;
        }
    }

    private static class HospitalRowMapper implements ParameterizedRowMapper<Hospital> {

        public Hospital mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hospital hospital = new Hospital();
            hospital.setDomainId(rs.getString("HOSPITAL_DOMAIN_ID"));
            hospital.setDomainName("HOSPITAL_DOMAIN_NAME");
            hospital.setPrefix(rs.getString("HOSPITAL_PID_PREFIX"));
            return hospital;
        }
    }

    private ParameterizedRowMapper<Hospital> getMapper() {
        return new HospitalRowMapper();
    }

}
