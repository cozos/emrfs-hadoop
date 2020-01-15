package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class AwsChunkedEncodingInputStream
  extends SdkInputStream
{
  protected static final String DEFAULT_ENCODING = "UTF-8";
  private static final int DEFAULT_CHUNK_SIZE = 131072;
  private static final int DEFAULT_BUFFER_SIZE = 262144;
  private static final String CRLF = "\r\n";
  private static final String CHUNK_STRING_TO_SIGN_PREFIX = "AWS4-HMAC-SHA256-PAYLOAD";
  private static final String CHUNK_SIGNATURE_HEADER = ";chunk-signature=";
  private static final int SIGNATURE_LENGTH = 64;
  private static final byte[] FINAL_CHUNK = new byte[0];
  private InputStream is = null;
  private final int maxBufferSize;
  private final String dateTime;
  private final String keyPath;
  private final String headerSignature;
  private String priorChunkSignature;
  private final AWS4Signer aws4Signer;
  private final MessageDigest sha256;
  private final Mac hmacSha256;
  private ChunkContentIterator currentChunkIterator;
  private DecodedStreamBuffer decodedStreamBuffer;
  private boolean isAtStart = true;
  private boolean isTerminating = false;
  private static final Log log = LogFactory.getLog(AwsChunkedEncodingInputStream.class);
  
  public AwsChunkedEncodingInputStream(InputStream in, byte[] kSigning, String datetime, String keyPath, String headerSignature, AWS4Signer aws4Signer)
  {
    this(in, 262144, kSigning, datetime, keyPath, headerSignature, aws4Signer);
  }
  
  public AwsChunkedEncodingInputStream(InputStream in, int maxBufferSize, byte[] kSigning, String datetime, String keyPath, String headerSignature, AWS4Signer aws4Signer)
  {
    if ((in instanceof AwsChunkedEncodingInputStream))
    {
      AwsChunkedEncodingInputStream originalChunkedStream = (AwsChunkedEncodingInputStream)in;
      maxBufferSize = Math.max(maxBufferSize, maxBufferSize);
      is = is;
      decodedStreamBuffer = decodedStreamBuffer;
    }
    else
    {
      is = in;
      decodedStreamBuffer = null;
    }
    if (maxBufferSize < 131072) {
      throw new IllegalArgumentException("Max buffer size should not be less than chunk size");
    }
    try
    {
      sha256 = MessageDigest.getInstance("SHA-256");
      String signingAlgo = SigningAlgorithm.HmacSHA256.toString();
      hmacSha256 = Mac.getInstance(signingAlgo);
      hmacSha256.init(new SecretKeySpec(kSigning, signingAlgo));
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new IllegalStateException(e);
    }
    catch (InvalidKeyException e)
    {
      throw new IllegalArgumentException(e);
    }
    this.maxBufferSize = maxBufferSize;
    dateTime = datetime;
    this.keyPath = keyPath;
    this.headerSignature = headerSignature;
    priorChunkSignature = headerSignature;
    this.aws4Signer = aws4Signer;
  }
  
  public int read()
    throws IOException
  {
    byte[] tmp = new byte[1];
    int count = read(tmp, 0, 1);
    if (count != -1)
    {
      if (log.isDebugEnabled()) {
        log.debug("One byte read from the stream.");
      }
      int unsignedByte = tmp[0] & 0xFF;
      return unsignedByte;
    }
    return count;
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    abortIfNeeded();
    if (b == null) {
      throw new NullPointerException();
    }
    if ((off < 0) || (len < 0) || (len > b.length - off)) {
      throw new IndexOutOfBoundsException();
    }
    if (len == 0) {
      return 0;
    }
    if ((null == currentChunkIterator) || 
      (!currentChunkIterator.hasNext()))
    {
      if (isTerminating) {
        return -1;
      }
      isTerminating = setUpNextChunk();
    }
    int count = currentChunkIterator.read(b, off, len);
    if (count > 0)
    {
      isAtStart = false;
      if (log.isTraceEnabled()) {
        log.trace(count + " byte read from the stream.");
      }
    }
    return count;
  }
  
  public long skip(long n)
    throws IOException
  {
    if (n <= 0L) {
      return 0L;
    }
    long remaining = n;
    int toskip = (int)Math.min(262144L, n);
    byte[] temp = new byte[toskip];
    while (remaining > 0L)
    {
      int count;
      if ((count = read(temp, 0, toskip)) < 0) {
        break;
      }
      remaining -= count;
    }
    return n - remaining;
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public void mark(int readlimit)
  {
    abortIfNeeded();
    if (!isAtStart) {
      throw new UnsupportedOperationException("Chunk-encoded stream only supports mark() at the start of the stream.");
    }
    if (is.markSupported())
    {
      if (log.isDebugEnabled()) {
        log.debug("AwsChunkedEncodingInputStream marked at the start of the stream (will directly mark the wrapped stream since it's mark-supported).");
      }
      is.mark(readlimit);
    }
    else
    {
      if (log.isDebugEnabled()) {
        log.debug("AwsChunkedEncodingInputStream marked at the start of the stream (initializing the buffer since the wrapped stream is not mark-supported).");
      }
      decodedStreamBuffer = new DecodedStreamBuffer(maxBufferSize);
    }
  }
  
  public void reset()
    throws IOException
  {
    abortIfNeeded();
    
    currentChunkIterator = null;
    priorChunkSignature = headerSignature;
    if (is.markSupported())
    {
      if (log.isDebugEnabled()) {
        log.debug("AwsChunkedEncodingInputStream reset (will reset the wrapped stream because it is mark-supported).");
      }
      is.reset();
    }
    else
    {
      if (log.isDebugEnabled()) {
        log.debug("AwsChunkedEncodingInputStream reset (will use the buffer of the decoded stream).");
      }
      if (null == decodedStreamBuffer) {
        throw new IOException("Cannot reset the stream because the mark is not set.");
      }
      decodedStreamBuffer.startReadBuffer();
    }
    currentChunkIterator = null;
    isAtStart = true;
    isTerminating = false;
  }
  
  public static long calculateStreamContentLength(long originalLength)
  {
    if (originalLength < 0L) {
      throw new IllegalArgumentException("Nonnegative content length expected.");
    }
    long maxSizeChunks = originalLength / 131072L;
    long remainingBytes = originalLength % 131072L;
    return maxSizeChunks * calculateSignedChunkLength(131072L) + (remainingBytes > 0L ? 
      calculateSignedChunkLength(remainingBytes) : 0L) + 
      calculateSignedChunkLength(0L);
  }
  
  private static long calculateSignedChunkLength(long chunkDataSize)
  {
    return 
    
      Long.toHexString(chunkDataSize).length() + ";chunk-signature=".length() + 64 + "\r\n".length() + chunkDataSize + "\r\n".length();
  }
  
  private boolean setUpNextChunk()
    throws IOException
  {
    byte[] chunkData = new byte[131072];
    int chunkSizeInBytes = 0;
    while (chunkSizeInBytes < 131072) {
      if ((null != decodedStreamBuffer) && 
        (decodedStreamBuffer.hasNext()))
      {
        chunkData[(chunkSizeInBytes++)] = decodedStreamBuffer.next();
      }
      else
      {
        int bytesToRead = 131072 - chunkSizeInBytes;
        int count = is.read(chunkData, chunkSizeInBytes, bytesToRead);
        if (count == -1) {
          break;
        }
        if (null != decodedStreamBuffer) {
          decodedStreamBuffer.buffer(chunkData, chunkSizeInBytes, count);
        }
        chunkSizeInBytes += count;
      }
    }
    if (chunkSizeInBytes == 0)
    {
      byte[] signedFinalChunk = createSignedChunk(FINAL_CHUNK);
      currentChunkIterator = new ChunkContentIterator(signedFinalChunk);
      return true;
    }
    if (chunkSizeInBytes < chunkData.length) {
      chunkData = Arrays.copyOf(chunkData, chunkSizeInBytes);
    }
    byte[] signedChunkContent = createSignedChunk(chunkData);
    currentChunkIterator = new ChunkContentIterator(signedChunkContent);
    return false;
  }
  
  private byte[] createSignedChunk(byte[] chunkData)
  {
    StringBuilder chunkHeader = new StringBuilder();
    
    chunkHeader.append(Integer.toHexString(chunkData.length));
    
    String chunkStringToSign = "AWS4-HMAC-SHA256-PAYLOAD\n" + dateTime + "\n" + keyPath + "\n" + priorChunkSignature + "\n" + AbstractAWSSigner.EMPTY_STRING_SHA256_HEX + "\n" + BinaryUtils.toHex(sha256.digest(chunkData));
    
    String chunkSignature = BinaryUtils.toHex(aws4Signer.signWithMac(chunkStringToSign, hmacSha256));
    priorChunkSignature = chunkSignature;
    chunkHeader.append(";chunk-signature=")
      .append(chunkSignature)
      .append("\r\n");
    try
    {
      byte[] header = chunkHeader.toString().getBytes(StringUtils.UTF8);
      byte[] trailer = "\r\n".getBytes(StringUtils.UTF8);
      byte[] signedChunk = new byte[header.length + chunkData.length + trailer.length];
      System.arraycopy(header, 0, signedChunk, 0, header.length);
      System.arraycopy(chunkData, 0, signedChunk, header.length, chunkData.length);
      System.arraycopy(trailer, 0, signedChunk, header.length + chunkData.length, trailer.length);
      
      return signedChunk;
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to sign the chunked data. " + e.getMessage(), e);
    }
  }
  
  protected InputStream getWrappedInputStream()
  {
    return is;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AwsChunkedEncodingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */