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

    }


    private static MessageAdapter inputMessage(String resource) {
        return MessageAdapters.load(resource);
    }




}
