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

package com.dogmalabs.wonderadapter.demo.db.provider.base;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created with IntelliJ IDEA.
 * User: Sergi
 * Date: 31/05/13
 * Time: 03:13
 * To change this template use File | Settings | File Templates.
 */
public class SimpleItemMinionContentProvider extends MinionContentProvider {

    private final String basePath;
    private final String tableName;
    private final String type;

    public SimpleItemMinionContentProvider(String basePath, String tableName, String type) {
        this.basePath = basePath;
        this.tableName = tableName;
        this.type = type;
    }

    @Override
    public String getBasePath() {
        return basePath;
    }

    @Override
    public Cursor query(SQLiteDatabase db, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String[] idArgs = new String[]{uri.getLastPathSegment()};
        return db.query(tableName, projection, "_id=?", idArgs, null, null, sortOrder);
    }

    @Override
    public long insert(SQLiteDatabase db, Uri uri, ContentValues contentValues) {

        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(SQLiteDatabase db, Uri uri, String where, String[] selectionArgs) {
        String[] idArgs = new String[]{uri.getLastPathSegment()};
        return db.delete(tableName, "_id=?", idArgs);
    }

    @Override
    public int update(SQLiteDatabase db, Uri uri, ContentValues values, String where, String[] selectionArgs) {
        String[] idArgs = new String[]{uri.getLastPathSegment()};
        return db.update(tableName, values, "_id=?", idArgs);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String[] getAvailableColumns() {
        return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
    }
}
