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

package com.dogmalabs.wonderadapter.demo.db.provider.cursor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.dogmalabs.wonderadapter.demo.db.Contract;
import com.dogmalabs.wonderadapter.demo.db.provider.base.BaseCursorHelper;
import com.dogmalabs.wonderadapter.demo.model.Wonder;

/**
 * Created by cesar on 27/01/14.
 */
public class WonderCursor extends BaseCursorHelper<Wonder> {

  @Override public ContentValues setValues(Context context, Wonder item) {
    return null;
  }

  @Override public Wonder readCursor(Context context, Cursor cursor) {
    Wonder wonder = new Wonder();
    wonder.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Cursor.Wonders.Column.TITLE)));
    wonder.setImage(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Cursor.Wonders.Column.IMAGE_URL)));
    wonder.setCountry(cursor.getString(cursor.getColumnIndexOrThrow(Contract.Cursor.Wonders.Column.COUNTRY)));
    return wonder;
  }
}
