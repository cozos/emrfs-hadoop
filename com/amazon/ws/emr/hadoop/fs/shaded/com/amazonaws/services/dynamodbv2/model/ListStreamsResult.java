package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListStreamsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private List<Stream> streams;
  private String lastEvaluatedStreamArn;
  
  public List<Stream> getStreams()
  {
    return streams;
  }
  
  public void setStreams(Collection<Stream> streams)
  {
    if (streams == null)
    {
      this.streams = null;
      return;
    }
    this.streams = new ArrayList(streams);
  }
  
  public ListStreamsResult withStreams(Stream... streams)
  {
    if (this.streams == null) {
      setStreams(new ArrayList(streams.length));
    }
    for (Stream ele : streams) {
      this.streams.add(ele);
    }
    return this;
  }
  
  public ListStreamsResult withStreams(Collection<Stream> streams)
  {
    setStreams(streams);
    return this;
  }
  
  public void setLastEvaluatedStreamArn(String lastEvaluatedStreamArn)
  {
    this.lastEvaluatedStreamArn = lastEvaluatedStreamArn;
  }
  
  public String getLastEvaluatedStreamArn()
  {
    return lastEvaluatedStreamArn;
  }
  
  public ListStreamsResult withLastEvaluatedStreamArn(String lastEvaluatedStreamArn)
  {
    setLastEvaluatedStreamArn(lastEvaluatedStreamArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStreams() != null) {
      sb.append("Streams: ").append(getStreams()).append(",");
    }
    if (getLastEvaluatedStreamArn() != null) {
      sb.append("LastEvaluatedStreamArn: ").append(getLastEvaluatedStreamArn());
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
    if (!(obj instanceof ListStreamsResult)) {
      return false;
    }
    ListStreamsResult other = (ListStreamsResult)obj;
    if (((other.getStreams() == null ? 1 : 0) ^ (getStreams() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreams() != null) && (!other.getStreams().equals(getStreams()))) {
      return false;
    }
    if (((other.getLastEvaluatedStreamArn() == null ? 1 : 0) ^ (getLastEvaluatedStreamArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastEvaluatedStreamArn() != null) && (!other.getLastEvaluatedStreamArn().equals(getLastEvaluatedStreamArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStreams() == null ? 0 : getStreams().hashCode());
    hashCode = 31 * hashCode + (getLastEvaluatedStreamArn() == null ? 0 : getLastEvaluatedStreamArn().hashCode());
    return hashCode;
  }
  
  public ListStreamsResult clone()
  {
    try
    {
      return (ListStreamsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */