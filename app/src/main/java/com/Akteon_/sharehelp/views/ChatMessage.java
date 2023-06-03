package com.Akteon_.sharehelp.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.Akteon_.sharehelp.R;
import com.Akteon_.sharehelp.databinding.ViewChatMessageBinding;

public class ChatMessage extends RelativeLayout {

    ViewChatMessageBinding binding;

    public ChatMessage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public ChatMessage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        binding = ViewChatMessageBinding.inflate(
                LayoutInflater.from(getContext()), this, true);
        TypedArray attributes = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ChatMessage, 0, 0);
        try {
            String authorUsername = attributes.getString(R.styleable.ChatMessage_author_username);
            binding.authorUsername.setText(authorUsername);

            String messageText = attributes.getString(R.styleable.ChatMessage_message_text);
            binding.messageText.setText(messageText);
        } finally {
            attributes.recycle();
        }
    }
}
