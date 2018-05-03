package examples.teamboard.dao;

public final class CategorySQL {
    public static final String updateName = "update category set name = :name where category_no = :categoryNo";

    public static final String selectCategories = "select category_no, name from category";

    public static final String deleteCategory = "delete from category where category_no = :categoryNo";

    private CategorySQL(){}
}
