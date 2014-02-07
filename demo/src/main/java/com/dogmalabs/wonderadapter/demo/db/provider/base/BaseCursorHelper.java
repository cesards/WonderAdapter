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

import java.util.List;

/**
 * Base template to create cursor reading/writing
 */
public abstract class BaseCursorHelper<T> {

    /**
     * Stores a T object into a content value array
     * @param item The object to store
     * @return The content values
     */
    public abstract ContentValues setValues(Context context ,T item);


    /**
     * Reads a cursor and deserializes to a T object
     * @param cursor the cursor positioned in the record to extract
     * @return A T object representing the record
     */
    public abstract T readCursor(Context context, Cursor cursor);


    /**
     * Generates an array of content values from a list of items of type T
     * @param items The list of T type objects
     * @return The array of content values. Empty if no items, bu tno null;
     */
    public ContentValues[] setValuesArray(Context context, List<T> items) {
        int length = items.size();
        ContentValues[] tableValues = new ContentValues[length];

        for (int i=0; i<length; i++) {
            tableValues[i] = setValues(context, items.get(i));
        }

        return tableValues;
    }

}
