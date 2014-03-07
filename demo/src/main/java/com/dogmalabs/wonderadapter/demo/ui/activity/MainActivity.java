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

package com.dogmalabs.wonderadapter.demo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.dogmalabs.wonderadapter.renderers.WonderAdapter;
import com.dogmalabs.wonderadapter.demo.R;
import com.dogmalabs.wonderadapter.demo.model.Wonder;

public class MainActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);

    WonderAdapter adapter = new WonderAdapter();

  }

  @OnClick(R.id.single_view_arrayadapter) public void onSingleViewArrayAdapterClick() {
    startActivity(new Intent(this, SingleViewActivity.class));
  }

  @OnClick(R.id.multiple_view_arrayadapter) public void onMultipleViewArrayAdapterClick() {
    startActivity(new Intent(this, MultipleViewActivity.class));
  }

  @OnClick(R.id.single_view_cursoradapter) public void onSingleViewCursorAdapterClick() {
    startActivity(new Intent(this, CursorActivity.class));
  }
}
