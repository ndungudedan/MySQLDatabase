package com.tidtech.mydatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private final Context mContext;
    private final LayoutInflater inflater;
    private final List<noteItem> mNotes;

    public RecyclerAdapter(Context mContext, List<noteItem> mNotes) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.mNotes = mNotes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView title;
        public final TextView sub;
        public final TextView course;
        public final TextView unit;
        public final TextView lecturer;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.txt_name);
            sub = (TextView)itemView.findViewById(R.id.txt_id);
            course = (TextView)itemView.findViewById(R.id.txt_course);
            unit = (TextView)itemView.findViewById(R.id.txt_unit);
            lecturer = (TextView)itemView.findViewById(R.id.txt_lec);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=inflater.inflate(R.layout.recycler,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, int i) {
        noteItem note=mNotes.get(i);
        viewHolder.title.setText(note.getItemName());
        viewHolder.sub.setText(note.getItemId());
        viewHolder.course.setText(note.getItemCourse());
        viewHolder.unit.setText(note.getItemUnit());
        viewHolder.lecturer.setText(note.getItemLec());
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }
}
