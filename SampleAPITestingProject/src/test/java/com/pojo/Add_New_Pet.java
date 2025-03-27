package com.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Add_New_Pet {
    private String name;
    private String category;
    private int id;
}
