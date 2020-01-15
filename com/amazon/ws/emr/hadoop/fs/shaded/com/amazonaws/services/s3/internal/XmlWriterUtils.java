package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

public final class XmlWriterUtils
{
  public static void addIfNotNull(XmlWriter writer, String tagName, String tagValue)
  {
    if (tagValue != null) {
      writer.start(tagName).value(tagValue).end();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriterUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */