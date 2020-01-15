package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class CSVOutput
  implements Serializable, Cloneable
{
  private String quoteFields;
  private String quoteEscapeCharacter;
  private String recordDelimiter;
  private String fieldDelimiter;
  private String quoteCharacter;
  
  public String getQuoteFields()
  {
    return quoteFields;
  }
  
  public void setQuoteFields(String quoteFields)
  {
    this.quoteFields = quoteFields;
  }
  
  public CSVOutput withQuoteFields(String quoteFields)
  {
    setQuoteFields(quoteFields);
    return this;
  }
  
  public void setQuoteFields(QuoteFields quoteFields)
  {
    setQuoteFields(quoteFields == null ? null : quoteFields.toString());
  }
  
  public CSVOutput withQuoteFields(QuoteFields quoteFields)
  {
    setQuoteFields(quoteFields);
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
  
  public CSVOutput withQuoteEscapeCharacter(String quoteEscapeCharacter)
  {
    setQuoteEscapeCharacter(quoteEscapeCharacter);
    return this;
  }
  
  public void setQuoteEscapeCharacter(Character quoteEscapeCharacter)
  {
    setQuoteEscapeCharacter(charToString(quoteEscapeCharacter));
  }
  
  public CSVOutput withQuoteEscapeCharacter(Character quoteEscapeCharacter)
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
  
  public CSVOutput withRecordDelimiter(String recordDelimiter)
  {
    setRecordDelimiter(recordDelimiter);
    return this;
  }
  
  public void setRecordDelimiter(Character recordDelimiter)
  {
    setRecordDelimiter(charToString(recordDelimiter));
  }
  
  public CSVOutput withRecordDelimiter(Character recordDelimiter)
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
  
  public CSVOutput withFieldDelimiter(String fieldDelimiter)
  {
    setFieldDelimiter(fieldDelimiter);
    return this;
  }
  
  public void setFieldDelimiter(Character fieldDelimiter)
  {
    setFieldDelimiter(charToString(fieldDelimiter));
  }
  
  public CSVOutput withFieldDelimiter(Character fieldDelimiter)
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
  
  public CSVOutput withQuoteCharacter(String quoteCharacter)
  {
    setQuoteCharacter(quoteCharacter);
    return this;
  }
  
  public void setQuoteCharacter(Character quoteCharacter)
  {
    setQuoteCharacter(charToString(quoteCharacter));
  }
  
  public CSVOutput withQuoteCharacter(Character quoteCharacter)
  {
    setQuoteCharacter(quoteCharacter);
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
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQuoteFields() != null) {
      sb.append("QuoteFields: ").append(getQuoteFields()).append(",");
    }
    if (getQuoteEscapeCharacter() != null) {
      sb.append("QuoteEscapeCharacter: ").append(getQuoteEscapeCharacterAsString()).append(",");
    }
    if (getRecordDelimiter() != null) {
      sb.append("RecordDelimiter: ").append(getRecordDelimiterAsString()).append(",");
    }
    if (getFieldDelimiter() != null) {
      sb.append("FieldDelimiter: ").append(getFieldDelimiterAsString()).append(",");
    }
    if (getQuoteCharacter() != null) {
      sb.append("QuoteCharacter: ").append(getQuoteCharacterAsString());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (!(obj instanceof CSVOutput))) {
      return false;
    }
    CSVOutput other = (CSVOutput)obj;
    if (((other.getQuoteEscapeCharacterAsString() == null ? 1 : 0) ^ (getQuoteEscapeCharacterAsString() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQuoteEscapeCharacterAsString() != null) && (!other.getQuoteEscapeCharacterAsString().equals(getQuoteEscapeCharacterAsString()))) {
      return false;
    }
    if (((other.getQuoteFields() == null ? 1 : 0) ^ (getQuoteFields() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQuoteFields() != null) && (!other.getQuoteFields().equals(getQuoteFields()))) {
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQuoteFields() == null ? 0 : getQuoteFields().hashCode());
    hashCode = 31 * hashCode + (getQuoteEscapeCharacterAsString() == null ? 0 : getQuoteEscapeCharacterAsString().hashCode());
    hashCode = 31 * hashCode + (getRecordDelimiterAsString() == null ? 0 : getRecordDelimiterAsString().hashCode());
    hashCode = 31 * hashCode + (getFieldDelimiterAsString() == null ? 0 : getFieldDelimiterAsString().hashCode());
    hashCode = 31 * hashCode + (getQuoteCharacterAsString() != null ? getQuoteCharacterAsString().hashCode() : 0);
    return hashCode;
  }
  
  public Object clone()
  {
    try
    {
      return super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CSVOutput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */