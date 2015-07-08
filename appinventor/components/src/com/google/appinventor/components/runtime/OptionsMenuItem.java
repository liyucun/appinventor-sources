package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.ComponentConstants;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

@DesignerComponent(version = YaVersion.OPTIONSMENUITEM_COMPONENT_VERSION,
        description = "your option menu item",
        category = ComponentCategory.USERINTERFACE,
        nonVisible = true,
        iconName = "images/optionsMenuItem.png")
@SimpleObject
public final class OptionsMenuItem extends AndroidNonvisibleComponent
        implements OnCreateOptionsMenuListener, OnPrepareOptionsMenuListener, Deleteable, OnMenuItemClickListener, Component {

    private String optionsMenuItemTitle;

    static final String DEFAULT_TITLE = "Menu Item";

    public OptionsMenuItem(ComponentContainer container) {
        super(container.$form());

        form.registerForOnCreateOptionsMenu(this);
        form.registerForOnPrepareOptionsMenu(this);

        optionsMenuItemTitle = DEFAULT_TITLE;
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING,
            defaultValue = DEFAULT_TITLE)
    @SimpleProperty
    public void Title(String title) {
        optionsMenuItemTitle = title;
    }

    @SimpleEvent(description = "")
    public boolean MenuItemClick() {
        return EventDispatcher.dispatchEvent(this, "OptionsMenuItem");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(Menu.NONE, Menu.NONE, Menu.NONE, optionsMenuItemTitle);
        menuItem.setOnMenuItemClickListener(this);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(Menu.NONE, Menu.NONE, Menu.NONE, optionsMenuItemTitle);
        menuItem.setOnMenuItemClickListener(this);
    }

    @Override
    public void onDelete() {}

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return MenuItemClick();
    }
} 

