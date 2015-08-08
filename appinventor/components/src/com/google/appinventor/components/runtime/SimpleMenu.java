package com.google.appinventor.components.runtime;


import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;

import android.view.Menu;

@DesignerComponent(version = YaVersion.SIMPLEMENU_COMPONENT_VERSION,
        category = ComponentCategory.USERINTERFACE,
        description = "",
        nonVisible = true,
        iconName = "images/simpleMenu.png")
@SimpleObject
public final class SimpleMenu extends AndroidNonvisibleComponent implements OnPrepareOptionsMenuListener {

    private static String titles = "";

    public SimpleMenu (ComponentContainer container) {
        super(container.$form());
        form.registerForOnPrepareOptionsMenu(this);
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING,
            defaultValue = "")
    @SimpleProperty
    public void Title(String title) {
        this.titles = title;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        for(String title : titles.split(",")) {
            menu.add(Menu.NONE, Menu.NONE, Menu.NONE, title);
        }
    }
}