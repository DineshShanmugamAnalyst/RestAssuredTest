package com.inputpojo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;


@Data
@Builder(toBuilder = true)

public class AddNewPet {

    public int id;
    public String name;
    public CategoryOne categoryOne;
    public ArrayList<String> photoUrls;
    public ArrayList<TagOne> tags;
    public String status;

}





