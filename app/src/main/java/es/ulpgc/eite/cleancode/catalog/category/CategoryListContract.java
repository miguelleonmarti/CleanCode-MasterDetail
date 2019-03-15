package es.ulpgc.eite.cleancode.catalog.category;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;

interface CategoryListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayCategoryListData(CategoryListViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void selectCategoryListData(CategoryItem item);

        void fetchCategoryListData();
    }

    interface Model {
        List<CategoryItem> fetchCategoryListData();
    }

    interface Router {
        void navigateToProductListScreen();

        void passDataToProductListScreen(CategoryItem item);
    }
}
