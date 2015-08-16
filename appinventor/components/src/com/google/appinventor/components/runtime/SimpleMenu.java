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

    private MenuItemIcon menu_item1_icon;
    private MenuItemIcon menu_item2_icon;
    private MenuItemIcon menu_item3_icon;
    private MenuItemIcon menu_item4_icon;

    private final static int NO_MENU_ICON = 0;

    public SimpleMenu (ComponentContainer container) {
        super(container.$form());
        form.registerForOnPrepareOptionsMenu(this);

        items = YailList.makeEmptyList();

        menu_item1_icon = new MenuItemIcon(NO_MENU_ICON);
        menu_item2_icon = new MenuItemIcon(NO_MENU_ICON);
        menu_item3_icon = new MenuItemIcon(NO_MENU_ICON);
        menu_item4_icon = new MenuItemIcon(NO_MENU_ICON);
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
        if(!items.isEmpty()){
            int size = items.size();

            for (int i = 1; i <= size; i++) {
                String itemString = YailList.YailListElementToString(items.get(i));
                MenuItem menuItem = menu.add(Menu.NONE, Menu.NONE, Menu.NONE, stringToHTML(itemString));

                switch (i) {
                    case 1:
                        menuItem.setIcon(menu_item1_icon.getIconValue());
                        break;
                    case 2:
                        menuItem.setIcon(menu_item2_icon.getIconValue());
                        break;
                    case 3:
                        menuItem.setIcon(menu_item3_icon.getIconValue());
                        break;
                    case 4:
                        menuItem.setIcon(menu_item4_icon.getIconValue());
                        break;

                }

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
    }

    @SimpleEvent(description = "Event called after the user selects an item from the dropdown list.")
    public void AfterSelecting(String selection){
        EventDispatcher.dispatchEvent(this, "AfterSelecting", selection);
    }

    private static SpannableString stringToHTML(String message) {
        return new SpannableString(Html.fromHtml(message));
    }


    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
            defaultValue = "0")
    @SimpleProperty(description="",  category = PropertyCategory.BEHAVIOR)
    public void Icon1(int icon) {
        chooseIcon(icon, menu_item1_icon);
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
            defaultValue = "0")
    @SimpleProperty(description="",  category = PropertyCategory.BEHAVIOR)
    public void Icon2(int icon) {
        chooseIcon(icon, menu_item2_icon);
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
            defaultValue = "0")
    @SimpleProperty(description="",  category = PropertyCategory.BEHAVIOR)
    public void Icon3(int icon) {
        chooseIcon(icon, menu_item3_icon);
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
            defaultValue = "0")
    @SimpleProperty(description="",  category = PropertyCategory.BEHAVIOR)
    public void Icon4(int icon) {
        chooseIcon(icon, menu_item4_icon);
    }

    class MenuItemIcon {

        int iconValue;

        public MenuItemIcon(int iconValue) {
            this.iconValue = iconValue;
        }

        public int getIconValue() {
            return iconValue;
        }

        public void setIconValue(int iconValue) {
            this.iconValue = iconValue;
        }
    }

    private void chooseIcon(int icon, MenuItemIcon menuItemIcon) {

        switch (icon) {
            case NO_MENU_ICON:
                menuItemIcon.setIconValue(NO_MENU_ICON);
                break;
            case 1:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_add);
                break;
            case 2:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_agenda);
                break;
            case 3:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_always_landscape_portrait);
                break;
            case 4:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_call);
                break;
            case 5:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_camera);
                break;
            case 6:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_close_clear_cancel);
                break;
            case 7:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_compass);
                break;
            case 8:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_crop);
                break;
            case 9:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_day);
                break;
            case 10:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_delete);
                break;
            case 11:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_directions);
                break;
            case 12:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_edit);
                break;
            case 13:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_gallery);
                break;
            case 14:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_help);
                break;
            case 15:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_info_details);
                break;
            case 16:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_manage);
                break;
            case 17:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_mapmode);
                break;
            case 18:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_month);
                break;
            case 19:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_more);
                break;
            case 20:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_my_calendar);
                break;
            case 21:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_mylocation);
                break;
            case 22:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_myplaces);
                break;
            case 23:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_preferences);
                break;
            case 24:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_recent_history);
                break;
            case 25:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_report_image);
                break;
            case 26:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_revert);
                break;
            case 27:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_rotate);
                break;
            case 28:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_save);
                break;
            case 29:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_search);
                break;
            case 30:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_send);
                break;
            case 31:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_set_as);
                break;
            case 32:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_share);
                break;
            case 33:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_slideshow);
                break;
            case 34:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_sort_alphabetically);
                break;
            case 35:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_sort_by_size);
                break;
            case 36:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_today);
                break;
            case 37:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_upload);
                break;
            case 38:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_upload_you_tube);
                break;
            case 39:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_upload_you_tube);
                break;
            case 40:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_view);
                break;
            case 41:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_week);
                break;
            case 42:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_zoom);
                break;
        }
    }
}