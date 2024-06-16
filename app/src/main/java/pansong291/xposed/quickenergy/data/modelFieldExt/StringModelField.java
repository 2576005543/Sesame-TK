package pansong291.xposed.quickenergy.data.modelFieldExt;


import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import pansong291.xposed.quickenergy.R;
import pansong291.xposed.quickenergy.data.ModelField;
import pansong291.xposed.quickenergy.ui.EditDialog;

public class StringModelField extends ModelField {

    public StringModelField() {
    }

    public StringModelField(String code, String name, String value) {
        super(code, name, value);
    }

    @Override
    public void setValue(Object value) {
        if (value != null) {
            value = String.valueOf(value);
        }
        this.value = value;
    }

    @Override
    public String getValue() {
        return (String) value;
    }

    @Override
    public View getView(Context context) {
        Button btn = new Button(context);
        btn.setText(getName());
        btn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btn.setTextColor(Color.parseColor("#008175"));
        btn.setBackground(context.getResources().getDrawable(R.drawable.button));
        btn.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
        btn.setMinHeight(150);
        btn.setPaddingRelative(40, 0, 40, 0);
        btn.setAllCaps(false);
        btn.setOnClickListener(v -> EditDialog.showEditDialog(v.getContext(), ((Button) v).getText(), this));
        return btn;
    }

}
