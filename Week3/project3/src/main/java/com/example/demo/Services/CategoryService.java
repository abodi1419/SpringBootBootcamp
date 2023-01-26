package com.example.demo.Services;

import com.example.demo.Pojo.Category;
import com.example.demo.Pojo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getCategories(){
        return categories;
    }

    public Category getCategory(int index){
        return categories.get(index);
    }
    public int getCategory(String id){
        for (int i=0; i<categories.size(); i++){
            if(categories.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }

    public void addCategory(Category category){
        categories.add(category);
    }

    public boolean updateCategory(Category category, String id){
        int index = getCategory(id);
        if(index>-1) {
            categories.set(index, category);
            return true;
        }
        return false;
    }

    public boolean deleteCategory(String id){
        int index = getCategory(id);
        if(index>-1) {
            categories.remove(index);
            return true;
        }
        return false;
    }


}
