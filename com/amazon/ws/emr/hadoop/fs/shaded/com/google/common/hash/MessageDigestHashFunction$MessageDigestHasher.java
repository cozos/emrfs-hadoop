package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.security.MessageDigest;
import java.util.Arrays;

final class MessageDigestHashFunction$MessageDigestHasher
  extends AbstractByteHasher
{
  private final MessageDigest digest;
  private final int bytes;
  private boolean done;
  
  private MessageDigestHashFunction$MessageDigestHasher(MessageDigest digest, int bytes)
  {
    this.digest = digest;
    this.bytes = bytes;
  }
  
  protected void update(byte b)
  {
    checkNotDone();
    digest.update(b);
  }
  
  protected void update(byte[] b)
  {
    checkNotDone();
    digest.update(b);
  }
  
  protected void update(byte[] b, int off, int len)
  {
    checkNotDone();
    digest.update(b, off, len);
  }
  
  private void checkNotDone()
  {
    Preconditions.checkState(!done, "Cannot re-use a Hasher after calling hash() on it");
  }
  
  public HashCode hash()
  {
    checkNotDone();
    done = true;
    return bytes == digest.getDigestLength() ? HashCode.fromBytesNoCopy(digest.digest()) : HashCode.fromBytesNoCopy(Arrays.copyOf(digest.digest(), bytes));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.MessageDigestHashFunction.MessageDigestHasher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */