package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.CredentialsEndpointProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.EC2CredentialsUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EC2MetadataUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

class InstanceProfileCredentialsProvider$InstanceMetadataCredentialsEndpointProvider
  extends CredentialsEndpointProvider
{
  public URI getCredentialsEndpoint()
    throws URISyntaxException, IOException
  {
    String host = EC2MetadataUtils.getHostAddressForEC2MetadataService();
    
    String securityCredentialsList = EC2CredentialsUtils.getInstance().readResource(new URI(host + "/latest/meta-data/iam/security-credentials/"));
    String[] securityCredentials = securityCredentialsList.trim().split("\n");
    if (securityCredentials.length == 0) {
      throw new SdkClientException("Unable to load credentials path");
    }
    return new URI(host + "/latest/meta-data/iam/security-credentials/" + securityCredentials[0]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.InstanceProfileCredentialsProvider.InstanceMetadataCredentialsEndpointProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */