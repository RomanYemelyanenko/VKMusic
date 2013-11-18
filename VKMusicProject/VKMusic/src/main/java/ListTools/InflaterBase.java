package listtools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Superman on 11/18/13.
 */
public abstract class InflaterBase<T> implements IInflater<T> {
    protected Context _context;
    protected LayoutInflater getLayoutInflater() { return  LayoutInflater.from(_context); };

    public  InflaterBase(Context context)
    {
        _context = context;
    }
    public ViewHolder<T> getViewHolder(View view) { return (ViewHolder<T>)view.getTag();  }

    public abstract View inflateView();
    public abstract ViewHolder<T> createViewHolder();
    public abstract void refill(View convertView, T item, ViewHolder<T> viewHolder);
}
