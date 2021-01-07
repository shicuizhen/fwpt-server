package com.sjzxy.fwpt.util.codeAuto;

/**
 * 表结构行信息实体类
 */
public class TableInfo {
    private String columnName;
    private String dataType;
    private String columnComment;
    private String columnKey;
    private String extra;

    TableInfo() {
    }

    String getColumnName() {
        return columnName;
    }

    void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    String getDataType() {
        return dataType;
    }

    void setDataType(String dataType) {
        this.dataType = dataType;
    }

    String getColumnComment() {
        return columnComment;
    }

    void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    String getColumnKey() {
        return columnKey;
    }

    void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    String getExtra() {
        return extra;
    }

    void setExtra(String extra) {
        this.extra = extra;
    }
}
