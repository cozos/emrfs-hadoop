package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListNextBatchOfObjectsRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private ObjectListing previousObjectListing;
  
  public ListNextBatchOfObjectsRequest(ObjectListing previousObjectListing)
  {
    setPreviousObjectListing(previousObjectListing);
  }
  
  public ObjectListing getPreviousObjectListing()
  {
    return previousObjectListing;
  }
  
  public void setPreviousObjectListing(ObjectListing previousObjectListing)
  {
    if (previousObjectListing == null) {
      throw new IllegalArgumentException("The parameter previousObjectListing must be specified.");
    }
    this.previousObjectListing = previousObjectListing;
  }
  
  public ListNextBatchOfObjectsRequest withPreviousObjectListing(ObjectListing previousObjectListing)
  {
    setPreviousObjectListing(previousObjectListing);
    return this;
  }
  
  public ListObjectsRequest toListObjectsRequest()
  {
    return 
    
      new ListObjectsRequest(previousObjectListing.getBucketName(), previousObjectListing.getPrefix(), previousObjectListing.getNextMarker(), previousObjectListing.getDelimiter(), Integer.valueOf(previousObjectListing.getMaxKeys())).withEncodingType(previousObjectListing.getEncodingType());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListNextBatchOfObjectsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */