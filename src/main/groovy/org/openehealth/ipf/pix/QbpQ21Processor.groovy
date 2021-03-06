package org.openehealth.ipf.pix

import org.apache.camel.Processor
import org.apache.camel.Exchange
import org.openehealth.ipf.modules.hl7dsl.MessageAdapter

import org.openehealth.ipf.commons.ihe.pixpdq.definitions.v25.pdq.message.RSP_K21
import java.text.SimpleDateFormat
import java.text.DateFormat

import org.apache.commons.logging.LogFactory
import org.apache.commons.logging.Log

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 10.01.11
 * Time: 10:51
 * To change this template use File | Settings | File Templates.
 */
class QbpQ21Processor implements  Processor {


    private static final transient Log LOG = LogFactory.getLog(QbpQ21Processor);



  @Override
  void process(Exchange exchange)  {
    def msg = exchange.in.body
    RSP_K21 rspMsg = new RSP_K21()
    HospitalServiceImpl hospitalService = new HospitalServiceImpl()
    def hospital = hospitalService.getHospitalByDomainId(msg.QPD[3][4][2].value);
    if (hospital != null) {
      LOG.debug("Hospital: " + hospital)
    }
    MessageAdapter qbpAdapter = new MessageAdapter(rspMsg)
    // wir bauen ein vernuenftiges MSH Segment
    qbpAdapter.MSH = msg.MSH
    //qbpAdapter.MSH[9] = 'RSP^K23^RSP_K23'
    qbpAdapter.MSH[3] = msg.MSH[5]
    qbpAdapter.MSH[4] = msg.MSH[6]
    qbpAdapter.MSH[5] = msg.MSH[3]
    qbpAdapter.MSH[6] = msg.MSH[4]
    qbpAdapter.MSH[9][1] = 'RSP'
    qbpAdapter.MSH[9][2] = 'K23'
    qbpAdapter.MSH[9][3] = ''
    //MSH[10]
    Date date = new Date()
    DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssS")
    def msh10 = formatter.format(date)
    qbpAdapter.MSH[10] = msh10
    qbpAdapter.MSA[1] = 'AA'
    qbpAdapter.MSA[2] = msg.MSH[10]
    qbpAdapter.QAK[1] = msg.QPD[2]
    qbpAdapter.QAK[2] = 'OK'
    qbpAdapter.QPD = msg.QPD

    //def prefixMap = PrefixLookup.prefixMap
    def prefixMapi = PrefixLookup.prefixMap
    def prefix =  prefixMapi.get(msg.QPD[3][4][2].value)
    if (prefix != null) {

      qbpAdapter.QUERY_RESPONSE.PID[3] = hospital.prefix + "_" + msg.QPD[3][1].value
      //qbpAdapter.QUERY_RESPONSE.PID[3] = msg.QPD[3][4][1].value + "_" + msg.QPD[3][1].value
      qbpAdapter.QUERY_RESPONSE.PID[3][4][1] = PIXConfiguration.globalNameSpaceId //'global'
      qbpAdapter.QUERY_RESPONSE.PID[3][4][2] = PIXConfiguration.globalUniversialId
      qbpAdapter.QUERY_RESPONSE.PID[3][4][3] = PIXConfiguration.globalUniversalIdType
      qbpAdapter.QUERY_RESPONSE.PID[3][5] = PIXConfiguration.globalIdentifierTypeCode
      qbpAdapter.QUERY_RESPONSE.PID[5](0)[7] = ''
      qbpAdapter.QUERY_RESPONSE.PID[5](1)[7] = 'S'
      LOG.debug("Global Patient ID found: " + qbpAdapter.QUERY_RESPONSE.PID[3].value )
    } else {
       LOG.debug("Global Patient ID not found may be local domain id is not configured :  QPD[3][4][2] " +  msg.QPD[3][4][2].value)
       qbpAdapter.QAK[2] = 'NF'
    }
    exchange.out.body = qbpAdapter


  }


}
