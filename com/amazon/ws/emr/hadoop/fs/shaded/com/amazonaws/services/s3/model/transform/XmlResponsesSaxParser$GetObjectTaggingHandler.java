package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$GetObjectTaggingHandler
  extends AbstractHandler
{
  private GetObjectTaggingResult getObjectTaggingResult;
  private List<Tag> tagSet;
  private String currentTagValue;
  private String currentTagKey;
  
  public GetObjectTaggingResult getResult()
  {
    return getObjectTaggingResult;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if ((in(new String[] { "Tagging" })) && 
      (name.equals("TagSet"))) {
      tagSet = new ArrayList();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if ((in(new String[] { "Tagging" })) && 
      (name.equals("TagSet")))
    {
      getObjectTaggingResult = new GetObjectTaggingResult(tagSet);
      tagSet = null;
    }
    if (in(new String[] { "Tagging", "TagSet" }))
    {
      if (name.equals("Tag"))
      {
        tagSet.add(new Tag(currentTagKey, currentTagValue));
        currentTagKey = null;
        currentTagValue = null;
      }
    }
    else if (in(new String[] { "Tagging", "TagSet", "Tag" })) {
      if (name.equals("Key")) {
        currentTagKey = getText();
      } else if (name.equals("Value")) {
        currentTagValue = getText();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.GetObjectTaggingHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */