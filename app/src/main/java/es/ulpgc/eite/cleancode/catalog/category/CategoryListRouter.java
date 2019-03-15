package es.ulpgc.eite.cleancode.catalog.category;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;

public class CategoryListRouter implements CategoryListContract.Router {

    public static String TAG = CategoryListRouter.class.getSimpleName();

    private CatalogMediator mediator;

    public CategoryListRouter(CatalogMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToProductListScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ProductListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToProductListScreen(CategoryItem item) {
        mediator.setCategory(item);
    }


}
