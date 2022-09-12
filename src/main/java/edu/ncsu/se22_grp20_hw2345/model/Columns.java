package edu.ncsu.se22_grp20_hw2345.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class Columns {
    List<String> names;
    Map<String, String> allData;
    List<String> klass;
    Map<String, List<String>> X;
    Map<String, List<String>> Y;
}
