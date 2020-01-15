package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriterUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockLegalHold;

public final class ObjectLockLegalHoldXmlFactory
{
  public byte[] convertToXmlByteArray(ObjectLockLegalHold legalHold)
  {
    XmlWriter writer = new XmlWriter();
    writer.start("LegalHold", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    XmlWriterUtils.addIfNotNull(writer, "Status", legalHold.getStatus());
    writer.end();
    return writer.getBytes();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.ObjectLockLegalHoldXmlFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */