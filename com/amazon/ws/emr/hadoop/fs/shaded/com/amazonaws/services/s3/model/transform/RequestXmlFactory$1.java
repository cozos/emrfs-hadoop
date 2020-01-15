package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import java.util.Comparator;

final class RequestXmlFactory$1
  implements Comparator<PartETag>
{
  public int compare(PartETag tag1, PartETag tag2)
  {
    if (tag1.getPartNumber() < tag2.getPartNumber()) {
      return -1;
    }
    if (tag1.getPartNumber() > tag2.getPartNumber()) {
      return 1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.RequestXmlFactory.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */