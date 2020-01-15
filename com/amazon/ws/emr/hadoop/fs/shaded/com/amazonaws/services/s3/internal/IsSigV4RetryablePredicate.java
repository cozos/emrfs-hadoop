package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkPredicate;
import java.util.Arrays;
import java.util.List;

public class IsSigV4RetryablePredicate
  extends SdkPredicate<AmazonServiceException>
{
  private static final List<String> AUTH_ERROR_CODES = Arrays.asList(new String[] { "InvalidRequest", "InvalidArgument" });
  private static final List<String> AUTH_ERROR_MESSAGES = Arrays.asList(new String[] { "Please use AWS4-HMAC-SHA256.", "AWS KMS managed keys require AWS Signature Version 4." });
  
  public boolean test(AmazonServiceException ase)
  {
    if ((ase == null) || (ase.getErrorMessage() == null)) {
      return false;
    }
    if (AUTH_ERROR_CODES.contains(ase.getErrorCode())) {
      for (String possibleErrorMessage : AUTH_ERROR_MESSAGES) {
        if (ase.getErrorMessage().contains(possibleErrorMessage)) {
          return true;
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.IsSigV4RetryablePredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */