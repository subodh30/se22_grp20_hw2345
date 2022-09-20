package edu.ncsu.se22_grp20_hw2345.code;


import lombok.Data;

@Data
public abstract class ColumnData {

    public String columnName;
    public int columnIndex;

    public abstract Object mid(int decimalPlaces);

    public abstract Double div(int decimalPlaces);

    //    function Num:add(v,    pos)
//  if v~="?" then
//    self.n  = self.n + 1
//    self.lo = math.min(v, self.lo)
//    self.hi = math.max(v, self.hi)
//            if     #self._has < the.nums           then pos=1 + (#self._has)
//    elseif math.random() < the.nums/self.n then pos=math.random(#self._has) end
//    if pos then self.isSorted = false
//    self._has[pos] = tonumber(v) end end end
    public abstract void add(String cellValue);
}
