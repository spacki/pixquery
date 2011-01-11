package org.openehealth.ipf.pix

import org.apache.camel.spring.SpringRouteBuilder
import org.openehealth.ipf.modules.hl7.message.MessageUtils
import static org.openehealth.ipf.platform.camel.core.util.Exchanges.resultMessage
import org.openehealth.ipf.commons.core.modules.api.ValidationException;
import ca.uhn.hl7v2.parser.PipeParser;

class SampleRouteBuilder extends SpringRouteBuilder {

    def rsp = '''MSH|^~\\&|MESA_XREF|XYZ_HOSPITAL|MESA_PIX_CLIENT|MESA_DEPARTMENT|20090901141123||RSP^K23^RSP_K23|356813|P|2.5
         MSA|AA|10501108
         QAK|QRY10501108|OK
         QPD|QRY_1001^Query for Corresponding Identifiers^IHEDEMO|QRY10501108|79471^^^HZLN^PI|^^^KHKN~^^^&2.16.840.1.113883.3.37.4.1.1.2.411.1&ISO~^^^PKLN&2.16.840.1.113883.3.37.4.1.1.2.511.1&ISO
         PID|1||79471^^^HZLN&2.16.840.1.113883.3.37.4.1.1.2.411.1&ISO^PI~78912^^^PKLN&2.16.840.1.113883.3.37.4.1.1.2.511.1&ISO^PI||~^S
             '''

    void configure() {


        // -------------------------------------------------------------
        //  Validate request, enqueue request and generate ack/nak
        // -------------------------------------------------------------
        //from('pix-iti9://0.0.0.0:8444?audit=false')
        from("pix-iti9://${PIXConfiguration.pixManagerInfo}")
           .onException(ValidationException.class).to('direct:error').end()
           .validate().iti9Request()
           //.inOnly().to('direct:input2')
           //.process { new QbpQ21Processor() }
           /*
           .process {
               println "Hallo welt -----------------------------------> " + it.in.body.QPD[3].value
               println "Hallo welt -----------------------------------> " + it.in.body.QPD[4].value
               println "MSH " + it.in.body.MSH.value
               println "QPD " + it.in.body.QPD.value
               println "RCP " + it.in.body.RCP[1].value

            //   MessageAdapters.make(new PipeParser(),MessageUtils.ack(it.in.body.target)
               //resultMessage(it).body = MessageUtils.ack(it.in.body.target)
               //resultMessage(it).body = rsp
           }*/
           .processRef('qbpq21Response')

         from('direct:error')
            .convertBodyTo(String.class)
    		.to('file:target/output')
    }
    
}
