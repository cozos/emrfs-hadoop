package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.util.List;

public class GetObjectTaggingResult
{
  private String versionId;
  private List<Tag> tagSet;
  
  public GetObjectTaggingResult(List<Tag> tagSet)
  {
    this.tagSet = tagSet;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
  
  public GetObjectTaggingResult withVersionId(String versionId)
  {
    setVersionId(versionId);
    return this;
  }
  
  public List<Tag> getTagSet()
  {
    return tagSet;
  }
  
  public void setTagSet(List<Tag> tagSet)
  {
    this.tagSet = tagSet;
  }
  
  public GetObjectTaggingResult withTagSet(List<Tag> tagSet)
  {
    setTagSet(tagSet);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectTaggingResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */