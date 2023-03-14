package com.Akteon_.sharehelp;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Akteon_.sharehelp.databinding.ViewDiscussionPreviewBinding;

public class DiscussionPreview extends RelativeLayout {

    ViewDiscussionPreviewBinding binding;

    public DiscussionPreview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public DiscussionPreview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        binding = ViewDiscussionPreviewBinding.inflate(
                LayoutInflater.from(getContext()), this, true);
        TypedArray attributes = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.DiscussionPreview, 0, 0);
        try {
            String topic = attributes.getString(R.styleable.DiscussionPreview_topic);
            binding.topic.setText(topic);

            String problem = attributes.getString(R.styleable.DiscussionPreview_problem);
            binding.problem.setText(problem);
        } finally {
            attributes.recycle();
        }
    }
}
