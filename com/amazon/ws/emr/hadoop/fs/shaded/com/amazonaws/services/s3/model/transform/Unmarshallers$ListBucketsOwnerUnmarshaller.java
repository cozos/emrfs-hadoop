package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$ListBucketsOwnerUnmarshaller
  implements Unmarshaller<Owner, InputStream>
{
  public Owner unmarshall(InputStream in)
    throws Exception
  {
    return 
      new XmlResponsesSaxParser().parseListMyBucketsResponse(in).getOwner();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListBucketsOwnerUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */