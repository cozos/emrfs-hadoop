package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$BucketVersioningConfigurationHandler
  extends AbstractHandler
{
  private final BucketVersioningConfiguration configuration = new BucketVersioningConfiguration();
  
  public BucketVersioningConfiguration getConfiguration()
  {
    return configuration;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "VersioningConfiguration" })) {
      if (name.equals("Status"))
      {
        configuration.setStatus(getText());
      }
      else if (name.equals("MfaDelete"))
      {
        String mfaDeleteStatus = getText();
        if (mfaDeleteStatus.equals("Disabled")) {
          configuration.setMfaDeleteEnabled(Boolean.valueOf(false));
        } else if (mfaDeleteStatus.equals("Enabled")) {
          configuration.setMfaDeleteEnabled(Boolean.valueOf(true));
        } else {
          configuration.setMfaDeleteEnabled(null);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.BucketVersioningConfigurationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */