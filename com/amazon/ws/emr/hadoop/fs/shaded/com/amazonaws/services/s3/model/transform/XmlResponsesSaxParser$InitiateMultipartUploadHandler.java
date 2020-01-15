package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$InitiateMultipartUploadHandler
  extends AbstractHandler
{
  private final InitiateMultipartUploadResult result = new InitiateMultipartUploadResult();
  
  public InitiateMultipartUploadResult getInitiateMultipartUploadResult()
  {
    return result;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "InitiateMultipartUploadResult" })) {
      if (name.equals("Bucket")) {
        result.setBucketName(getText());
      } else if (name.equals("Key")) {
        result.setKey(getText());
      } else if (name.equals("UploadId")) {
        result.setUploadId(getText());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.InitiateMultipartUploadHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */