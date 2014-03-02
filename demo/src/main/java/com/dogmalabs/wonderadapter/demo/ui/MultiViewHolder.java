package com.dogmalabs.wonderadapter.demo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;
import com.dogmalabs.wonderadapter.MultiWonder;
import com.dogmalabs.wonderadapter.demo.R;
import com.dogmalabs.wonderadapter.demo.model.Wonder;
import com.dogmalabs.wonderadapter.demo.model.WonderHeader;
import com.squareup.picasso.Picasso;

/**
 * Created by menor on 10/02/14.
 */
public class MultiViewHolder implements MultiWonder<MultiViewHolder> {

  // Constants
  private static final int VIEW_ROW = 0;
  private static final int VIEW_HEADER = 1;
  private static final int TYPE_COUNT = 2;

  // UI
  @Optional @InjectView(R.id.row_country_title) TextView countryView;
  @Optional @InjectView(R.id.row_wonder_image)  ImageView wonderImageView;
  @Optional @InjectView(R.id.row_wonder_title)  TextView wonderTitleView;

  @Override public void bind(Context context, Object item, int viewType) {
    if (viewType == VIEW_ROW) {
      Picasso.with(context).load(((Wonder) item).getImage()).into(wonderImageView);
      wonderTitleView.setText(((Wonder) item).getTitle());
    } else {
      WonderHeader won = (WonderHeader) item;
      countryView.setText(won.getCountry());
    }
  }

  @Override public MultiViewHolder newInstance() {
    return new MultiViewHolder();
  }

  @Override public int getViewTypeCount() {
    return TYPE_COUNT;
  }

  @Override public int getViewType(Object object) {
    // Better way I've found know which object type is
    if (object instanceof WonderHeader) {
      return VIEW_HEADER;
    } else {
      return VIEW_ROW;
    }
  }

  @Override public View inflate(LayoutInflater inflater, ViewGroup parent, int viewType) {
    View view;
    if (viewType == VIEW_ROW) {
      view = inflater.inflate(R.layout.row_wonder, parent, false);
    } else {
      view = inflater.inflate(R.layout.row_country, parent, false);
    }
    ButterKnife.inject(this, view); // Or you could also find Views by their ids...
    return view;
  }
}
