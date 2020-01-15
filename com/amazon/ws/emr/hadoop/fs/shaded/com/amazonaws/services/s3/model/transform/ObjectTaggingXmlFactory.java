package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectTagging;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;

public class ObjectTaggingXmlFactory
{
  public byte[] convertToXmlByteArray(ObjectTagging tagging)
  {
    XmlWriter writer = new XmlWriter();
    writer.start("Tagging").start("TagSet");
    for (Tag tag : tagging.getTagSet())
    {
      writer.start("Tag");
      writer.start("Key").value(tag.getKey()).end();
      writer.start("Value").value(tag.getValue()).end();
      writer.end();
    }
    writer.end();
    writer.end();
    
    return writer.getBytes();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.ObjectTaggingXmlFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */