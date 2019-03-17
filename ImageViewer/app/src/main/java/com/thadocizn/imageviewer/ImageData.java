package com.thadocizn.imageviewer;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import android.net.Uri;

import java.io.Serializable;

public class ImageData extends BaseObservable implements Serializable {

    private String name;
    private String uri;

    public ImageData(String name, Uri uri) {
        this.name = name;
        this.uri = uri.toString();
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public Uri getUri() {
        return Uri.parse(uri);
    }

    public void setUri(Uri uri) {
        this.uri = uri.toString();
        notifyPropertyChanged(BR.uri);
    }


}
