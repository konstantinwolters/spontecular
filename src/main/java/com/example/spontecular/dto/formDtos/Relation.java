package com.example.spontecular.dto.formDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Relation {
    private String subject;
    private String predicate;
    private String object;
    private int minCardinality;
    private int maxCardinality;
}
