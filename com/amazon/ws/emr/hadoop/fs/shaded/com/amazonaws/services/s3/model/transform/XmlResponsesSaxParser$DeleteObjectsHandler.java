package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsResult.DeletedObject;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultiObjectDeleteException.DeleteError;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$DeleteObjectsHandler
  extends AbstractHandler
{
  private final DeleteObjectsResponse response = new DeleteObjectsResponse();
  private DeleteObjectsResult.DeletedObject currentDeletedObject = null;
  private MultiObjectDeleteException.DeleteError currentError = null;
  
  public DeleteObjectsResponse getDeleteObjectResult()
  {
    return response;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "DeleteResult" })) {
      if (name.equals("Deleted")) {
        currentDeletedObject = new DeleteObjectsResult.DeletedObject();
      } else if (name.equals("Error")) {
        currentError = new MultiObjectDeleteException.DeleteError();
      }
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "DeleteResult" }))
    {
      if (name.equals("Deleted"))
      {
        response.getDeletedObjects().add(currentDeletedObject);
        currentDeletedObject = null;
      }
      else if (name.equals("Error"))
      {
        response.getErrors().add(currentError);
        currentError = null;
      }
    }
    else if (in(new String[] { "DeleteResult", "Deleted" }))
    {
      if (name.equals("Key")) {
        currentDeletedObject.setKey(getText());
      } else if (name.equals("VersionId")) {
        currentDeletedObject.setVersionId(getText());
      } else if (name.equals("DeleteMarker")) {
        currentDeletedObject.setDeleteMarker(
          getText().equals("true"));
      } else if (name.equals("DeleteMarkerVersionId")) {
        currentDeletedObject.setDeleteMarkerVersionId(getText());
      }
    }
    else if (in(new String[] { "DeleteResult", "Error" })) {
      if (name.equals("Key")) {
        currentError.setKey(getText());
      } else if (name.equals("VersionId")) {
        currentError.setVersionId(getText());
      } else if (name.equals("Code")) {
        currentError.setCode(getText());
      } else if (name.equals("Message")) {
        currentError.setMessage(getText());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.DeleteObjectsHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */