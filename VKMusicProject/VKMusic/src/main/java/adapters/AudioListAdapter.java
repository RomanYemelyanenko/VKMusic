package adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import DAL.AudioDescriptor;

/**
 * Created by Superman on 11/18/13.
 */
public class AudioListAdapter extends ArrayAdapter<AudioDescriptor> {

    public AudioListAdapter(Context context, List<AudioDescriptor> list)
    {
        super(context, 0, list);
    }

}
