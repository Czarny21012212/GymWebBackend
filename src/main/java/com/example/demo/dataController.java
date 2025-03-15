package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class dataController {

    @Autowired
    private dataService dataService;

    //Function to activating a Pass
    @PostMapping("/activatePass")
    public ResponseEntity<Map<String, String>>  activatePass(@RequestBody personData personData) {
        Map<String, String> response = new HashMap<String, String>();

        try{
            dataService.activatePass(personData);
            response.put("message", "Karnet został aktywowany");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("message", "Coś poszło nie tak | Error: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    //Function to Cancelling the Pass
    @PostMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deletePass(@PathVariable long id) {
        Map<String, String> response = new HashMap<String, String>();

        try{
            if(dataService.findById(id) != null){
                dataService.deletePass(id);
                response.put("messageDelete", "Karnet został anulowany");
                return ResponseEntity.ok(response);
            }else {
                response.put("messageDelete", "Nie znaleziono takiego karnetu");
                return ResponseEntity.badRequest().body(response);
            }
        }catch(Exception e){
            response.put("messageDelete", "Coś poszło nie tak | Error: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    //function to show your pass
    @GetMapping("/show")
    public List<personData> showPass(){

        if(dataService.yourPass() != null){
            return dataService.yourPass();
        }else {return null;}
    }

}
