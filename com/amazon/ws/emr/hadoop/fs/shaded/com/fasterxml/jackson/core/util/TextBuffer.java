package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.NumberInput;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public final class TextBuffer
{
  static final char[] NO_CHARS = new char[0];
  static final int MIN_SEGMENT_LEN = 1000;
  static final int MAX_SEGMENT_LEN = 262144;
  private final BufferRecycler _allocator;
  private char[] _inputBuffer;
  private int _inputStart;
  private int _inputLen;
  private ArrayList<char[]> _segments;
  private boolean _hasSegments = false;
  private int _segmentSize;
  private char[] _currentSegment;
  private int _currentSize;
  private String _resultString;
  private char[] _resultArray;
  
  public TextBuffer(BufferRecycler allocator)
  {
    _allocator = allocator;
  }
  
  public void releaseBuffers()
  {
    if (_allocator == null)
    {
      resetWithEmpty();
    }
    else if (_currentSegment != null)
    {
      resetWithEmpty();
      
      char[] buf = _currentSegment;
      _currentSegment = null;
      _allocator.releaseCharBuffer(2, buf);
    }
  }
  
  public void resetWithEmpty()
  {
    _inputStart = -1;
    _currentSize = 0;
    _inputLen = 0;
    
    _inputBuffer = null;
    _resultString = null;
    _resultArray = null;
    if (_hasSegments) {
      clearSegments();
    }
  }
  
  public void resetWithShared(char[] buf, int start, int len)
  {
    _resultString = null;
    _resultArray = null;
    
    _inputBuffer = buf;
    _inputStart = start;
    _inputLen = len;
    if (_hasSegments) {
      clearSegments();
    }
  }
  
  public void resetWithCopy(char[] buf, int start, int len)
  {
    _inputBuffer = null;
    _inputStart = -1;
    _inputLen = 0;
    
    _resultString = null;
    _resultArray = null;
    if (_hasSegments) {
      clearSegments();
    } else if (_currentSegment == null) {
      _currentSegment = buf(len);
    }
    _currentSize = (_segmentSize = 0);
    append(buf, start, len);
  }
  
  public void resetWithString(String value)
  {
    _inputBuffer = null;
    _inputStart = -1;
    _inputLen = 0;
    
    _resultString = value;
    _resultArray = null;
    if (_hasSegments) {
      clearSegments();
    }
    _currentSize = 0;
  }
  
  private char[] buf(int needed)
  {
    if (_allocator != null) {
      return _allocator.allocCharBuffer(2, needed);
    }
    return new char[Math.max(needed, 1000)];
  }
  
  private void clearSegments()
  {
    _hasSegments = false;
    
    _segments.clear();
    _currentSize = (_segmentSize = 0);
  }
  
  public int size()
  {
    if (_inputStart >= 0) {
      return _inputLen;
    }
    if (_resultArray != null) {
      return _resultArray.length;
    }
    if (_resultString != null) {
      return _resultString.length();
    }
    return _segmentSize + _currentSize;
  }
  
  public int getTextOffset()
  {
    return _inputStart >= 0 ? _inputStart : 0;
  }
  
  public boolean hasTextAsCharacters()
  {
    if ((_inputStart >= 0) || (_resultArray != null)) {
      return true;
    }
    if (_resultString != null) {
      return false;
    }
    return true;
  }
  
  public char[] getTextBuffer()
  {
    if (_inputStart >= 0) {
      return _inputBuffer;
    }
    if (_resultArray != null) {
      return _resultArray;
    }
    if (_resultString != null) {
      return _resultArray = _resultString.toCharArray();
    }
    if (!_hasSegments) {
      return _currentSegment == null ? NO_CHARS : _currentSegment;
    }
    return contentsAsArray();
  }
  
  public String contentsAsString()
  {
    if (_resultString == null) {
      if (_resultArray != null)
      {
        _resultString = new String(_resultArray);
      }
      else if (_inputStart >= 0)
      {
        if (_inputLen < 1) {
          return _resultString = "";
        }
        _resultString = new String(_inputBuffer, _inputStart, _inputLen);
      }
      else
      {
        int segLen = _segmentSize;
        int currLen = _currentSize;
        if (segLen == 0)
        {
          _resultString = (currLen == 0 ? "" : new String(_currentSegment, 0, currLen));
        }
        else
        {
          StringBuilder sb = new StringBuilder(segLen + currLen);
          if (_segments != null)
          {
            int i = 0;
            for (int len = _segments.size(); i < len; i++)
            {
              char[] curr = (char[])_segments.get(i);
              sb.append(curr, 0, curr.length);
            }
          }
          sb.append(_currentSegment, 0, _currentSize);
          _resultString = sb.toString();
        }
      }
    }
    return _resultString;
  }
  
  public char[] contentsAsArray()
  {
    char[] result = _resultArray;
    if (result == null) {
      _resultArray = (result = resultArray());
    }
    return result;
  }
  
  public BigDecimal contentsAsDecimal()
    throws NumberFormatException
  {
    if (_resultArray != null) {
      return NumberInput.parseBigDecimal(_resultArray);
    }
    if ((_inputStart >= 0) && (_inputBuffer != null)) {
      return NumberInput.parseBigDecimal(_inputBuffer, _inputStart, _inputLen);
    }
    if ((_segmentSize == 0) && (_currentSegment != null)) {
      return NumberInput.parseBigDecimal(_currentSegment, 0, _currentSize);
    }
    return NumberInput.parseBigDecimal(contentsAsArray());
  }
  
  public double contentsAsDouble()
    throws NumberFormatException
  {
    return NumberInput.parseDouble(contentsAsString());
  }
  
  public void ensureNotShared()
  {
    if (_inputStart >= 0) {
      unshare(16);
    }
  }
  
  public void append(char c)
  {
    if (_inputStart >= 0) {
      unshare(16);
    }
    _resultString = null;
    _resultArray = null;
    
    char[] curr = _currentSegment;
    if (_currentSize >= curr.length)
    {
      expand(1);
      curr = _currentSegment;
    }
    curr[(_currentSize++)] = c;
  }
  
  public void append(char[] c, int start, int len)
  {
    if (_inputStart >= 0) {
      unshare(len);
    }
    _resultString = null;
    _resultArray = null;
    
    char[] curr = _currentSegment;
    int max = curr.length - _currentSize;
    if (max >= len)
    {
      System.arraycopy(c, start, curr, _currentSize, len);
      _currentSize += len;
      return;
    }
    if (max > 0)
    {
      System.arraycopy(c, start, curr, _currentSize, max);
      start += max;
      len -= max;
    }
    do
    {
      expand(len);
      int amount = Math.min(_currentSegment.length, len);
      System.arraycopy(c, start, _currentSegment, 0, amount);
      _currentSize += amount;
      start += amount;
      len -= amount;
    } while (len > 0);
  }
  
  public void append(String str, int offset, int len)
  {
    if (_inputStart >= 0) {
      unshare(len);
    }
    _resultString = null;
    _resultArray = null;
    
    char[] curr = _currentSegment;
    int max = curr.length - _currentSize;
    if (max >= len)
    {
      str.getChars(offset, offset + len, curr, _currentSize);
      _currentSize += len;
      return;
    }
    if (max > 0)
    {
      str.getChars(offset, offset + max, curr, _currentSize);
      len -= max;
      offset += max;
    }
    do
    {
      expand(len);
      int amount = Math.min(_currentSegment.length, len);
      str.getChars(offset, offset + amount, _currentSegment, 0);
      _currentSize += amount;
      offset += amount;
      len -= amount;
    } while (len > 0);
  }
  
  public char[] getCurrentSegment()
  {
    if (_inputStart >= 0)
    {
      unshare(1);
    }
    else
    {
      char[] curr = _currentSegment;
      if (curr == null) {
        _currentSegment = buf(0);
      } else if (_currentSize >= curr.length) {
        expand(1);
      }
    }
    return _currentSegment;
  }
  
  public char[] emptyAndGetCurrentSegment()
  {
    _inputStart = -1;
    _currentSize = 0;
    _inputLen = 0;
    
    _inputBuffer = null;
    _resultString = null;
    _resultArray = null;
    if (_hasSegments) {
      clearSegments();
    }
    char[] curr = _currentSegment;
    if (curr == null) {
      _currentSegment = (curr = buf(0));
    }
    return curr;
  }
  
  public int getCurrentSegmentSize()
  {
    return _currentSize;
  }
  
  public void setCurrentLength(int len)
  {
    _currentSize = len;
  }
  
  public String setCurrentAndReturn(int len)
  {
    _currentSize = len;
    if (_segmentSize > 0) {
      return contentsAsString();
    }
    int currLen = _currentSize;
    String str = currLen == 0 ? "" : new String(_currentSegment, 0, currLen);
    _resultString = str;
    return str;
  }
  
  public char[] finishCurrentSegment()
  {
    if (_segments == null) {
      _segments = new ArrayList();
    }
    _hasSegments = true;
    _segments.add(_currentSegment);
    int oldLen = _currentSegment.length;
    _segmentSize += oldLen;
    _currentSize = 0;
    
    int newLen = oldLen + (oldLen >> 1);
    if (newLen < 1000) {
      newLen = 1000;
    } else if (newLen > 262144) {
      newLen = 262144;
    }
    char[] curr = carr(newLen);
    _currentSegment = curr;
    return curr;
  }
  
  public char[] expandCurrentSegment()
  {
    char[] curr = _currentSegment;
    
    int len = curr.length;
    int newLen = len + (len >> 1);
    if (newLen > 262144) {
      newLen = len + (len >> 2);
    }
    return _currentSegment = Arrays.copyOf(curr, newLen);
  }
  
  public char[] expandCurrentSegment(int minSize)
  {
    char[] curr = _currentSegment;
    if (curr.length >= minSize) {
      return curr;
    }
    _currentSegment = (curr = Arrays.copyOf(curr, minSize));
    return curr;
  }
  
  public String toString()
  {
    return contentsAsString();
  }
  
  private void unshare(int needExtra)
  {
    int sharedLen = _inputLen;
    _inputLen = 0;
    char[] inputBuf = _inputBuffer;
    _inputBuffer = null;
    int start = _inputStart;
    _inputStart = -1;
    
    int needed = sharedLen + needExtra;
    if ((_currentSegment == null) || (needed > _currentSegment.length)) {
      _currentSegment = buf(needed);
    }
    if (sharedLen > 0) {
      System.arraycopy(inputBuf, start, _currentSegment, 0, sharedLen);
    }
    _segmentSize = 0;
    _currentSize = sharedLen;
  }
  
  private void expand(int minNewSegmentSize)
  {
    if (_segments == null) {
      _segments = new ArrayList();
    }
    char[] curr = _currentSegment;
    _hasSegments = true;
    _segments.add(curr);
    _segmentSize += curr.length;
    _currentSize = 0;
    int oldLen = curr.length;
    
    int newLen = oldLen + (oldLen >> 1);
    if (newLen < 1000) {
      newLen = 1000;
    } else if (newLen > 262144) {
      newLen = 262144;
    }
    _currentSegment = carr(newLen);
  }
  
  private char[] resultArray()
  {
    if (_resultString != null) {
      return _resultString.toCharArray();
    }
    if (_inputStart >= 0)
    {
      int len = _inputLen;
      if (len < 1) {
        return NO_CHARS;
      }
      int start = _inputStart;
      if (start == 0) {
        return Arrays.copyOf(_inputBuffer, len);
      }
      return Arrays.copyOfRange(_inputBuffer, start, start + len);
    }
    int size = size();
    if (size < 1) {
      return NO_CHARS;
    }
    int offset = 0;
    char[] result = carr(size);
    if (_segments != null)
    {
      int i = 0;
      for (int len = _segments.size(); i < len; i++)
      {
        char[] curr = (char[])_segments.get(i);
        int currLen = curr.length;
        System.arraycopy(curr, 0, result, offset, currLen);
        offset += currLen;
      }
    }
    System.arraycopy(_currentSegment, 0, result, offset, _currentSize);
    return result;
  }
  
  private char[] carr(int len)
  {
    return new char[len];
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.TextBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */