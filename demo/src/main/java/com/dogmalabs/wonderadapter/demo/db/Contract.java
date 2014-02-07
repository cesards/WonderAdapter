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

import android.provider.BaseColumns;
import com.dogmalabs.wonderadapter.demo.db.provider.base.BaseContract;

/**
 * This class contain all data base and content provider constants and defines the tables structure
 */
public final class Contract extends BaseContract {

  public static final String DATABASE_NAME = "wonders.db";
  public static final int DATABASE_VERSION = 1;

  public static final class Db {

    public static final class Wonder {

      public static final String TABLE = "wonders";

      public static final class Column implements BaseColumns {
        public static final String TITLE = "title";
        public static final String IMAGE_URL = "image_url";
      }
    }
  }

  public static final class Cursor {

    public static final class Wonders {

      public static final String PATH_DIR = "wonders";
      public static final String PATH_ITEM = "wonders/#";

      public static final class Column implements BaseColumns {
        public static final String TITLE = "title";
        public static final String IMAGE_URL = "image_url";
      }
    }
  }
}
