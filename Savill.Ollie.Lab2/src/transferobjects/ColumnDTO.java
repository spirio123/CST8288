/**
 * File name: ColumnDTO.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package transferobjects;

import java.util.List;
import java.util.ArrayList;

/**
 * This class represents a data transfer object for a database column. It
 * contains fields for the column count, column name, column type, and class type.
 *
 * @author savil
 */
public class ColumnDTO {

    private Integer columnCount;
    private List<String> columnName;
    private List<String> columnType;
    private List<String> classType;

    /**
     * Constructor for the ColumnDTO class. Initializes the column count and
     * creates empty lists for the column names, column types, and class types.
     */
    public ColumnDTO() {
        columnCount = 0;
        columnName = new ArrayList<>();
        columnType = new ArrayList<>();
        classType = new ArrayList<>();
    }

    /**
     * Returns the number of columns in the database.
     *
     * @return the number of columns
     */
    public Integer getColumnCount() {
        return columnCount;
    }

    /**
     * Returns the name of the specified column in the database.
     *
     * @param o the index of the column to retrieve the name of
     * @return the name of the column
     */
    public String getColumnName(int o) {
        return columnName.get(o);
    }

    /**
     * Returns the type of the specified column in the database.
     *
     * @param o the index of the column to retrieve the type of
     * @return the type of the column
     */
    public String getColumnType(int o) {
        return columnType.get(o);
    }

    /**
     * Returns the class type of the specified column in the database.
     *
     * @param o the index of the column to retrieve the class type of
     * @return the class type of the column
     */
    public String getClassType(int o) {
        return classType.get(o);
    }

    /**
     * Sets the number of columns in the database.
     *
     * @param columnCount the number of columns to set
     */
    public void setColumnCount(Integer columnCount) {
        this.columnCount = columnCount;
    }

    /**
     * Adds the specified column name to the list of column names.
     *
     * @param columnName the column name to add
     */
    public void setColumnName(String columnName) {
        this.columnName.add(columnName);
    }

    /**
     * Adds the specified column type to the list of column types.
     *
     * @param columnType the column type to add
     */
    public void setColumnType(String columnType) {
        this.columnType.add(columnType);
    }

    /**
     * Adds the specified class type to the list of class types.
     *
     * @param classType the class type to add
     */
    public void setClassType(String classType) {
        this.classType.add(classType);
    }

}
/*
The design pattern used in this code is the Transfer Object pattern. The ColumnDTO 
class acts as a data transfer object for a database column, providing a way to 
transfer data between the database and the application layer. The class encapsulates 
the column count, column name, column type, and class type, and provides getters and 
setters for each field. The class uses lists to store multiple values for column 
name, column type, and class type.
*/