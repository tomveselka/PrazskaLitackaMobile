package com.tomveselka.prazskalitackamobile.race.domain;



import com.tomveselka.prazskalitackamobile.entities.RowEntity;

import java.util.ArrayList;
import java.util.List;

public class RowService {
/*
    public List<RowEntity> returnListOfRows(){
        List<RowEntity> listOfRows = new ArrayList<RowEntity>();
        listOfRows.add(new RowEntity(false,5,false,"Křižíkova",false,6,false,"Invalidovna",false,4,false,"24","tram",false,null,15));
        listOfRows.add(new RowEntity(true,0,false,"Invalidovna",false,6,false,"Českomoravská",false,2,false,"B","metro",false, null, 8));
        listOfRows.add(new RowEntity(true,0,false,"Českomoravská",false,31,true,"Klíčov",false,3,false,"151","bus",true,"odklon",38));

        return listOfRows;
    }
*/
    public int getTotalPoints(RowEntity entity){
        int sum=entity.getFromPoints()+ entity.getToPoints()+ entity.getLinePoints();
        return sum;
    }
}
