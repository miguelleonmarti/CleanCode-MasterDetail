package es.ulpgc.eite.cleancode.catalog.category;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListAdapter;

public class CategoryListActivity
        extends AppCompatActivity implements CategoryListContract.View {

    public static String TAG = CategoryListActivity.class.getSimpleName();

    private CategoryListContract.Presenter presenter;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.title_product_list)); //TODO: cambiar
        }

        listView = findViewById(R.id.product_list);

        // do the setup
        CategoryListScreen.configure(this);

        // do some work
        presenter.fetchCategoryListData();
    }

    @Override
    public void injectPresenter(CategoryListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayCategoryListData(CategoryListViewModel viewModel) {
        //Log.e(TAG, "displayCategoryListData()");

        // deal with the data
        listView.setAdapter(new CategoryListAdapter(
                        this, viewModel.categories, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        CategoryItem item = (CategoryItem) view.getTag();
                        presenter.selectCategoryListData(item);
                    }
                })
        );
    }
}
