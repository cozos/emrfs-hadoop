package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum BucketNameUtils
{
  private static final int MIN_BUCKET_NAME_LENGTH = 3;
  private static final int MAX_BUCKET_NAME_LENGTH = 63;
  private static final Pattern ipAddressPattern = Pattern.compile("(\\d+\\.){3}\\d+");
  
  private BucketNameUtils() {}
  
  public static void validateBucketName(String bucketName)
  {
    isValidV2BucketName(bucketName, true);
  }
  
  public static boolean isValidV2BucketName(String bucketName)
  {
    return isValidV2BucketName(bucketName, false);
  }
  
  public static boolean isDNSBucketName(String bucketName)
  {
    return isValidV2BucketName(bucketName);
  }
  
  private static boolean isValidV2BucketName(String bucketName, boolean throwOnError)
  {
    if (bucketName == null) {
      return exception(throwOnError, "Bucket name cannot be null");
    }
    if ((bucketName.length() < 3) || 
      (bucketName.length() > 63)) {
      return exception(throwOnError, "Bucket name should be between 3 and 63 characters long");
    }
    if (ipAddressPattern.matcher(bucketName).matches()) {
      return exception(throwOnError, "Bucket name must not be formatted as an IP Address");
    }
    char previous = '\000';
    for (int i = 0; i < bucketName.length(); i++)
    {
      char next = bucketName.charAt(i);
      if ((next >= 'A') && (next <= 'Z')) {
        return exception(throwOnError, "Bucket name should not contain uppercase characters");
      }
      if ((next == ' ') || (next == '\t') || (next == '\r') || (next == '\n')) {
        return exception(throwOnError, "Bucket name should not contain white space");
      }
      if (next == '.')
      {
        if (previous == 0) {
          return exception(throwOnError, "Bucket name should not begin with a period");
        }
        if (previous == '.') {
          return exception(throwOnError, "Bucket name should not contain two adjacent periods");
        }
        if (previous == '-') {
          return exception(throwOnError, "Bucket name should not contain dashes next to periods");
        }
      }
      else if (next == '-')
      {
        if (previous == '.') {
          return exception(throwOnError, "Bucket name should not contain dashes next to periods");
        }
        if (previous == 0) {
          return exception(throwOnError, "Bucket name should not begin with a '-'");
        }
      }
      else if ((next < '0') || ((next > '9') && (next < 'a')) || (next > 'z'))
      {
        return exception(throwOnError, "Bucket name should not contain '" + next + "'");
      }
      previous = next;
    }
    if ((previous == '.') || (previous == '-')) {
      return exception(throwOnError, "Bucket name should not end with '-' or '.'");
    }
    return true;
  }
  
  private static boolean exception(boolean exception, String message)
  {
    if (exception) {
      throw new IllegalArgumentException(message);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.BucketNameUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */