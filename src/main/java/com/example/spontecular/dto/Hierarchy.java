package com.example.spontecular.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Hierarchy implements Feature{
    private List<HierarchyItem> hierarchy = new ArrayList<>();

    @Override
    public Map<String, Object> getResponseMap() {

        //Only show non blacklisted items
        hierarchy = hierarchy.stream()
                .filter(item -> !item.isBlacklisted())
                .toList();

        return Map.of(
                "featureType", "hierarchy",
                "nextFeatureType", "relations",
                "itemList", getHierarchy()
        );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (HierarchyItem hierarchyItem : hierarchy) {
            sb.append(hierarchyItem.toString()).append(",\n");
        }
        return sb.toString();
    }
}
