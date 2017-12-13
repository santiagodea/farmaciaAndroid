package ar.com.ciu.pharmapp.Turnos;

/**
 * Created by ramiro on 12/12/17.
 */

public class EventDataObject {
    //Constructors

    public EventDataObject(String name, String title, String description){
        this.description = description;
        this.name = name;
        this.title = title;
    }

    //Fields

    String description;
    String name;
    String title;

    //Methods


    //Getters y Setters

    public String getDescription(){
        return this.description;
    }

    public String getName(){
        return this.name;
    }

    public String getTitle(){
        return this.title;
    }


}
