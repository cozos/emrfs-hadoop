package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsRequest.KeyVersion;

public class MultiObjectDeleteXmlFactory
{
  public byte[] convertToXmlByteArray(DeleteObjectsRequest rq)
    throws SdkClientException
  {
    XmlWriter xml = new XmlWriter();
    xml.start("Delete");
    if (rq.getQuiet()) {
      xml.start("Quiet").value("true").end();
    }
    for (DeleteObjectsRequest.KeyVersion keyVersion : rq.getKeys()) {
      writeKeyVersion(xml, keyVersion);
    }
    xml.end();
    
    return xml.getBytes();
  }
  
  private void writeKeyVersion(XmlWriter xml, DeleteObjectsRequest.KeyVersion keyVersion)
  {
    xml.start("Object");
    xml.start("Key").value(keyVersion.getKey()).end();
    if (keyVersion.getVersion() != null) {
      xml.start("VersionId").value(keyVersion.getVersion()).end();
    }
    xml.end();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.MultiObjectDeleteXmlFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */