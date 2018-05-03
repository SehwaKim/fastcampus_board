package examples.teamboard.service;

import examples.teamboard.domain.Category;

import java.util.List;

public interface CategoryService {
    public int addCategory(String name);
    public int modifyCategory(Category category);
    public int deleteCategory(int CategoryNo);
    public List<Category> getCategories();

}
