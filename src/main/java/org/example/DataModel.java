package org.example;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataModel {

    private StringProperty name, date;

    public StringProperty nameProperty(){
        if(name == null) {
            name = new SimpleStringProperty(this, "Vorname Nachname");
        }
        return name;
    }

    public StringProperty dateProperty(){
        if(date == null) {
            date = new SimpleStringProperty(this, "20.01.2038");
        }
        return date;
    }

    public void setName(String name){
        nameProperty().set(name);
    }

    public String getName(){
        return nameProperty().get();
    }

    public void setDate(String date){
        dateProperty().set(date);
    }

    public String getDate(){
        return dateProperty().get();
    }




}
