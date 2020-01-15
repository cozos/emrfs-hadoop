package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum GroupGrantee
  implements Grantee
{
  AllUsers("http://acs.amazonaws.com/groups/global/AllUsers"),  AuthenticatedUsers("http://acs.amazonaws.com/groups/global/AuthenticatedUsers"),  LogDelivery("http://acs.amazonaws.com/groups/s3/LogDelivery");
  
  private String groupUri;
  
  public String getTypeIdentifier()
  {
    return "uri";
  }
  
  private GroupGrantee(String groupUri)
  {
    this.groupUri = groupUri;
  }
  
  public String getIdentifier()
  {
    return groupUri;
  }
  
  public void setIdentifier(String id)
  {
    throw new UnsupportedOperationException("Group grantees have preset identifiers that cannot be modified.");
  }
  
  public String toString()
  {
    return "GroupGrantee [" + groupUri + "]";
  }
  
  public static GroupGrantee parseGroupGrantee(String groupUri)
  {
    for (GroupGrantee grantee : ) {
      if (groupUri.equals(groupUri)) {
        return grantee;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GroupGrantee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */