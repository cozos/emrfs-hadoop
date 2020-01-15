package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

final class ByteString$CodedBuilder
{
  private final CodedOutputStream output;
  private final byte[] buffer;
  
  private ByteString$CodedBuilder(int size)
  {
    buffer = new byte[size];
    output = CodedOutputStream.newInstance(buffer);
  }
  
  public ByteString build()
  {
    output.checkNoSpaceLeft();
    
    return new LiteralByteString(buffer);
  }
  
  public CodedOutputStream getCodedOutput()
  {
    return output;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ByteString.CodedBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */