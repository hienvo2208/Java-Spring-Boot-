package com.example.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserReq {
    @NotNull(message = "Full name is required")
    @NotEmpty(message = "Full name is required")
    @ApiModelProperty(
            example = "Hien Vo",
            notes = "Full name cannot be empty",
            required = true
    )
    @JsonProperty("full_name")
    private String name;


    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @ApiModelProperty(
            example = "hachiko3179@gmail.com",
            notes = "Email cannot be empty",
            required = true
    )
    private String email;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    @ApiModelProperty(
            example = "voduchien",
            notes = "password cannot be empty",
            required = true
    )
    private String password;


    @ApiModelProperty(
            example = "0858187868",
            notes = "Your phone numbers cannot be empty",
            required = true
    )
    private String phone;

//    @Valid
//    @URL(regexp="(https?:\\/\\/.*\\.(?:png|jpg))", message="Avatar must be an url image")
//    @ApiModelProperty(
//            example="https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png",
//            notes="Avatar must be an url image",
//            required=false
//    )
    private String avatar;
}
