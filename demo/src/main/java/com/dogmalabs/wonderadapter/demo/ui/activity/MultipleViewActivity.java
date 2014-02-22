package com.dogmalabs.wonderadapter.demo.ui.activity;

import android.database.Cursor;
import android.net.Uri;
import com.dogmalabs.wonderadapter.adapter.WMultiArrayAdapter;
import com.dogmalabs.wonderadapter.demo.db.Contract;
import com.dogmalabs.wonderadapter.demo.db.provider.cursor.WonderCursor;
import com.dogmalabs.wonderadapter.demo.model.Wonder;
import com.dogmalabs.wonderadapter.demo.model.WonderHeader;
import com.dogmalabs.wonderadapter.demo.ui.MultiViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by menor on 10/02/14.
 */
public class MultipleViewActivity extends BaseActivity {

  // Vars
  private final WonderCursor wonderCursor = new WonderCursor();

  @Override public void setInitData() {
    final Uri uri = Contract.getContentUri(this, Contract.Cursor.Wonders.PATH_DIR);

    // This should be in background task
    Cursor cursor = getContentResolver().query(uri, null, null, null, null);

    WMultiArrayAdapter<MultiViewHolder> adapter =
        new WMultiArrayAdapter<>(this, getData(cursor), new MultiViewHolder());

    listView.setAdapter(adapter);
  }

  private List getData(Cursor cursor) {
    String country = "";
    ArrayList<Object> wonders = new ArrayList<>();
    if (cursor.moveToFirst()) {
      do {
        Wonder wonder = wonderCursor.readCursor(this, cursor);
        if (country.compareTo(wonder.getCountry()) != 0) {
          country = wonder.getCountry();
          WonderHeader header = new WonderHeader();
          header.setCountry(country);
          wonders.add(header);
        }
        wonders.add(wonder);
      } while (cursor.moveToNext());
    }
    return wonders;
  }
}

