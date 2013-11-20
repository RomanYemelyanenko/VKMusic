package views;

import android.app.Fragment;
import android.app.FragmentManager;
import android.view.View;

/**
 * Created by Roman on 21.11.13.
 */
public interface ITabBuilder {
    View getTabView(int position);
    Fragment getTabFragment(int position);

    int getCountOfTabs();
    FragmentManager getFragmentManager();
}
