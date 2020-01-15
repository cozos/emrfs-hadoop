package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkDigestInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;

public class DigestValidationInputStream
  extends SdkDigestInputStream
{
  private byte[] expectedHash;
  private boolean digestValidated = false;
  
  public DigestValidationInputStream(InputStream in, MessageDigest digest, byte[] serverSideHash)
  {
    super(in, digest);
    expectedHash = serverSideHash;
  }
  
  public int read()
    throws IOException
  {
    int ch = super.read();
    if (ch == -1) {
      validateMD5Digest();
    }
    return ch;
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    int result = super.read(b, off, len);
    if (result == -1) {
      validateMD5Digest();
    }
    return result;
  }
  
  public byte[] getMD5Checksum()
  {
    return digest.digest();
  }
  
  private void validateMD5Digest()
  {
    if ((expectedHash != null) && (!digestValidated))
    {
      digestValidated = true;
      if (!Arrays.equals(digest.digest(), expectedHash)) {
        throw new SdkClientException("Unable to verify integrity of data download.  Client calculated content hash didn't match hash calculated by Amazon S3.  The data may be corrupt.");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.DigestValidationInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */