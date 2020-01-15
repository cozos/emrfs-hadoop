package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
public abstract class AbstractRepeatableCipherInputStream<T>
  extends SdkFilterInputStream
{
  private final T cipherFactory;
  private final InputStream unencryptedDataStream;
  private boolean hasBeenAccessed;
  
  protected AbstractRepeatableCipherInputStream(InputStream input, FilterInputStream cipherInputStream, T cipherFactory)
  {
    super(cipherInputStream);
    unencryptedDataStream = input;
    this.cipherFactory = cipherFactory;
  }
  
  public boolean markSupported()
  {
    abortIfNeeded();
    return unencryptedDataStream.markSupported();
  }
  
  public void mark(int readlimit)
  {
    abortIfNeeded();
    if (hasBeenAccessed) {
      throw new UnsupportedOperationException("Marking is only supported before your first call to read or skip.");
    }
    unencryptedDataStream.mark(readlimit);
  }
  
  public void reset()
    throws IOException
  {
    abortIfNeeded();
    unencryptedDataStream.reset();
    in = createCipherInputStream(unencryptedDataStream, cipherFactory);
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
  
  protected abstract FilterInputStream createCipherInputStream(InputStream paramInputStream, T paramT);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.AbstractRepeatableCipherInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */