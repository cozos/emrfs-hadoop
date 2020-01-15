package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$InitiateMultipartUploadResultUnmarshaller
  implements Unmarshaller<InitiateMultipartUploadResult, InputStream>
{
  public InitiateMultipartUploadResult unmarshall(InputStream in)
    throws Exception
  {
    return 
      new XmlResponsesSaxParser().parseInitiateMultipartUploadResponse(in).getInitiateMultipartUploadResult();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.InitiateMultipartUploadResultUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */