package com.blkang.simpletodo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends ActionBarActivity {

    EditText etEditItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String itemText = getIntent().getStringExtra("item_text");

        etEditItem = (EditText) findViewById(R.id.etEditItem);
        etEditItem.setText(itemText);

        // get length, set selector to end of item, focus on item
        int newTextPos = etEditItem.length();
        etEditItem.setSelection(newTextPos);
        etEditItem.requestFocus();
    }

    public void onEdit(View view) {
        EditText etItem = (EditText) findViewById(R.id.etEditItem);
        String newText = etItem.getText().toString();

        int itemPos = getIntent().getIntExtra("item_position", 0);

        Intent data = new Intent();

        data.putExtra("new_text", newText);
        data.putExtra("item_pos", itemPos);

        setResult(RESULT_OK, data);
        finish();
    }
}
