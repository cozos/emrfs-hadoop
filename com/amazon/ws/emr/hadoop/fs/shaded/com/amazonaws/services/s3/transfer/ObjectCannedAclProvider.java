package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList;
import java.io.File;

public abstract interface ObjectCannedAclProvider
{
  public abstract CannedAccessControlList provideObjectCannedAcl(File paramFile);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.ObjectCannedAclProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */