package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class GenerateRandomResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private ByteBuffer plaintext;
  
  public void setPlaintext(ByteBuffer plaintext)
  {
    this.plaintext = plaintext;
  }
  
  public ByteBuffer getPlaintext()
  {
    return plaintext;
  }
  
  public GenerateRandomResult withPlaintext(ByteBuffer plaintext)
  {
    setPlaintext(plaintext);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPlaintext() != null) {
      sb.append("Plaintext: ").append("***Sensitive Data Redacted***");
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof GenerateRandomResult)) {
      return false;
    }
    GenerateRandomResult other = (GenerateRandomResult)obj;
    if (((other.getPlaintext() == null ? 1 : 0) ^ (getPlaintext() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPlaintext() != null) && (!other.getPlaintext().equals(getPlaintext()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPlaintext() == null ? 0 : getPlaintext().hashCode());
    return hashCode;
  }
  
  public GenerateRandomResult clone()
  {
    try
    {
      return (GenerateRandomResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateRandomResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */