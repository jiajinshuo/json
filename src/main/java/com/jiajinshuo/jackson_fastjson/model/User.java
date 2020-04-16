package com.jiajinshuo.jackson_fastjson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiajinshuo
 * @create 2020-04-15 21:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String gender;
    private Integer age;
}
