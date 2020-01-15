package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkThreadLocalsRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

public class UploadPartCallable
  implements Callable<PartETag>
{
  private static final int MAX_SKIPS = 100;
  private static final ThreadLocal<MessageDigest> MD5_DIGEST = SdkThreadLocalsRegistry.register(new ThreadLocal()
  {
    protected MessageDigest initialValue()
    {
      try
      {
        return MessageDigest.getInstance("MD5");
      }
      catch (NoSuchAlgorithmException e)
      {
        throw new SdkClientException("Unable to get a digest instance for MD5!", e);
      }
    }
  });
  private final AmazonS3 s3;
  private final UploadPartRequest request;
  private final boolean calculateMd5;
  
  public UploadPartCallable(AmazonS3 s3, UploadPartRequest request)
  {
    this(s3, request, false);
  }
  
  public UploadPartCallable(AmazonS3 s3, UploadPartRequest request, boolean calculateMd5)
  {
    this.s3 = s3;
    this.request = request;
    this.calculateMd5 = calculateMd5;
  }
  
  public PartETag call()
    throws Exception
  {
    if (calculateMd5) {
      request.withMD5Digest(computedMd5());
    }
    PartETag partETag = s3.uploadPart(request).getPartETag();
    return partETag;
  }
  
  private String computedMd5()
  {
    FileInputStream fileStream = null;
    try
    {
      fileStream = new FileInputStream(request.getFile());
      skipBytes(fileStream, request.getFileOffset());
      return BinaryUtils.toBase64(computeMd5Bytes(fileStream, request.getPartSize()));
    }
    catch (IOException e)
    {
      throw new SdkClientException(e);
    }
    finally
    {
      if (fileStream != null) {
        try
        {
          fileStream.close();
        }
        catch (IOException localIOException2) {}
      }
    }
  }
  
  private static byte[] computeMd5Bytes(InputStream is, long remaining)
    throws IOException
  {
    byte[] readBuff = new byte['က'];
    MessageDigest digest = (MessageDigest)MD5_DIGEST.get();
    digest.reset();
    int read;
    while ((remaining > 0L) && ((read = is.read(readBuff)) != -1))
    {
      int updateLen = (int)Math.min(remaining, read);
      digest.update(readBuff, 0, updateLen);
      remaining -= updateLen;
    }
    return digest.digest();
  }
  
  private void skipBytes(FileInputStream fs, long n)
    throws IOException
  {
    long skippedSoFar = 0L;
    for (int skips = 0; (skips < 100) && (skippedSoFar < n); skips++) {
      skippedSoFar += fs.skip(n - skippedSoFar);
    }
    if (skippedSoFar != n) {
      throw new SdkClientException(String.format("Unable to skip to offset %d in file %s after %d attempts", new Object[] {
        Long.valueOf(n), request.getFile().getAbsolutePath(), Integer.valueOf(100) }));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.UploadPartCallable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */