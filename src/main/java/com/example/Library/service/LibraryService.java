package com.example.Library.service;

import com.example.Library.model.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class LibraryService {
    private static List<Library> ls=new ArrayList<>();
    static{
        ls.add(new Library("liba","mathura",9,"ice cream"));
    }
    public void add(Library library)
    {
        ls.add(library);
    }
    public List<Library> getAll()
    {
        return ls;
    }
    public Library getByName(String name)
    {
        Predicate<? super Library> predicate=library -> library.getName().equals(name);
        return ls.stream().filter(predicate).findFirst().get();
    }
    public void updateByName(String name,Library library)
    {
        Library lib=getByName(name);
        lib.setName(library.getName());
        lib.setAddress(library.getAddress());
        lib.setNumber(library.getNumber());
        lib.setFacilities(library.getFacilities());
    }
    public void deleteByName(String name)
    {
        Predicate<? super Library> predicate=library -> library.getName().equals(name);
        ls.removeIf(predicate);
    }
}
