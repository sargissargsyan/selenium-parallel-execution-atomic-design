package com.sargissargsyan.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("slug")
    private String slug;

    @SerializedName("owner")
    private User owner;

    @SerializedName("members")
    private User[] members;

    @SerializedName("creation_template")
    private Integer creationTemplate;

    @SerializedName("is_private")
    private Boolean isPrivate;


}
