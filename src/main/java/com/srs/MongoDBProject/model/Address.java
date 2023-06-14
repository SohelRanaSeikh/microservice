package com.srs.MongoDBProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Field("street_name")
    private  String streetName;

    @Field("city_name")

    private  String cityName;
    private  String state;

    @Field("org_name")
    private  String orgName;
    @Field("zip_code")
    private  int zipCode;
}
