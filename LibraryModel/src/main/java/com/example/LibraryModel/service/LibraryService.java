package com.example.LibraryModel.service;

import com.example.LibraryModel.model.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {

    List<Library> list = new ArrayList<>();

    public void addLibrary(Library library) {
        list.add(library);
    }

    public List<Library> findAll() {
        return list;
    }

    public Library findLibrary(String library) {
        for(Library l:list){
            if(l.getName().equals(library)){
                return l;
            }
        }
        return null;
    }

    public void updateLibrary(String library_name, Library l) {
        Library lb = findLibrary(library_name);
        lb.setAddress(l.getAddress());
        lb.setFacilities(l.getFacilities());
        lb.setName(l.getName());
        lb.setPhNo(l.getPhNo());
    }

    public void deleteLibrary(String library) {
        Library lb = findLibrary(library);
        list.remove(lb);
    }
}
