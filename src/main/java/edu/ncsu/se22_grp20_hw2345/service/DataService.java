package edu.ncsu.se22_grp20_hw2345.service;

import edu.ncsu.se22_grp20_hw2345.model.Columns;
import edu.ncsu.se22_grp20_hw2345.model.Data;
import edu.ncsu.se22_grp20_hw2345.model.Row;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataService {
    private CSVFileService fileService;

    public DataService(CSVFileService fileService) {
        this.fileService = fileService;
    }

    public void addData(String src) {
        Data data = new Data();
        List<Row> rows = fileService.getRows(src);
        for (Row row : rows) {
            add(row, data);
        }
    }

    public void add(Row row, Data data) {
        if (null == data.getColumns()) {
            data.setColumns(Columns.builder()
                    .names(row.getCells())
                    .build());
        }else{
            data.getRows().add(row);
        }
    }

    public void stats(Map<String, List<String>> columns, String functionName, int decimalPlaces) {
        if (functionName.equals("mid")) {
            for (Map.Entry entry : columns.entrySet()) {
                //column logic S,s
                //call mid
                //round upto decimal places
            }
        } else {
            for (Map.Entry entry : columns.entrySet()) {
                //column logic S,s
                //call div
                //round upto decimal places
            }

        }
    }
}
