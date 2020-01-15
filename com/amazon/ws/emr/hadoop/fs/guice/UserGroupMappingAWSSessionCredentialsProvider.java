package com.amazon.ws.emr.hadoop.fs.guice;

import com.amazon.ws.emr.hadoop.fs.identity.HadoopFileSystemOwner;
import com.amazon.ws.emr.hadoop.fs.rolemapping.RoleMappings;
import com.amazon.ws.emr.hadoop.fs.util.AWSSessionCredentialsProviderFactory;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AWSSessionCredentialsProvider;
import java.io.IOException;
import java.util.Optional;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.hadoop.security.UserGroupInformation.AuthenticationMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserGroupMappingAWSSessionCredentialsProvider
  implements AWSSessionCredentialsProvider
{
  private static final Logger LOG = LoggerFactory.getLogger(UserGroupMappingAWSSessionCredentialsProvider.class);
  private final Optional<UserGroupInformation> ownerOptional;
  
  public UserGroupMappingAWSSessionCredentialsProvider()
  {
    UserGroupInformation currentUser = null;
    try
    {
      currentUser = UserGroupInformation.getCurrentUser();
    }
    catch (IOException localIOException) {}
    ownerOptional = Optional.ofNullable(currentUser);
  }
  
  public AWSSessionCredentials getCredentials()
  {
    if (!ownerOptional.isPresent()) {
      return null;
    }
    UserGroupInformation ugi = (UserGroupInformation)ownerOptional.get();
    LOG.debug("retrieving credentials for {}, short name {}", ugi, ugi.getShortUserName());
    if ((UserGroupInformation.isSecurityEnabled()) && 
      (ugi.getAuthenticationMethod() == UserGroupInformation.AuthenticationMethod.SIMPLE)) {
      return null;
    }
    AWSSessionCredentialsProvider sessionCredentialsProvider = AWSSessionCredentialsProviderFactory.getCredentialsProviderForRoleArn(
      RoleMappings.getRoleArnForFileSystemOwner(new HadoopFileSystemOwner(ugi)));
    if (sessionCredentialsProvider != null) {
      return sessionCredentialsProvider.getCredentials();
    }
    return null;
  }
  
  public void refresh() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.guice.UserGroupMappingAWSSessionCredentialsProvider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */