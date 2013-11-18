package listtools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Superman on 11/18/13.
 */
public class SingleViewAdapter<T> extends ArrayAdapter<T> {

    private  IInflater<T> _inflater;

    public SingleViewAdapter(Context context, List<T> items, IInflater<T> inflater)
    {
        super(context, 0, items);
        _inflater = inflater;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        T item = getItem(position);
        View newView = convertView;
        if (newView == null)
        {
            newView = _inflater.inflateView();
            newView.setTag(_inflater.createViewHolder(newView, item));
        }
        ViewHolder<T> viewHolder = _inflater.getViewHolder(newView);
        _inflater.refill(newView, item, viewHolder);
        viewHolder.Item = item;
        return newView;
    }
}
