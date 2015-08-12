package com.google.appinventor.components.runtime;


import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;

import android.view.Menu;
import android.view.MenuItem;

@DesignerComponent(version = YaVersion.SIMPLEMENU_COMPONENT_VERSION,
        category = ComponentCategory.USERINTERFACE,
        description = "",
        nonVisible = true,
        iconName = "images/simpleMenu.png")
@SimpleObject
public final class SimpleMenu extends AndroidNonvisibleComponent implements OnPrepareOptionsMenuListener {

    private static String titles = "";

    private String selection = "";

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

    @SimpleProperty
    public String Selection() {
        return selection;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        for(final String title : titles.split(",")) {
            MenuItem menuItem = menu.add(Menu.NONE, Menu.NONE, Menu.NONE, title);

            menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    SimpleMenu.this.selection = (String) item.getTitle();
                    SimpleMenu.this.AfterSelecting((String) item.getTitle());

                    return true;
                }
            });

        }
    }

    @SimpleEvent(description = "Event called after the user selects an item from the dropdown list.")
    public void AfterSelecting(String selection){
        EventDispatcher.dispatchEvent(this, "AfterSelecting", selection);
    }

}