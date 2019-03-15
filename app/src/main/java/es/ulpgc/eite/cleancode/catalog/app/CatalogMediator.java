package es.ulpgc.eite.cleancode.catalog.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.catalog.category.CategoryListState;
import es.ulpgc.eite.cleancode.catalog.product.ProductDetailState;
import es.ulpgc.eite.cleancode.catalog.products.ProductListState;

public class CatalogMediator extends Application {

  private ProductListState productListState = new ProductListState();
  private ProductDetailState productDetailState = new ProductDetailState();

  private CategoryListState categoryListState = new CategoryListState();

  private ProductItem product;
  private CategoryItem category;


  public ProductListState getProductListState() {
    return productListState;
  }

  public ProductDetailState getProductDetailState() {
    return productDetailState;
  }

  public ProductItem getProduct() {
    ProductItem item = product;
    //product = null;
    return item;
  }


  public void setProduct(ProductItem item) {
    product = item;
  }

  public CategoryItem getCategory() {
    CategoryItem item = category;
    //product = null;
    return item;
  }

  public void setCategory(CategoryItem item) { category = item; }

  public void setCategoryListState(CategoryListState categoryListState) {
    this.categoryListState = categoryListState;
  }

  public CategoryListState getCategoryListState() {
    return categoryListState;
  }


}
