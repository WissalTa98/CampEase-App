package com.wissal.microproduct.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductFile {
    @Setter(AccessLevel.NONE)
    private int id;
    private  byte[] file;
}
