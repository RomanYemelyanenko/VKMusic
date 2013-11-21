package adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vkmusic.EmptyFragment;
import com.vkmusic.PlayerFragment;
import com.vkmusic.R;

import java.lang.reflect.Type;

import views.ITabBuilder;

/**
 * Created by Roman on 21.11.13.
 */
public class RightSideBarTabs implements ITabBuilder {

    private class TabDescriptor
    {
        private String _tabText;
        private String _fragmentName;
        public TabDescriptor(String tabText, String fragmentName)
        {
            _tabText = tabText;
            _fragmentName = fragmentName;
        };

        public String getTabText(){ return _tabText ; }
        public String getFragmentName() { return _fragmentName; }
    }

    private Context _context;
    private FragmentManager _fragmentManager;
    private TabDescriptor[] _tabDescriptors;

    public RightSideBarTabs(Context context, FragmentManager fragmentManager)
    {
        _context = context;
        _fragmentManager = fragmentManager;
        _tabDescriptors = new TabDescriptor[]
                {
                        new TabDescriptor( "Плеер", EmptyFragment.class.getName()),
                        new TabDescriptor( "Плеер", PlayerFragment.class.getName()),
                        new TabDescriptor( "Плеер", PlayerFragment.class.getName()),
                        new TabDescriptor( "Плеер", PlayerFragment.class.getName())
                };
    }

    @Override
    public View getTabView(int position) {
        LayoutInflater inflater = LayoutInflater.from(_context);
        TextView view = (TextView)inflater.inflate(R.layout.layout_tab, null);
        view.setText(_tabDescriptors[position].getTabText());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMargins(0,0,15,0);
        view.setLayoutParams(params);
        return view;
    }

    @Override
    public Fragment getTabFragment(int position) {
        String fragmentName = _tabDescriptors[position].getFragmentName();
        Fragment fragment = _fragmentManager.findFragmentByTag(fragmentName);
        if(fragment == null)
            fragment = Fragment.instantiate(_context,fragmentName);

        return fragment;
    }

    @Override
    public int getCountOfTabs() {
        return _tabDescriptors.length;
    }
}
