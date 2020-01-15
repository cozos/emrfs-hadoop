package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DefaultRetention;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLockConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockRule;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$GetObjectLockConfigurationResponseHandler
  extends AbstractHandler
{
  private GetObjectLockConfigurationResult result = new GetObjectLockConfigurationResult();
  private ObjectLockConfiguration objectLockConfiguration = new ObjectLockConfiguration();
  private ObjectLockRule rule;
  private DefaultRetention defaultRetention;
  
  public GetObjectLockConfigurationResult getResult()
  {
    return result.withObjectLockConfiguration(objectLockConfiguration);
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "ObjectLockConfiguration" }))
    {
      if ("Rule".equals(name)) {
        rule = new ObjectLockRule();
      }
    }
    else if ((in(new String[] { "ObjectLockConfiguration", "Rule" })) && 
      ("DefaultRetention".equals(name))) {
      defaultRetention = new DefaultRetention();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "ObjectLockConfiguration" }))
    {
      if ("ObjectLockEnabled".equals(name)) {
        objectLockConfiguration.setObjectLockEnabled(getText());
      } else if ("Rule".equals(name)) {
        objectLockConfiguration.setRule(rule);
      }
    }
    else if (in(new String[] { "ObjectLockConfiguration", "Rule" }))
    {
      if ("DefaultRetention".equals(name)) {
        rule.setDefaultRetention(defaultRetention);
      }
    }
    else if (in(new String[] { "ObjectLockConfiguration", "Rule", "DefaultRetention" })) {
      if ("Mode".equals(name)) {
        defaultRetention.setMode(getText());
      } else if ("Days".equals(name)) {
        defaultRetention.setDays(Integer.valueOf(Integer.parseInt(getText())));
      } else if ("Years".equals(name)) {
        defaultRetention.setYears(Integer.valueOf(Integer.parseInt(getText())));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.GetObjectLockConfigurationResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */