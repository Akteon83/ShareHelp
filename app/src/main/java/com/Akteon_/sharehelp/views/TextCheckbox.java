package com.Akteon_.sharehelp.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.Akteon_.sharehelp.R;
import com.Akteon_.sharehelp.databinding.ViewTextCheckboxBinding;

public class TextCheckbox extends LinearLayout {

    ViewTextCheckboxBinding binding;

    public TextCheckbox(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public TextCheckbox(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        binding = ViewTextCheckboxBinding.inflate(
                LayoutInflater.from(getContext()), this, true);
        TypedArray attributes = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.TextCheckbox, 0, 0);
        try {
            String text = attributes.getString(R.styleable.TextCheckbox_android_text);
            binding.text.setText(text);
        } finally {
            attributes.recycle();
        }
    }

    public Boolean isChecked() {
        return binding.checkbox.isChecked();
    }
}
