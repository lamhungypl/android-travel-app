package com.example.endtermandroid.object;


import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.example.endtermandroid.R;


import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ViewDialog {
    Activity activity;
    Dialog dialog;
    public ViewDialog(Activity activity){
        this.activity = activity;
    }
    public void showDialog() {

        dialog  = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //...set cancelable false so that it's never get hidden
        dialog.setCancelable(false);
        //...that's the layout i told you will inflate later
        dialog.setContentView(R.layout.activity_custom_loading);

        //...initialize the imageView form infalted layout
        ImageView gifImageView = dialog.findViewById(R.id.shiba_loading_cusotm);
         /*
        it was never easy to load gif into an ImageView before Glide or Others library
        and for doing this we need DrawableImageViewTarget to that ImageView
        */
        DrawableImageViewTarget imageViewTarget = new DrawableImageViewTarget(gifImageView);

        //...now load that gif which we put inside the drawble folder here with the help of Glide
//        RequestOptions options = new RequestOptions()
//                .centerCrop()
//                .placeholder(R.drawable.shiba_gif)
//                .error(R.drawable.shiba_gif)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .priority(Priority.HIGH);
//
        Glide.with(activity).load(R.drawable.shiba).placeholder(R.drawable.shiba).apply(RequestOptions.circleCropTransform()).into(imageViewTarget);

//        Glide.with(this.activity)
//                .load(R.drawable.shiba_gif)
//                .placeholder(R.drawable.shiba_gif)
////                .apply(options)
//                .into(imageViewTarget);
//
////                .centerCrop()
////                .transition(withCrossFade())

        //...finaly show it
        dialog.show();
    }
    public void hideDialog(){
        dialog.dismiss();
    }
}