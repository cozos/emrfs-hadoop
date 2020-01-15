package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.CRC32MismatchException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;

public class Message
{
  private static final int TRAILING_CRC_LENGTH = 4;
  static final int MESSAGE_OVERHEAD = 16;
  private final Map<String, HeaderValue> headers;
  private final byte[] payload;
  
  public Message(Map<String, HeaderValue> headers, byte[] payload)
  {
    this.headers = headers;
    this.payload = ((byte[])payload.clone());
  }
  
  public Map<String, HeaderValue> getHeaders()
  {
    return headers;
  }
  
  public byte[] getPayload()
  {
    return (byte[])payload.clone();
  }
  
  public static Message decode(ByteBuffer buf)
  {
    Prelude prelude = Prelude.decode(buf);
    
    int totalLength = prelude.getTotalLength();
    validateMessageCrc(buf, totalLength);
    buf.position(buf.position() + 12);
    
    long headersLength = prelude.getHeadersLength();
    byte[] headerBytes = new byte[Utils.toIntExact(headersLength)];
    buf.get(headerBytes);
    Map<String, HeaderValue> headers = decodeHeaders(ByteBuffer.wrap(headerBytes));
    
    byte[] payload = new byte[Utils.toIntExact(totalLength - 16 - headersLength)];
    buf.get(payload);
    buf.getInt();
    
    return new Message(headers, payload);
  }
  
  private static void validateMessageCrc(ByteBuffer buf, int totalLength)
  {
    Checksum crc = new CRC32();
    
    Checksums.update(crc, (ByteBuffer)buf.duplicate().limit(buf.position() + totalLength - 4));
    long computedMessageCrc = crc.getValue();
    
    long wireMessageCrc = Utils.toUnsignedLong(buf.getInt(buf.position() + totalLength - 4));
    if (wireMessageCrc != computedMessageCrc) {
      throw new SdkClientException(new CRC32MismatchException(String.format("Message checksum failure: expected 0x%x, computed 0x%x", new Object[] {Long.valueOf(wireMessageCrc), Long.valueOf(computedMessageCrc) })));
    }
  }
  
  static Map<String, HeaderValue> decodeHeaders(ByteBuffer buf)
  {
    Map<String, HeaderValue> headers = new HashMap();
    while (buf.hasRemaining())
    {
      Header header = Header.decode(buf);
      headers.put(header.getName(), header.getValue());
    }
    return Collections.unmodifiableMap(headers);
  }
  
  public ByteBuffer toByteBuffer()
  {
    try
    {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      encode(baos);
      baos.close();
      return ByteBuffer.wrap(baos.toByteArray());
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public void encode(OutputStream os)
  {
    try
    {
      CheckedOutputStream checkedOutputStream = new CheckedOutputStream(os, new CRC32());
      encodeOrThrow(checkedOutputStream);
      long messageCrc = checkedOutputStream.getChecksum().getValue();
      os.write((int)(0xFF & messageCrc >> 24));
      os.write((int)(0xFF & messageCrc >> 16));
      os.write((int)(0xFF & messageCrc >> 8));
      os.write((int)(0xFF & messageCrc));
      
      os.flush();
    }
    catch (IOException ex)
    {
      throw new RuntimeException(ex);
    }
  }
  
  private void encodeOrThrow(OutputStream os)
    throws IOException
  {
    ByteArrayOutputStream headersAndPayload = new ByteArrayOutputStream();
    
    DataOutputStream dos = new DataOutputStream(headersAndPayload);
    for (Map.Entry<String, HeaderValue> entry : headers.entrySet()) {
      Header.encode(entry, dos);
    }
    dos.write(payload);
    dos.flush();
    
    int totalLength = 12 + headersAndPayload.size() + 4;
    
    byte[] preludeBytes = getPrelude(totalLength);
    Checksum crc = new CRC32();
    crc.update(preludeBytes, 0, preludeBytes.length);
    
    DataOutputStream dos = new DataOutputStream(os);
    dos.write(preludeBytes);
    long value = crc.getValue();
    int value1 = (int)value;
    dos.writeInt(value1);
    dos.flush();
    
    headersAndPayload.writeTo(os);
  }
  
  private byte[] getPrelude(int totalLength)
    throws IOException
  {
    ByteArrayOutputStream baos = new ByteArrayOutputStream(8);
    DataOutputStream dos = new DataOutputStream(baos);
    
    int headerLength = totalLength - 16 - payload.length;
    dos.writeInt(totalLength);
    dos.writeInt(headerLength);
    
    dos.close();
    return baos.toByteArray();
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    Message message = (Message)o;
    if (!headers.equals(headers)) {
      return false;
    }
    return Arrays.equals(payload, payload);
  }
  
  public int hashCode()
  {
    int result = headers.hashCode();
    result = 31 * result + Arrays.hashCode(payload);
    return result;
  }
  
  public String toString()
  {
    StringBuilder ret = new StringBuilder();
    for (Map.Entry<String, HeaderValue> entry : headers.entrySet())
    {
      ret.append((String)entry.getKey());
      ret.append(": ");
      ret.append(((HeaderValue)entry.getValue()).toString());
      ret.append('\n');
    }
    ret.append('\n');
    
    HeaderValue contentTypeHeader = (HeaderValue)headers.get("content-type");
    if (contentTypeHeader == null) {
      contentTypeHeader = HeaderValue.fromString("application/octet-stream");
    }
    String contentType = contentTypeHeader.getString();
    if ((contentType.contains("json")) || (contentType.contains("text"))) {
      ret.append(new String(payload, StringUtils.UTF8));
    } else {
      ret.append(Base64.encodeAsString(payload));
    }
    ret.append('\n');
    return ret.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.Message
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */