package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRetentionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockRetention;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$GetObjectRetentionResponseHandler
  extends AbstractHandler
{
  private GetObjectRetentionResult result = new GetObjectRetentionResult();
  private ObjectLockRetention retention = new ObjectLockRetention();
  
  public GetObjectRetentionResult getResult()
  {
    return result.withRetention(retention);
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "Retention" })) {
      if ("Mode".equals(name)) {
        retention.setMode(getText());
      } else if ("RetainUntilDate".equals(name)) {
        retention.setRetainUntilDate(ServiceUtils.parseIso8601Date(getText()));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.GetObjectRetentionResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */