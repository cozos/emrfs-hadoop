package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$BucketLoggingConfigurationHandler
  extends AbstractHandler
{
  private final BucketLoggingConfiguration bucketLoggingConfiguration = new BucketLoggingConfiguration();
  
  public BucketLoggingConfiguration getBucketLoggingConfiguration()
  {
    return bucketLoggingConfiguration;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "BucketLoggingStatus", "LoggingEnabled" })) {
      if (name.equals("TargetBucket")) {
        bucketLoggingConfiguration.setDestinationBucketName(getText());
      } else if (name.equals("TargetPrefix")) {
        bucketLoggingConfiguration.setLogFilePrefix(getText());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.BucketLoggingConfigurationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */