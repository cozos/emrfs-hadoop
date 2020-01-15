package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestPaymentConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestPaymentConfiguration.Payer;

public class RequestPaymentConfigurationXmlFactory
{
  public byte[] convertToXmlByteArray(RequestPaymentConfiguration requestPaymentConfiguration)
  {
    XmlWriter xml = new XmlWriter();
    xml.start("RequestPaymentConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    
    RequestPaymentConfiguration.Payer payer = requestPaymentConfiguration.getPayer();
    if (payer != null)
    {
      XmlWriter payerDocumentElement = xml.start("Payer");
      payerDocumentElement.value(payer.toString());
      payerDocumentElement.end();
    }
    xml.end();
    return xml.getBytes();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.RequestPaymentConfigurationXmlFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */