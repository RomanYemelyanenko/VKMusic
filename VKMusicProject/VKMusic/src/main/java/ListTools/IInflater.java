package listtools;

import android.view.View;

/**
 * Created by Superman on 11/18/13.
 */
public interface IInflater<T> {
    View inflateView();
    ViewHolder<T> createViewHolder(View view, T item);
    ViewHolder<T> getViewHolder(View view);
    void refill(View convertView, T item, ViewHolder<T> viewHolder);
}
