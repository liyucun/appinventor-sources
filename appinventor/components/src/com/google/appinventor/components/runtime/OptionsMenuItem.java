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
    private int menu_icon;

    static final String DEFAULT_TITLE = "Menu Item";
    static final int DEFAULT_ICON = 0;

    public OptionsMenuItem(ComponentContainer container) {
        super(container.$form());

        form.registerForOnCreateOptionsMenu(this);
        form.registerForOnPrepareOptionsMenu(this);

        optionsMenuItemTitle = DEFAULT_TITLE;
        menu_icon = DEFAULT_ICON;
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING,
            defaultValue = DEFAULT_TITLE)
    @SimpleProperty
    public void Title(String title) {
        optionsMenuItemTitle = title;
    }




    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_MENU_ICON,
            defaultValue = Component.MENU_NONE + "")
    @SimpleProperty(userVisible = false)
    public void Icon(int icon) {

        switch (icon) {
            case Component.MENU_NONE:
                menu_icon = DEFAULT_ICON;
                break;
            case Component.MENU_ADD:
                menu_icon = android.R.drawable.ic_menu_add;
                break;
            case Component.MENU_AGENDA:
                menu_icon = android.R.drawable.ic_menu_agenda;
                break;
            case Component.MENU_ALWAYS_LANDSCAPE_PORTRAIT:
                menu_icon = android.R.drawable.ic_menu_always_landscape_portrait;
                break;
            case Component.MENU_CALL:
                menu_icon = android.R.drawable.ic_menu_call;
                break;
            case Component.MENU_CAMERA:
                menu_icon = android.R.drawable.ic_menu_camera;
                break;
            case Component.MENU_CLOSE_CLEAR_CANCEL:
                menu_icon = android.R.drawable.ic_menu_close_clear_cancel;
                break;
            case Component.MENU_COMPASS:
                menu_icon = android.R.drawable.ic_menu_compass;
                break;
            case Component.MENU_CROP:
                menu_icon = android.R.drawable.ic_menu_crop;
                break;
            case Component.MENU_DAY:
                menu_icon = android.R.drawable.ic_menu_day;
                break;
            case Component.MENU_DELETE:
                menu_icon = android.R.drawable.ic_menu_delete;
                break;
            case Component.MENU_DIRECTIONS:
                menu_icon = android.R.drawable.ic_menu_directions;
                break;
            case Component.MENU_EDIT:
                menu_icon = android.R.drawable.ic_menu_edit;
                break;
            case Component.MENU_GALLERY:
                menu_icon = android.R.drawable.ic_menu_gallery;
                break;
            case Component.MENU_HELP:
                menu_icon = android.R.drawable.ic_menu_help;
                break;
            case Component.MENU_INFO_DETAILS:
                menu_icon = android.R.drawable.ic_menu_info_details;
                break;
            case Component.MENU_MANAGE:
                menu_icon = android.R.drawable.ic_menu_manage;
                break;
            case Component.MENU_MAPMODE:
                menu_icon = android.R.drawable.ic_menu_mapmode;
                break;
            case Component.MENU_MONTH:
                menu_icon = android.R.drawable.ic_menu_month;
                break;
            case Component.MENU_MORE:
                menu_icon = android.R.drawable.ic_menu_more;
                break;
            case Component.MENU_MY_CALENDAR:
                menu_icon = android.R.drawable.ic_menu_my_calendar;
                break;
            case Component.MENU_MYLOCATION:
                menu_icon = android.R.drawable.ic_menu_mylocation;
                break;
            case Component.MENU_MYPLACES:
                menu_icon = android.R.drawable.ic_menu_myplaces;
                break;
            case Component.MENU_PREFERENCES:
                menu_icon = android.R.drawable.ic_menu_preferences;
                break;
            case Component.MENU_RECENT_HISTORY:
                menu_icon = android.R.drawable.ic_menu_recent_history;
                break;
            case Component.MENU_REPORT_IMAGE:
                menu_icon = android.R.drawable.ic_menu_report_image;
                break;
            case Component.MENU_REVERT:
                menu_icon = android.R.drawable.ic_menu_revert;
                break;
            case Component.MENU_ROTATE:
                menu_icon = android.R.drawable.ic_menu_rotate;
                break;
            case Component.MENU_SAVE:
                menu_icon = android.R.drawable.ic_menu_save;
                break;
            case Component.MENU_SEARCH:
                menu_icon = android.R.drawable.ic_menu_search;
                break;
            case Component.MENU_SEND:
                menu_icon = android.R.drawable.ic_menu_send;
                break;
            case Component.MENU_SET_AS:
                menu_icon = android.R.drawable.ic_menu_set_as;
                break;
            case Component.MENU_SHARE:
                menu_icon = android.R.drawable.ic_menu_share;
                break;
            case Component.MENU_SLIDESHOW:
                menu_icon = android.R.drawable.ic_menu_slideshow;
                break;
            case Component.MENU_SORT_ALPHABETICALLY:
                menu_icon = android.R.drawable.ic_menu_sort_alphabetically;
                break;
            case Component.MENU_SORT_BY_SIZE:
                menu_icon = android.R.drawable.ic_menu_sort_by_size;
                break;
            case Component.MENU_TODAY:
                menu_icon = android.R.drawable.ic_menu_today;
                break;
            case Component.MENU_UPLOAD:
                menu_icon = android.R.drawable.ic_menu_upload;
                break;
            case Component.MENU_UPLOAD_YOU_TUBE:
                menu_icon = android.R.drawable.ic_menu_upload_you_tube;
                break;
            case Component.MENU_VIEW:
                menu_icon = android.R.drawable.ic_menu_view;
                break;
            case Component.MENU_WEEK:
                menu_icon = android.R.drawable.ic_menu_week;
                break;
            case Component.MENU_ZOOM:
                menu_icon = android.R.drawable.ic_menu_zoom;
                break;
        }

    }
	
	@SimpleEvent(description = "")
    public boolean MenuItemClick() {
        return EventDispatcher.dispatchEvent(this, "OptionsMenuItem");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(Menu.NONE, Menu.NONE, Menu.NONE, optionsMenuItemTitle);

        if(menu_icon != DEFAULT_ICON) {
            menuItem.setIcon(menu_icon);
        }

        menuItem.setOnMenuItemClickListener(this);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(Menu.NONE, Menu.NONE, Menu.NONE, optionsMenuItemTitle);

        if(menu_icon != DEFAULT_ICON) {
            menuItem.setIcon(menu_icon);
        }

        menuItem.setOnMenuItemClickListener(this);
    }

    @Override
    public void onDelete() {}

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return MenuItemClick();
    }
} 

