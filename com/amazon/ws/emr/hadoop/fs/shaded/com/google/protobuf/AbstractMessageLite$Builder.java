package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public abstract class AbstractMessageLite$Builder<BuilderType extends Builder>
  implements MessageLite.Builder
{
  public abstract BuilderType clone();
  
  public BuilderType mergeFrom(CodedInputStream input)
    throws IOException
  {
    return mergeFrom(input, ExtensionRegistryLite.getEmptyRegistry());
  }
  
  public abstract BuilderType mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException;
  
  public BuilderType mergeFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    try
    {
      CodedInputStream input = data.newCodedInput();
      mergeFrom(input);
      input.checkLastTagWas(0);
      return this;
    }
    catch (InvalidProtocolBufferException e)
    {
      throw e;
    }
    catch (IOException e)
    {
      throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e);
    }
  }
  
  public BuilderType mergeFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    try
    {
      CodedInputStream input = data.newCodedInput();
      mergeFrom(input, extensionRegistry);
      input.checkLastTagWas(0);
      return this;
    }
    catch (InvalidProtocolBufferException e)
    {
      throw e;
    }
    catch (IOException e)
    {
      throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e);
    }
  }
  
  public BuilderType mergeFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return mergeFrom(data, 0, data.length);
  }
  
  public BuilderType mergeFrom(byte[] data, int off, int len)
    throws InvalidProtocolBufferException
  {
    try
    {
      CodedInputStream input = CodedInputStream.newInstance(data, off, len);
      
      mergeFrom(input);
      input.checkLastTagWas(0);
      return this;
    }
    catch (InvalidProtocolBufferException e)
    {
      throw e;
    }
    catch (IOException e)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
    }
  }
  
  public BuilderType mergeFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return mergeFrom(data, 0, data.length, extensionRegistry);
  }
  
  public BuilderType mergeFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    try
    {
      CodedInputStream input = CodedInputStream.newInstance(data, off, len);
      
      mergeFrom(input, extensionRegistry);
      input.checkLastTagWas(0);
      return this;
    }
    catch (InvalidProtocolBufferException e)
    {
      throw e;
    }
    catch (IOException e)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
    }
  }
  
  public BuilderType mergeFrom(InputStream input)
    throws IOException
  {
    CodedInputStream codedInput = CodedInputStream.newInstance(input);
    mergeFrom(codedInput);
    codedInput.checkLastTagWas(0);
    return this;
  }
  
  public BuilderType mergeFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    CodedInputStream codedInput = CodedInputStream.newInstance(input);
    mergeFrom(codedInput, extensionRegistry);
    codedInput.checkLastTagWas(0);
    return this;
  }
  
  static final class LimitedInputStream
    extends FilterInputStream
  {
    private int limit;
    
    LimitedInputStream(InputStream in, int limit)
    {
      super();
      this.limit = limit;
    }
    
    public int available()
      throws IOException
    {
      return Math.min(super.available(), limit);
    }
    
    public int read()
      throws IOException
    {
      if (limit <= 0) {
        return -1;
      }
      int result = super.read();
      if (result >= 0) {
        limit -= 1;
      }
      return result;
    }
    
    public int read(byte[] b, int off, int len)
      throws IOException
    {
      if (limit <= 0) {
        return -1;
      }
      len = Math.min(len, limit);
      int result = super.read(b, off, len);
      if (result >= 0) {
        limit -= result;
      }
      return result;
    }
    
    public long skip(long n)
      throws IOException
    {
      long result = super.skip(Math.min(n, limit));
      if (result >= 0L) {
        limit = ((int)(limit - result));
      }
      return result;
    }
  }
  
  public boolean mergeDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    int firstByte = input.read();
    if (firstByte == -1) {
      return false;
    }
    int size = CodedInputStream.readRawVarint32(firstByte, input);
    InputStream limitedInput = new LimitedInputStream(input, size);
    mergeFrom(limitedInput, extensionRegistry);
    return true;
  }
  
  public boolean mergeDelimitedFrom(InputStream input)
    throws IOException
  {
    return mergeDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());
  }
  
  protected static UninitializedMessageException newUninitializedMessageException(MessageLite message)
  {
    return new UninitializedMessageException(message);
  }
  
  protected static <T> void addAll(Iterable<T> values, Collection<? super T> list)
  {
    if ((values instanceof LazyStringList)) {
      checkForNullValues(((LazyStringList)values).getUnderlyingElements());
    } else {
      checkForNullValues(values);
    }
    if ((values instanceof Collection))
    {
      Collection<T> collection = (Collection)values;
      list.addAll(collection);
    }
    else
    {
      for (T value : values) {
        list.add(value);
      }
    }
  }
  
  private static void checkForNullValues(Iterable<?> values)
  {
    for (Object value : values) {
      if (value == null) {
        throw new NullPointerException();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.AbstractMessageLite.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */