package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

class ChunkContentIterator
{
  private final byte[] signedChunk;
  private int pos;
  
  public ChunkContentIterator(byte[] signedChunk)
  {
    this.signedChunk = signedChunk;
  }
  
  public boolean hasNext()
  {
    return pos < signedChunk.length;
  }
  
  public int read(byte[] output, int offset, int length)
  {
    if (length == 0) {
      return 0;
    }
    if (!hasNext()) {
      return -1;
    }
    int remaingBytesNum = signedChunk.length - pos;
    int bytesToRead = Math.min(remaingBytesNum, length);
    System.arraycopy(signedChunk, pos, output, offset, bytesToRead);
    pos += bytesToRead;
    return bytesToRead;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ChunkContentIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */