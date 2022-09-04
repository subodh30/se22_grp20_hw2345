package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CommandArgs {
    private String shortName;
    private String longName;
    private String description;
}
