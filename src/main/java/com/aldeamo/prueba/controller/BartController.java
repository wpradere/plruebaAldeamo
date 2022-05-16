package com.aldeamo.prueba.controller;


import com.aldeamo.prueba.dto.DataDto;
import com.aldeamo.prueba.model.BarTentity;
import com.aldeamo.prueba.service.BartService;
import net.bytebuddy.matcher.FilterableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/app/bartender/")
public class BartController {

    @Autowired
    private BartService bartService;


    @PostMapping("/resp")
    public ResponseEntity<?> proceso(@RequestBody DataDto dataDto) {


        List<Integer> p = new ArrayList<Integer>();
        Stack<Integer> a = new Stack<>();
        Stack<Integer> a1 = new Stack<>();

        Stack<Integer> b = new Stack<>();
        Stack<Integer> respuesta = new Stack<>();
        String resp;

        int q = 3, tamano = 0, data = 0;

        if ( bartService.findOne(dataDto.getId())== null){
            resp = "mensaje : El ID" + "  "+ dataDto.getId() + " " + "no existe ";
            return new ResponseEntity(resp, HttpStatus.OK);
        }else {


        BarTentity barTentity = bartService.findOne(dataDto.getId());
        String []arregloData = barTentity.getImput().split(",");

        for(int r =0;r<arregloData.length;r++){
           a.push(Integer.parseInt(arregloData[r]));
        }
        p.add(2);p.add(3);p.add(5);p.add(7);p.add(11);p.add(13);

        for (int i = 0; i < q; i++) {

            tamano = a.size();
            while (tamano > 0) {
                data = a.pop();
                if (Math.floorMod(data, p.get(i)) == 0) {
                    b.push(data);
                    respuesta.push(data);
                } else if (Math.floorMod(data, p.get(i)) != 0) {
                    a1.push(data);
                }
                tamano--;
            }
            a = a1;
            b.clear();
        }
            return new ResponseEntity(respuesta, HttpStatus.OK);
        }
    }

}

