package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$CompleteMultipartUploadResultUnmarshaller
  implements Unmarshaller<XmlResponsesSaxParser.CompleteMultipartUploadHandler, InputStream>
{
  public XmlResponsesSaxParser.CompleteMultipartUploadHandler unmarshall(InputStream in)
    throws Exception
  {
    return new XmlResponsesSaxParser().parseCompleteMultipartUploadResponse(in);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.CompleteMultipartUploadResultUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */