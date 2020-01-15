package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$BucketAccelerateConfigurationHandler
  extends AbstractHandler
{
  private final BucketAccelerateConfiguration configuration = new BucketAccelerateConfiguration((String)null);
  
  public BucketAccelerateConfiguration getConfiguration()
  {
    return configuration;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if ((in(new String[] { "AccelerateConfiguration" })) && 
      (name.equals("Status"))) {
      configuration.setStatus(getText());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.BucketAccelerateConfigurationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */