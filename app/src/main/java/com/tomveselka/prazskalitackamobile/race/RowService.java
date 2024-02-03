package com.tomveselka.prazskalitackamobile.race;



import com.tomveselka.prazskalitackamobile.entities.RowEntity;

import java.util.ArrayList;
import java.util.List;

public class RowService {

    public List<RowEntity> returnListOfRows(){
        List<RowEntity> listOfRows = new ArrayList<RowEntity>();
        listOfRows.add(new RowEntity(false,5,false,"Křižíkova",false,6,false,"Invalidovna",false,4,false,"24","tram"));
        listOfRows.add(new RowEntity(true,0,false,"Invalidovna",false,6,false,"Českomoravská",false,2,false,"B","metro"));
        listOfRows.add(new RowEntity(true,0,false,"Českomoravská",false,31,true,"Klíčov",false,3,false,"151","bus"));

        return listOfRows;
    }

    public int getTotalPoints(RowEntity entity){
        int sum=entity.getFromPoints()+ entity.getToPoints()+ entity.getLinePoints();
        return sum;
    }
}
