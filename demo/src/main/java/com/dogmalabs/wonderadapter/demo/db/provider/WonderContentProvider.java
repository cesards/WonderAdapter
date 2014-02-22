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

package com.dogmalabs.wonderadapter.demo.db.provider;

import android.database.sqlite.SQLiteDatabase;
import com.dogmalabs.wonderadapter.demo.db.Contract;
import com.dogmalabs.wonderadapter.demo.db.DatabaseHelper;
import com.dogmalabs.wonderadapter.demo.db.provider.base.BaseContract;
import com.dogmalabs.wonderadapter.demo.db.provider.base.DespicableContentProvider;
import com.dogmalabs.wonderadapter.demo.db.provider.base.SimpleMinionContentProvider;
/**
 * This class creates a data base and add all minions
 */
public class WonderContentProvider extends DespicableContentProvider {

  private static SQLiteDatabase db;

  @Override
  public void recruitMinions() {
    addMinion(new SimpleMinionContentProvider(Contract.Cursor.Wonders.PATH_DIR, Contract.Db.Wonder.TABLE, Contract.getContentType(getContext(), true)));
  }

  @Override public String getAuthority() {
    return BaseContract.getAuthority(getContext());
  }

  @Override public SQLiteDatabase getDb() {
    // Open the database.
    if (db == null) {
      db = new DatabaseHelper(getContext()).getReadableDatabase();
    }
    return db;
  }
}
