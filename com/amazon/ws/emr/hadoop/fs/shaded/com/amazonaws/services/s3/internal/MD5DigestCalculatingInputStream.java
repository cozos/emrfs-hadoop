package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5DigestCalculatingInputStream
  extends SdkFilterInputStream
{
  private static Log log = LogFactory.getLog(MD5DigestCalculatingInputStream.class);
  private MessageDigest digest;
  private boolean digestCanBeCloned;
  private MessageDigest digestLastMarked;
  
  public MD5DigestCalculatingInputStream(InputStream in)
  {
    super(in);
    resetDigest();
    if ((in.markSupported()) && (!digestCanBeCloned)) {
      log.debug("Mark-and-reset disabled on MD5 calculation because the digest implementation does not support cloning. This will limit the SDK's ability to retry requests that failed. Consider pre-calculating the MD5 checksum for the request or switching to a security provider that supports message digest cloning.");
    }
  }
  
  private void resetDigest()
  {
    try
    {
      digest = MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new IllegalStateException("No message digest support for MD5 was found.", e);
    }
    digestCanBeCloned = canBeCloned(digest);
  }
  
  private boolean canBeCloned(MessageDigest digest)
  {
    try
    {
      digest.clone();
      return true;
    }
    catch (CloneNotSupportedException e) {}
    return false;
  }
  
  private MessageDigest cloneFrom(MessageDigest from)
  {
    try
    {
      return (MessageDigest)from.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Message digest implementation does not support cloning.", e);
    }
  }
  
  public boolean markSupported()
  {
    return (super.markSupported()) && (digestCanBeCloned);
  }
  
  public byte[] getMd5Digest()
  {
    return digest.digest();
  }
  
  public void mark(int readlimit)
  {
    if (markSupported())
    {
      super.mark(readlimit);
      digestLastMarked = cloneFrom(digest);
    }
  }
  
  public void reset()
    throws IOException
  {
    if (markSupported())
    {
      super.reset();
      if (digestLastMarked == null) {
        resetDigest();
      } else {
        digest = cloneFrom(digestLastMarked);
      }
    }
    else
    {
      throw new IOException("mark/reset not supported");
    }
  }
  
  public int read()
    throws IOException
  {
    int ch = super.read();
    if (ch != -1) {
      digest.update((byte)ch);
    }
    return ch;
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    int result = super.read(b, off, len);
    if (result != -1) {
      digest.update(b, off, result);
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.MD5DigestCalculatingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */