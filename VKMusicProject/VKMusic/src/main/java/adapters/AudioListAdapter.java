package adapters;

import android.content.Context;
import android.media.audiofx.AudioEffect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.vkmusic.R;

import java.util.List;

import DAL.AudioDescriptor;

/**
 * Created by Superman on 11/18/13.
 */
public class AudioListAdapter extends ArrayAdapter<AudioDescriptor> {

    private class ViewHolder
    {
        public ViewHolder(AudioDescriptor descriptor, TextView textView, Button button)
        {
            Descriptor= descriptor; TextView = textView; DeleteButton = button;
        }
        public AudioDescriptor Descriptor;
        public TextView TextView;
        public View DeleteButton;
    }

    public AudioListAdapter(Context context, List<AudioDescriptor> list)
    {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(this.getContext()).inflate(R.layout.layout_audio_list_item,null);
        ViewHolder holder = new ViewHolder(
                getItem(position),
                (TextView) view.findViewById(R.id.audio_text),
                (Button)view.findViewById(R.id.audio_deleteButton)
        );

        holder.TextView.setText(holder.Descriptor.AudioName);
        holder.DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewHolder holder = (ViewHolder)((View)view.getParent()).getTag();

                remove(holder.Descriptor);
            }
        });
        view.setTag(holder);
        return view;
    }
}
