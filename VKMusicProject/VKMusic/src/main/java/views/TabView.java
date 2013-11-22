package views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
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
    private int _tabsHolderId;
    private int _contentHolderId;
    private FragmentManager _fragmentManager;

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

        _fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();

        _tabsHolderId = a.getResourceId(R.styleable.TabView_tab_holder, 0);
        _contentHolderId = a.getResourceId(R.styleable.TabView_content_holder, 0);
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {

        super.onRestoreInstanceState(state);
    }

    public  void setTabBuilder(ITabBuilder tabBuilder)
    {
        _tabBuilder = tabBuilder;
        for(int i = 0; i < tabBuilder.getCountOfTabs(); i++)
        {
            ViewGroup tabsHolder = (ViewGroup)findViewById(_tabsHolderId);

            View tabView = tabBuilder.getTabView(i);
            tabView.setTag((Integer)i);
            tabView.setOnClickListener(
                    new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if(view == _currentView) return;

                    int index = (Integer)view.getTag();
                    if(_currentView != null)  _currentView.setSelected(false);
                    view.setSelected(true);
                    _currentView = view;
                    Fragment newFragment = _tabBuilder.getTabFragment(index);

                    FragmentTransaction fm = _fragmentManager.beginTransaction();
                    fm.setCustomAnimations(R.anim.come_set,R.anim.out_set,R.anim.come_set,R.anim.out_set );
                    fm.replace(_contentHolderId, newFragment);

                    fm.commit();
                }
            });
            tabsHolder.addView(tabView);
            if(i==0) tabView.performClick();
        }
    }
}
