package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;

@Deprecated
public class JsonSchema
{
  private final ObjectNode schema;
  
  @JsonCreator
  public JsonSchema(ObjectNode schema)
  {
    this.schema = schema;
  }
  
  @JsonValue
  public ObjectNode getSchemaNode()
  {
    return schema;
  }
  
  public String toString()
  {
    return schema.toString();
  }
  
  public int hashCode()
  {
    return schema.hashCode();
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (!(o instanceof JsonSchema)) {
      return false;
    }
    JsonSchema other = (JsonSchema)o;
    if (schema == null) {
      return schema == null;
    }
    return schema.equals(schema);
  }
  
  public static JsonNode getDefaultSchemaNode()
  {
    ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
    objectNode.put("type", "any");
    
    return objectNode;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonschema.JsonSchema
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */