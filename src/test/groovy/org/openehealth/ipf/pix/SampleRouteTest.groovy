package org.openehealth.ipf.pix


import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.ContextConfiguration
import org.junit.Before
import org.junit.After
import org.springframework.beans.factory.annotation.Autowired
import org.apache.camel.ProducerTemplate
import org.junit.Test
import static junit.framework.Assert.*
import org.openehealth.ipf.commons.ihe.pixpdq.definitions.v25.pix.message.QBP_Q21
import org.openehealth.ipf.modules.hl7dsl.MessageAdapter
import org.openehealth.ipf.modules.hl7.parser.PipeParser
import org.openehealth.ipf.modules.hl7dsl.MessageAdapters
import org.junit.Ignore

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 09.01.11
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(locations = ['/context.xml'])
class SampleRouteTest {


    //@Autowired
   // private ProducerTemplate template;
   // private PIXConfiguration pixConfiguration;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testDummy() throws Exception {
       String expected = "Hallo";
       String current = "Hallo";
       assertEquals(expected, current);
    }

    @Test       @Ignore
    public void testRoutePixQuery() throws Exception{
      assertEquals("Eisern Union", "Eisern Union")

      def message = inputMessage("message/QBP_Q23.hl7")
      println ("MSH9:------------------------------ " + message.MSH[9][2].value)
      //String message = inputMessage("QBP_Q23.hl7").toString();
      //println "---------------------------->"  + message
      /*
      QBP_Q21 qbpMsg = new QBP_Q21()
      MessageAdapter qbpAdapter = new MessageAdapter(new PipeParser(), qbpMsg)
      println "Message: " + qbpMsg

      qbpAdapter.MSH[1] = '|'
      qbpAdapter.MSH[2] = PIXConfiguration.encodingChars
      qbpAdapter.MSH[3] = PIXConfiguration.sendingApplication
      qbpAdapter.MSH[4] = PIXConfiguration.sendingFacility
      qbpAdapter.MSH[5] = PIXConfiguration.receivingApplication
      qbpAdapter.MSH[6] = PIXConfiguration.receivingFacility
	  qbpAdapter.MSH[9][1] = 'QBP'
	  qbpAdapter.MSH[9][2] = 'Q23'
	  qbpAdapter.MSH[12] = PIXConfiguration.hl7Version
	  qbpAdapter.QPD[1][1] = PIXConfiguration.pixQueryId_1
	  qbpAdapter.QPD[1][2] = PIXConfiguration.pixQueryId_2
	  qbpAdapter.QPD[1][3] = PIXConfiguration.pixQueryId_3
	  qbpAdapter.QPD[3][2] = ''
	  qbpAdapter.QPD[3][3] = ''
	  qbpAdapter.QPD[3][4][1] = PIXConfiguration.localNamespace
	  qbpAdapter.QPD[3][4][2] = PIXConfiguration.localAssigningAuthority
	  qbpAdapter.QPD[3][4][3] = PIXConfiguration.localUUtype
	  qbpAdapter.QPD[4][1] = ''
	  qbpAdapter.QPD[4][2] = ''
	  qbpAdapter.QPD[4][3] = ''
	  qbpAdapter.QPD[4][4] = PIXConfiguration.globalAssigningAuthority
	  qbpAdapter.RCP[1] = 'I'
      println "New Messageadapter: " + qbpAdapter.QPD[1][1];
      println "New Message: " + qbpAdapter.RCP[1];
      */
    }


    private static MessageAdapter inputMessage(String resource) {
        return MessageAdapters.load(resource);
    }




}
