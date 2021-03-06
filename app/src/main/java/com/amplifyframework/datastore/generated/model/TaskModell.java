package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the TaskModell type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "TaskModells")
public final class TaskModell implements Model {
  public static final QueryField ID = field("TaskModell", "id");
  public static final QueryField TITLE = field("TaskModell", "title");
  public static final QueryField BODY = field("TaskModell", "body");
  public static final QueryField STATE = field("TaskModell", "state");
  public static final QueryField LAT = field("TaskModell", "lat");
  public static final QueryField LON = field("TaskModell", "lon");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String title;
  private final @ModelField(targetType="String") String body;
  private final @ModelField(targetType="String") String state;
  private final @ModelField(targetType="Int") Integer lat;
  private final @ModelField(targetType="Int") Integer lon;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getTitle() {
      return title;
  }
  
  public String getBody() {
      return body;
  }
  
  public String getState() {
      return state;
  }
  
  public Integer getLat() {
      return lat;
  }
  
  public Integer getLon() {
      return lon;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private TaskModell(String id, String title, String body, String state, Integer lat, Integer lon) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.state = state;
    this.lat = lat;
    this.lon = lon;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      TaskModell taskModell = (TaskModell) obj;
      return ObjectsCompat.equals(getId(), taskModell.getId()) &&
              ObjectsCompat.equals(getTitle(), taskModell.getTitle()) &&
              ObjectsCompat.equals(getBody(), taskModell.getBody()) &&
              ObjectsCompat.equals(getState(), taskModell.getState()) &&
              ObjectsCompat.equals(getLat(), taskModell.getLat()) &&
              ObjectsCompat.equals(getLon(), taskModell.getLon()) &&
              ObjectsCompat.equals(getCreatedAt(), taskModell.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), taskModell.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getTitle())
      .append(getBody())
      .append(getState())
      .append(getLat())
      .append(getLon())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("TaskModell {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("title=" + String.valueOf(getTitle()) + ", ")
      .append("body=" + String.valueOf(getBody()) + ", ")
      .append("state=" + String.valueOf(getState()) + ", ")
      .append("lat=" + String.valueOf(getLat()) + ", ")
      .append("lon=" + String.valueOf(getLon()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static TitleStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static TaskModell justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new TaskModell(
      id,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      title,
      body,
      state,
      lat,
      lon);
  }
  public interface TitleStep {
    BuildStep title(String title);
  }
  

  public interface BuildStep {
    TaskModell build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep body(String body);
    BuildStep state(String state);
    BuildStep lat(Integer lat);
    BuildStep lon(Integer lon);
  }
  

  public static class Builder implements TitleStep, BuildStep {
    private String id;
    private String title;
    private String body;
    private String state;
    private Integer lat;
    private Integer lon;
    @Override
     public TaskModell build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new TaskModell(
          id,
          title,
          body,
          state,
          lat,
          lon);
    }
    
    @Override
     public BuildStep title(String title) {
        Objects.requireNonNull(title);
        this.title = title;
        return this;
    }
    
    @Override
     public BuildStep body(String body) {
        this.body = body;
        return this;
    }
    
    @Override
     public BuildStep state(String state) {
        this.state = state;
        return this;
    }
    
    @Override
     public BuildStep lat(Integer lat) {
        this.lat = lat;
        return this;
    }
    
    @Override
     public BuildStep lon(Integer lon) {
        this.lon = lon;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String title, String body, String state, Integer lat, Integer lon) {
      super.id(id);
      super.title(title)
        .body(body)
        .state(state)
        .lat(lat)
        .lon(lon);
    }
    
    @Override
     public CopyOfBuilder title(String title) {
      return (CopyOfBuilder) super.title(title);
    }
    
    @Override
     public CopyOfBuilder body(String body) {
      return (CopyOfBuilder) super.body(body);
    }
    
    @Override
     public CopyOfBuilder state(String state) {
      return (CopyOfBuilder) super.state(state);
    }
    
    @Override
     public CopyOfBuilder lat(Integer lat) {
      return (CopyOfBuilder) super.lat(lat);
    }
    
    @Override
     public CopyOfBuilder lon(Integer lon) {
      return (CopyOfBuilder) super.lon(lon);
    }
  }
  
}
