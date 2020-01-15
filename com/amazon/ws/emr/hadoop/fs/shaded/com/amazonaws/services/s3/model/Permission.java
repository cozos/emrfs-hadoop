package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum Permission
{
  FullControl("FULL_CONTROL", "x-amz-grant-full-control"),  Read("READ", "x-amz-grant-read"),  Write("WRITE", "x-amz-grant-write"),  ReadAcp("READ_ACP", "x-amz-grant-read-acp"),  WriteAcp("WRITE_ACP", "x-amz-grant-write-acp");
  
  private String permissionString;
  private String headerName;
  
  private Permission(String permissionString, String headerName)
  {
    this.permissionString = permissionString;
    this.headerName = headerName;
  }
  
  public String getHeaderName()
  {
    return headerName;
  }
  
  public String toString()
  {
    return permissionString;
  }
  
  public static Permission parsePermission(String str)
  {
    for (Permission permission : ) {
      if (permissionString.equals(str)) {
        return permission;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Permission
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */