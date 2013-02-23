
package br.com.dina.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import br.com.dina.ui.R;

/**
 * @author Lope Chupijay Emano 
 * This was taken from UIButton
 */
public class UICenterButton extends LinearLayout {

    private LayoutInflater mInflater;
    private LinearLayout mButtonContainer;
    private ClickListener mClickListener;
    private CharSequence mTitle;

    public UICenterButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setClickable(true);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mButtonContainer = (LinearLayout) mInflater.inflate(R.layout.view_center_button, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.UIButton, 0, 0);
        mTitle = a.getString(R.styleable.UIButton_title);

        if (mTitle != null) {
            ((TextView) mButtonContainer.findViewById(R.id.title)).setText(mTitle.toString());
        } else {
            ((TextView) mButtonContainer.findViewById(R.id.title)).setText("subtitle");
        }

        mButtonContainer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mClickListener != null)
                    mClickListener.onClick(UICenterButton.this);
            }

        });

        addView(mButtonContainer, params);
    }

    public interface ClickListener {
        void onClick(View view);
    }

    /**
     * @param listener
     */
    public void addClickListener(ClickListener listener) {
        this.mClickListener = listener;
    }

    /**
	 * 
	 */
    public void removeClickListener() {
        this.mClickListener = null;
    }

}
