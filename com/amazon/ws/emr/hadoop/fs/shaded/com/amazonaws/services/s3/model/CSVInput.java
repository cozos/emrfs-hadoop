package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class CSVInput
  implements Serializable, Cloneable
{
  private String fileHeaderInfo;
  private String comments;
  private String quoteEscapeCharacter;
  private String recordDelimiter;
  private String fieldDelimiter;
  private String quoteCharacter;
  private Boolean allowQuotedRecordDelimiter;
  
  public String getFileHeaderInfo()
  {
    return fileHeaderInfo;
  }
  
  public void setFileHeaderInfo(String fileHeaderInfo)
  {
    this.fileHeaderInfo = fileHeaderInfo;
  }
  
  public CSVInput withFileHeaderInfo(String fileHeaderInfo)
  {
    setFileHeaderInfo(fileHeaderInfo);
    return this;
  }
  
  public void setFileHeaderInfo(FileHeaderInfo fileHeaderInfo)
  {
    setFileHeaderInfo(fileHeaderInfo == null ? null : fileHeaderInfo.toString());
  }
  
  public CSVInput withFileHeaderInfo(FileHeaderInfo fileHeaderInfo)
  {
    setFileHeaderInfo(fileHeaderInfo);
    return this;
  }
  
  public Character getComments()
  {
    return stringToChar(comments);
  }
  
  public String getCommentsAsString()
  {
    return comments;
  }
  
  public void setComments(String comments)
  {
    validateNotEmpty(comments, "comments");
    this.comments = comments;
  }
  
  public CSVInput withComments(String comments)
  {
    setComments(comments);
    return this;
  }
  
  public void setComments(Character comments)
  {
    setComments(charToString(comments));
  }
  
  public CSVInput withComments(Character comments)
  {
    setComments(comments);
    return this;
  }
  
  public Character getQuoteEscapeCharacter()
  {
    return stringToChar(quoteEscapeCharacter);
  }
  
  public String getQuoteEscapeCharacterAsString()
  {
    return quoteEscapeCharacter;
  }
  
  public void setQuoteEscapeCharacter(String quoteEscapeCharacter)
  {
    validateNotEmpty(quoteEscapeCharacter, "quoteEscapeCharacter");
    this.quoteEscapeCharacter = quoteEscapeCharacter;
  }
  
  public CSVInput withQuoteEscapeCharacter(String quoteEscapeCharacter)
  {
    setQuoteEscapeCharacter(quoteEscapeCharacter);
    return this;
  }
  
  public void setQuoteEscapeCharacter(Character quoteEscapeCharacter)
  {
    setQuoteEscapeCharacter(charToString(quoteEscapeCharacter));
  }
  
  public CSVInput withQuoteEscapeCharacter(Character quoteEscapeCharacter)
  {
    setQuoteEscapeCharacter(quoteEscapeCharacter);
    return this;
  }
  
  public Character getRecordDelimiter()
  {
    return stringToChar(recordDelimiter);
  }
  
  public String getRecordDelimiterAsString()
  {
    return recordDelimiter;
  }
  
  public void setRecordDelimiter(String recordDelimiter)
  {
    validateNotEmpty(recordDelimiter, "recordDelimiter");
    this.recordDelimiter = recordDelimiter;
  }
  
  public CSVInput withRecordDelimiter(String recordDelimiter)
  {
    setRecordDelimiter(recordDelimiter);
    return this;
  }
  
  public void setRecordDelimiter(Character recordDelimiter)
  {
    setRecordDelimiter(charToString(recordDelimiter));
  }
  
  public CSVInput withRecordDelimiter(Character recordDelimiter)
  {
    setRecordDelimiter(recordDelimiter);
    return this;
  }
  
  public Character getFieldDelimiter()
  {
    return stringToChar(fieldDelimiter);
  }
  
  public String getFieldDelimiterAsString()
  {
    return fieldDelimiter;
  }
  
  public void setFieldDelimiter(String fieldDelimiter)
  {
    validateNotEmpty(fieldDelimiter, "fieldDelimiter");
    this.fieldDelimiter = fieldDelimiter;
  }
  
  public CSVInput withFieldDelimiter(String fieldDelimiter)
  {
    setFieldDelimiter(fieldDelimiter);
    return this;
  }
  
  public void setFieldDelimiter(Character fieldDelimiter)
  {
    setFieldDelimiter(charToString(fieldDelimiter));
  }
  
  public CSVInput withFieldDelimiter(Character fieldDelimiter)
  {
    setFieldDelimiter(fieldDelimiter);
    return this;
  }
  
  public Character getQuoteCharacter()
  {
    return stringToChar(quoteCharacter);
  }
  
  public String getQuoteCharacterAsString()
  {
    return quoteCharacter;
  }
  
  public void setQuoteCharacter(String quoteCharacter)
  {
    validateNotEmpty(quoteCharacter, "quoteCharacter");
    this.quoteCharacter = quoteCharacter;
  }
  
  public CSVInput withQuoteCharacter(String quoteCharacter)
  {
    setQuoteCharacter(quoteCharacter);
    return this;
  }
  
  public void setQuoteCharacter(Character quoteCharacter)
  {
    setQuoteCharacter(charToString(quoteCharacter));
  }
  
  public CSVInput withQuoteCharacter(Character quoteCharacter)
  {
    setQuoteCharacter(quoteCharacter);
    return this;
  }
  
  public Boolean getAllowQuotedRecordDelimiter()
  {
    return allowQuotedRecordDelimiter;
  }
  
  public void setAllowQuotedRecordDelimiter(Boolean allowQuotedRecordDelimiter)
  {
    this.allowQuotedRecordDelimiter = allowQuotedRecordDelimiter;
  }
  
  public CSVInput withAllowQuotedRecordDelimiter(Boolean allowQuotedRecordDelimiter)
  {
    setAllowQuotedRecordDelimiter(allowQuotedRecordDelimiter);
    return this;
  }
  
  private String charToString(Character character)
  {
    return character == null ? null : character.toString();
  }
  
  private Character stringToChar(String string)
  {
    return string == null ? null : Character.valueOf(string.charAt(0));
  }
  
  private void validateNotEmpty(String value, String valueName)
  {
    if ("".equals(value)) {
      throw new IllegalArgumentException(valueName + " must not be empty-string.");
    }
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (!(obj instanceof CSVInput))) {
      return false;
    }
    CSVInput other = (CSVInput)obj;
    if (((other.getFileHeaderInfo() == null ? 1 : 0) ^ (getFileHeaderInfo() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getFileHeaderInfo() != null) && (!other.getFileHeaderInfo().equals(getFileHeaderInfo()))) {
      return false;
    }
    if (((other.getQuoteEscapeCharacterAsString() == null ? 1 : 0) ^ (getQuoteEscapeCharacterAsString() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQuoteEscapeCharacterAsString() != null) && (!other.getQuoteEscapeCharacterAsString().equals(getQuoteEscapeCharacterAsString()))) {
      return false;
    }
    if (((other.getCommentsAsString() == null ? 1 : 0) ^ (getCommentsAsString() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCommentsAsString() != null) && (!other.getCommentsAsString().equals(getCommentsAsString()))) {
      return false;
    }
    if (((other.getRecordDelimiterAsString() == null ? 1 : 0) ^ (getRecordDelimiterAsString() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRecordDelimiterAsString() != null) && (!other.getRecordDelimiterAsString().equals(getRecordDelimiterAsString()))) {
      return false;
    }
    if (((other.getFieldDelimiterAsString() == null ? 1 : 0) ^ (getFieldDelimiterAsString() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getFieldDelimiterAsString() != null) && (!other.getFieldDelimiterAsString().equals(getFieldDelimiterAsString()))) {
      return false;
    }
    if (((other.getQuoteCharacterAsString() == null ? 1 : 0) ^ (getQuoteCharacterAsString() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQuoteCharacterAsString() != null) && (!other.getQuoteCharacterAsString().equals(getQuoteCharacterAsString()))) {
      return false;
    }
    if ((other.getAllowQuotedRecordDelimiter() != null) && (!other.getAllowQuotedRecordDelimiter().equals(getAllowQuotedRecordDelimiter()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getFileHeaderInfo() == null ? 0 : getFileHeaderInfo().hashCode());
    hashCode = 31 * hashCode + (getCommentsAsString() == null ? 0 : getCommentsAsString().hashCode());
    hashCode = 31 * hashCode + (getQuoteEscapeCharacterAsString() == null ? 0 : getQuoteEscapeCharacterAsString().hashCode());
    hashCode = 31 * hashCode + (getRecordDelimiterAsString() == null ? 0 : getRecordDelimiterAsString().hashCode());
    hashCode = 31 * hashCode + (getFieldDelimiterAsString() == null ? 0 : getFieldDelimiterAsString().hashCode());
    hashCode = 31 * hashCode + (getQuoteCharacterAsString() != null ? getQuoteCharacterAsString().hashCode() : 0);
    hashCode = 31 * hashCode + (getAllowQuotedRecordDelimiter() == null ? 0 : getAllowQuotedRecordDelimiter().hashCode());
    return hashCode;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getFileHeaderInfo() != null) {
      sb.append("FileHeaderInfo: ").append(getFileHeaderInfo()).append(",");
    }
    if (getCommentsAsString() != null) {
      sb.append("Comments: ").append(getCommentsAsString()).append(",");
    }
    if (getQuoteEscapeCharacterAsString() != null) {
      sb.append("QuoteEscapeCharacter: ").append(getQuoteEscapeCharacterAsString()).append(",");
    }
    if (getRecordDelimiterAsString() != null) {
      sb.append("RecordDelimiter: ").append(getRecordDelimiterAsString()).append(",");
    }
    if (getFieldDelimiterAsString() != null) {
      sb.append("FieldDelimiter: ").append(getFieldDelimiterAsString()).append(",");
    }
    if (getQuoteCharacterAsString() != null) {
      sb.append("QuoteCharacter: ").append(getQuoteCharacterAsString());
    }
    if (getAllowQuotedRecordDelimiter() != null) {
      sb.append("AllowQuotedRecordDelimiter: ").append(getAllowQuotedRecordDelimiter());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public CSVInput clone()
  {
    try
    {
      return (CSVInput)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CSVInput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */