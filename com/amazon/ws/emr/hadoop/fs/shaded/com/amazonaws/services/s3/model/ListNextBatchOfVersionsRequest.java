package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListNextBatchOfVersionsRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private VersionListing previousVersionListing;
  
  public ListNextBatchOfVersionsRequest(VersionListing previousVersionListing)
  {
    setPreviousVersionListing(previousVersionListing);
  }
  
  public VersionListing getPreviousVersionListing()
  {
    return previousVersionListing;
  }
  
  public void setPreviousVersionListing(VersionListing previousVersionListing)
  {
    if (previousVersionListing == null) {
      throw new IllegalArgumentException("The parameter previousVersionListing must be specified.");
    }
    this.previousVersionListing = previousVersionListing;
  }
  
  public ListNextBatchOfVersionsRequest withPreviousVersionListing(VersionListing previousVersionListing)
  {
    setPreviousVersionListing(previousVersionListing);
    return this;
  }
  
  public ListVersionsRequest toListVersionsRequest()
  {
    return 
    
      new ListVersionsRequest(previousVersionListing.getBucketName(), previousVersionListing.getPrefix(), previousVersionListing.getNextKeyMarker(), previousVersionListing.getNextVersionIdMarker(), previousVersionListing.getDelimiter(), Integer.valueOf(previousVersionListing.getMaxKeys())).withEncodingType(previousVersionListing.getEncodingType());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListNextBatchOfVersionsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */