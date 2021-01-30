package com.example.stackoverflowclone.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Questions {

    @SerializedName("questions")
    @Expose
    public List<Question> questions = null;

}

