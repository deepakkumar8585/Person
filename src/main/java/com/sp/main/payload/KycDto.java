package com.sp.main.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KycDto {

    private long id;
    private String panNumber;
    private String mobile;
}
