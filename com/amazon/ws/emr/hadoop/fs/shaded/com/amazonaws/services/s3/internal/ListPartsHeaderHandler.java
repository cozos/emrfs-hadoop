package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartListing;
import java.util.Map;

public class ListPartsHeaderHandler
  implements HeaderHandler<PartListing>
{
  public void handle(PartListing result, HttpResponse response)
  {
    result.setAbortDate(ServiceUtils.parseRfc822Date((String)response.getHeaders().get("x-amz-abort-date")));
    result.setAbortRuleId((String)response.getHeaders().get("x-amz-abort-rule-id"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ListPartsHeaderHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */