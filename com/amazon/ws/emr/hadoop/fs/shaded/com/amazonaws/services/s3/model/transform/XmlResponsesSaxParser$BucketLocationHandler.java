package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$BucketLocationHandler
  extends AbstractHandler
{
  private String location = null;
  
  public String getLocation()
  {
    return location;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs) {}
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if ((atTopLevel()) && 
      (name.equals("LocationConstraint")))
    {
      String elementText = getText();
      if (elementText.length() == 0) {
        location = null;
      } else {
        location = elementText;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.BucketLocationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */