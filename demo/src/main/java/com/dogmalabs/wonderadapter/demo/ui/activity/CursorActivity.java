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
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import com.dogmalabs.wonderadapter.adapter.WCursorAdapter;
import com.dogmalabs.wonderadapter.demo.ui.CursorViewHolder;
import com.dogmalabs.wonderadapter.demo.util.CursorUtil;

/**
 * Created by cesar on 07/02/14.
 */
public class CursorActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<Cursor> {

  // Constants
  private static final int LOADER_ID_WONDERS = 07021252;

  // Controller/logic fields
  private WCursorAdapter adapter;

  // Lifecycle
  @Override public void onResume() {
    super.onResume();
    getSupportLoaderManager().restartLoader(LOADER_ID_WONDERS, null, this);
  }

  // Public
  @Override public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
    return new CursorUtil(this).getWondersLoader();
  }

  @Override public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
    adapter.swapCursor(cursor);
  }

  @Override public void onLoaderReset(Loader<Cursor> cursorLoader) {
    adapter.swapCursor(null);
  }

  @Override public void setInitData() {
    adapter = new WCursorAdapter(this, new CursorViewHolder());
    listView.setAdapter(adapter);
  }

}
