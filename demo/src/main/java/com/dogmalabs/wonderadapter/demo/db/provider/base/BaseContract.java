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

import android.content.Context;
import android.net.Uri;

/**
 * Created by cesar on 27/01/14.
 */
public class BaseContract {

  protected static final String CONTENT = "content://";
  protected static final String CONTENT_TYPE_DIR = "vnd.android.cursor.dir/vnd.";
  protected static final String CONTENT_TYPE_ITEM = "vnd.android.cursor.item/vnd.";

  public static String getAuthority(Context context) {
    return context.getPackageName();
  }

  public static Uri getContentUri(Context context, String path) {
    Uri authorityUri = Uri.parse(CONTENT + getAuthority(context));
    return Uri.withAppendedPath(authorityUri, path);
  }

  public static String getContentType(Context context, boolean isDir) {
    if (isDir) {
      return CONTENT_TYPE_DIR + getAuthority(context);
    }
    return CONTENT_TYPE_ITEM + getAuthority(context);
  }

}
