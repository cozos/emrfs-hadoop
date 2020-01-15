package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Bucket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.List;

public final class Unmarshallers$ListBucketsUnmarshaller
  implements Unmarshaller<List<Bucket>, InputStream>
{
  public List<Bucket> unmarshall(InputStream in)
    throws Exception
  {
    return 
      new XmlResponsesSaxParser().parseListMyBucketsResponse(in).getBuckets();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListBucketsUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */