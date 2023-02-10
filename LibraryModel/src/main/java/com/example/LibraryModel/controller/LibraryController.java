package com.example.LibraryModel.controller;

import com.example.LibraryModel.model.Library;
import com.example.LibraryModel.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/library_model")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @PostMapping("/addLibrary")
    public void addLibrary(@RequestBody Library library){
        libraryService.addLibrary(library);
    }
    @GetMapping("/findAll")
    public List<Library> findAll(){
        return libraryService.findAll();
    }
    @GetMapping("/findLibrary/library/{library}")
    public Library findLibrary(@PathVariable String library){
        return libraryService.findLibrary(library);
    }
    @PutMapping("/updateLibrary/library/{library}")
    public void updateLibrary(@PathVariable String library, @RequestBody Library l){
        libraryService.updateLibrary(library,l);
    }

    @DeleteMapping("deleteLibrary/library/{library}")
    public void deleteLibrary(@PathVariable String library){
        libraryService.deleteLibrary(library);
    }
}
