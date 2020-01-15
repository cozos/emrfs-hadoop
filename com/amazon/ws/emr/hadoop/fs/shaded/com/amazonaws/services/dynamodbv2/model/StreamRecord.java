package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.StreamRecordMarshaller;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StreamRecord
  implements Serializable, Cloneable, StructuredPojo
{
  private Date approximateCreationDateTime;
  private Map<String, AttributeValue> keys;
  private Map<String, AttributeValue> newImage;
  private Map<String, AttributeValue> oldImage;
  private String sequenceNumber;
  private Long sizeBytes;
  private String streamViewType;
  
  public void setApproximateCreationDateTime(Date approximateCreationDateTime)
  {
    this.approximateCreationDateTime = approximateCreationDateTime;
  }
  
  public Date getApproximateCreationDateTime()
  {
    return approximateCreationDateTime;
  }
  
  public StreamRecord withApproximateCreationDateTime(Date approximateCreationDateTime)
  {
    setApproximateCreationDateTime(approximateCreationDateTime);
    return this;
  }
  
  public Map<String, AttributeValue> getKeys()
  {
    return keys;
  }
  
  public void setKeys(Map<String, AttributeValue> keys)
  {
    this.keys = keys;
  }
  
  public StreamRecord withKeys(Map<String, AttributeValue> keys)
  {
    setKeys(keys);
    return this;
  }
  
  public StreamRecord addKeysEntry(String key, AttributeValue value)
  {
    if (null == keys) {
      keys = new HashMap();
    }
    if (keys.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    keys.put(key, value);
    return this;
  }
  
  public StreamRecord clearKeysEntries()
  {
    keys = null;
    return this;
  }
  
  public Map<String, AttributeValue> getNewImage()
  {
    return newImage;
  }
  
  public void setNewImage(Map<String, AttributeValue> newImage)
  {
    this.newImage = newImage;
  }
  
  public StreamRecord withNewImage(Map<String, AttributeValue> newImage)
  {
    setNewImage(newImage);
    return this;
  }
  
  public StreamRecord addNewImageEntry(String key, AttributeValue value)
  {
    if (null == newImage) {
      newImage = new HashMap();
    }
    if (newImage.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    newImage.put(key, value);
    return this;
  }
  
  public StreamRecord clearNewImageEntries()
  {
    newImage = null;
    return this;
  }
  
  public Map<String, AttributeValue> getOldImage()
  {
    return oldImage;
  }
  
  public void setOldImage(Map<String, AttributeValue> oldImage)
  {
    this.oldImage = oldImage;
  }
  
  public StreamRecord withOldImage(Map<String, AttributeValue> oldImage)
  {
    setOldImage(oldImage);
    return this;
  }
  
  public StreamRecord addOldImageEntry(String key, AttributeValue value)
  {
    if (null == oldImage) {
      oldImage = new HashMap();
    }
    if (oldImage.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    oldImage.put(key, value);
    return this;
  }
  
  public StreamRecord clearOldImageEntries()
  {
    oldImage = null;
    return this;
  }
  
  public void setSequenceNumber(String sequenceNumber)
  {
    this.sequenceNumber = sequenceNumber;
  }
  
  public String getSequenceNumber()
  {
    return sequenceNumber;
  }
  
  public StreamRecord withSequenceNumber(String sequenceNumber)
  {
    setSequenceNumber(sequenceNumber);
    return this;
  }
  
  public void setSizeBytes(Long sizeBytes)
  {
    this.sizeBytes = sizeBytes;
  }
  
  public Long getSizeBytes()
  {
    return sizeBytes;
  }
  
  public StreamRecord withSizeBytes(Long sizeBytes)
  {
    setSizeBytes(sizeBytes);
    return this;
  }
  
  public void setStreamViewType(String streamViewType)
  {
    this.streamViewType = streamViewType;
  }
  
  public String getStreamViewType()
  {
    return streamViewType;
  }
  
  public StreamRecord withStreamViewType(String streamViewType)
  {
    setStreamViewType(streamViewType);
    return this;
  }
  
  public void setStreamViewType(StreamViewType streamViewType)
  {
    withStreamViewType(streamViewType);
  }
  
  public StreamRecord withStreamViewType(StreamViewType streamViewType)
  {
    this.streamViewType = streamViewType.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getApproximateCreationDateTime() != null) {
      sb.append("ApproximateCreationDateTime: ").append(getApproximateCreationDateTime()).append(",");
    }
    if (getKeys() != null) {
      sb.append("Keys: ").append(getKeys()).append(",");
    }
    if (getNewImage() != null) {
      sb.append("NewImage: ").append(getNewImage()).append(",");
    }
    if (getOldImage() != null) {
      sb.append("OldImage: ").append(getOldImage()).append(",");
    }
    if (getSequenceNumber() != null) {
      sb.append("SequenceNumber: ").append(getSequenceNumber()).append(",");
    }
    if (getSizeBytes() != null) {
      sb.append("SizeBytes: ").append(getSizeBytes()).append(",");
    }
    if (getStreamViewType() != null) {
      sb.append("StreamViewType: ").append(getStreamViewType());
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
    if (!(obj instanceof StreamRecord)) {
      return false;
    }
    StreamRecord other = (StreamRecord)obj;
    if (((other.getApproximateCreationDateTime() == null ? 1 : 0) ^ (getApproximateCreationDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getApproximateCreationDateTime() != null) && (!other.getApproximateCreationDateTime().equals(getApproximateCreationDateTime()))) {
      return false;
    }
    if (((other.getKeys() == null ? 1 : 0) ^ (getKeys() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeys() != null) && (!other.getKeys().equals(getKeys()))) {
      return false;
    }
    if (((other.getNewImage() == null ? 1 : 0) ^ (getNewImage() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNewImage() != null) && (!other.getNewImage().equals(getNewImage()))) {
      return false;
    }
    if (((other.getOldImage() == null ? 1 : 0) ^ (getOldImage() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOldImage() != null) && (!other.getOldImage().equals(getOldImage()))) {
      return false;
    }
    if (((other.getSequenceNumber() == null ? 1 : 0) ^ (getSequenceNumber() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSequenceNumber() != null) && (!other.getSequenceNumber().equals(getSequenceNumber()))) {
      return false;
    }
    if (((other.getSizeBytes() == null ? 1 : 0) ^ (getSizeBytes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSizeBytes() != null) && (!other.getSizeBytes().equals(getSizeBytes()))) {
      return false;
    }
    if (((other.getStreamViewType() == null ? 1 : 0) ^ (getStreamViewType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStreamViewType() != null) && (!other.getStreamViewType().equals(getStreamViewType()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getApproximateCreationDateTime() == null ? 0 : getApproximateCreationDateTime().hashCode());
    hashCode = 31 * hashCode + (getKeys() == null ? 0 : getKeys().hashCode());
    hashCode = 31 * hashCode + (getNewImage() == null ? 0 : getNewImage().hashCode());
    hashCode = 31 * hashCode + (getOldImage() == null ? 0 : getOldImage().hashCode());
    hashCode = 31 * hashCode + (getSequenceNumber() == null ? 0 : getSequenceNumber().hashCode());
    hashCode = 31 * hashCode + (getSizeBytes() == null ? 0 : getSizeBytes().hashCode());
    hashCode = 31 * hashCode + (getStreamViewType() == null ? 0 : getStreamViewType().hashCode());
    return hashCode;
  }
  
  public StreamRecord clone()
  {
    try
    {
      return (StreamRecord)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    StreamRecordMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.StreamRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */