package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;

final class BucketConfigurationXmlFactoryFunctions
{
  static void addParameterIfNotNull(XmlWriter xml, String xmlTagName, String value)
  {
    if (value != null) {
      xml.start(xmlTagName).value(value).end();
    }
  }
  
  static void writePrefix(XmlWriter xml, String prefix)
  {
    addParameterIfNotNull(xml, "Prefix", prefix);
  }
  
  static void writeTag(XmlWriter xml, Tag tag)
  {
    if (tag == null) {
      return;
    }
    xml.start("Tag");
    xml.start("Key").value(tag.getKey()).end();
    xml.start("Value").value(tag.getValue()).end();
    xml.end();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.BucketConfigurationXmlFactoryFunctions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */