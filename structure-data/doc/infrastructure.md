>We use Eclipse as IDE in discussions below. After importing the project into Eclipse as Maven project and you will see
![alt text](image/project_layout_in_Explorer.png)

_Main_ is the entry of this project. You can run it and see all outputs.

_FlatData_ matches row in data.csv file in src/main/resources. It has 9 fields and two static functions to read and write data from and to the file.

_Model_ is an abstract class. It has a protected and static List<FlatData>, which stores loaded data from external data file, and is used by derived classes to create different structure data.

Each jxsource.javademo.structuredata.model sub package: _company_ and _timeseries_, and _ceo_ contains classes for a separate structured data model. Each created by an Analyzer class which is a sub class of Model and all use List<FlatData> in abstract Model to create different structure data. Note, although all Analyzers have the same Name but their implementations are different (See their different code). In other words, each Analyzer is in different package so they have different class path, which makes them different. It is same for FlatDataComparator, which Analyaer uses to sort List<FlatData>. Although all FlatDataComparators have the same name, their implementations are different. 

_company_ has a structure: Company -> Year -> Qtr -> Info.

_Timeseries_ has a structure: Year -> Company.

_CEO_ has a structure: CEO -> Company.

There are two interfaces: SummayReport and CEOReport. ceo package Analyzer implements CEOReport. timeseries package Analyzer implements SummaryReports. company package Analyzer implements both CEOReport and SummaryReport.

Note, ReportPrinter methods take CEOReport or SummaryReport, not Analyzer class, as input argument. This is very common way to use polymorphism in Java programming. 

All Analyzers implements abstract List<FlatData> getFlatDataList() method defined in Model class, which converts different structure data back to FlatData and used by save() method to export data to a file. Note, because company, timeseries and CEO data structures are different, they way convert them back to FlatData are different. To allow Model.save() method to use it when saving different structure data, it is defined as abstract in Model, which Model.save() method can call it by leave the implementation for the derived classes.



