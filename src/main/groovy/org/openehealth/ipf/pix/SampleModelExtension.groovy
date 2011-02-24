package org.openehealth.ipf.pix

import org.apache.camel.model.ProcessorDefinition
import org.apache.camel.Exchange
import org.apache.commons.logging.LogFactory
import org.apache.commons.logging.Log

/**
 * Created by IntelliJ IDEA.
 * User: 100026806
 * Date: 18.02.11
 * Time: 08:18
 * To change this template use File | Settings | File Templates.
 */
class SampleModelExtension  {

  private static final transient Log LOG = LogFactory.getLog(SampleModelExtension.class)

  static extensions = {

    ProcessorDefinition.metaClass.output = { String message, Closure c ->
            return delegate.process {
                def payload = c ? c(it.in.body) : it.in.body
                LOG.debug("\n${'-' * 20} ${message} ${'-' * 20}\n${payload}")
            }
    }

    ProcessorDefinition.metaClass.output = { String message  ->
            return delegate.process {
                //def payload = c ? c(it.in.body) : it.in.body
                LOG.debug("${'-' * 20} ${message} ${'-' * 20}")
            }
    }
  }
}
