package com.example.Library.controller;

import com.example.Library.model.Library;
import com.example.Library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/library")
public class LibraryController {

    @Autowired
    LibraryService service;
    @PostMapping("add-library")
    public void addLibrary(@RequestBody Library library)
    {
        service.add(library);
    }

    @GetMapping("get")
    public List<Library> get()
    {
        return service.getAll();
    }
    @GetMapping("get/name/{name}")
    public Library getLibrary(@PathVariable String name)
    {
        return service.getByName(name);
    }
    @PutMapping("update/name/{name}")
    public void updateLibrary(@PathVariable String name,@RequestBody Library library)
    {
        service.updateByName(name,library);
    }
    @DeleteMapping("delete/name/{name}")
    public void deleteLibrary(@PathVariable String name)
    {
        service.deleteByName(name);
    }

}
