package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class CipherLiteInputStream
  extends SdkFilterInputStream
{
  private static final int MAX_RETRY = 1000;
  private static final int DEFAULT_IN_BUFFER_SIZE = 512;
  private CipherLite cipherLite;
  private final boolean multipart;
  private final boolean lastMultiPart;
  private boolean eof;
  private byte[] bufin;
  private byte[] bufout;
  private int curr_pos;
  private int max_pos;
  
  public CipherLiteInputStream(InputStream is, CipherLite cipherLite)
  {
    this(is, cipherLite, 512, false, false);
  }
  
  public CipherLiteInputStream(InputStream is, CipherLite c, int buffsize)
  {
    this(is, c, buffsize, false, false);
  }
  
  public CipherLiteInputStream(InputStream is, CipherLite c, int buffsize, boolean multipart, boolean lastMultiPart)
  {
    super(is);
    if ((lastMultiPart) && (!multipart)) {
      throw new IllegalArgumentException("lastMultiPart can only be true if multipart is true");
    }
    this.multipart = multipart;
    this.lastMultiPart = lastMultiPart;
    cipherLite = c;
    if ((buffsize <= 0) || (buffsize % 512 != 0)) {
      throw new IllegalArgumentException("buffsize (" + buffsize + ") must be a positive multiple of " + 512);
    }
    bufin = new byte[buffsize];
  }
  
  protected CipherLiteInputStream(InputStream is)
  {
    this(is, CipherLite.Null, 512, false, false);
  }
  
  public int read()
    throws IOException
  {
    if (!readNextChunk()) {
      return -1;
    }
    return bufout[(curr_pos++)] & 0xFF;
  }
  
  public int read(byte[] b)
    throws IOException
  {
    return read(b, 0, b.length);
  }
  
  public int read(byte[] buf, int off, int target_len)
    throws IOException
  {
    if (!readNextChunk()) {
      return -1;
    }
    if (target_len <= 0) {
      return 0;
    }
    int len = max_pos - curr_pos;
    if (target_len < len) {
      len = target_len;
    }
    System.arraycopy(bufout, curr_pos, buf, off, len);
    curr_pos += len;
    return len;
  }
  
  private boolean readNextChunk()
    throws IOException
  {
    if (curr_pos >= max_pos)
    {
      if (eof) {
        return false;
      }
      int count = 0;
      int len;
      do
      {
        if (count > 1000) {
          throw new IOException("exceeded maximum number of attempts to read next chunk of data");
        }
        len = nextChunk();
        if (bufout == null) {
          count++;
        }
      } while (len == 0);
      if (len == -1) {
        return false;
      }
    }
    return true;
  }
  
  public long skip(long n)
    throws IOException
  {
    abortIfNeeded();
    int available = max_pos - curr_pos;
    if (n > available) {
      n = available;
    }
    if (n < 0L) {
      return 0L;
    }
    curr_pos = ((int)(curr_pos + n));
    return n;
  }
  
  public int available()
  {
    abortIfNeeded();
    return max_pos - curr_pos;
  }
  
  public void close()
    throws IOException
  {
    in.close();
    if ((!multipart) && 
      (!S3CryptoScheme.isAesGcm(cipherLite.getCipherAlgorithm()))) {
      try
      {
        cipherLite.doFinal();
      }
      catch (BadPaddingException localBadPaddingException) {}catch (IllegalBlockSizeException localIllegalBlockSizeException) {}
    }
    curr_pos = (max_pos = 0);
    abortIfNeeded();
  }
  
  public boolean markSupported()
  {
    abortIfNeeded();
    return (in.markSupported()) && (cipherLite.markSupported());
  }
  
  public void mark(int readlimit)
  {
    abortIfNeeded();
    in.mark(readlimit);
    cipherLite.mark();
  }
  
  public void reset()
    throws IOException
  {
    abortIfNeeded();
    in.reset();
    cipherLite.reset();
    resetInternal();
  }
  
  final void resetInternal()
  {
    curr_pos = (max_pos = 0);
    eof = false;
  }
  
  private int nextChunk()
    throws IOException
  {
    abortIfNeeded();
    if (eof) {
      return -1;
    }
    bufout = null;
    int len = in.read(bufin);
    if (len == -1)
    {
      eof = true;
      if ((!multipart) || (lastMultiPart)) {
        try
        {
          bufout = cipherLite.doFinal();
          if (bufout == null) {
            return -1;
          }
          curr_pos = 0;
          return max_pos = bufout.length;
        }
        catch (IllegalBlockSizeException localIllegalBlockSizeException) {}catch (BadPaddingException e)
        {
          if (S3CryptoScheme.isAesGcm(cipherLite.getCipherAlgorithm())) {
            throw new SecurityException(e);
          }
        }
      }
      return -1;
    }
    bufout = cipherLite.update(bufin, 0, len);
    curr_pos = 0;
    return max_pos = bufout == null ? 0 : bufout.length;
  }
  
  void renewCipherLite()
  {
    cipherLite = cipherLite.recreate();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.CipherLiteInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */