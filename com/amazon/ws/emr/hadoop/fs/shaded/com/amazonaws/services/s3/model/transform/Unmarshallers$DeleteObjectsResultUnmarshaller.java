package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$DeleteObjectsResultUnmarshaller
  implements Unmarshaller<DeleteObjectsResponse, InputStream>
{
  public DeleteObjectsResponse unmarshall(InputStream in)
    throws Exception
  {
    return new XmlResponsesSaxParser().parseDeletedObjectsResult(in).getDeleteObjectResult();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.DeleteObjectsResultUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */