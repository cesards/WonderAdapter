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
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.util.Arrays;
import java.util.HashSet;

/**
 * This class manage a specific provider
 */
public abstract class MinionContentProvider {

    private Context context;


    /**
     * Returns the base path of this entity. For example "sports". Will be added to the getAuthority of the DespicableContentProvider
     * in the shape content://{DespicableContentProvider.getAuthority()}/{getBasePath()}
     * @return The base path
     */
    public abstract String getBasePath();

    /**
     * Performs a query on the entity managed by this minion
     * @param db the current db
     * @param uri	The URI to query. This will be the full URI sent by the client; if the client is requesting a specific record, the URI will end in a record number that the implementation should parse and add to a WHERE or HAVING clause, specifying that _id value.
     * @param projection	The list of columns to put into the cursor. If null all columns are included.
     * @param selection	A selection criteria to apply when filtering rows. If null then all rows are included.
     * @param selectionArgs	You may include ?s in selection, which will be replaced by the values from selectionArgs, in order that they appear in the selection. The values will be bound as Strings.
     * @paramsortOrder	How the rows in the cursor should be sorted. If null then the provider is free to define the sort order.
     * @return a Cursor or null.
     */
    public abstract Cursor query(SQLiteDatabase db, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder);

    /**
     * Inserts value in the entity managed by this minion
     * @param db the current db
     * @param uri The content:// URI of the insertion request.
     * @param contentValues A set of column_name/value pairs to add to the database.
     * @return  The URI for the newly inserted item.
     */
    public abstract long insert(SQLiteDatabase db, Uri uri, ContentValues contentValues);

    /**
     * Deletes one or more rows for the  entity managed by this minion
     * @param db
     * @param uri The full URI to query, including a row ID (if a specific record is requested).
     * @param where An optional restriction to apply to rows when deleting.
     * @param selectionArgs the values for the arguments
     * @return The number of rows affected.
     */
    public abstract int delete(SQLiteDatabase db, Uri uri, String where, String[] selectionArgs);

    /**
     *  Updates one or more rows
     * @param uri The URI to query. This can potentially have a record ID if this is an update request for a specific record.
     * @param values A Bundle mapping from column names to new column values (NULL is a
     *               valid value).
     * @param where An optional filter to match rows to update.
     * @return the number of rows affected.
     * @return
     */
    public abstract int update(SQLiteDatabase db, Uri uri, ContentValues values, String where, String[] selectionArgs);

    public abstract String getType();

    /**
     * This method is invoked on the query process. It's responsible to verify if all the columns projected do exist in the database.
     * Should throw a IllegalArgumentException runtime error if failed
     * @param projection The array of fields to verify
     */
    public void checkColumns(String[] projection) {
        String[] available = getAvailableColumns();
        if (projection != null) {
            HashSet<String> requestedColumns = new HashSet<String>(Arrays.asList(projection));
            HashSet<String> availableColumns = new HashSet<String>(Arrays.asList(available));
            // Check if all columns which are requested are available
            if (!availableColumns.containsAll(requestedColumns)) {
                throw new IllegalArgumentException(
                        "Unknown columns in projection");
            }
        }
    }

    public abstract String[] getAvailableColumns();

    public void setContext(Context context) {
        this.context=context;
    }

    public Context getContext() {
        return context;
    }

}