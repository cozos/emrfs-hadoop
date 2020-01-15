package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import java.io.OutputStream;
import java.util.LinkedList;

public final class ByteArrayBuilder
  extends OutputStream
{
  public static final byte[] NO_BYTES = new byte[0];
  private static final int INITIAL_BLOCK_SIZE = 500;
  private static final int MAX_BLOCK_SIZE = 262144;
  static final int DEFAULT_BLOCK_ARRAY_SIZE = 40;
  private final BufferRecycler _bufferRecycler;
  private final LinkedList<byte[]> _pastBlocks = new LinkedList();
  private int _pastLen;
  private byte[] _currBlock;
  private int _currBlockPtr;
  
  public ByteArrayBuilder()
  {
    this(null);
  }
  
  public ByteArrayBuilder(BufferRecycler br)
  {
    this(br, 500);
  }
  
  public ByteArrayBuilder(int firstBlockSize)
  {
    this(null, firstBlockSize);
  }
  
  public ByteArrayBuilder(BufferRecycler br, int firstBlockSize)
  {
    _bufferRecycler = br;
    _currBlock = (br == null ? new byte[firstBlockSize] : br.allocByteBuffer(2));
  }
  
  public void reset()
  {
    _pastLen = 0;
    _currBlockPtr = 0;
    if (!_pastBlocks.isEmpty()) {
      _pastBlocks.clear();
    }
  }
  
  public void release()
  {
    reset();
    if ((_bufferRecycler != null) && (_currBlock != null))
    {
      _bufferRecycler.releaseByteBuffer(2, _currBlock);
      _currBlock = null;
    }
  }
  
  public void append(int i)
  {
    if (_currBlockPtr >= _currBlock.length) {
      _allocMore();
    }
    _currBlock[(_currBlockPtr++)] = ((byte)i);
  }
  
  public void appendTwoBytes(int b16)
  {
    if (_currBlockPtr + 1 < _currBlock.length)
    {
      _currBlock[(_currBlockPtr++)] = ((byte)(b16 >> 8));
      _currBlock[(_currBlockPtr++)] = ((byte)b16);
    }
    else
    {
      append(b16 >> 8);
      append(b16);
    }
  }
  
  public void appendThreeBytes(int b24)
  {
    if (_currBlockPtr + 2 < _currBlock.length)
    {
      _currBlock[(_currBlockPtr++)] = ((byte)(b24 >> 16));
      _currBlock[(_currBlockPtr++)] = ((byte)(b24 >> 8));
      _currBlock[(_currBlockPtr++)] = ((byte)b24);
    }
    else
    {
      append(b24 >> 16);
      append(b24 >> 8);
      append(b24);
    }
  }
  
  public byte[] toByteArray()
  {
    int totalLen = _pastLen + _currBlockPtr;
    if (totalLen == 0) {
      return NO_BYTES;
    }
    byte[] result = new byte[totalLen];
    int offset = 0;
    for (byte[] block : _pastBlocks)
    {
      int len = block.length;
      System.arraycopy(block, 0, result, offset, len);
      offset += len;
    }
    System.arraycopy(_currBlock, 0, result, offset, _currBlockPtr);
    offset += _currBlockPtr;
    if (offset != totalLen) {
      throw new RuntimeException("Internal error: total len assumed to be " + totalLen + ", copied " + offset + " bytes");
    }
    if (!_pastBlocks.isEmpty()) {
      reset();
    }
    return result;
  }
  
  public byte[] resetAndGetFirstSegment()
  {
    reset();
    return _currBlock;
  }
  
  public byte[] finishCurrentSegment()
  {
    _allocMore();
    return _currBlock;
  }
  
  public byte[] completeAndCoalesce(int lastBlockLength)
  {
    _currBlockPtr = lastBlockLength;
    return toByteArray();
  }
  
  public byte[] getCurrentSegment()
  {
    return _currBlock;
  }
  
  public void setCurrentSegmentLength(int len)
  {
    _currBlockPtr = len;
  }
  
  public int getCurrentSegmentLength()
  {
    return _currBlockPtr;
  }
  
  public void write(byte[] b)
  {
    write(b, 0, b.length);
  }
  
  public void write(byte[] b, int off, int len)
  {
    for (;;)
    {
      int max = _currBlock.length - _currBlockPtr;
      int toCopy = Math.min(max, len);
      if (toCopy > 0)
      {
        System.arraycopy(b, off, _currBlock, _currBlockPtr, toCopy);
        off += toCopy;
        _currBlockPtr += toCopy;
        len -= toCopy;
      }
      if (len <= 0) {
        break;
      }
      _allocMore();
    }
  }
  
  public void write(int b)
  {
    append(b);
  }
  
  public void close() {}
  
  public void flush() {}
  
  private void _allocMore()
  {
    _pastLen += _currBlock.length;
    
    int newSize = Math.max(_pastLen >> 1, 1000);
    if (newSize > 262144) {
      newSize = 262144;
    }
    _pastBlocks.add(_currBlock);
    _currBlock = new byte[newSize];
    _currBlockPtr = 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.ByteArrayBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */