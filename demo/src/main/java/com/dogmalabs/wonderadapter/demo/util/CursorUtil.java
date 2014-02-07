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

package com.dogmalabs.wonderadapter.demo.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import com.dogmalabs.wonderadapter.demo.db.Contract;

/**
 * Created by cesar on 28/01/14.
 */
public class CursorUtil {

  private Context context;
  private String[] projection;
  private String selection;
  private String[] selectionArgs;
  private String orderBy;

  public CursorUtil(Context context) {
    this.context = context;
  }

  public Loader<Cursor> getWondersLoader() {
    Uri uri = Contract.getContentUri(context, Contract.Cursor.Wonders.PATH_DIR);
    return new CursorLoader(context, uri, projection, selection, selectionArgs, orderBy);
  }

}
