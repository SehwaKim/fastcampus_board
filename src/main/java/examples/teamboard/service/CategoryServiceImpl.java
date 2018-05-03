package examples.teamboard.service;

import examples.teamboard.dao.CategoryDAO;
import examples.teamboard.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }

    @Override
    public int addCategory(String name) {
        return categoryDAO.insertCategory(name);
    }

    @Override
    public int modifyCategory(Category category) {
        return categoryDAO.updateName(category);
    }

    @Override
    public int deleteCategory(int categoryNo) {
        return categoryDAO.deleteCategory(categoryNo);
    }

    @Override
    public List<Category> getCategories() {
        return categoryDAO.selectCategoryList();
    }
}
