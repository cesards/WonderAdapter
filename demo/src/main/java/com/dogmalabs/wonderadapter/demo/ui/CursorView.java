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

package com.dogmalabs.wonderadapter.demo.ui;

import android.content.Context;
import android.database.Cursor;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.dogmalabs.wonderadapter.BaseWonder;
import com.dogmalabs.wonderadapter.CursorWonder;
import com.dogmalabs.wonderadapter.demo.R;
import com.dogmalabs.wonderadapter.demo.db.provider.cursor.WonderCursor;
import com.dogmalabs.wonderadapter.demo.model.Wonder;
import com.squareup.picasso.Picasso;

/**
 * Created by cesar on 07/02/14.
 */
public class CursorView implements CursorWonder<CursorView> {

  // Views
  @InjectView(R.id.row_wonder_image) ImageView imageView;
  @InjectView(R.id.row_wonder_title) TextView titleView;
  // Vars
  private final WonderCursor wonderCursor = new WonderCursor();

  @Override public void bind(Context context, Cursor cursor) {
    final Wonder wonder = wonderCursor.readCursor(context, cursor);
    Picasso.with(context).load(wonder.getImage()).into(imageView);
    titleView.setText(wonder.getTitle());
  }

  @Override public BaseWonder newInstance() {
    return new CursorView();
  }

  @Override public int getLayout() {
    return R.layout.row_wonder;
  }
}
