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
import com.google.appinventor.components.runtime.util.ElementsUtil;
import com.google.appinventor.components.runtime.util.YailList;

import android.view.Menu;
import android.view.MenuItem;
import android.text.SpannableString;
import android.text.Html;

@DesignerComponent(version = YaVersion.SIMPLEMENU_COMPONENT_VERSION,
        category = ComponentCategory.USERINTERFACE,
        description = "",
        nonVisible = true,
        iconName = "images/simpleMenu.png")
@SimpleObject
public final class SimpleMenu extends AndroidNonvisibleComponent implements OnPrepareOptionsMenuListener {

    private String selection = "";

    private YailList items;

    public SimpleMenu (ComponentContainer container) {
        super(container.$form());
        form.registerForOnPrepareOptionsMenu(this);
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING, defaultValue = "")
    @SimpleProperty(description="",  category = PropertyCategory.BEHAVIOR)
    public void ElementsFromString(String itemstring) {
        items = ElementsUtil.elementsFromString(itemstring);
    }

    @SimpleProperty(description="", category = PropertyCategory.BEHAVIOR)
    public void Elements(YailList itemsList) {
        items = ElementsUtil.elements(itemsList, "SimpleMenu");
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public YailList Elements() {
        return items;
    }


    @SimpleProperty
    public String Selection() {
        return selection;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        int size = items.size();
        for (int i = 1; i <= size; i++) {
            String itemString = YailList.YailListElementToString(items.get(i));
            MenuItem menuItem = menu.add(Menu.NONE, Menu.NONE, Menu.NONE, stringToHTML(itemString));

            menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    SimpleMenu.this.selection = item.getTitle().toString();
                    SimpleMenu.this.AfterSelecting(item.getTitle().toString());

                    return true;
                }
            });
        }
    }

    @SimpleEvent(description = "Event called after the user selects an item from the dropdown list.")
    public void AfterSelecting(String selection){
        EventDispatcher.dispatchEvent(this, "AfterSelecting", selection);
    }

    private static SpannableString stringToHTML(String message) {
        return new SpannableString(Html.fromHtml(message));
    }
}