package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.noteapp.bean.Note;
import com.example.noteapp.NoteDbOpenHelper;
import com.example.noteapp.R;
import com.example.noteapp.bean.Note;
import com.example.noteapp.util.ToastUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddActivity extends AppCompatActivity {

    private EditText etTitle,etContent,etAuthor;

    private NoteDbOpenHelper mNoteDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.et_title);
        etContent = findViewById(R.id.et_content);
        etAuthor = findViewById(R.id.et_author);
        mNoteDbOpenHelper = new NoteDbOpenHelper(this);

    }

    public void add(View view) {//获取标题内容作者
        String title = etTitle.getText().toString();
        String content = etContent.getText().toString();
        String author = etAuthor.getText().toString();
        if (TextUtils.isEmpty(title)) {
            ToastUtil.toastShort(this, "标题不能为空！");
            return;
        }if (TextUtils.isEmpty(author)) {
            ToastUtil.toastShort(this, "作者不能为空！");
            return;
        }

        Note note = new Note();//保存到数据库中

        note.setTitle(title);
        note.setContent(content);
        note.setAuthor(author);
        note.setCreatedTime(getCurrentTimeFormat());
        long row = mNoteDbOpenHelper.insertData(note);
        if (row != -1) {
            ToastUtil.toastShort(this,"添加成功！");
            this.finish();//结束当前页面，返回主界面
        }else {
            ToastUtil.toastShort(this,"添加失败！");
        }

    }

    private String getCurrentTimeFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}