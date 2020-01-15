package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import java.io.IOException;
import java.io.InputStream;

public final class RenewableCipherLiteInputStream
  extends CipherLiteInputStream
{
  private boolean hasBeenAccessed;
  
  public RenewableCipherLiteInputStream(InputStream is, CipherLite cipherLite)
  {
    super(is, cipherLite);
  }
  
  public RenewableCipherLiteInputStream(InputStream is, CipherLite c, int buffsize)
  {
    super(is, c, buffsize);
  }
  
  public RenewableCipherLiteInputStream(InputStream is, CipherLite c, int buffsize, boolean multipart, boolean lastMultiPart)
  {
    super(is, c, buffsize, multipart, lastMultiPart);
  }
  
  protected RenewableCipherLiteInputStream(InputStream is)
  {
    super(is);
  }
  
  public boolean markSupported()
  {
    abortIfNeeded();
    return in.markSupported();
  }
  
  public void mark(int readlimit)
  {
    abortIfNeeded();
    if (hasBeenAccessed) {
      throw new UnsupportedOperationException("Marking is only supported before your first call to read or skip.");
    }
    in.mark(readlimit);
  }
  
  public void reset()
    throws IOException
  {
    abortIfNeeded();
    in.reset();
    renewCipherLite();
    resetInternal();
    hasBeenAccessed = false;
  }
  
  public int read()
    throws IOException
  {
    hasBeenAccessed = true;
    return super.read();
  }
  
  public int read(byte[] b)
    throws IOException
  {
    hasBeenAccessed = true;
    return super.read(b);
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    hasBeenAccessed = true;
    return super.read(b, off, len);
  }
  
  public long skip(long n)
    throws IOException
  {
    hasBeenAccessed = true;
    return super.skip(n);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.RenewableCipherLiteInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */