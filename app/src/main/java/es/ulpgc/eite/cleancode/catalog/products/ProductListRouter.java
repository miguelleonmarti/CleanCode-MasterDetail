package es.ulpgc.eite.cleancode.catalog.products;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;
import es.ulpgc.eite.cleancode.catalog.product.ProductDetailActivity;


public class ProductListRouter implements ProductListContract.Router {

  public static String TAG = ProductListRouter.class.getSimpleName();

  private CatalogMediator mediator;


  public ProductListRouter(CatalogMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToProductDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ProductDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToProductDetailScreen(ProductItem item) {
    mediator.setProduct(item);
  }

  @Override
  public CategoryItem getDataFromCategoryListScreen() {
    CategoryItem categoryItem = mediator.getCategory();
    return categoryItem;
  }



}
