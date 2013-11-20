package views;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.vkmusic.R;

/**
 * Created by Roman on 20.11.13.
 */
public class TabView extends LinearLayout
{
    final int indexKeyId = 50390;
    private int _tabsHolderId;
    private int _contentHolderId;
    private ITabBuilder _tabBuilder;

    private View _currentView;
    private Fragment _currentFragment;

    public TabView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TabView,
                0, 0);

        _tabsHolderId = a.getResourceId(R.styleable.TabView_tab_holder, 0);
        _contentHolderId = a.getResourceId(R.styleable.TabView_content_holder, 0);
    }

    public  void SetTabBuilder(ITabBuilder tabBuilder)
    {
        _tabBuilder = tabBuilder;
        for(int i = 0; i < tabBuilder.getCountOfTabs(); i++)
        {
            ViewGroup tabsHolder = (ViewGroup)findViewById(_tabsHolderId);

            View tabView = tabBuilder.getTabView(i);
            tabView.setTag(indexKeyId,(Integer)i);
            tabView.setOnClickListener(
                    new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if(view == _currentView) return;

                    int index = (Integer)view.getTag(indexKeyId);
                    _currentView.setSelected(false);
                    view.setSelected(true);
                    _currentView = view;

                    FragmentTransaction fm = _tabBuilder.getFragmentManager().beginTransaction();
                    if(_currentFragment != null) fm.remove(_currentFragment);
                    _currentFragment = _tabBuilder.getTabFragment(index);
                    fm.add(_contentHolderId,_currentFragment);
                    fm.commit();
                }
            });
            tabsHolder.addView(tabView);
            if(i==0) tabView.performClick();
        }
    }
}
