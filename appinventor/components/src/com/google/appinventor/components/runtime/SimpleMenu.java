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
public final class SimpleMenu extends AndroidNonvisibleComponent implements OnPrepareOptionsMenuListener, Component {

    private String selection = "";

    private YailList items;

    private MenuItemIcon menu_item1_icon;
    private MenuItemIcon menu_item2_icon;
    private MenuItemIcon menu_item3_icon;
    private MenuItemIcon menu_item4_icon;
    private MenuItemIcon menu_item5_icon;
    private MenuItemIcon menu_item6_icon;

    public SimpleMenu (ComponentContainer container) {
        super(container.$form());
        form.registerForOnPrepareOptionsMenu(this);

        items = YailList.makeEmptyList();

        menu_item1_icon = new MenuItemIcon(Component.MENU_NO_ICON);
        menu_item2_icon = new MenuItemIcon(Component.MENU_NO_ICON);
        menu_item3_icon = new MenuItemIcon(Component.MENU_NO_ICON);
        menu_item4_icon = new MenuItemIcon(Component.MENU_NO_ICON);
        menu_item5_icon = new MenuItemIcon(Component.MENU_NO_ICON);
        menu_item6_icon = new MenuItemIcon(Component.MENU_NO_ICON);
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
                    case 5:
                        menuItem.setIcon(menu_item5_icon.getIconValue());
                        break;
                    case 6:
                        menuItem.setIcon(menu_item6_icon.getIconValue());
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


    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_SIMPLE_MENU_ICON,
            defaultValue = Component.MENU_NO_ICON + "")
    @SimpleProperty(description="",  category = PropertyCategory.BEHAVIOR)
    public void Icon1(int icon) {
        chooseIcon(icon, menu_item1_icon);
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_SIMPLE_MENU_ICON,
            defaultValue = Component.MENU_NO_ICON + "")
    @SimpleProperty(description="",  category = PropertyCategory.BEHAVIOR)
    public void Icon2(int icon) {
        chooseIcon(icon, menu_item2_icon);
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_SIMPLE_MENU_ICON,
            defaultValue = Component.MENU_NO_ICON + "")
    @SimpleProperty(description="",  category = PropertyCategory.BEHAVIOR)
    public void Icon3(int icon) {
        chooseIcon(icon, menu_item3_icon);
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_SIMPLE_MENU_ICON,
            defaultValue = Component.MENU_NO_ICON + "")
    @SimpleProperty(description="",  category = PropertyCategory.BEHAVIOR)
    public void Icon4(int icon) {
        chooseIcon(icon, menu_item4_icon);
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_SIMPLE_MENU_ICON,
            defaultValue = Component.MENU_NO_ICON + "")
    @SimpleProperty(description="",  category = PropertyCategory.BEHAVIOR)
    public void Icon5(int icon) {
        chooseIcon(icon, menu_item5_icon);
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_SIMPLE_MENU_ICON,
            defaultValue = Component.MENU_NO_ICON + "")
    @SimpleProperty(description="",  category = PropertyCategory.BEHAVIOR)
    public void Icon6(int icon) {
        chooseIcon(icon, menu_item6_icon);
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
            case Component.MENU_NO_ICON:
                menuItemIcon.setIconValue(0);
                break;
            case Component.MENU_ADD:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_add);
                break;
            case Component.MENU_AGENDA:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_agenda);
                break;
            case Component.MENU_ALWAYS_LANDSCAPE_PORTRAIT:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_always_landscape_portrait);
                break;
            case Component.MENU_CALL:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_call);
                break;
            case Component.MENU_CAMERA:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_camera);
                break;
            case Component.MENU_CLOSE_CLEAR_CANCEL:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_close_clear_cancel);
                break;
            case Component.MENU_COMPASS:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_compass);
                break;
            case Component.MENU_CROP:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_crop);
                break;
            case Component.MENU_DAY:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_day);
                break;
            case Component.MENU_DELETE:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_delete);
                break;
            case Component.MENU_DIRECTIONS:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_directions);
                break;
            case Component.MENU_EDIT:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_edit);
                break;
            case Component.MENU_GALLERY:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_gallery);
                break;
            case Component.MENU_HELP:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_help);
                break;
            case Component.MENU_INFO_DETAILS:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_info_details);
                break;
            case Component.MENU_MANAGE:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_manage);
                break;
            case Component.MENU_MAPMODE:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_mapmode);
                break;
            case Component.MENU_MONTH:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_month);
                break;
            case Component.MENU_MORE:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_more);
                break;
            case Component.MENU_MY_CALENDAR:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_my_calendar);
                break;
            case Component.MENU_MYLOCATION:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_mylocation);
                break;
            case Component.MENU_MYPLACES:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_myplaces);
                break;
            case Component.MENU_PREFERENCES:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_preferences);
                break;
            case Component.MENU_RECENT_HISTORY:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_recent_history);
                break;
            case Component.MENU_REPORT_IMAGE:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_report_image);
                break;
            case Component.MENU_REVERT:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_revert);
                break;
            case Component.MENU_ROTATE:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_rotate);
                break;
            case Component.MENU_SAVE:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_save);
                break;
            case Component.MENU_SEARCH:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_search);
                break;
            case Component.MENU_SEND:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_send);
                break;
            case Component.MENU_SET_AS:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_set_as);
                break;
            case Component.MENU_SHARE:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_share);
                break;
            case Component.MENU_SLIDESHOW:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_slideshow);
                break;
            case Component.MENU_SORT_ALPHABETICALLY:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_sort_alphabetically);
                break;
            case Component.MENU_SORT_BY_SIZE:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_sort_by_size);
                break;
            case Component.MENU_TODAY:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_today);
                break;
            case Component.MENU_UPLOAD:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_upload);
                break;
            case Component.MENU_UPLOAD_YOU_TUBE:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_upload_you_tube);
                break;
            case Component.MENU_VIEW:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_view);
                break;
            case Component.MENU_WEEK:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_week);
                break;
            case Component.MENU_ZOOM:
                menuItemIcon.setIconValue(android.R.drawable.ic_menu_zoom);
                break;
        }
    }
}