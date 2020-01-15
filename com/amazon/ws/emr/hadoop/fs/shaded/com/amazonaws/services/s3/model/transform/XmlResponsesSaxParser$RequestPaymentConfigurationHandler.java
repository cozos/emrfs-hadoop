package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestPaymentConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestPaymentConfiguration.Payer;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$RequestPaymentConfigurationHandler
  extends AbstractHandler
{
  private String payer = null;
  
  public RequestPaymentConfiguration getConfiguration()
  {
    return new RequestPaymentConfiguration(RequestPaymentConfiguration.Payer.valueOf(payer));
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if ((in(new String[] { "RequestPaymentConfiguration" })) && 
      (name.equals("Payer"))) {
      payer = getText();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.RequestPaymentConfigurationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */