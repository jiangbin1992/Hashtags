package com.tito.megahashtagsinsta;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static androidx.core.content.ContextCompat.getSystemService;
import static com.best.now.myad.utils.PublicHelperKt.loadAd;

public class FragmentContent extends Fragment
{
    TextView textViewHashtagContent,textViewSubCategory;
    ImageView imageViewCategory;
    Button buttonDashboard,buttonCopyContent,buttonCopyAndOpenInstagram;
    String mHashtagsContent,mHashtagsCategory;
    Bundle bundle;
    int mThumbnailHashtag;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView=inflater.inflate(R.layout.fragment_content,container,false);
        textViewHashtagContent=myView.findViewById(R.id.textViewContentHashtags);
        textViewSubCategory=myView.findViewById(R.id.textViewSubCategoryHashtagContent);
        buttonDashboard=myView.findViewById(R.id.buttonDashboardContent);
        buttonCopyContent=myView.findViewById(R.id.buttonCopyContent);
        buttonCopyAndOpenInstagram=myView.findViewById(R.id.buttonCopyAndOpenInstaContent);
        imageViewCategory=myView.findViewById(R.id.imageViewHashtagContent);
        LinearLayout advBanner = myView.findViewById(R.id.advBanner);
        loadAd(advBanner);
        //Ads

        // Getting Data From Arguments To Show
        bundle=getArguments();
        mHashtagsContent=bundle.getString(Hashtags.HASHTAGS_TO_SHOW);
        mHashtagsCategory=bundle.getString(Hashtags.CONTENT_CATEGORY);
        mThumbnailHashtag=bundle.getInt(Hashtags.THUMBNAIL_CONTENT);
        // Setting Data To Right Place
        textViewSubCategory.setText(mHashtagsCategory);
        textViewHashtagContent.setText(mHashtagsContent);
        imageViewCategory.setImageResource(mThumbnailHashtag);

        // Setting On Click Listner For Buttons
        buttonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Container_FrameLayout,new FragmentAllHashtags()).commit();
            }
        });

        buttonCopyContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CopyText(mHashtagsContent);

            }
        });
        buttonCopyAndOpenInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CopyText(mHashtagsContent);
                Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.instagram.android");
                if (launchIntent != null)
                {
                    startActivity(launchIntent);
                }
                else
                {
                    Toast.makeText(MainActivity.mContext,"Please Install Instagram And Try Again",Toast.LENGTH_SHORT).show();

                }
            }
        });









        return myView;
    }
    public void CopyText(String textToCopy)
    {

        ClipboardManager clipboard =(ClipboardManager) getContext().getSystemService(getContext().CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label",textToCopy);
        clipboard.setPrimaryClip(clip);
    }
}
