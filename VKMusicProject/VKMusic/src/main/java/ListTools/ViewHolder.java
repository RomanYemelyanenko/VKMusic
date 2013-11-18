package listtools;

import android.view.View;

/**
 * Created by Superman on 11/18/13.
 */
public abstract class ViewHolder<T> {
    public T Item;

    public  ViewHolder(View view, T item)
    {
        Item = item;
    }
}
