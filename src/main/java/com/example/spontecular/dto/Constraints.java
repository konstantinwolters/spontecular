package com.example.spontecular.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class Constraints implements Feature {
    List<ConstraintsItem> constraints = new ArrayList<>();

    @JsonIgnore
    @Override
    public Map<String, Object> getResponseMap() {

        //Only show non blacklisted items
        constraints = constraints.stream()
                .filter(item -> !item.isBlacklisted())
                .toList();

        return new HashMap<>() {{
            put("featureType", "constraints");
            put("nextFeatureType", "");
            put("itemList", getConstraints());
        }};
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ConstraintsItem constraintsItem : constraints) {
            sb.append(constraintsItem.toString()).append(",\n");
        }
        return sb.toString();
    }
}
