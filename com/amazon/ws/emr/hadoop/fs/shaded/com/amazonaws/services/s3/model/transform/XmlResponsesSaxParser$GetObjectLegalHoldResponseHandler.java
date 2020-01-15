package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLegalHoldResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockLegalHold;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$GetObjectLegalHoldResponseHandler
  extends AbstractHandler
{
  private GetObjectLegalHoldResult getObjectLegalHoldResult = new GetObjectLegalHoldResult();
  private ObjectLockLegalHold legalHold = new ObjectLockLegalHold();
  
  public GetObjectLegalHoldResult getResult()
  {
    return getObjectLegalHoldResult.withLegalHold(legalHold);
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if ((in(new String[] { "LegalHold" })) && 
      ("Status".equals(name))) {
      legalHold.setStatus(getText());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.GetObjectLegalHoldResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */