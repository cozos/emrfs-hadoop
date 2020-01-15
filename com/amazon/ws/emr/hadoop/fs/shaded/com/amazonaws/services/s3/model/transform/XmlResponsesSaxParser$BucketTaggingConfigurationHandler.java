package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.TagSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$BucketTaggingConfigurationHandler
  extends AbstractHandler
{
  private final BucketTaggingConfiguration configuration = new BucketTaggingConfiguration();
  private Map<String, String> currentTagSet;
  private String currentTagKey;
  private String currentTagValue;
  
  public BucketTaggingConfiguration getConfiguration()
  {
    return configuration;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if ((in(new String[] { "Tagging" })) && 
      (name.equals("TagSet"))) {
      currentTagSet = new LinkedHashMap();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "Tagging" }))
    {
      if (name.equals("TagSet"))
      {
        configuration.getAllTagSets().add(new TagSet(currentTagSet));
        currentTagSet = null;
      }
    }
    else if (in(new String[] { "Tagging", "TagSet" }))
    {
      if (name.equals("Tag"))
      {
        if ((currentTagKey != null) && (currentTagValue != null)) {
          currentTagSet.put(currentTagKey, currentTagValue);
        }
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.BucketTaggingConfigurationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */