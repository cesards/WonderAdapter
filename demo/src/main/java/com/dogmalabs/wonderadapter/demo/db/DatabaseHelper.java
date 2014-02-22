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

package com.dogmalabs.wonderadapter.demo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.dogmalabs.wonderadapter.demo.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class manages all Tables in data base
 */
public class DatabaseHelper extends SQLiteOpenHelper {

  private Context context;

  public DatabaseHelper(Context context) {
    super(context, Contract.DATABASE_NAME, null, Contract.DATABASE_VERSION);
    this.context = context;
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    loadSQLFile(db);
  }

  private void loadSQLFile(SQLiteDatabase db){
    // Open the resource
    InputStream insertsStream = context.getResources().openRawResource(R.raw.wonder_defaults);
    BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));

    // Iterate through lines (assuming each instruction has its own line and theres no other stuff)
    try {
      while (insertReader.ready()) {
        String insertStmt = insertReader.readLine();
        db.execSQL(insertStmt);
      }
      insertReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  }
}
