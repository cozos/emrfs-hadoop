package com.amazon.ws.emr.hadoop.fs.identity;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import org.apache.hadoop.security.UserGroupInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HadoopFileSystemOwner
  implements FileSystemOwner
{
  private static final Logger LOG = LoggerFactory.getLogger(HadoopFileSystemOwner.class);
  private final UserGroupInformation underlyingUserGroupInformation;
  
  public HadoopFileSystemOwner(UserGroupInformation ugi)
  {
    Preconditions.checkNotNull(ugi);
    underlyingUserGroupInformation = ugi;
  }
  
  public String getFullUserName()
  {
    return underlyingUserGroupInformation.getUserName();
  }
  
  public String getShortUserName()
  {
    return underlyingUserGroupInformation.getShortUserName();
  }
  
  public String getGroup()
  {
    try
    {
      return underlyingUserGroupInformation.getPrimaryGroupName();
    }
    catch (IOException ioe)
    {
      LOG.warn("found no group information for {}, using {} as primary group", underlyingUserGroupInformation, 
        getFullUserName());
    }
    return getFullUserName();
  }
  
  public String[] getGroupNames()
  {
    return underlyingUserGroupInformation.getGroupNames();
  }
  
  public String toString()
  {
    return underlyingUserGroupInformation.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.identity.HadoopFileSystemOwner
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */