package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum CannedAccessControlList
{
  Private("private"),  PublicRead("public-read"),  PublicReadWrite("public-read-write"),  AuthenticatedRead("authenticated-read"),  LogDeliveryWrite("log-delivery-write"),  BucketOwnerRead("bucket-owner-read"),  BucketOwnerFullControl("bucket-owner-full-control"),  AwsExecRead("aws-exec-read");
  
  private final String cannedAclHeader;
  
  private CannedAccessControlList(String cannedAclHeader)
  {
    this.cannedAclHeader = cannedAclHeader;
  }
  
  public String toString()
  {
    return cannedAclHeader;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */