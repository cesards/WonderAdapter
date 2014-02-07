/*
 * Copyright 2014 DogmaLabs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dogmalabs.wonderadapter.demo.ui.activity;

import android.database.Cursor;
import android.net.Uri;
import com.dogmalabs.wonderadapter.WArrayAdapter;
import com.dogmalabs.wonderadapter.demo.db.Contract;
import com.dogmalabs.wonderadapter.demo.db.provider.cursor.WonderCursor;
import com.dogmalabs.wonderadapter.demo.model.Wonder;
import com.dogmalabs.wonderadapter.demo.ui.ArrayView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesar on 07/02/14.
 */
public class ArrayListActivity extends BaseListActivity {

  // Vars
  private final WonderCursor wonderCursor = new WonderCursor();

  @Override public void setInitData() {
    final Uri uri = Contract.getContentUri(this, Contract.Cursor.Wonders.PATH_DIR);

    // This should be in background task
    Cursor cursor = getContentResolver().query(uri, null, null, null, null);

    WArrayAdapter<Wonder, ArrayView> adapter = new WArrayAdapter(this, getData(cursor), new ArrayView());
    listView.setAdapter(adapter);
  }

  private List getData(Cursor cursor) {
    ArrayList<Wonder> wonders = new ArrayList<>();
    if (cursor.moveToFirst()) {
      do {
        Wonder wonder = wonderCursor.readCursor(this, cursor);
        wonders.add(wonder);
      } while (cursor.moveToNext());
    }
    return wonders;
  }
}
