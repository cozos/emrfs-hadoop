package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriterUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DefaultRetention;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockRule;

public final class ObjectLockConfigurationXmlFactory
{
  public byte[] convertToXmlByteArray(ObjectLockConfiguration config)
  {
    XmlWriter writer = new XmlWriter();
    writer.start("ObjectLockConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    XmlWriterUtils.addIfNotNull(writer, "ObjectLockEnabled", config.getObjectLockEnabled());
    addRuleIfNotNull(writer, config.getRule());
    writer.end();
    return writer.getBytes();
  }
  
  private static void addRuleIfNotNull(XmlWriter writer, ObjectLockRule rule)
  {
    if (rule == null) {
      return;
    }
    writer.start("Rule");
    writeDefaultRetention(writer, rule.getDefaultRetention());
    writer.end();
  }
  
  private static void writeDefaultRetention(XmlWriter writer, DefaultRetention retention)
  {
    if (retention == null) {
      return;
    }
    writer.start("DefaultRetention");
    XmlWriterUtils.addIfNotNull(writer, "Mode", retention.getMode());
    Integer days = retention.getDays();
    if (days != null) {
      writer.start("Days").value(Integer.toString(days.intValue())).end();
    }
    Integer years = retention.getYears();
    if (years != null) {
      writer.start("Years").value(Integer.toString(years.intValue())).end();
    }
    writer.end();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.ObjectLockConfigurationXmlFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */