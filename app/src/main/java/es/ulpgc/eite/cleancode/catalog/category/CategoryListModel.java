package es.ulpgc.eite.cleancode.catalog.category;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;
import es.ulpgc.eite.cleancode.catalog.category.CategoryListContract;

public class CategoryListModel implements CategoryListContract.Model {

    public static String TAG = CategoryListModel.class.getSimpleName();

    private final List<CategoryItem> itemList = new ArrayList<>();
    private final int COUNT = 20;

    public CategoryListModel() {
        // Add some sample items
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index));
        }
    }

    @Override
    public List<CategoryItem> fetchCategoryListData() {
        Log.e(TAG, "fetchProductListData()");
        return itemList;
    }

    private void addProduct(CategoryItem item) {
        itemList.add(item);
    }


    private CategoryItem createProduct(int position) {
        String content = "Category " + position; // TODO: CAMBIAR

        return new CategoryItem(
                position, content, fetchCategoryDetails(position)
        );

    }


    private String fetchCategoryDetails(int position) {
        String content = "Details about Category:  " + position;
        StringBuilder builder = new StringBuilder();
        builder.append(content);

        for (int index = 0; index < position; index++) {
            builder.append("\nMore details information here.");
        }

        return builder.toString();
    }

}