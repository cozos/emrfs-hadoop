package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicy.RetryCondition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.IDPCommunicationErrorException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.InvalidIdentityTokenException;
import java.io.IOException;

class STSAssumeRoleWithWebIdentitySessionCredentialsProvider$StsRetryCondition
  implements RetryPolicy.RetryCondition
{
  public boolean shouldRetry(AmazonWebServiceRequest originalRequest, AmazonClientException exception, int retriesAttempted)
  {
    if ((exception.getCause() instanceof IOException)) {
      return true;
    }
    if ((exception.getCause() instanceof InvalidIdentityTokenException)) {
      return true;
    }
    if ((exception.getCause() instanceof IDPCommunicationErrorException)) {
      return true;
    }
    if ((exception instanceof AmazonServiceException))
    {
      AmazonServiceException ase = (AmazonServiceException)exception;
      if (RetryUtils.isRetryableServiceException(ase)) {
        return true;
      }
      if (RetryUtils.isThrottlingException(ase)) {
        return true;
      }
      if (RetryUtils.isClockSkewError(ase)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.STSAssumeRoleWithWebIdentitySessionCredentialsProvider.StsRetryCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */