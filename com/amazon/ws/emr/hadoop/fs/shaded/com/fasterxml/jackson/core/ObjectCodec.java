package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type.ResolvedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Iterator;

public abstract class ObjectCodec
  extends TreeCodec
  implements Versioned
{
  public Version version()
  {
    return Version.unknownVersion();
  }
  
  public abstract <T> T readValue(JsonParser paramJsonParser, Class<T> paramClass)
    throws IOException, JsonProcessingException;
  
  public abstract <T> T readValue(JsonParser paramJsonParser, TypeReference<?> paramTypeReference)
    throws IOException, JsonProcessingException;
  
  public abstract <T> T readValue(JsonParser paramJsonParser, ResolvedType paramResolvedType)
    throws IOException, JsonProcessingException;
  
  public abstract <T> Iterator<T> readValues(JsonParser paramJsonParser, Class<T> paramClass)
    throws IOException, JsonProcessingException;
  
  public abstract <T> Iterator<T> readValues(JsonParser paramJsonParser, TypeReference<?> paramTypeReference)
    throws IOException, JsonProcessingException;
  
  public abstract <T> Iterator<T> readValues(JsonParser paramJsonParser, ResolvedType paramResolvedType)
    throws IOException, JsonProcessingException;
  
  public abstract void writeValue(JsonGenerator paramJsonGenerator, Object paramObject)
    throws IOException, JsonProcessingException;
  
  public abstract <T extends TreeNode> T readTree(JsonParser paramJsonParser)
    throws IOException, JsonProcessingException;
  
  public abstract void writeTree(JsonGenerator paramJsonGenerator, TreeNode paramTreeNode)
    throws IOException, JsonProcessingException;
  
  public abstract TreeNode createObjectNode();
  
  public abstract TreeNode createArrayNode();
  
  public abstract JsonParser treeAsTokens(TreeNode paramTreeNode);
  
  public abstract <T> T treeToValue(TreeNode paramTreeNode, Class<T> paramClass)
    throws JsonProcessingException;
  
  @Deprecated
  public JsonFactory getJsonFactory()
  {
    return getFactory();
  }
  
  public JsonFactory getFactory()
  {
    return getJsonFactory();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */